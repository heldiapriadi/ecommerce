package com.example.ecommerce.db.custom.mapper;

import com.example.ecommerce.db.custom.bean.ProductCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CartProductMapper {

    @Select("SELECT p.product_id, p.name, cp.quantity, p.price, cp.quantity * p.price as total_price, cp.cart_id " +
            "FROM product p " +
            "INNER JOIN cart cp ON p.product_id = cp.product_id " +
            "WHERE cp.customer_id = #{customerId}")
    @Results({
            @Result(property = "productId", column = "product_id"),
            @Result(property = "productName", column = "name"),
            @Result(property = "quantity", column = "quantity"),
            @Result(property = "price", column = "price"),
            @Result(property = "totalPrice", column = "total_price"),
            @Result(property = "cartId", column = "cart_id")
    })
    List<ProductCart> getCartProduct(Long customerId);
}
