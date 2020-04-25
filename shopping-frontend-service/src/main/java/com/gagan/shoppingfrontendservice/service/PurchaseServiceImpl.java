package com.gagan.shoppingfrontendservice.service;

import com.gagan.shoppingfrontendservice.config.Helper;
import com.gagan.shoppingfrontendservice.model.ProductDetails;
import com.gagan.shoppingfrontendservice.model.PurchaseDetails;
import com.gagan.shoppingfrontendservice.model.ShoppingCart;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.SneakyThrows;
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
    public PurchaseDetails createPurchase(ShoppingCart cart) throws Exception {
        for (int i = 0; i < cart.getCartItems().size(); i++) {
            cart.getCartItems().get(i).setCart(null);
        }
        PurchaseDetails details = restTemplate.postForObject(purchaseUrl + "/purchase", cart, PurchaseDetails.class);
        service.fetchAllProducts();
        return details;
    }

    @Override
    public List<PurchaseDetails> showAllBills() throws Exception {
        purchaseDetailsList = getPurchaseDetails();
        logger.info(purchaseDetailsList.toString());
        service.fetchAllProducts();
        return purchaseDetailsList;
    }

    private List<PurchaseDetails> getPurchaseDetails() {
        logger.info("--------------------");
       PurchaseDetails[] array = restTemplate
                .getForEntity(purchaseUrl + "/purchase/username/" + currentUser.getUsername(), PurchaseDetails[].class)
                .getBody();
       List<PurchaseDetails> details = Arrays.asList(array);
        return details;
    }

}
