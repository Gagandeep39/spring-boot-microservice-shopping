package com.gagan.shoppingfrontendservice.service;

import com.gagan.shoppingfrontendservice.model.PurchaseDetails;
import com.gagan.shoppingfrontendservice.model.ShoppingCart;

import java.util.List;

/**
 * @author Gagandeep
 * @date 24-04-2020
 * @time 23:50
 */
public interface PurchaseService {

    public PurchaseDetails createPurchase(ShoppingCart cart);
    public List<PurchaseDetails> showAllBills();
}
