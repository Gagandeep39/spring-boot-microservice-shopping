package com.gagan.shoppingfrontendservice.service;

import com.gagan.shoppingfrontendservice.config.Helper;
import com.gagan.shoppingfrontendservice.model.PurchaseDetails;
import com.gagan.shoppingfrontendservice.model.ShoppingCart;
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
 * @time 23:51
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

    private Logger logger = LoggerFactory.getLogger(PurchaseServiceImpl.class);

    public static List<PurchaseDetails> purchaseDetailsList;

    @Autowired
    private ProductService service;

    @Autowired
    private RestTemplate restTemplate;
    @Value("${url.purchaseservice}")
    private String purchaseUrl;

    @Override
    public PurchaseDetails createPurchase(ShoppingCart cart) {
        for (int i=0; i<cart.getCartItems().size(); i++){
            cart.getCartItems().get(i).setCart(null);
        }
 PurchaseDetails details = restTemplate.postForObject( purchaseUrl+"/purchase", cart, PurchaseDetails.class);
        return details;
    }

    @Override
    public List<PurchaseDetails> showAllBills() {
        purchaseDetailsList = Arrays.asList(restTemplate.getForEntity(purchaseUrl + "/purchase/username/" + currentUser.getUsername(), PurchaseDetails[].class).getBody());
        logger.info(purchaseDetailsList.toString());
        service.fetchAllProducts();
        return purchaseDetailsList;
    }
}
