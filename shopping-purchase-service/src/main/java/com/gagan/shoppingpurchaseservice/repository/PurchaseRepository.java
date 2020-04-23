package com.gagan.shoppingpurchaseservice.repository;

import com.gagan.shoppingpurchaseservice.model.PurchaseDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Gagandeep
 * @date 23-04-2020
 * @time 20:06
 */

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseDetails, Integer> {
    @Query(value = "SELECT p FROM PurchaseDetails p WHERE p.shoppingCart.customer.username=?1")
    public List<PurchaseDetails> findByUsername(String username);
}
