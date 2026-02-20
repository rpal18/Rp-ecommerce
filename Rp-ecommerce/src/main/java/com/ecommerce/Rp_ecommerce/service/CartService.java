package com.ecommerce.Rp_ecommerce.service;

import com.ecommerce.Rp_ecommerce.payload.CartDTO;
import com.ecommerce.Rp_ecommerce.payload.ProductDTO;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CartService {

    public CartDTO addProductToCart(Long productId , Integer quantity) ;

    public List<CartDTO> fetchAllCarts();

    CartDTO fetchUserCart(String emailId, Long cartId);
    @Transactional
    CartDTO updateProductQuantityInCart(Long productId, int quantity);

    String deleteProductFromCart(Long cartId , Long productId);

}
