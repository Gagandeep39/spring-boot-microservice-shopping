/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-23 11:14:12
 * @modify date 2020-04-23 11:14:12
 * @desc [description]
 */
package com.gagan.shoppingproductservice.service;

import java.util.List;

import com.gagan.shoppingproductservice.model.Product;
import com.gagan.shoppingproductservice.repository.ProductDetailsRepository;
import com.gagan.shoppingproductservice.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductDetailsRepository detailsRepository;

    @Override
    public void addProduct(Product product) {
        detailsRepository.save(product.getProductDetails());
        repository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        detailsRepository.save(product.getProductDetails());
        repository.save(product);
    }

    @Override
    public List<Product> fetchAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product fetchById(Integer productId) {
        return repository.findById(productId).get();
    }

}