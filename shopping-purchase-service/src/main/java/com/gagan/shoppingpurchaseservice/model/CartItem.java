/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-23 10:48:03
 * @modify date 2020-04-23 10:48:03
 * @desc [description]
 */
package com.gagan.shoppingpurchaseservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "shopping_cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_item_id")
    private Integer cartItemId;
    @Column(name = "cart_item_quantity")
    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "product_details_id")
    private ProductDetails productDetails;

//    dont use lazy loading to fix thi error
//    com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor
    @ManyToOne
    @JoinColumn(name = "cart_id")
    @JsonBackReference
    private ShoppingCart cart;


    public CartItem() {
    }

//     public CartItem(Integer cartItemId, Integer quantity, Product product) {
//         this.cartItemId = cartItemId;
//         this.quantity = quantity;
//         this.product = product;
//     }

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