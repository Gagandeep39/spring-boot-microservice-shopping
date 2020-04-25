/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-22 19:43:53
 * @modify date 2020-04-22 19:43:53
 * @desc User Entity
 */
package com.gagan.shoppingfrontendservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Stores User credentials
 * Inherited by Customer 
 *  @see Customer
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

    /**
     * USer name is teh [rimary key]
     */
    @NotNull
    @Size(min = 4, max = 20, message = "Length must be 4-20")
    private String username;
    /**
     * Password
     */
    @NotNull
    @Size(min = 4, max = 20, message = "Length must be 4-20")
    private String password;


}