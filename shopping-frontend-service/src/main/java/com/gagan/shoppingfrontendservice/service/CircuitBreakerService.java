package com.gagan.shoppingfrontendservice.service;

import com.gagan.shoppingfrontendservice.model.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author Gagandeep
 * @date 25-04-2020
 * @time 13:24
 */

@Service
public class CircuitBreakerService {

    @Value("${url.productservice}")
    private String productUrl;

    @Autowired
    private RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(CircuitBreakerService.class);
    @HystrixCommand(fallbackMethod = "handleFetchProduct")
    public List<Product> fetchFromProductService() {
        Product[] productArray = restTemplate.getForEntity(productUrl + "/products", Product[].class).getBody();
        List<Product> list = Arrays.asList(productArray);
        return list;
    }

    public List<Product> handleFetchProduct() throws Exception {
        return null;
    }
}
