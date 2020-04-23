package com.gagan.shoppingpurchaseservice.service;

import com.gagan.shoppingpurchaseservice.model.Product;
import com.gagan.shoppingpurchaseservice.model.PurchaseDetails;
import com.gagan.shoppingpurchaseservice.model.ShoppingCart;
import com.gagan.shoppingpurchaseservice.repository.PurchaseRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author Gagandeep
 * @date 23-04-2020
 * @time 20:09
 */

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {

    private Logger logger = LoggerFactory.getLogger(PurchaseServiceImpl.class);

    @Autowired
    private PurchaseRepository repository;

    @Autowired
    private CircuitBreakerService circuitBreakerService;

    @Override
    public PurchaseDetails completePurchase(ShoppingCart shoppingCart)throws Exception {
        if(shoppingCart.getStatus().equals("Completed")) throw new Exception("Cart has already been checked out");
        ShoppingCart cart = circuitBreakerService.updateStocks(shoppingCart);
        if(cart==null) throw new Exception("Unable to communicate to Product service, try again later");
        return createPurchaseDetails(cart);
    }

    private PurchaseDetails createPurchaseDetails(ShoppingCart cart) throws Exception {
        PurchaseDetails details = new PurchaseDetails();
        details.setAmount((double)calculateAmount(cart));
        details.setTimestamp(System.currentTimeMillis());
        cart.setStatus("Completed");
        ShoppingCart updatedCart = circuitBreakerService.updateCartStatus(cart);
        if(updatedCart==null) throw new Exception("Error Communication to Soping Cart service");
        details.setShoppingCart(updatedCart);
        repository.save(details);
        return details;
    }

    int amount = 0;
    private int calculateAmount(ShoppingCart cart) {
        amount = 0;
        cart.getCartItems().forEach(item-> {
            int quantiy = item.getQuantity();
            double price = item.getProductDetails().getProductPrice();
            amount += quantiy*price;
        });
        return amount;
    }

    @Override
    public List<PurchaseDetails> fetchAllCustomerPurchase(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public List<PurchaseDetails> fetchAllPurchase() {
        return repository.findAll();
    }

    @Override
    public PurchaseDetails completePurchaseByCartId(Integer cartId) throws Exception {
        ShoppingCart cart = circuitBreakerService.fetchCartById(cartId);
        if(cart==null) throw new Exception("Error making the purchase using ID, cannot connect to cart service");
        logger.info(cart.getStatus());
        if(cart.getStatus().equals("Completed")) throw new Exception("Cart has already been checked out");
        return createPurchaseDetails(cart);
    }
}
