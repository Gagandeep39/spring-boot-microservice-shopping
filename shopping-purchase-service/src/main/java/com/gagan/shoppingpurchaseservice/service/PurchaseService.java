package com.gagan.shoppingpurchaseservice.service;

import com.gagan.shoppingpurchaseservice.model.PurchaseDetails;
import com.gagan.shoppingpurchaseservice.model.ShoppingCart;

import java.util.List;

/**
 * @author Gagandeep
 * @date 23-04-2020
 * @time 20:08
 */
public interface PurchaseService {

    public PurchaseDetails completePurchase(ShoppingCart cart) throws Exception;
    public List<PurchaseDetails> fetchAllCustomerPurchase(String username);
    public List<PurchaseDetails>  fetchAllPurchase();
    public PurchaseDetails completePurchaseByCartId(Integer cartId) throws Exception;
}
