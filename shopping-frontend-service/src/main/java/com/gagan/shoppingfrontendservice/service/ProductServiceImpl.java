package com.gagan.shoppingfrontendservice.service;

import com.gagan.shoppingfrontendservice.model.CartItem;
import com.gagan.shoppingfrontendservice.model.Product;
import com.gagan.shoppingfrontendservice.model.ShoppingCart;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static com.gagan.shoppingfrontendservice.config.Helper.currentUser;


/**
 * @author Gagandeep
 * @date 24-04-2020
 * @time 18:01
 */

@Service
public class ProductServiceImpl implements ProductService {

    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Value("${url.productservice}")
    private String productUrl;

    @Value("${url.cartservice}")
    private String cartUrl;


    public static ShoppingCart cart;
    public static List<Product> products;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CircuitBreakerService breakerService;


    @Override
    public List<Product> fetchAllProducts() throws Exception {
        cart = new ShoppingCart();
        cart.setStatus("Shopping");
        cart.setCustomer(currentUser);
        products = breakerService.fetchFromProductService();
        if(products==null)throw new Exception("Hysterix: Error Communicating to Product Service");
        return products;
    }



    @Override
    public ShoppingCart addToCart(Integer productId, Integer quantity) {
        Product currentProduct = products.stream().filter(product -> product.getProductId() == productId).findFirst().get();
        logger.info(currentProduct.toString());
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setQuantity(quantity);
        cartItem.setProductDetails(currentProduct.getProductDetails());
        cart.addCartItem(cartItem);
        logger.info(cartItem.toString());
        logger.info(cart.toString());
        return cart;
    }

    @Override
    public ShoppingCart deleteFromCart(Integer productId) {
        List<CartItem> items = cart.getCartItems();
        int index = 0;
        for (int i=0; i<items.size(); i++){
            if (items.get(i).getProductDetails().getProductDetailsId()==productId){
                index = i;
            }
        }
        items.remove(index);
        cart.setCartItems(items);
        return cart;
    }



    @Override
    public ShoppingCart saveCartToServer(ShoppingCart cart) {
        for (int i=0; i<cart.getCartItems().size(); i++){
            cart.getCartItems().get(i).setCart(null);
        }
        logger.info(cart.toString());
        cart = restTemplate.postForObject(cartUrl + "/update", cart, ShoppingCart.class);
        logger.info(cart.toString());
        return cart;
    }


}

