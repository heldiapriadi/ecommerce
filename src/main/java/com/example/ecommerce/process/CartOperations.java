package com.example.ecommerce.process;

import com.example.ecommerce.response.ProductCartResponse;

import java.util.List;

public interface CartOperations {
    void addToCart(Long customerId, Long productId, int quantity);

    void removeFromCart(Long customerId, Long productId);

    void clearCart(Long customerId);

    List<ProductCartResponse> getCart(Long customerId);
}
