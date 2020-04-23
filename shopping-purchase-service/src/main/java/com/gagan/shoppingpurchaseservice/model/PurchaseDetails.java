package com.gagan.shoppingpurchaseservice.model;

import javax.persistence.*;

/**
 * @author Gagandeep
 * @date 23-04-2020
 * @time 20:00
 */

@Entity
@Table(name = "shopping_purchase_table")
public class PurchaseDetails {

    @Id
    @Column(name = "purchase_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer purchaseId;

    @Column(name = "timestamp")
    private Long timestamp;

    @Column(name = "amount")
    private Double amount;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private ShoppingCart shoppingCart;

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public PurchaseDetails() {
    }

    @Override
    public String toString() {
        return "PurchaseDetails{" +
                "purchaseId=" + purchaseId +
                ", timestamp=" + timestamp +
                ", amount=" + amount +
                '}';
    }
}
