package com.example.ecommerce.process;

public interface CartOperations {
    void addToCart(Long customerId, Long productId, int quantity);
}
