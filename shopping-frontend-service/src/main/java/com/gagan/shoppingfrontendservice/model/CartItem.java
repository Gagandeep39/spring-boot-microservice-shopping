/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-23 10:48:03
 * @modify date 2020-04-23 10:48:03
 * @desc [description]
 */
package com.gagan.shoppingcartservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Cart Item - To store product detail that was added to cart")
@Entity
@Table(name = "shopping_cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_item_id")
    @ApiModelProperty(value = "Cart Item Id")
    private Integer cartItemId;
    @Column(name = "cart_item_quantity")
    @ApiModelProperty(value = "Cart Item Quatity Purchased")
    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "product_details_id")
    @ApiModelProperty(value = "Product Details")
    private ProductDetails productDetails;

//    dont use lazy loading to fix thi error
//    com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor
    @ManyToOne
    @JoinColumn(name = "cart_id")
    @ApiModelProperty(value = "Shopping Cart o which this item belong. It is used for abck refenrece")
    @JsonBackReference
    private ShoppingCart cart;


    public CartItem() {
    }

    public Integer getCartItemId() {
        return this.cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    public ShoppingCart getCart() {
        return this.cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "{" +
                " cartItemId='" + getCartItemId() + "'" +
                ", quantity='" + getQuantity() + "'" +
                ", productDetails='" + getProductDetails() + "'" +
                "}";
    }


}