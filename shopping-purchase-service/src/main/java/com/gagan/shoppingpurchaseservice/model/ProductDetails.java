/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-22 23:23:23
 * @modify date 2020-04-22 23:23:23
 * @desc Product Class. Must not be Changed. Fully Tested and Functional
 */
package com.gagan.shoppingpurchaseservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@Entity
@Table(name = "shopping_product_details_table")
@ApiModel(value = "Product Details such as price, category etc")
public class ProductDetails {

    @Id
    @Column(name = "product_details_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Product Details ID")
    private Integer productDetailsId;
    @Column(name = "product_name")
    @ApiModelProperty(value = "Product Name")
    private String productName;
    @Column(name = "product_category")
    @ApiModelProperty(value = "Category Of Product")
    private String productCategory;
    @Column(name = "product_price")
    @ApiModelProperty(value = "Product Price")
    private double productPrice;

    public ProductDetails() {

    }

    public ProductDetails(Integer productDetailsId, String productName, String productCategory, double productPrice) {
        this.productDetailsId = productDetailsId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
    }

    public Integer getProductDetailsId() {
        return this.productDetailsId;
    }

    public void setProductDetailsId(Integer productDetailsId) {
        this.productDetailsId = productDetailsId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return this.productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public double getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "{" +
            " productDetailsId='" + getProductDetailsId() + "'" +
            ", productName='" + getProductName() + "'" +
            ", productCategory='" + getProductCategory() + "'" +
            ", productPrice='" + getProductPrice() + "'" +
            "}";
    }


}
