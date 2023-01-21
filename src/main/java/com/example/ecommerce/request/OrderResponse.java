package com.example.ecommerce.request;

import lombok.Data;

@Data
public class OrderResponse {
    private Long orderId;
    private String orderStatus;
    private String orderDate;
    private String orderAddress;
    private String orderEmail;
}
