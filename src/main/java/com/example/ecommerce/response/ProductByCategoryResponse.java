package com.example.ecommerce.response;

import lombok.Data;

import java.util.List;

@Data
public class ProductByCategoryResponse {
    private Long categoryId;
    private String categoryName;
    private String categoryDescription;
    private List<ProductView> products;
}
