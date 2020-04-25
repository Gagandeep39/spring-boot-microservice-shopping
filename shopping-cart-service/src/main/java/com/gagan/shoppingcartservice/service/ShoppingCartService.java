/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-23 02:14:56
 * @modify date 2020-04-23 02:14:56
 * @desc [description]
 */
package com.gagan.shoppingcartservice.service;

import com.gagan.shoppingcartservice.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    public ShoppingCart updateCart(ShoppingCart cart);
    public List<ShoppingCart> fetchAllCarts();
    public List<ShoppingCart> fetchCartByUsername(String username);
    public ShoppingCart deleteCart(Integer cartId);
    public ShoppingCart findCartById(Integer id);
}