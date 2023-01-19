package com.example.ecommerce.process;

import com.example.ecommerce.response.ProductByCategoryResponse;

import java.util.List;

public interface ProductCategoryView {
    ProductByCategoryResponse getProductByCategory(Long categoryId);
}
