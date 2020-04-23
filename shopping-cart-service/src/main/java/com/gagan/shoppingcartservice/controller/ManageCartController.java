package com.gagan.shoppingcartservice.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.gagan.shoppingcartservice.model.Customer;
import com.gagan.shoppingcartservice.model.ShoppingCart;
import com.gagan.shoppingcartservice.service.ShoppingCartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ManageCartController {

    @Autowired
    private ShoppingCartService service;

    @PostMapping("/carts")
    public List<ShoppingCart> fetchAllCarts(){
        return service.fetchCarts();
    }

    @PostMapping("/update")
    public ShoppingCart updateCart(@RequestBody ShoppingCart cart){
        return service.updateCart(cart);
    }
    
    @PostMapping("/create")
    public ShoppingCart createCart(@RequestBody Customer customer){
        return service.createCart(customer);
    }

}