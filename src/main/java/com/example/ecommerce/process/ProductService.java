package com.example.ecommerce.process;

import com.example.ecommerce.db.custom.bean.ProductByCategory;
import com.example.ecommerce.db.custom.mapper.ProductByCategoryMapper;
import com.example.ecommerce.response.ProductByCategoryResponse;
import com.example.ecommerce.response.ProductView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductCategoryView{
    private final ProductByCategoryMapper productByCategoryMapper;

    @Override
    public ProductByCategoryResponse getProductByCategory(Long categoryId) {
        List<ProductByCategory> productByCategoryList = productByCategoryMapper.getProductByCategory(categoryId);
        ProductByCategoryResponse productByCategoryResponse = new ProductByCategoryResponse();
        productByCategoryResponse.setCategoryId(categoryId);
        productByCategoryResponse.setCategoryName(productByCategoryList.get(0).getCategoryName());
        productByCategoryResponse.setCategoryDescription(productByCategoryList.get(0).getCategoryDescription());
        productByCategoryResponse.setProducts(ProductView.convert(productByCategoryList));
        return productByCategoryResponse;
    }
}
