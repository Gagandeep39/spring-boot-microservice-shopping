package com.gagan.shoppingfrontendservice.service;

import com.gagan.shoppingfrontendservice.model.Product;
import com.gagan.shoppingfrontendservice.model.ShoppingCart;

import java.util.List;

/**
 * @author Gagandeep
 * @date 24-04-2020
 * @time 17:55
 */
public interface ProductService {

    public List<Product> fetchAllProducts() throws Exception;
    public ShoppingCart addToCart(Integer productId, Integer quantity);
    public ShoppingCart deleteFromCart(Integer productId);
    public ShoppingCart saveCartToServer(ShoppingCart cart);
}
