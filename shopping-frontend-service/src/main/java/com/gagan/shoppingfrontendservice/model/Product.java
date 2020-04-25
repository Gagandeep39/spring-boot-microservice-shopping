/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-23 11:06:19
 * @modify date 2020-04-23 11:06:19
 * @desc [description]
 */
package com.gagan.shoppingcartservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "shopping_product_table")
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Product Master - Product ID")
    private Integer productId;
    @Column(name = "product_stock")
    @ApiModelProperty(value = "Product Stocks - Total quantity of products availabke")
    private Integer stocks;

    @OneToOne
    @JoinColumn(name = "product_details_id")
    @ApiModelProperty(value = "Product Details Mapping")
    private ProductDetails productDetails;


    public Product() {
    }

    public Product(Integer productId, Integer stocks, ProductDetails productDetails) {
        this.productId = productId;
        this.stocks = stocks;
        this.productDetails = productDetails;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getStocks() {
        return this.stocks;
    }

    public void setStocks(Integer stocks) {
        this.stocks = stocks;
    }


    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", stocks=" + stocks +
                ", productDetails=" + productDetails +
                '}';
    }
}