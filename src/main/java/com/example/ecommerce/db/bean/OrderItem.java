package com.example.ecommerce.db.bean;

public class OrderItem {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_item.order_item_id
     *
     * @mbg.generated Tue Jan 17 00:34:23 WIB 2023
     */
    private Long orderItemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_item.quantity
     *
     * @mbg.generated Tue Jan 17 00:34:23 WIB 2023
     */
    private Integer quantity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_item.order_id
     *
     * @mbg.generated Tue Jan 17 00:34:23 WIB 2023
     */
    private Long orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_item.product_id
     *
     * @mbg.generated Tue Jan 17 00:34:23 WIB 2023
     */
    private Long productId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_item.order_item_id
     *
     * @return the value of order_item.order_item_id
     *
     * @mbg.generated Tue Jan 17 00:34:23 WIB 2023
     */
    public Long getOrderItemId() {
        return orderItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_item.order_item_id
     *
     * @param orderItemId the value for order_item.order_item_id
     *
     * @mbg.generated Tue Jan 17 00:34:23 WIB 2023
     */
    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_item.quantity
     *
     * @return the value of order_item.quantity
     *
     * @mbg.generated Tue Jan 17 00:34:23 WIB 2023
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_item.quantity
     *
     * @param quantity the value for order_item.quantity
     *
     * @mbg.generated Tue Jan 17 00:34:23 WIB 2023
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_item.order_id
     *
     * @return the value of order_item.order_id
     *
     * @mbg.generated Tue Jan 17 00:34:23 WIB 2023
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_item.order_id
     *
     * @param orderId the value for order_item.order_id
     *
     * @mbg.generated Tue Jan 17 00:34:23 WIB 2023
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_item.product_id
     *
     * @return the value of order_item.product_id
     *
     * @mbg.generated Tue Jan 17 00:34:23 WIB 2023
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_item.product_id
     *
     * @param productId the value for order_item.product_id
     *
     * @mbg.generated Tue Jan 17 00:34:23 WIB 2023
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }
}