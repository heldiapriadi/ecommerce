package com.example.ecommerce.process;

public interface UserOperations {
    boolean existsByEmail(String email);

    String signIn(String email, String password);

    void signUp(String name, String email, String password, String address);
}