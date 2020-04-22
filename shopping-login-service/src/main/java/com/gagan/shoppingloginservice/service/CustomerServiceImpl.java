/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-22 20:27:40
 * @modify date 2020-04-22 20:27:40
 * @desc Customer Service Impl
 */
package com.gagan.shoppingloginservice.service;

import com.gagan.shoppingloginservice.model.Customer;
import com.gagan.shoppingloginservice.model.User;
import com.gagan.shoppingloginservice.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer validatCustomer(User user) {
        if (repository.findById(user.getUsername()).isPresent()) {
            return repository.findById(user.getUsername()).get();
        }
        return null;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        repository.save(customer);
        return customer;
    }

}