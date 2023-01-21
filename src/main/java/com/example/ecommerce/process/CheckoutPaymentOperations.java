package com.example.ecommerce.process;

import java.util.List;

public interface CheckoutPaymentOperations {
    void createPayment(Long customerId, Long orderId, List<Integer> paymentId);
}
