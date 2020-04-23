package com.gagan.shoppingpurchaseservice.service;

import java.util.Arrays;
import java.util.List;

import com.gagan.shoppingpurchaseservice.model.Product;
import com.gagan.shoppingpurchaseservice.model.ShoppingCart;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CircuitBreakerService {

    private Logger Logger = LoggerFactory.getLogger(CircuitBreakerService.class);

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "showErrorMessage")
    public ShoppingCart updateStocks(ShoppingCart cart) throws Exception {
        ResponseEntity<Product[]> products = restTemplate.getForEntity("http://shopping-product-service:3004/products",
                Product[].class);
        Product[] productList = products.getBody();
        List<Product> list = Arrays.asList(productList);
        cart.getCartItems().forEach(cartItem -> {
            list.stream().forEach(product -> {
                if (product.getProductDetails().getProductDetailsId() == cartItem.getProductDetails()
                        .getProductDetailsId()) {
                    product.setStocks(product.getStocks() - cartItem.getQuantity());
                }
            });
        });
        for (Product p : list) {
            if (p.getStocks() < 0)
                throw new Exception("Product Out of Stock");
        }
        list.stream().forEach(product -> {
            restTemplate.postForObject("http://shopping-product-service:3004/products", product, Product.class);
        });
        return cart;
    }

    public ShoppingCart showErrorMessage(ShoppingCart cart) throws Exception {
        Logger.error("Error making the purchase, cannot connect to product service");
        return null;
    }

    @HystrixCommand(fallbackMethod = "showCartErrorMessage")
    public ShoppingCart fetchCartById(Integer cartId) {
        ShoppingCart cart = restTemplate.getForObject("http://shopping-cart-service:3003/carts/id=" + cartId, ShoppingCart.class);
        return cart;
    }

    public ShoppingCart showCartErrorMessage(Integer cartId){
        Logger.error("Error making the purchase using ID, cannot connect to cart service");
        return null;
    }

    
    @HystrixCommand(fallbackMethod = "showupdateCartStatusError")
	public ShoppingCart updateCartStatus(ShoppingCart cart) {
        ShoppingCart updatedCart = restTemplate.postForObject("http://shopping-cart-service:3003/update", cart, ShoppingCart.class);
		return updatedCart;
    }
    
    public ShoppingCart showupdateCartStatusError(ShoppingCart cart){
        Logger.error("Error making the purchase using Shoppin Cart, cannot connect to cart service");
        return null;
    }
}