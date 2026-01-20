package com.ecommerce.Rp_ecommerce.repository;

import com.ecommerce.Rp_ecommerce.model.Category;
import com.ecommerce.Rp_ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory(Category category);

    List<Product> findByProductNameLikeIgnoreCase(String s);

    boolean existsByProductNameAndCategory(String name, Category category);
}
