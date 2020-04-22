/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-23 00:52:19
 * @modify date 2020-04-23 00:52:19
 * @desc [description]
 */


package com.gagan.shoppingproductservice.controller;

import java.util.List;

import com.gagan.shoppingproductservice.model.Product;
import com.gagan.shoppingproductservice.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping(value="/products")
    public List<Product> fetchAllProducts() {
        return repository.findAll();
    }
    


}