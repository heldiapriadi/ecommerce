package com.example.ecommerce.db.bean;

public class ProductCategory {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_category.product_category_id
     *
     * @mbg.generated Thu Jan 19 15:23:10 ICT 2023
     */
    private Long productCategoryId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_category.name
     *
     * @mbg.generated Thu Jan 19 15:23:10 ICT 2023
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_category.description
     *
     * @mbg.generated Thu Jan 19 15:23:10 ICT 2023
     */
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_category.product_category_id
     *
     * @return the value of product_category.product_category_id
     *
     * @mbg.generated Thu Jan 19 15:23:10 ICT 2023
     */
    public Long getProductCategoryId() {
        return productCategoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_category.product_category_id
     *
     * @param productCategoryId the value for product_category.product_category_id
     *
     * @mbg.generated Thu Jan 19 15:23:10 ICT 2023
     */
    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_category.name
     *
     * @return the value of product_category.name
     *
     * @mbg.generated Thu Jan 19 15:23:10 ICT 2023
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_category.name
     *
     * @param name the value for product_category.name
     *
     * @mbg.generated Thu Jan 19 15:23:10 ICT 2023
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_category.description
     *
     * @return the value of product_category.description
     *
     * @mbg.generated Thu Jan 19 15:23:10 ICT 2023
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_category.description
     *
     * @param description the value for product_category.description
     *
     * @mbg.generated Thu Jan 19 15:23:10 ICT 2023
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}