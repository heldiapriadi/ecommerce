package com.example.ecommerce.db.custom.bean;

import lombok.Data;

@Data
public class ProductCart {
    private Long productId;
    private String productName;
    private int quantity;
    private double price;
    private double totalPrice;
}
