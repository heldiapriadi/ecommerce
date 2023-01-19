package com.example.ecommerce.db.custom.mapper;

import com.example.ecommerce.db.custom.bean.ProductByCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductByCategoryMapper {
    @Select("SELECT p.product_id, p.name, p.description, p.price, p.quantity, p.image, c.product_category_id, c.name as category_name, c.description as category_description " +
            "FROM product p " +
            "INNER JOIN product_category c ON p.category_id = c.product_category_id " +
            "WHERE p.category_id = #{categoryId}")
    @Results({
            @Result(property = "productId", column = "product_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "price", column = "price"),
            @Result(property = "quantity", column = "quantity"),
            @Result(property = "image", column = "image"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "categoryName", column = "category_name"),
            @Result(property = "categoryDescription", column = "category_description")
    })
    List<ProductByCategory> getProductByCategory(Long categoryId);
}
