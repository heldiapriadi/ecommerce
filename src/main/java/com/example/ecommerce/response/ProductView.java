package com.example.ecommerce.response;

import com.example.ecommerce.db.custom.bean.ProductByCategory;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductView {
    private Long productId;
    private String name;
    private String description;
    private Long price;
    private Integer quantity;
    private String image;

    public static List<ProductView> convert(List<ProductByCategory> productByCategoryList) {
        List<ProductView> productViews = new ArrayList<>();
        productByCategoryList.forEach(productByCategory -> {
            ProductView productView = new ProductView();
            productView.setProductId(productByCategory.getProductId());
            productView.setName(productByCategory.getName());
            productView.setDescription(productByCategory.getDescription());
            productView.setPrice(productByCategory.getPrice());
            productView.setQuantity(productByCategory.getQuantity());
            productView.setImage(productByCategory.getImage());
            productViews.add(productView);
        });
        return productViews;
    }
}
