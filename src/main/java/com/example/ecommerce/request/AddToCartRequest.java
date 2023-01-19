package com.example.ecommerce.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddToCartRequest {
    @NotNull
    private Long customerId;

    @NotNull
    private Long productId;

    @NotNull
    private Integer quantity;
}
