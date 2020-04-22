/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-22 20:14:08
 * @modify date 2020-04-22 20:14:08
 * @desc Registration COntroller
 */
package com.gagan.shoppingloginservice.controller;

import com.gagan.shoppingloginservice.model.Customer;
import com.gagan.shoppingloginservice.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller clas to Allow user registration
 */
@RestController
public class RegisterController {


    /**
     * Injecting Service dependency
     */
    @Autowired
    private CustomerService service;

    /**
     * 
     * @param customer Customer details to be added to the database
     * @return Customer detailsafter adding it to user
     */
    @PostMapping("/register")
    public Customer registerCustomer(@RequestBody Customer customer){
        service.addCustomer(customer);
        return customer;
    }

}