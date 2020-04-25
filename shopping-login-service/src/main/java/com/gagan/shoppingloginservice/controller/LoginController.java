/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-22 19:44:23
 * @modify date 2020-04-22 19:44:23
 * @desc Login Controller class
 */
package com.gagan.shoppingloginservice.controller;


import javax.management.RuntimeErrorException;

import com.gagan.shoppingloginservice.model.Customer;
import com.gagan.shoppingloginservice.model.User;
import com.gagan.shoppingloginservice.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Used to Validate the Login User against username and Password
 */
@RestController
public class LoginController {

    /**
     * Service object
     */
    @Autowired
    private CustomerService service;

    /**
     * Login Service to validate user
     * 
     * @param User User credential to be logged in
     * @return User details of the valid user
     * @throws Exception
     */
    @PostMapping("/login")
    public User validateUser(@RequestBody User user) throws Exception {
        Customer customer = service.validatCustomer(user);
        if(customer==null)
            throw new RuntimeException("Invalid Username Password");
        return customer;
    }

}