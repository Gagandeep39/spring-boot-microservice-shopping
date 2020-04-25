package com.gagan.shoppingfrontendservice.service;

import com.gagan.shoppingfrontendservice.exception.CustomerNotFoundException;
import com.gagan.shoppingfrontendservice.model.Customer;
import com.gagan.shoppingfrontendservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.gagan.shoppingfrontendservice.config.Helper.currentUser;

/**
 * @author Gagandeep
 * @date 24-04-2020
 * @time 14:22
 */

@Service
public class LoginServiceImpl implements LoginService {


    @Value("${url.loginservice}")
    private String loginUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Customer registerUser(Customer customer) {
        Customer registeredCustomer = restTemplate.postForObject(loginUrl + "/register", customer, Customer.class);
        return registeredCustomer;
    }

    @Override
    public Customer validateLogin(User user) throws CustomerNotFoundException {
        currentUser = restTemplate.postForObject(  loginUrl+"/login", user, Customer.class);
        if(currentUser!=null && currentUser.getName()==null)
            throw new CustomerNotFoundException("Customer Not Found");
        return currentUser;
    }
}
