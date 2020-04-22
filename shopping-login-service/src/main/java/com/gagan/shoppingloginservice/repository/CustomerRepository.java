/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-22 20:17:11
 * @modify date 2020-04-22 20:17:11
 * @desc Customer Repository
 */
package com.gagan.shoppingloginservice.repository;

import com.gagan.shoppingloginservice.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Store Cusotmer Information
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    // @Query("SELECT c FROM Customer c WHERE c.username= ?1")
    // Customer findCustomerByUsername(String username);
}