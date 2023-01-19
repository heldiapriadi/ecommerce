package com.example.ecommerce.controller;

import com.example.ecommerce.exception.AddToCartException;
import com.example.ecommerce.process.CartOperations;
import com.example.ecommerce.request.AddToCartRequest;
import com.example.ecommerce.request.ClearCartRequest;
import com.example.ecommerce.request.RemoveFromCartRequest;
import com.example.ecommerce.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/shopping-cart")
public class ShoppingCartController {
    @Resource
    private CartOperations cartOperations;

    @PostMapping("/add-to-cart")
    public ResponseEntity<?> addToCart(@RequestBody AddToCartRequest addToCartRequest){
        ApiResponse apiResponse = new ApiResponse();
        try {
            cartOperations.addToCart(addToCartRequest.getCustomerId(), addToCartRequest.getProductId(), addToCartRequest.getQuantity());
            apiResponse.setMessage("Added to cart successfully");
            apiResponse.setSuccess(true);
            return ResponseEntity.ok(apiResponse);
        }catch (AddToCartException e){
            apiResponse.setMessage(e.getMessage());
            apiResponse.setSuccess(false);
            return ResponseEntity.badRequest().body(apiResponse);
        } catch (Exception e){
            apiResponse.setMessage("Failed to add to cart");
            apiResponse.setSuccess(false);
            return ResponseEntity.internalServerError().body(apiResponse);
        }
    }

    @DeleteMapping("/remove-from-cart")
    public ResponseEntity<?> removeFromCart(@RequestBody @Valid RemoveFromCartRequest removeFromCartRequest){
        ApiResponse apiResponse = new ApiResponse();
        try {
            cartOperations.removeFromCart(removeFromCartRequest.getCustomerId(), removeFromCartRequest.getProductId());
            apiResponse.setMessage("Removed from cart successfully");
            apiResponse.setSuccess(true);
            return ResponseEntity.ok(apiResponse);
        }catch (Exception e){
            apiResponse.setMessage("Failed to remove from cart");
            apiResponse.setSuccess(false);
            return ResponseEntity.internalServerError().body(apiResponse);
        }
    }

    @DeleteMapping("/clear-cart")
    public ResponseEntity<?> clearCart(@RequestBody ClearCartRequest clearCartRequest){
        ApiResponse apiResponse = new ApiResponse();
        try {
            cartOperations.clearCart(clearCartRequest.getCustomerId());
            apiResponse.setMessage("Cart cleared successfully");
            apiResponse.setSuccess(true);
            return ResponseEntity.ok(apiResponse);
        }catch (Exception e){
            apiResponse.setMessage("Failed to clear cart");
            apiResponse.setSuccess(false);
            return ResponseEntity.internalServerError().body(apiResponse);
        }
    }

}
