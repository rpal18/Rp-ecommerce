package com.ecommerce.Rp_ecommerce.service;

import com.ecommerce.Rp_ecommerce.exception.ApiException;
import com.ecommerce.Rp_ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.Rp_ecommerce.model.Cart;
import com.ecommerce.Rp_ecommerce.model.CartItem;
import com.ecommerce.Rp_ecommerce.model.Product;
import com.ecommerce.Rp_ecommerce.payload.CartDTO;
import com.ecommerce.Rp_ecommerce.payload.ProductDTO;
import com.ecommerce.Rp_ecommerce.repository.CartItemRepository;
import com.ecommerce.Rp_ecommerce.repository.CartRepository;
import com.ecommerce.Rp_ecommerce.repository.ProductRepository;
import com.ecommerce.Rp_ecommerce.utils.AuthUtils;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final AuthUtils authUtil;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, AuthUtils authUtil,
                           ProductRepository productRepository,
                           CartItemRepository cartItemRepository,
                           ModelMapper modelMapper) {
        this.cartRepository = cartRepository;
        this.authUtil = authUtil;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CartDTO addProductToCart(Long productId, Integer quantity) {

        Cart cart = createCart();
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new ResourceNotFoundException("Product", "product id", productId));
        CartItem cartItem = cartItemRepository.findByCartIdAndProductId(cart.getCartId(), productId);
        if (cartItem != null) {
            throw new ApiException("Product" + product.getProductName() + "already exist");
        }

        if (product.getQuantity() == 0) {
            throw new ApiException("Product  ,  " + product.getProductName() + " out of stock");
        }

        if (product.getQuantity() < quantity) {
            throw new ApiException(" insufficient quantity , kindly request for less quantity ");
        }
        //creating cartItem
        CartItem newCartItem = new CartItem();
        newCartItem.setCart(cart);
        newCartItem.setProduct(product);
        newCartItem.setProductPrice(product.getPrice());
        newCartItem.setDiscount(product.getDiscount());
        newCartItem.setQuantity(quantity);

        cartItemRepository.save(newCartItem);
        cart.getCartItemList().add(newCartItem);



        product.setQuantity(product.getQuantity() - quantity);
        cart.setTotalCartPrice(cart.getTotalCartPrice() + (product.getSpecialPrice() * quantity));
        Cart savedCart = cartRepository.save(cart);

        CartDTO cartDTO = modelMapper.map(savedCart, CartDTO.class);

        List<CartItem> cartItems = cart.getCartItemList();
        List<ProductDTO> productDTOStream = cartItems.stream().map(item -> {
            ProductDTO map = modelMapper.map(item.getProduct(), ProductDTO.class);
            map.setQuantity(item.getQuantity());
            return map;
        }).collect(Collectors.toList());
        cartDTO.setProducts(productDTOStream);
        return cartDTO;
    }

    @Override
    public List<CartDTO> fetchAllCarts() {
        List<Cart> carts = cartRepository.findAll();
        if(carts.isEmpty()){
            throw new ApiException("No Cart found !!");
        }

        // otherwise we need to return cartDTO

        List<CartDTO> cartDTOS = carts.stream().
                map((element) -> {
                  CartDTO cartDTO =  modelMapper.map(element, CartDTO.class);
                 List<ProductDTO> productDTOS = element.getCartItemList().stream().
                         map(p -> modelMapper.map(p.getProduct() ,  ProductDTO.class)).toList();
                 cartDTO.setProducts(productDTOS);
                 return cartDTO;
                }).
                toList();

        return cartDTOS;
    }

    @Override
    public CartDTO fetchUserCart(String emailId, Long cartId) {
        Cart cart = cartRepository.findCartByEmailAndCartId(emailId , cartId);
        if(cart == null){
            throw new ResourceNotFoundException("Cart" , "CartID" , cartId);
        }

        CartDTO cartDTO = modelMapper.map(cart , CartDTO.class);
        cart.getCartItemList().forEach(item->item.getProduct().setQuantity(item.getQuantity()));
        List<ProductDTO> productDTOS = cart.getCartItemList().stream().
                map(p -> modelMapper.map(p.getProduct() ,  ProductDTO.class)).toList();
        cartDTO.setProducts(productDTOS);
        return cartDTO;
    }
    @Transactional
    @Override
    public CartDTO updateProductQuantityInCart(Long productId, int quantity) {
        String email = authUtil.loggedInEmail();
        Cart userCart = cartRepository.findCartByEmail(email);
        Long cartId  = userCart.getCartId();
        Cart cart = cartRepository.findById(cartId).orElseThrow(() ->
                new ResourceNotFoundException("Cart" , "CartID" , cartId));

        Product product = productRepository.findById(productId).orElseThrow(() ->
                new ResourceNotFoundException("Product" , "ProductId" , productId));

        if(product.getQuantity() == 0){
            throw new ApiException(product.getProductName() + "is not available");
        }

        if(product.getQuantity() < quantity){
            throw new ApiException("insufficient Quantity !!");
        }

        CartItem cartItem = cartItemRepository.findByCartIdAndProductId(cartId , productId);
        if(cartItem == null){
            throw new ApiException(product.getProductName() +"Product not available in the cart");
        }
        cartItem.setProductPrice(product.getSpecialPrice());
        cartItem.setQuantity(cartItem.getQuantity() + quantity);
        cartItem.setDiscount(product.getDiscount());
        cart.setTotalCartPrice(cart.getTotalCartPrice() +  (cartItem.getProductPrice() * quantity ) );
        cartRepository.save(cart);
        CartItem updatedCartItem = cartItemRepository.save(cartItem);
        if(updatedCartItem.getQuantity() == 0){
            cartItemRepository.deleteById(updatedCartItem.getCartItemId());
        }

        CartDTO cartDTO = modelMapper.map(cart , CartDTO.class);
        List<CartItem> cartItems = cart.getCartItemList();
        List<ProductDTO> list = cartItems.stream().map(item ->{
            ProductDTO productDTO = modelMapper.map(item.getProduct() , ProductDTO.class);
          productDTO.setQuantity(item.getQuantity());
            return productDTO;
        }).toList();

        cartDTO.setProducts(list);
        return cartDTO;
    }

    private Cart createCart() {
        Cart userCart = cartRepository.findCartByEmail(authUtil.loggedInEmail());
        if (userCart != null) {
            return userCart;
        }

        Cart cart = new Cart();
        cart.setTotalCartPrice(0.0);
        cart.setUser(authUtil.loggedInUserName());
        return cartRepository.save(cart);
    }
}
