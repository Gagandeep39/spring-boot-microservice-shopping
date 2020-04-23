package com.gagan.shoppingpurchaseservice.service;
import com.gagan.shoppingpurchaseservice.model.Product;
import com.gagan.shoppingpurchaseservice.model.PurchaseDetails;
import com.gagan.shoppingpurchaseservice.model.ShoppingCart;
import com.gagan.shoppingpurchaseservice.repository.PurchaseRepository;
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

    // private Logger logger = LoggerFactory.getLogger(PurchaseServiceImpl.class);

    @Autowired
    private PurchaseRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public PurchaseDetails completePurchase(ShoppingCart cart)throws Exception {
        ResponseEntity<Product[]> products = restTemplate.getForEntity("http://localhost:3004/products", Product[].class);
        Product[] productList = products.getBody();
        List<Product> list = Arrays.asList(productList);
        cart.getCartItems().forEach(cartItem -> {
            list.stream().forEach(product -> {
                if (product.getProductDetails().getProductDetailsId()==cartItem.getProductDetails().getProductDetailsId()){
                    product.setStocks(product.getStocks()-cartItem.getQuantity());
                }
            });
        });

        for (Product p: list) {
            if (p.getStocks()<0)
                throw new Exception("Product Out of Stock");
        }
        list.stream().forEach(product -> {
            restTemplate.postForObject("http://localhost:3004/products", product, Product.class);
        });
        PurchaseDetails details = new PurchaseDetails();
        details.setShoppingCart(cart);
        details.setAmount((double)calculateAmount(cart));
        details.setTimestamp(System.currentTimeMillis());
        repository.save(details);
        cart.setStatus("Completed");
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
}
