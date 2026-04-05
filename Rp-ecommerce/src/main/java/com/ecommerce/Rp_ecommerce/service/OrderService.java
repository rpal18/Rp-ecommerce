package com.ecommerce.Rp_ecommerce.service;

import com.ecommerce.Rp_ecommerce.model.Order;
import com.ecommerce.Rp_ecommerce.payload.OrderRequestDTO;
import com.ecommerce.Rp_ecommerce.payload.OrderResponseDTO;

public interface OrderService {


    Order createOrder(OrderRequestDTO orderRequestDTO);
}
