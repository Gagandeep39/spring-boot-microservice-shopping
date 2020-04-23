/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-22 23:46:12
 * @modify date 2020-04-22 23:46:12
 * @desc [description]
 */
package com.gagan.shoppingcartservice.service;

import java.util.List;

import com.gagan.shoppingcartservice.model.Customer;
import com.gagan.shoppingcartservice.model.ShoppingCart;
import com.gagan.shoppingcartservice.repository.ShoppingCartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// @Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartRepository cartRepository;

    @Override
    public ShoppingCart updateCart(ShoppingCart cart) {
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public List<ShoppingCart> fetchCarts(Customer customer) {
        // cartRepository.findByUsername(customer.getUsername());
        List<ShoppingCart> carts = cartRepository.findAll(customer);
        return carts;
    }

    @Override
    public ShoppingCart createCart(Customer customer) {
        ShoppingCart newCart = new ShoppingCart();
        newCart.setStatus("Shopping");
        newCart.setCustomer(customer);
        cartRepository.save(newCart);
        return newCart;
    }

}