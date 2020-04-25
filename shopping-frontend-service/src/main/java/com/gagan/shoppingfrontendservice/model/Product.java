/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-23 11:06:19
 * @modify date 2020-04-23 11:06:19
 * @desc [description]
 */
package com.gagan.shoppingfrontendservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
public class Product {

    private Integer productId;
    private Integer stocks;
    private ProductDetails productDetails;

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", stocks=" + stocks +
                '}';
    }
}