package com.example.ecommerce.controller;

import com.example.ecommerce.process.CheckoutOrderOperations;
import com.example.ecommerce.request.CheckoutRequest;
import com.example.ecommerce.response.ApiResponse;
import com.example.ecommerce.util.SecurityUtil;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/checkout")
@SecurityRequirement(name = "Bearer Authentication")
public class CheckoutController {
    @Resource
    private CheckoutOrderOperations checkoutOrderOperations;

    @PostMapping
    public ResponseEntity<?> checkout(@RequestBody @Valid CheckoutRequest checkoutRequest){
        ApiResponse response = new ApiResponse();
        try {
            SecurityUtil.validateCustomer(checkoutRequest.getCustomerId());
            checkoutOrderOperations.createOrder(checkoutRequest.getCustomerId(),
                    checkoutRequest.getCartId(), checkoutRequest.getPaymentId());
            response.setSuccess(true);
            response.setMessage("Checkout successfully");
            response.setData(null);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            response.setSuccess(false);
            response.setMessage("Checkout failed");
            response.setData(null);
            return ResponseEntity.internalServerError().body(response);
        }
    }
}
