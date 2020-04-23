package com.gagan.shoppingcartservice.repository;

import java.util.List;

import com.gagan.shoppingcartservice.model.Customer;
import com.gagan.shoppingcartservice.model.ShoppingCart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    @Query("FROM ShoppingCart c WHERE c.customer.username = :username")
    List<ShoppingCart> findByUsername(@Param("username") String username);

}