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
        return cartRepository.save(cart);
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
    public ShoppingCart createCart(Customer customer) {
        ShoppingCart newCart = new ShoppingCart();
        newCart.setStatus("Shopping");
        newCart.setCustomer(customer);
        cartRepository.save(newCart);
        return newCart;
    }

    @Override
    public ShoppingCart deleteCart(Integer cartId) {
        ShoppingCart cartItem = cartRepository.findById(cartId).get();
        cartRepository.delete(cartItem);
        return cartItem;
    }

    @Override
    public ShoppingCart addItemToCart(CartItem cartItem) {
        itemRepository.save(cartItem);
        return findCartById(cartItem.getCart().getCartId());
    }

    @Override
    public ShoppingCart deleteFromCart(Integer id) {
        CartItem item = itemRepository.findById(id).get();
        ShoppingCart cart = findCartById(item.getCart().getCartId());
        itemRepository.delete(item);
        return cart;
    }

    @Override
    public ShoppingCart findCartById(Integer id) {
        return cartRepository.findById(id).get();
    }

    @Override
    public ShoppingCart fetchCartById(Integer id) {
        return cartRepository.findById(id).get();
    }

}