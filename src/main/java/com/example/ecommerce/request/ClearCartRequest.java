package com.example.ecommerce.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ClearCartRequest {
    @NotNull
    private Long customerId;
}
