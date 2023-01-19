package com.example.ecommerce.db.custom.bean;

import lombok.Data;

@Data
public class ProductByCategory {
    private Long productId;
    private String name;
    private String description;
    private Long price;
    private Integer quantity;
    private String image;
    private Long categoryId;
    private String categoryName;
    private String categoryDescription;
}
