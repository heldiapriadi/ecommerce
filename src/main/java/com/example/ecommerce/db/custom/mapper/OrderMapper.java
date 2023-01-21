package com.example.ecommerce.db.custom.mapper;

import com.example.ecommerce.db.bean.TransactionOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface OrderMapper {
    @Insert("INSERT INTO transaction_order (customer_id, order_date, status, total_price, created_at, updated_at) " +
            "VALUES (#{customerId}, #{orderDate}, #{status}, #{totalPrice}, #{createdAt}, #{updatedAt})")
    @Options(useGeneratedKeys = true, keyProperty = "orderId")
    Long insertAndGetId(TransactionOrder order);
}
