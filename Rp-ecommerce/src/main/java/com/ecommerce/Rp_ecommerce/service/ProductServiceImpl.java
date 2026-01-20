package com.ecommerce.Rp_ecommerce.service;

import com.ecommerce.Rp_ecommerce.exception.ApiException;
import com.ecommerce.Rp_ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.Rp_ecommerce.model.Category;
import com.ecommerce.Rp_ecommerce.model.Product;
import com.ecommerce.Rp_ecommerce.payload.ProductDTO;
import com.ecommerce.Rp_ecommerce.payload.ProductResponse;
import com.ecommerce.Rp_ecommerce.repository.CategoryRepository;
import com.ecommerce.Rp_ecommerce.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    private final FileService fileService;
    @Value("${project.image}")
    private String path ;


    public ProductServiceImpl(CategoryRepository categoryRepository,
                              ProductRepository productRepository,
                              ModelMapper modelMapper,
                              FileService fileService) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.fileService = fileService;
    }


    @Override
    public ProductDTO addProduct(ProductDTO productDTO, Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() ->
                new ResourceNotFoundException("Category", "id", categoryId));

        boolean isPresent = productRepository.existsByProductNameAndCategory(productDTO.getName() , category);
        
        if(!isPresent) {

            Product product = new Product();
            product.setProductName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            double actualPrice = productDTO.getPrice();
            double discountRate = productDTO.getDiscount();
            double specialPrice = (actualPrice - (actualPrice * 0.01 * discountRate));

            product.setSpecialPrice(specialPrice);
            product.setDescription(productDTO.getDescription());
            product.setDiscount(discountRate);
            product.setCategory(category);
            product.setQuantity(productDTO.getQuantity());

            Product saved = productRepository.save(product);

            return modelMapper.map(saved, ProductDTO.class);
        }else {
            throw new ApiException("Product already exist!!");
        }

    }

    @Override
    public ProductResponse getAllProduct(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() ->
                new ResourceNotFoundException("Category", "category id", categoryId));
        ProductResponse finalResponse = new ProductResponse();
        List<Product> products = productRepository.findAllByCategory(category);
        List<ProductDTO> response = products.stream().map((element) -> modelMapper.map(element, ProductDTO.class)).toList();
        finalResponse.setProducts(response);
        return finalResponse;
    }

    // generally here , elastic search is used in real word especially dealing with large dataset .
    @Override
    public ProductResponse getFromKeyword(String key) {
        List<Product> products = productRepository.findByProductNameLikeIgnoreCase('%' + key + '%');
        List<ProductDTO> productDTOS = products.stream().map((element) -> modelMapper.map(element, ProductDTO.class)).toList();
        ProductResponse response = new ProductResponse();
        response.setProducts(productDTOS);
        return response;
    }

    @Override
    public ProductDTO updateProduct(Long productId, ProductDTO productDTO) {
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new ResourceNotFoundException("Product", "product id", productId));

        product.setProductName(productDTO.getName());
        product.setQuantity(productDTO.getQuantity());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setImage(productDTO.getImage());
        double actualPrice = productDTO.getPrice();
        double discountRate = productDTO.getDiscount();
        double specialPrice = (actualPrice - (actualPrice * 0.01 * discountRate));
        product.setSpecialPrice(productDTO.getSpecialPrice());
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public String deleteProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new ResourceNotFoundException("Product", "product id", productId));
        productRepository.deleteById(productId);
        return "successfully deleted";
    }

    @Override
    public ProductDTO updateImage(Long productId, MultipartFile image) throws IOException {
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new ResourceNotFoundException("Product", "product id", productId));
        String fileName = fileService.uploadNewImage(path, image);

        product.setImage(fileName);

        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }

}
