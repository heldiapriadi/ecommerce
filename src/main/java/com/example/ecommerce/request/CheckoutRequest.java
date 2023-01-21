package com.example.ecommerce.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class CheckoutRequest {
    @NotNull
    private Long customerId;
    @NotEmpty
    private List<Long> cartId;
    @NotNull
    private List<Integer> paymentId;
}
