package com.gagan.shoppingfrontendservice.controller;

import com.gagan.shoppingfrontendservice.model.PurchaseDetails;
import com.gagan.shoppingfrontendservice.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import static com.gagan.shoppingfrontendservice.service.PurchaseServiceImpl.purchaseDetailsList;
import static com.gagan.shoppingfrontendservice.service.ProductServiceImpl.cart;

/**
 * @author Gagandeep
 * @date 24-04-2020
 * @time 23:42
 */

@Controller
@RequestMapping("/PurchaseCtrl")
public class PurchaseController {

    @Autowired
    private PurchaseService service;

    @GetMapping("/purchasehistory")
    public String showPurchaseHistory(Model model){
        List<PurchaseDetails> purchaseDetails = new ArrayList<>();
        if (purchaseDetailsList==null || purchaseDetailsList.size()<=0)
            purchaseDetails = service.showAllBills();
        purchaseDetailsList = purchaseDetails;
        model.addAttribute("purchases", purchaseDetailsList);
        return "PurchaseHistory";
    }

    @GetMapping("/generatebill")
    public String showBill(Model model){
        PurchaseDetails details = service.createPurchase(cart);
        model.addAttribute("purchase", details);
        return "BillingPage";
    }
}
