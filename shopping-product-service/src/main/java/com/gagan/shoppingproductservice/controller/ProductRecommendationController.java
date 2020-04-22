/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-23 01:05:32
 * @modify date 2020-04-23 01:05:32
 * @desc [description]
 */
package com.gagan.shoppingproductservice.controller;

import java.util.List;

import com.gagan.shoppingproductservice.model.Product;
import com.gagan.shoppingproductservice.model.ShoppingCart;
import com.gagan.shoppingproductservice.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductRecommendationController {

    @Autowired
    private ProductService productService;

    @PostMapping(value="/recommendation")
    public List<Product> getRecommendedProducts(@RequestBody ShoppingCart cart) {
        List<Product> recommendedProducts = productService.fetchRecommendedProduct(cart);
        return recommendedProducts;
    }
    

}