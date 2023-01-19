package com.example.ecommerce.controller;

import com.example.ecommerce.exception.SignUpException;
import com.example.ecommerce.process.UserOperations;
import com.example.ecommerce.request.LoginRequest;
import com.example.ecommerce.request.SignUpRequest;
import com.example.ecommerce.response.ApiResponse;
import com.example.ecommerce.util.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/auth/")
public class AuthenticationController   {
    @Resource
    private UserOperations userOperations;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            String email = loginRequest.getEmail();
            String password = loginRequest.getPassword();
            String token = userOperations.signIn(email, password);

            apiResponse.setMessage("Login successfully");
            apiResponse.setSuccess(true);
            apiResponse.setData(token);
            return ResponseEntity.ok(apiResponse);
        }catch (Exception e){
            e.printStackTrace();
            apiResponse.setMessage("Invalid Credentials");
            apiResponse.setSuccess(false);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiResponse);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            userOperations.signUp(signUpRequest.getName(), signUpRequest.getEmail(),
                    signUpRequest.getPassword(), signUpRequest.getAddress());

            apiResponse.setMessage("Register successfully");
            apiResponse.setSuccess(true);
            return ResponseEntity.ok(apiResponse);
        }catch (SignUpException e){
            apiResponse.setMessage(e.getMessage());
            apiResponse.setSuccess(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
        }catch (Exception e){
            e.printStackTrace();
            apiResponse.setMessage("Something went wrong");
            apiResponse.setSuccess(false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
        }
    }
}
