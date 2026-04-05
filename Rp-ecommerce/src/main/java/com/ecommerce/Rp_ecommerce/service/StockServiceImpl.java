package com.ecommerce.Rp_ecommerce.service;

import com.ecommerce.Rp_ecommerce.model.OrderItem;
import com.ecommerce.Rp_ecommerce.model.Product;
import com.ecommerce.Rp_ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService{

    private final ProductRepository productRepository;
    @Autowired
    public StockServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
     }
    @Override
    public void reserveStock(Product product, int quantity) {
        if(product.getQuantity() - product.getReservedQuantity() < quantity) {
            throw new RuntimeException("Insufficient stock for product: " + product.getProductName());
        }
        product.setReservedQuantity(product.getReservedQuantity() + quantity);
        productRepository.save(product);
    }

    @Override
    public void rollbackStock(OrderItem orderItem) {
       Product product = orderItem.getProduct();
       product.setReservedQuantity(product.getReservedQuantity() - orderItem.getQuantity());
       productRepository.save(product);
    }
}
