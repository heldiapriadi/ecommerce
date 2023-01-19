package com.example.ecommerce.response;

import com.example.ecommerce.db.custom.bean.ProductCart;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductCartResponse {
    private Long productId;
    private String productName;
    private int quantity;
    private double price;
    private double totalPrice;

    public static List<ProductCartResponse> fromProductCarts(List<ProductCart> productCarts) {
        List<ProductCartResponse> productCartResponses = new ArrayList<>();
        productCarts.forEach(productCart -> {
            ProductCartResponse productCartResponse = new ProductCartResponse();
            productCartResponse.setProductId(productCart.getProductId());
            productCartResponse.setProductName(productCart.getProductName());
            productCartResponse.setQuantity(productCart.getQuantity());
            productCartResponse.setPrice(productCart.getPrice());
            productCartResponse.setTotalPrice(productCart.getTotalPrice());
            productCartResponses.add(productCartResponse);
        });
        return productCartResponses;
    }
}
