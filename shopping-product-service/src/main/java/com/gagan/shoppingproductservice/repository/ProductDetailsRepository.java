package com.gagan.shoppingproductservice.repository;

import com.gagan.shoppingproductservice.model.ProductDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer> {

}