/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-23 11:27:20
 * @modify date 2020-04-23 11:27:20
 * @desc [description]
 */
package com.gagan.shoppingproductservice.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.gagan.shoppingproductservice.model.ProductDetails;
import com.gagan.shoppingproductservice.service.ProductDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ProductDetailsController {

    @Autowired
    private ProductDetailsService detailsService;

    @GetMapping(value="/productdetails")
    public List<ProductDetails> getProductDetails() {
        return detailsService.fetchProductDetails();
    }
    

}