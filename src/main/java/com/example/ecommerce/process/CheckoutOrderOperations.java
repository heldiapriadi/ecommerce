package com.example.ecommerce.process;

import com.example.ecommerce.request.OrderResponse;

import java.util.List;

public interface CheckoutOrderOperations {
    void createOrder(Long customerId, List<Long> cartId, List<Integer> paymentId);
}
