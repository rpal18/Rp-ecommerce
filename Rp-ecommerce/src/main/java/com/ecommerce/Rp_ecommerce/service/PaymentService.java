package com.ecommerce.Rp_ecommerce.service;

import com.ecommerce.Rp_ecommerce.model.Order;

public interface PaymentService {

    boolean processPaymentWithRetry(Order order );
}
