/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-23 10:48:03
 * @modify date 2020-04-23 10:48:03
 * @desc [description]
 */
package com.gagan.shoppingfrontendservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
public class CartItem {

    private Integer cartItemId;
    private Integer quantity;
    private ProductDetails productDetails;
    private ShoppingCart cart;

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId=" + cartItemId +
                ", quantity=" + quantity +
                ", productDetails=" + productDetails +
                '}';
    }
}