package com.gagan.shoppingfrontendservice.service;

import com.gagan.shoppingfrontendservice.exception.CustomerNotFoundException;
import com.gagan.shoppingfrontendservice.model.Customer;
import com.gagan.shoppingfrontendservice.model.User;

/**
 * @author Gagandeep
 * @date 24-04-2020
 * @time 14:21
 */
public interface LoginService {

    public Customer registerUser(Customer customer);
    public Customer validateLogin(User user) throws CustomerNotFoundException;
}
