package com.ecommerce.Rp_ecommerce.controller;

import com.ecommerce.Rp_ecommerce.model.Cart;
import com.ecommerce.Rp_ecommerce.payload.CartDTO;
import com.ecommerce.Rp_ecommerce.repository.CartRepository;
import com.ecommerce.Rp_ecommerce.service.CartService;
import com.ecommerce.Rp_ecommerce.utils.AuthUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CartController {
    private final CartService cartService ;
    private final AuthUtils authUtil;

    private final CartRepository cartRepository;
    @Autowired
    public CartController( CartService cartService ,
                           AuthUtils authUtil ,
                           CartRepository cartRepository){
        this.cartService = cartService;
        this.authUtil = authUtil;
        this.cartRepository = cartRepository;
    }
    @PostMapping("/carts/products/{productId}/quantity/{quantity}")
    public ResponseEntity<?> addProductToCart(@PathVariable Long productId ,
                                              @PathVariable Integer quantity){
        CartDTO response  = cartService.addProductToCart(productId , quantity );
        return new ResponseEntity<>(response  , HttpStatus.CREATED);
    }

    @GetMapping("/carts")
    @PreAuthorize(("hasRole('ADMIN')"))
    public ResponseEntity<List<CartDTO>> fetchAllCarts(){
        List<CartDTO> cartDTOList = cartService.fetchAllCarts();
        return new ResponseEntity<>(cartDTOList , HttpStatus.FOUND);
    }
    @GetMapping("/carts/user")
    @PreAuthorize(("hasRole('USER')"))
    public ResponseEntity<CartDTO> fetchUserCart(){
        /*
        Here , I am making use of two things two parameter ( email and cartId ) for scalability.
        we would have better control in future if we want to add more cart to a single user .
         */

        String emailId = authUtil.loggedInEmail();
        Cart cart = cartRepository.findCartByEmail(emailId);
        Long cartId = cart.getCartId();
        CartDTO cartDTO = cartService.fetchUserCart(emailId , cartId);
        return new ResponseEntity<>(cartDTO , HttpStatus.FOUND);
    }
  @PutMapping("/cart/product/{productId}/quantity/{operation}")
    public ResponseEntity<CartDTO> updateCartProduct(@PathVariable  Long productId ,
                                                      @PathVariable String operation){
       CartDTO cartDTO = cartService.updateProductQuantityInCart(productId ,
               operation.equalsIgnoreCase("delete") ? -1 : 1);
       return new ResponseEntity<>(cartDTO , HttpStatus.OK);
  }
}
