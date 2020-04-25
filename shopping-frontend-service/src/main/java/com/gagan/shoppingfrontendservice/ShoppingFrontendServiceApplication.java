package com.gagan.shoppingfrontendservice;

import com.gagan.shoppingfrontendservice.exception.RestResponseErrorHandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ShoppingFrontendServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingFrontendServiceApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate(){
        RestTemplate template = new RestTemplate();
        template.setErrorHandler(new RestResponseErrorHandler());
        return template;
    }
}
