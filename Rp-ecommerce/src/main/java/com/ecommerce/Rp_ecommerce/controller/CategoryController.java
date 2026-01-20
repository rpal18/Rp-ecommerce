package com.ecommerce.Rp_ecommerce.controller;

import com.ecommerce.Rp_ecommerce.config.AppConstants;
import com.ecommerce.Rp_ecommerce.payload.CategoryDTO;
import com.ecommerce.Rp_ecommerce.payload.CategoryResponse;
import com.ecommerce.Rp_ecommerce.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    private CategoryService categoryService;
   @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/categories")
    public CategoryResponse getAllCategory(@RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER) Integer pageNumber,
                                           @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE) Integer pageSize,
                                           @RequestParam(name = "SortBy" , defaultValue = AppConstants.SORT_BY_CATEGORY_ID) String SortBy,
                                           @RequestParam(name = "SortOrder" , defaultValue = AppConstants.SORT_ORDER) String SortOrder) {
        return categoryService.getAllCategory(pageNumber, pageSize , SortBy , SortOrder);
    }
    /*
    I am going to use this over here , because I just want to test @RequestParam
     */
/*
--------------------------------------------------------------------------------------------------------------------------------------------------------
 The below method is just for learning purpose it has nothing to do with the core logic of this application.
--------------------------------------------------------------------------------------------------------------------------------------------------------
 */
    @RequestMapping("/api/public/echo")
    public ResponseEntity<String> echoMessage(@RequestParam(name = "message", required = false) String message) {
        return ResponseEntity.status(HttpStatus.OK).body("echoed message is :" + message);
    }

    @PostMapping("/api/admin/add")
    public ResponseEntity<CategoryDTO> addCategory(@Valid @RequestBody CategoryDTO category) {
        CategoryDTO categoryDTO = categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryDTO);
    }

    // for deleting Category
    @DeleteMapping("/api/admin/deleteCategory/{id}")
    public ResponseEntity<CategoryDTO> deletcategory(@PathVariable Long id) {
        CategoryDTO deletedCategoryDTO = categoryService.deleteCategory(id);
        return new ResponseEntity<>(deletedCategoryDTO, HttpStatus.OK);
    }

    @PutMapping("/api/admin/update/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO category, @PathVariable Long categoryId) {
        CategoryDTO savedCategoryDTO = categoryService.updateCategory(category, categoryId);
        return ResponseEntity.status(HttpStatus.OK).body(savedCategoryDTO);
    }
}
