package com.example.ecommerce.controller;

import com.example.ecommerce.exception.AddToCartException;
import com.example.ecommerce.exception.AuthenticationException;
import com.example.ecommerce.model.UserCustomer;
import com.example.ecommerce.process.CartOperations;
import com.example.ecommerce.process.CustomerUserDetailsService;
import com.example.ecommerce.request.AddToCartRequest;
import com.example.ecommerce.request.ClearCartRequest;
import com.example.ecommerce.request.RemoveFromCartRequest;
import com.example.ecommerce.response.ApiResponse;
import com.example.ecommerce.util.SecurityUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/shopping-cart")
public class ShoppingCartController {
    @Resource
    private CartOperations cartOperations;

    @PostMapping("/add-to-cart")
    public ResponseEntity<?> addToCart(@RequestBody @Valid AddToCartRequest addToCartRequest){
        ApiResponse apiResponse = new ApiResponse();
        try {
            SecurityUtil.validateCustomer(addToCartRequest.getCustomerId());
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
            SecurityUtil.validateCustomer(removeFromCartRequest.getCustomerId());
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
    public ResponseEntity<?> clearCart(@RequestBody @Valid ClearCartRequest clearCartRequest){
        ApiResponse apiResponse = new ApiResponse();
        try {
            SecurityUtil.validateCustomer(clearCartRequest.getCustomerId());
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

    @GetMapping("/get-cart")
    public ResponseEntity<?> getCart(@RequestParam("customer_id") @Valid Long customerId){
        ApiResponse apiResponse = new ApiResponse();
        try {
            SecurityUtil.validateCustomer(customerId);
            apiResponse.setMessage("Cart fetched successfully");
            apiResponse.setSuccess(true);
            apiResponse.setData(cartOperations.getCart(customerId));
            return ResponseEntity.ok(apiResponse);
        }catch (Exception e){
            e.printStackTrace();
            apiResponse.setMessage("Failed to fetch cart");
            apiResponse.setSuccess(false);
            return ResponseEntity.internalServerError().body(apiResponse);
        }
    }


}
