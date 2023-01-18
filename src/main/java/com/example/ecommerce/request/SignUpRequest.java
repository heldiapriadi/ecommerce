package com.example.ecommerce.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class SignUpRequest {
    @NotEmpty
    @NotBlank
    private String name;

    @Email
    private String email;

    @Size(min = 8)
    private String password;

    private String address;
}
