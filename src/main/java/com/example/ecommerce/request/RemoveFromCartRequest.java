package com.example.ecommerce.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RemoveFromCartRequest {
    @NotNull
    private Long customerId;

    @NotNull
    private Long productId;
}
