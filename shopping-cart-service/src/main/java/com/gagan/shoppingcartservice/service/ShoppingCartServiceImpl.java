/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-22 23:46:12
 * @modify date 2020-04-22 23:46:12
 * @desc [description]
 */
package com.gagan.shoppingcartservice.service;

import java.util.List;

import com.gagan.shoppingcartservice.model.CartItem;
import com.gagan.shoppingcartservice.model.Customer;
import com.gagan.shoppingcartservice.model.ShoppingCart;
import com.gagan.shoppingcartservice.repository.CartItemRepository;
import com.gagan.shoppingcartservice.repository.ShoppingCartRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {

    Logger logger = LoggerFactory.getLogger(ShoppingCartServiceImpl.class);

    @Autowired
    private ShoppingCartRepository cartRepository;

    @Autowired
    private CartItemRepository itemRepository;

    @Override
    public ShoppingCart updateCart(ShoppingCart cart) {
        for(int i=0; i<cart.getCartItems().size(); i++) {
            CartItem item = cart.getCartItems().get(i);
            itemRepository.save(item);
        }
        ShoppingCart c = cartRepository.save(cart);
        logger.info(c.toString());
        return c;
    }

    @Override
    public List<ShoppingCart> fetchAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public List<ShoppingCart> fetchCartByUsername(String username) {
        return cartRepository.findByUsername(username);
    }

    @Override
    public ShoppingCart deleteCart(Integer cartId) {
        ShoppingCart cartItem = cartRepository.findById(cartId).get();
        cartRepository.delete(cartItem);
        return cartItem;
    }

    @Override
    public ShoppingCart findCartById(Integer id) {
        return cartRepository.findById(id).get();
    }

}