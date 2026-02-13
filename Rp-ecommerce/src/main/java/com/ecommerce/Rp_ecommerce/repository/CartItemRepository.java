package com.ecommerce.Rp_ecommerce.repository;

import com.ecommerce.Rp_ecommerce.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}