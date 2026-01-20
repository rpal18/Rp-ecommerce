package com.ecommerce.Rp_ecommerce.service;

import com.ecommerce.Rp_ecommerce.payload.ProductDTO;
import com.ecommerce.Rp_ecommerce.payload.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductService {
    ProductDTO addProduct(ProductDTO productDTO, Long categoryId);

    ProductResponse getAllProduct(Long categoryId);

    ProductResponse getFromKeyword(String key);

    ProductDTO updateProduct(Long productId, ProductDTO productDTO);

    String deleteProduct(Long productId);

    ProductDTO updateImage(Long productId, MultipartFile image) throws IOException;
}
