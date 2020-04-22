package com.gagan.shoppingproductservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.gagan.shoppingproductservice.model.Product;
import com.gagan.shoppingproductservice.model.ShoppingCart;
import com.gagan.shoppingproductservice.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> fetchAllProducts() {
        return repository.findAll();
    }

    @Override
    public List<Product> fetchRecommendedProduct(ShoppingCart cart) {
        if (cart == null)
            return new ArrayList<Product>();
        List<Product> recommendedProducts = fetchAllProducts().stream()
                .filter(product -> cart.getProducts().stream()
                        .anyMatch(cartItem -> cartItem.getProductCategory().equals(product.getProductCategory())))
                .collect(Collectors.toList());
        if(recommendedProducts.size() > 10)
            return recommendedProducts.subList(0, 10);
        return recommendedProducts;
    };

}