package com.example.ecommerce.db.bean;

import java.util.Date;

public class TransactionPayment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column transaction_payment.payment_id
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    private Long paymentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column transaction_payment.payment_method
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    private Integer paymentMethod;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column transaction_payment.payment_status
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    private Integer paymentStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column transaction_payment.order_id
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    private Long orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column transaction_payment.created_at
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    private Date createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column transaction_payment.updated_at
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    private Date updatedAt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column transaction_payment.payment_id
     *
     * @return the value of transaction_payment.payment_id
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    public Long getPaymentId() {
        return paymentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column transaction_payment.payment_id
     *
     * @param paymentId the value for transaction_payment.payment_id
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column transaction_payment.payment_method
     *
     * @return the value of transaction_payment.payment_method
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    public Integer getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column transaction_payment.payment_method
     *
     * @param paymentMethod the value for transaction_payment.payment_method
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column transaction_payment.payment_status
     *
     * @return the value of transaction_payment.payment_status
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column transaction_payment.payment_status
     *
     * @param paymentStatus the value for transaction_payment.payment_status
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column transaction_payment.order_id
     *
     * @return the value of transaction_payment.order_id
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column transaction_payment.order_id
     *
     * @param orderId the value for transaction_payment.order_id
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column transaction_payment.created_at
     *
     * @return the value of transaction_payment.created_at
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column transaction_payment.created_at
     *
     * @param createdAt the value for transaction_payment.created_at
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column transaction_payment.updated_at
     *
     * @return the value of transaction_payment.updated_at
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column transaction_payment.updated_at
     *
     * @param updatedAt the value for transaction_payment.updated_at
     *
     * @mbg.generated Sun Jan 22 17:40:26 ICT 2023
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}