package com.example.ecommerce.db.mapper;

import com.example.ecommerce.db.bean.Product;
import com.example.ecommerce.db.bean.ProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    long countByExample(ProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    int deleteByExample(ProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    int deleteByPrimaryKey(Long productId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    int insert(Product row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    int insertSelective(Product row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    List<Product> selectByExample(ProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    Product selectByPrimaryKey(Long productId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    int updateByExampleSelective(@Param("row") Product row, @Param("example") ProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    int updateByExample(@Param("row") Product row, @Param("example") ProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    int updateByPrimaryKeySelective(Product row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    int updateByPrimaryKey(Product row);
}