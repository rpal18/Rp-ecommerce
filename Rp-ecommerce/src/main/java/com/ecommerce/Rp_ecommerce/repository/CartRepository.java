package com.ecommerce.Rp_ecommerce.repository;

import com.ecommerce.Rp_ecommerce.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}