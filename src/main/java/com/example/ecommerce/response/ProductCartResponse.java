package com.example.ecommerce.response;

import com.example.ecommerce.db.custom.bean.ProductCart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProductCartResponse {
    private Long cartId;
    private Long productId;
    private String productName;
    private int quantity;
    private BigDecimal price;
    private BigDecimal totalPrice;

    public static List<ProductCartResponse> fromProductCarts(List<ProductCart> productCarts) {
        List<ProductCartResponse> productCartResponses = new ArrayList<>();
        productCarts.forEach(productCart -> {
            ProductCartResponse productCartResponse = new ProductCartResponse();
            productCartResponse.setCartId(productCart.getCartId());
            productCartResponse.setProductId(productCart.getProductId());
            productCartResponse.setProductName(productCart.getProductName());
            productCartResponse.setQuantity(productCart.getQuantity());
            productCartResponse.setPrice(productCart.getPrice());
            productCartResponse.setTotalPrice(productCart.getTotalPrice());
            productCartResponses.add(productCartResponse);
        });
        return productCartResponses;
    }
}
