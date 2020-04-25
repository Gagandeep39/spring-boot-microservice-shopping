package com.gagan.shoppingpurchaseservice.controller;

import java.util.List;

import com.gagan.shoppingpurchaseservice.model.PurchaseDetails;
import com.gagan.shoppingpurchaseservice.model.ShoppingCart;
import com.gagan.shoppingpurchaseservice.repository.PurchaseRepository;
import com.gagan.shoppingpurchaseservice.service.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author Gagandeep
 * @date 23-04-2020
 * @time 20:25
 */

@RestController
@Api("Purchase COntroller to Generate a purchase Bill")
public class PurchaseController {

    @Autowired
    private PurchaseService service;

    @ApiOperation(
        value = "Show All Purchases for a given User", 
        notes = "Fetches a list of Purchases of a user based on username")
    @GetMapping("/purchase/username/{username}")
    public List<PurchaseDetails> fetchPurchasesByUsername(
            @ApiParam(value = "Username based on which product will be fetched", required = true)
            @PathVariable String username){
        return service.fetchAllCustomerPurchase(username);
    }

    @ApiOperation(
        value = "Show All purchases", 
        notes = "A complete list of purchases is returned")
    @GetMapping("/purchase")
    public List<PurchaseDetails> fetchAllPurchases(){
        return service.fetchAllPurchase();
    }

    @PostMapping("/purchase")
    public PurchaseDetails createPurchase(@RequestBody ShoppingCart shoppingCart)throws Exception {
        return service.completePurchase(shoppingCart);
    }




}
