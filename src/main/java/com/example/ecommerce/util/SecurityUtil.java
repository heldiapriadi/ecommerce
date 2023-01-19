package com.example.ecommerce.util;

import com.example.ecommerce.exception.AuthenticationException;
import com.example.ecommerce.model.UserCustomer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    public static void validateCustomer(Long customerId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserCustomer userCustomer = (UserCustomer) authentication.getPrincipal();
        if(!userCustomer.getId().equals(customerId)){
            throw new AuthenticationException("You are not authorized to add to cart");
        }
    }
}
