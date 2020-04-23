package com.gagan.shoppingproductservice.service;

import java.util.List;

import com.gagan.shoppingproductservice.model.ProductDetails;

public interface ProductDetailsService {

    public List<ProductDetails> fetchProductDetails();
    public ProductDetails fetchProductDetailsById(Integer id);

}