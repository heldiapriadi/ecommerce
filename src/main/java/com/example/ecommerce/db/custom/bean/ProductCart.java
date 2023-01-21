package com.example.ecommerce.db.custom.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductCart {
    private Long cartId;
    private Long productId;
    private String productName;
    private int quantity;
    private BigDecimal price;
    private BigDecimal totalPrice;
}
