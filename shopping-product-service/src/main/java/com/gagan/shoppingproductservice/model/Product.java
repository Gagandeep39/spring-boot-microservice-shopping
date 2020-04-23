/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-22 23:23:23
 * @modify date 2020-04-22 23:23:23
 * @desc [description]
 */
package com.gagan.shoppingproductservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "shopping_product")
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_category")
    private String productCategory;
    @Column(name = "product_price")
    private double productPrice;

    // @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH,
    // CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    // @JoinTable(name = "cart_product", joinColumns = @JoinColumn(name =
    // "product_id"), inverseJoinColumns = @JoinColumn(name = "cart_id"))
    // private List<ShoppingCart> carts;

    // public void addToCart(ShoppingCart cart){
    // if(carts == null)
    // carts = new ArrayList<>();
    // carts.add(cart);
    // }

    public Product() {

    }

    public Product(String productName) {
        this.productName = productName;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    // public List<ShoppingCart> getCarts() {
    // return this.carts;
    // }
    
    // public void setCarts(List<ShoppingCart> carts) {
    // this.carts = carts;
    // }

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
        return "{" + " productId='" + getProductId() + "'" + ", productName='" + getProductName() + "'"
                + ", productCategory='" + getProductCategory() + "'" + ", productPrice='" + getProductPrice() + "'"
                + "}";
    }

}
