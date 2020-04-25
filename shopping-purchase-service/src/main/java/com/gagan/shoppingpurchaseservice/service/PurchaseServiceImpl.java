package com.gagan.shoppingpurchaseservice.service;

import com.gagan.shoppingpurchaseservice.model.PurchaseDetails;
import com.gagan.shoppingpurchaseservice.model.ShoppingCart;
import com.gagan.shoppingpurchaseservice.repository.PurchaseRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        details.setAmount(calculateAmount(cart));
        logger.info(details.getAmount() + "");
        details.setTimestamp(System.currentTimeMillis());
        cart.setStatus("Completed");
        ShoppingCart updatedCart = circuitBreakerService.updateCartStatus(cart);
        if(updatedCart==null) throw new Exception("Error Communication to Soping Cart service");
        details.setShoppingCart(updatedCart);
        repository.save(details);
        return details;
    }

    private double calculateAmount(ShoppingCart cart) {
        double amount = 0;
        for (int i = 0; i < cart.getCartItems().size(); i++) {
            logger.info("Price: " + cart.getCartItems().get(i).getProductDetails().getProductPrice());
            amount += cart.getCartItems().get(i).getQuantity() * cart.getCartItems().get(i).getProductDetails().getProductPrice();
        }
        return amount;
    }

    @Override
    public List<PurchaseDetails> fetchAllCustomerPurchase(String username) {
        List<PurchaseDetails> details = repository.findByUsername(username);
        logger.debug(details.toString());
        return details;
    }

    @Override
    public List<PurchaseDetails> fetchAllPurchase() {
        return repository.findAll();
    }

}
