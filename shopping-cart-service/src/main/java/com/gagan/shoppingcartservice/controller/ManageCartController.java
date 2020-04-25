package com.gagan.shoppingcartservice.controller;

import com.gagan.shoppingcartservice.model.CartItem;
import com.gagan.shoppingcartservice.model.Customer;
import com.gagan.shoppingcartservice.model.ShoppingCart;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.gagan.shoppingcartservice.service.ShoppingCartService;

import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class ManageCartController {

    @Autowired
    private ShoppingCartService service;

    @GetMapping("/carts")
    public List<ShoppingCart> fetchAllCarts(){
        return service.fetchAllCarts();
    }

    @GetMapping("/carts/{username}")
    public List<ShoppingCart> fetchCartsByUsername(@PathVariable String username){
        return service.fetchCartByUsername(username);
    }

    @PostMapping("/update")
    public ShoppingCart updateCart(@RequestBody ShoppingCart cart){
        return service.updateCart(cart);
    }
    
    @DeleteMapping("/carts/{id}")
    public ShoppingCart deleteCart(@PathVariable Integer id){
        return service.deleteCart(id);
    }
    

}