/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-22 20:27:36
 * @modify date 2020-04-22 20:27:36
 * @desc CustomerService Interface
 */
package com.gagan.shoppingloginservice.service;

import com.gagan.shoppingloginservice.model.Customer;
import com.gagan.shoppingloginservice.model.User;

/**
 * Provide Login/Registration related operation
 */
public interface CustomerService {

    public Customer validatCustomer(User user) throws Exception;
    public Customer addCustomer(Customer customer);

}