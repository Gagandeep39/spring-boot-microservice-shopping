/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-23 02:14:56
 * @modify date 2020-04-23 02:14:56
 * @desc [description]
 */
package com.gagan.shoppingcartservice.service;

import java.util.List;

import com.gagan.shoppingcartservice.model.Customer;
import com.gagan.shoppingcartservice.model.ShoppingCart;

public interface ShoppingCartService {

    public ShoppingCart updateCart(ShoppingCart cart);
    public List<ShoppingCart> fetchCarts();
    public ShoppingCart createCart(Customer customer);

}