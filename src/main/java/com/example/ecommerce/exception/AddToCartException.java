package com.example.ecommerce.exception;

public class AddToCartException extends RuntimeException {
    public AddToCartException(String message) {
        super(message);
    }
}
