/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-22 23:54:34
 * @modify date 2020-04-22 23:54:34
 * @desc [description]
 */
package com.gagan.shoppingproductservice.repository;

import com.gagan.shoppingproductservice.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}