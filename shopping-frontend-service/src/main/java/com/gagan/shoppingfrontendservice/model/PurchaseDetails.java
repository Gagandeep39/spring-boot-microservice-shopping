package com.gagan.shoppingfrontendservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Gagandeep
 * @date 23-04-2020
 * @time 20:00
 */

@Getter
@Setter
@NoArgsConstructor
public class PurchaseDetails {

    private Integer purchaseId;
    private long timestamp;
    private Double amount;
    private ShoppingCart shoppingCart;

    @Override
    public String toString() {
        return "PurchaseDetails{" +
                "purchaseId=" + purchaseId +
                ", timestamp=" + timestamp +
                ", amount=" + amount +
                '}';
    }
}
