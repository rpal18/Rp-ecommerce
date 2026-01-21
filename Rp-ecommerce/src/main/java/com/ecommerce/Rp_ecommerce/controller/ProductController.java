package com.ecommerce.Rp_ecommerce.controller;

import com.ecommerce.Rp_ecommerce.config.AppConstants;
import com.ecommerce.Rp_ecommerce.payload.ProductDTO;
import com.ecommerce.Rp_ecommerce.payload.ProductResponse;
import com.ecommerce.Rp_ecommerce.repository.ProductRepository;
import com.ecommerce.Rp_ecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("api/")
public class ProductController {

    private ProductService productService;
    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductService productService,
                             ProductRepository productRepository){
        this.productService = productService;
        this.productRepository = productRepository;
    }
    @PostMapping("/admin/category/{categoryId}/product")
    public ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody ProductDTO productDTO,
                                                 @PathVariable Long categoryId){
        ProductDTO savedProduct = productService.addProduct(productDTO , categoryId);
        return new ResponseEntity<>(savedProduct , HttpStatus.CREATED);
    }
    @GetMapping("/public/category/{categoryId}/product")
    public ResponseEntity<ProductResponse> getAllProductsByCategory(@PathVariable Long categoryId , @RequestParam(value = "pageNumber" , defaultValue = AppConstants.PAGE_NUMBER , required = false) Integer pageNumber ,
                                                                    @RequestParam(value = "pageSize" , defaultValue = AppConstants.PAGE_SIZE , required = false) Integer pageSize ,
                                                                    @RequestParam(value = "sortBy" ,defaultValue = AppConstants.SORT_BY_PRODUCT_ID , required = false) String sortBy ,
                                                                    @RequestParam(value = "sortOrder", defaultValue = AppConstants.SORT_ORDER , required = false) String sortOrder){
        ProductResponse response = productService.getAllProductByCategory(categoryId , pageNumber, pageSize, sortBy, sortOrder);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }
    @GetMapping("/public/category/product")
    public ResponseEntity<ProductResponse> getAllProducts(@RequestParam(value = "pageNumber" , defaultValue = AppConstants.PAGE_NUMBER , required = false) Integer pageNumber ,
                                                          @RequestParam(value = "pageSize" , defaultValue = AppConstants.PAGE_SIZE , required = false) Integer pageSize ,
                                                          @RequestParam(value = "sortBy" ,defaultValue = AppConstants.SORT_BY_PRODUCT_ID , required = false) String sortBy ,
                                                          @RequestParam(value = "sortOrder", defaultValue = AppConstants.SORT_ORDER , required = false) String sortOrder){
        ProductResponse response = productService.getAllProduct(pageNumber, pageSize, sortBy, sortOrder);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    //search product from keyword
    @GetMapping("/public/product/keyword/{key}")
    public ResponseEntity<ProductResponse> getProductKeyword(@PathVariable String key ,@RequestParam(value = "pageNumber" , defaultValue = AppConstants.PAGE_NUMBER , required = false) Integer pageNumber ,
                                                             @RequestParam(value = "pageSize" , defaultValue = AppConstants.PAGE_SIZE , required = false) Integer pageSize ,
                                                             @RequestParam(value = "sortBy" ,defaultValue = AppConstants.SORT_BY_PRODUCT_ID , required = false) String sortBy ,
                                                             @RequestParam(value = "sortOrder", defaultValue = AppConstants.SORT_ORDER , required = false) String sortOrder
                                                             ){
        ProductResponse response = productService.getFromKeyword(key , pageNumber, pageSize, sortBy, sortOrder);
        return new ResponseEntity<>(response , HttpStatus.FOUND);
    }

    //update the product
    @PutMapping("admin/product/{productId}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long productId ,
                                                   @Valid @RequestBody ProductDTO productDTO){
    ProductDTO productDto = productService.updateProduct(productId , productDTO);
    return new ResponseEntity<>(productDTO , HttpStatus.OK);
    }
    //delete product
    @DeleteMapping("admin/product/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId){
        String response = productService.deleteProduct(productId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("admin/product/{productId}/image")
    public ResponseEntity<ProductDTO> uploadImage(@PathVariable Long productId ,
                                                  @RequestParam("image")MultipartFile image) throws IOException {
        ProductDTO updatedDTO = productService.updateImage(productId , image);
        return new ResponseEntity<>(updatedDTO , HttpStatus.OK);
    }

}
