package com.ecommerce.Rp_ecommerce.service;

import com.ecommerce.Rp_ecommerce.exception.ApiException;
import com.ecommerce.Rp_ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.Rp_ecommerce.model.*;
import com.ecommerce.Rp_ecommerce.payload.OrderItemDTO;
import com.ecommerce.Rp_ecommerce.payload.OrderRequestDTO;
import com.ecommerce.Rp_ecommerce.payload.OrderResponseDTO;
import com.ecommerce.Rp_ecommerce.repository.*;
import com.ecommerce.Rp_ecommerce.utils.AuthUtils;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final AddressRepository addressRepository;

    private final AuthUtils authUtil;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;
    private final ModelMapper modelMapper;
    private final OrderItemRepository orderItemRepository;
    private final StockService stockService;

    private final PaymentService paymentService;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, AddressRepository addressRepository,
                            AuthUtils authUtil,
                            ProductRepository productRepository,
                            CartItemRepository cartItemRepository
                              ,ModelMapper modelMapper,
                            OrderItemRepository orderItemRepository ,
                            PaymentService paymentService ,
                            StockService stockService) {
        this.orderRepository = orderRepository;
        this.addressRepository = addressRepository;
        this.authUtil = authUtil;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
        this.modelMapper = modelMapper;
        this.orderItemRepository = orderItemRepository;
        this.stockService = stockService;
        this.paymentService = paymentService;
    }

    @Transactional
    public Order createOrder(OrderRequestDTO orderRequestDTO) {
        // Fetch the logged-in user
        User user = authUtil.loggedInUser();

        // Validate the address
        Address address = addressRepository.findById(orderRequestDTO.getAddressId())
                .orElseThrow(() -> new ResourceNotFoundException("Address", "id", orderRequestDTO.getAddressId()));

        // Initialize the order
        Order order = initializeOrder(user, address);
        List<OrderItem> orderItems = new ArrayList<>();
        BigDecimal totalPrice = BigDecimal.ZERO;

        // Process each order item
        for (OrderItemDTO item : orderRequestDTO.getItems()) {
            Product product = productRepository.findById(item.getProductId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product", "Id", item.getProductId()));

            // Reserve stock for the product
            stockService.reserveStock(product, item.getQuantity());

            // Create and add the order item
            OrderItem orderItem = createOrderItem(order, product, item);
            orderItems.add(orderItem);
            totalPrice = totalPrice.add(orderItem.getFinalAmount());
        }

        // Set order details
        order.setOrderItems(orderItems);
        order.setTotalAmount(totalPrice);

        // Save the order
        Order savedOrder = orderRepository.save(order);
        return savedOrder;
    }

    private Order initializeOrder(User user, Address address) {
        Order order = new Order();
        order.setUser(user);
        order.setStreet(address.getStreet());
        order.setCity(address.getCity());
        order.setState(address.getState());
        order.setZipCode(address.getZipCode());
        order.setCountry(address.getCountry());
        order.setLandmark(address.getLandmark());
        order.setMobileNumber(user.getMobileNumber());
        order.setOrderStatus(OrderStatus.PENDING);
        order.setPaymentStatus(PaymentStatus.PENDING);
        return order;
    }

    private OrderItem createOrderItem(Order order, Product product, OrderItemDTO itemDTO) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setQuantity(itemDTO.getQuantity());
        orderItem.setPriceAtPurchase(product.getPrice());
        orderItem.setDiscount(product.getDiscount());

        BigDecimal priceAtPurchase = product.getPrice();
        BigDecimal discount = product.getDiscount() != null ? product.getDiscount() : BigDecimal.ZERO;
        BigDecimal discountedPrice = priceAtPurchase.subtract(priceAtPurchase.multiply(discount).divide(BigDecimal.valueOf(100)));
        BigDecimal finalAmount = discountedPrice.multiply(BigDecimal.valueOf(itemDTO.getQuantity()));

        orderItem.setFinalAmount(finalAmount);
        orderItem.setTotalPrice(priceAtPurchase.multiply(BigDecimal.valueOf(itemDTO.getQuantity())));
        orderItem.setShippingCharge(BigDecimal.ZERO); // Set default shipping charge if applicable
        return orderItem;
    }
}
