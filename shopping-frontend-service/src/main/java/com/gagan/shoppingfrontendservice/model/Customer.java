/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-22 20:12:59
 * @modify date 2020-04-22 20:12:59
 * @desc Customer Entity to store customer details
 */
package com.gagan.shoppingfrontendservice.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Customer Entity Inheriting from User
 * @see User It stores user credentials
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User {

    /**
     * Full name of User
     */
    @NotNull(message = "Cannot be null")
    @Size(min = 4, max = 20, message = "Length must be between 4-20")
    @Pattern(regexp = "[A-Za-z]{4,20}", message = "Only Alphabets allowed")
    private String name;

    /**
     * Full address
     */
    @NotNull(message = "Cannot be null")
    @Size(min = 4, max = 20, message = "Length must be between 4-20")
    private String address;

    /**
     * Full Email ID
     */
    @NotNull(message = "Cannot be Empty")
    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", message = "Enter a valid Email")
    private String email;
    /**
     * Phone  Number
     */
    @Pattern(regexp = "[0-9]{10}", message = "Enter a 10 digit number")
    private String phoneNumber;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}