package com.gagan.shoppingcartservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Gagandeep
 * @date 23-04-2020
 * @time 20:00
 */

@Entity
@Table(name = "shopping_purchase_table")
@ApiModel(value = "Purchase Details - Bill generated on Purchase")
public class PurchaseDetails {

    @Id
    @Column(name = "purchase_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Purchase ID")
    private Integer purchaseId;

    @Column(name = "timestamp")
    @ApiModelProperty(value = "Timestamp of BillCreation")
    private Long timestamp;

    @Column(name = "amount")
    @ApiModelProperty(value = "Total Bill Amount")
    private Double amount;

    @OneToOne
    @JoinColumn(name = "cart_id")
    @ApiModelProperty(value = "Cart Back reference")
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
