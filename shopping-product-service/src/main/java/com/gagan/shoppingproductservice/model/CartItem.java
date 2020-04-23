/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-23 10:48:03
 * @modify date 2020-04-23 10:48:03
 * @desc [description]
 */
package com.gagan.shoppingproductservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_cart_item")
public class CartItem {

    @Id
    @Column(name = "cart_item_id")
    private Integer cartItemId;
    @Column(name = "cart_item_quantity")
    private Integer quantity;
    // @OneToOne
    // @JoinColumn(name = "product_id")
    // private Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private ShoppingCart cart;


    public CartItem() {
    }

    // public CartItem(Integer cartItemId, Integer quantity, Product product) {
    //     this.cartItemId = cartItemId;
    //     this.quantity = quantity;
    //     this.product = product;
    // }

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

    // public Product getProduct() {
    //     return this.product;
    // }

    // public void setProduct(Product product) {
    //     this.product = product;
    // }


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
            // ", product='" + getProduct() + "'" +
            "}";
    }



}