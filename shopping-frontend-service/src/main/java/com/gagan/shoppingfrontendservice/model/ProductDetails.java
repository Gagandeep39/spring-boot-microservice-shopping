/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-22 23:23:23
 * @modify date 2020-04-22 23:23:23
 * @desc Product Class. Must not be Changed. Fully Tested and Functional
 */
package com.gagan.shoppingfrontendservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
public class ProductDetails {

    private Integer productDetailsId;
    private String productName;
    private String productCategory;
    private double productPrice;

    @Override
    public String toString() {
        return "ProductDetails{" +
                "productDetailsId=" + productDetailsId +
                ", productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
