package com.ecommerce.Rp_ecommerce.controller;

import com.ecommerce.Rp_ecommerce.payload.CartDTO;
import com.ecommerce.Rp_ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CartController {
    private CartService cartService ;
    @Autowired
    public CartController( CartService cartService){
        this.cartService = cartService;
    }
    @PostMapping("/carts/products/{productId}/quantity/{quantity}")
    public ResponseEntity<?> addProductToCart(@PathVariable Long productId ,
                                              @PathVariable Integer quantity){
        CartDTO response  = cartService.addProductToCart(productId , quantity );
        return new ResponseEntity<>(response  , HttpStatus.CREATED);
    }
}
