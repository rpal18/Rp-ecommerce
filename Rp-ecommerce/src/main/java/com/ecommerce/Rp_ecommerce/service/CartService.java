package com.ecommerce.Rp_ecommerce.service;

import com.ecommerce.Rp_ecommerce.payload.CartDTO;

public interface CartService {

    public CartDTO addProductToCart(Long productId , Integer quantity) ;

}
