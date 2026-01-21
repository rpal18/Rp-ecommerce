package com.ecommerce.Rp_ecommerce.service;

import com.ecommerce.Rp_ecommerce.exception.ApiException;
import com.ecommerce.Rp_ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.Rp_ecommerce.model.Category;
import com.ecommerce.Rp_ecommerce.payload.CategoryDTO;
import com.ecommerce.Rp_ecommerce.payload.CategoryResponse;
import com.ecommerce.Rp_ecommerce.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
/*
Pageable is an interface coming from org.springframework.data.domain package , Used for requesting a specific
page , rather than loading all the item from database which is not really useful.

----------------------------------------------------------------------------------------------------------------------

PageRequest is the implementation for pageable
 */


@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryResponse getAllCategory(Integer pageNumber, Integer pageSize, String SortBy, String SortOrder) {
        Sort sortByAndOrder = SortOrder.equalsIgnoreCase("asc") ?
                Sort.by(SortBy).ascending() :
                Sort.by(SortBy).descending();

        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);
        Page<Category> categoryPage = categoryRepository.findAll(pageDetails);
        List<Category> allCategories = categoryPage.getContent();
        if (allCategories.isEmpty()) {
            throw new ApiException("Category Never Created");
        }

        List<CategoryDTO> categoryDTOS = allCategories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class)).toList();

        CategoryResponse response = new CategoryResponse();
        response.setContent(categoryDTOS);
        response.setPageNumber(categoryPage.getNumber());
        response.setPageSize(categoryPage.getSize());
        response.setTotalElement(categoryPage.getTotalElements());
        response.setTotalPages(categoryPage.getTotalPages());
        response.setLast(categoryPage.isLast());
        return response;
    }

    @Override
    @Transactional
    public CategoryDTO createCategory(CategoryDTO categorydto) {
        /*
        ------------------------------------------------------------------
         don't create if already available
         to validate CategoryDTO to Category
         for creating category ,
         we need to change this to entity
         -----------------------------------------------------------------
         */
        Category category = modelMapper.map(categorydto, Category.class);
        Category category2 = categoryRepository.findByName(category.getName());
        if (category2 != null) {
            throw new ApiException("Category Already found:");
        }
        Category savedCategory = categoryRepository.save(category);

        CategoryDTO savedCategoryDto = modelMapper.map(savedCategory, CategoryDTO.class);
        return savedCategoryDto;
    }

    @Override
    public CategoryDTO deleteCategory(Long id) {
        // check whether it exists or not
        Category category = categoryRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Category", "Category", id));
        // hard delete
        categoryRepository.delete(category);
        return modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categorydto, Long oldCategoryId) {

        Category category = modelMapper.map(categorydto, Category.class);
        Category newCatr = categoryRepository.findById(oldCategoryId).orElseThrow(() -> new ResourceNotFoundException
                ("Category", "Category", oldCategoryId));
        category.setCategoryId(oldCategoryId);
        Category savedCategory = categoryRepository.save(category);

        return modelMapper.map(savedCategory, CategoryDTO.class);
    }
}
