package com.example.ecommerce.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiResponse {
    private Boolean success;
    private String message;
    private Object data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object error;

    @JsonProperty(namespace = "error_code")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer errorCode;
}
