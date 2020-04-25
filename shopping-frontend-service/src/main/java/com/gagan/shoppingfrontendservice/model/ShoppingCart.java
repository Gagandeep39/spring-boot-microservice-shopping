/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-22 22:58:19
 * @modify date 2020-04-22 22:58:19
 * @desc Shopping cart to add products
 */
package com.gagan.shoppingfrontendservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @OneToOne unidirectional mapping with user
 */
@Getter
@Setter
@NoArgsConstructor
public class ShoppingCart {

    private Integer cartId;
    private String status;
    private Customer customer;
    private List<CartItem> cartItems = new ArrayList<>();

    public void addCartItem(CartItem item){
        cartItems.add(item);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cartId=" + cartId +
                ", status='" + status + '\'' +
                ", customer=" + customer +
                '}';
    }
}