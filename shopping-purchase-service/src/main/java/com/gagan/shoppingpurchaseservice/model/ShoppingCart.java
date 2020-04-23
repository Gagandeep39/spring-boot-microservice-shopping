/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-22 22:58:19
 * @modify date 2020-04-22 22:58:19
 * @desc Shopping cart to add products
 */
package com.gagan.shoppingpurchaseservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * @OneToOne unidirectional mapping with user
 */
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartId;
    @Column(name = "cart_status")
    private String status;

    /**
     * **NOTE: Do not use Cascade type.Persist (It implies cascade save)
     */
    @ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
    @JoinColumn(name = "username")
    private Customer customer;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems = new ArrayList<>();

    public ShoppingCart() {}

    public void addCartItemToCart(CartItem item){
        cartItems.add(item);
    }

    public ShoppingCart(Integer cartId, String status, Customer customer, List<CartItem> cartItems) {
        this.cartId = cartId;
        this.status = status;
        this.customer = customer;
        this.cartItems = cartItems;
    }

    public Integer getCartId() {
        return this.cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<CartItem> getCartItems() {
        return this.cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }


    @Override
    public String toString() {
        return "{" +
            " cartId='" + getCartId() + "'" +
            ", status='" + getStatus() + "'" +
            ", customer='" + getCustomer() + "'" +
            "}";
    }


}