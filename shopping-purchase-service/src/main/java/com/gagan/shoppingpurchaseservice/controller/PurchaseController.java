package com.gagan.shoppingpurchaseservice.controller;

import com.gagan.shoppingpurchaseservice.model.PurchaseDetails;
import com.gagan.shoppingpurchaseservice.model.ShoppingCart;
import com.gagan.shoppingpurchaseservice.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Gagandeep
 * @date 23-04-2020
 * @time 20:25
 */

@RestController
public class PurchaseController {

    @Autowired
    private PurchaseService service;

    @PostMapping("/purchase")
    public PurchaseDetails makePurchase(@RequestBody ShoppingCart cart) throws Exception {
        return service.completePurchase(cart);
    }

    @GetMapping("/purchase/username={username}")
    public List<PurchaseDetails> fetchPurchasesByUsername(@PathVariable String username){
        return service.fetchAllCustomerPurchase(username);
    }

    @GetMapping("/purchase")
    public List<PurchaseDetails> fetchAllPurchases(){
        return service.fetchAllPurchase();
    }

    @GetMapping("/purchase/id={id}")
    public PurchaseDetails fechDetailsById(@PathVariable Integer id) throws Exception {
        return service.completePurchaseByCartId(id);
    }

}
