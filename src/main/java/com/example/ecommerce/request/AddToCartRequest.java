package com.example.ecommerce.request;

import lombok.Data;

@Data
public class AddToCartRequest {
    private Long customerId;
    private Long productId;
    private Integer quantity;
}
