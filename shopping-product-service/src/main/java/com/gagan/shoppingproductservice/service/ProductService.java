/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-23 01:08:44
 * @modify date 2020-04-23 01:08:44
 * @desc [description]
 */
package com.gagan.shoppingproductservice.service;

import java.util.List;

import com.gagan.shoppingproductservice.model.Product;
import com.gagan.shoppingproductservice.model.ShoppingCart;

public interface ProductService {

    public List<Product> fetchAllProducts();
    public List<Product> fetchRecommendedProduct(ShoppingCart cart);

}