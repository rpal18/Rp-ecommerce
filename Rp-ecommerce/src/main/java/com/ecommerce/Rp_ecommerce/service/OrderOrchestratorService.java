package com.ecommerce.Rp_ecommerce.service;

import com.ecommerce.Rp_ecommerce.exception.ApiException;
import com.ecommerce.Rp_ecommerce.model.Order;
import com.ecommerce.Rp_ecommerce.model.OrderStatus;
import com.ecommerce.Rp_ecommerce.payload.OrderRequestDTO;
import com.ecommerce.Rp_ecommerce.payload.OrderResponseDTO;
import com.ecommerce.Rp_ecommerce.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderOrchestratorService {

    private final OrderService orderService;
    private final PaymentService paymentService;
    private final StockService stockService;
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderOrchestratorService(OrderService orderService, PaymentService paymentService, StockService stockService,
                                    OrderRepository orderRepository , ModelMapper modelMapper) {
        this.orderService = orderService;
        this.paymentService = paymentService;
        this.stockService = stockService;
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }
@Transactional
    public OrderResponseDTO processOrder(OrderRequestDTO orderRequestDTO) {
        Order order = orderService.createOrder(orderRequestDTO);
        try {
            order.getOrderItems().forEach(item -> stockService.reserveStock(item.getProduct(), item.getQuantity()));
            boolean paymentSuccess = paymentService.processPaymentWithRetry(order);
            if (!paymentSuccess) {
                throw new ApiException("Payment failed , Rolling back stock ");
            }

            order.setOrderStatus(OrderStatus.CONFIRMED);
            orderRepository.save(order);
        } catch(Exception e){
            order.getOrderItems().forEach(stockService::rollbackStock);
            throw e;
        }
      return modelMapper.map(order , OrderResponseDTO.class);
    }
}
