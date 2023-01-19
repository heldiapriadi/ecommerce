package com.example.ecommerce.process;

public interface CartOperations {
    void addToCart(Long customerId, Long productId, int quantity);

    void removeFromCart(Long customerId, Long productId);

    void clearCart(Long customerId);
}
