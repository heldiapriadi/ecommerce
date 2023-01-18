package com.example.ecommerce.request;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class LoginRequest {
    @Email
    private String email;

    @Size(min = 8)
    private String password;
}
