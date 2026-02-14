package com.ecommerce.Rp_ecommerce.service;

import com.ecommerce.Rp_ecommerce.payload.CartDTO;

import java.util.List;

public interface CartService {

    public CartDTO addProductToCart(Long productId , Integer quantity) ;

    public List<CartDTO> fetchAllCarts();
}
