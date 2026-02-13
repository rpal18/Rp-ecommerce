package com.ecommerce.Rp_ecommerce.repository;

import com.ecommerce.Rp_ecommerce.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    @Query("SELECT ci from CartItem ci WHERE ci.cart.id = ?1 AND ci.product.id =?2")
    CartItem findByCartIdAndProductId(Long cartId, Long productId);
}