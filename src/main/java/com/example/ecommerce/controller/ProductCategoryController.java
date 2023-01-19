package com.example.ecommerce.controller;

import com.example.ecommerce.process.ProductCategoryView;
import com.example.ecommerce.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/product-category")
public class ProductCategoryController {

    @Resource
    private ProductCategoryView productCategoryView;

    @GetMapping
    public ResponseEntity<?> getProductByCategory(@RequestParam("category_id") @Valid Long categoryId) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            apiResponse.setMessage("Get product by category successfully");
            apiResponse.setSuccess(true);
            apiResponse.setData(productCategoryView.getProductByCategory(categoryId));
            return ResponseEntity.ok(apiResponse);
        }catch (Exception e){
            e.printStackTrace();
            apiResponse.setMessage("Get product by category failed");
            apiResponse.setSuccess(false);
            return ResponseEntity.badRequest().body(apiResponse);
        }
    }
}
