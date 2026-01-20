package com.ecommerce.Rp_ecommerce.service;

import com.ecommerce.Rp_ecommerce.model.Category;
import com.ecommerce.Rp_ecommerce.payload.CategoryDTO;
import com.ecommerce.Rp_ecommerce.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse getAllCategory(Integer pageNumber, Integer pageSize , String SortBy , String SortOrder);

    CategoryDTO createCategory(CategoryDTO categorydto);

    CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(CategoryDTO categorydto, Long oldCategoryId);
}
