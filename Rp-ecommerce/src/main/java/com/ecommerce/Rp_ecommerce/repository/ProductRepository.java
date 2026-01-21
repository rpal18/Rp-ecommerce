package com.ecommerce.Rp_ecommerce.repository;

import com.ecommerce.Rp_ecommerce.model.Category;
import com.ecommerce.Rp_ecommerce.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAll(Pageable pageDetails);

    Page<Product> findByProductNameLikeIgnoreCase(String s, Pageable pageDetails);

    boolean existsByProductNameAndCategory(String name, Category category);

    Page<Product> findAllByCategoryOrderByPriceAsc(Category category, Pageable pageDetails);
}
