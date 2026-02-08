package com.ecommerce.Rp_ecommerce.repository;

import com.ecommerce.Rp_ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameAndMobileNumber(String username, String mobileNumber);

    boolean existsByUsernameAndMobileNumber(String username, String mobileNumber);

    boolean existsByUsername(String testuser);

    boolean existsByEmail(String email);
}