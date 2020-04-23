/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-23 11:24:37
 * @modify date 2020-04-23 11:24:37
 * @desc [description]
 */
package com.gagan.shoppingproductservice.service;

import java.util.List;

import com.gagan.shoppingproductservice.model.ProductDetails;
import com.gagan.shoppingproductservice.repository.ProductDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductDetailsServiceImpl implements ProductDetailsService {

    @Autowired
    private ProductDetailsRepository detailsRepository;

    @Override
    public List<ProductDetails> fetchProductDetails() {
        return detailsRepository.findAll();
    }

    @Override
    public ProductDetails fetchProductDetailsById(Integer id) {
        return detailsRepository.findById(id).get();
    }

}