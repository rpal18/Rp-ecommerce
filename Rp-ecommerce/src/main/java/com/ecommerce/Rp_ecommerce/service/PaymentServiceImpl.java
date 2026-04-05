package com.ecommerce.Rp_ecommerce.service;

import com.ecommerce.Rp_ecommerce.model.Order;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Override
    public boolean processPaymentWithRetry(Order order) {

        return false;
    }
}
