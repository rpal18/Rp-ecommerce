package com.ecommerce.Rp_ecommerce.service;

import com.ecommerce.Rp_ecommerce.model.OrderItem;
import com.ecommerce.Rp_ecommerce.model.Product;

public interface StockService {
    void reserveStock(Product product, int quantity);
    void rollbackStock(OrderItem orderItem);
}