package com.gagan.shoppingcartservice.repository;

import com.gagan.shoppingcartservice.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gagandeep
 * @date 23-04-2020
 * @time 13:41
 */

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}
