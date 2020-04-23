/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-22 20:12:59
 * @modify date 2020-04-22 20:12:59
 * @desc Customer Entity to store customer details
 */
package com.gagan.shoppingcartservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Customer Entity Inheriting from User
 * @see User It stores user credentials
 */
@Entity
@PrimaryKeyJoinColumn(name = "username")
public class Customer extends User {

    /**
     * Full name of User
     */
    @Column(name = "name")
    private String name;

    /**
     * Full address
     */
    @Column(name = "address")
    private String address;

    /**
     * Full Email ID
     */
    @Column(name = "email")
    private String email;
    /**
     * Phone  Number
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * Default Constructor
     */
    public Customer() {}

    /**
     * Parametrized COnstructor
     */
    public Customer(String username, String password, String name, String address, String email, String phoneNumber) {
        super(username, password);
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", address='" + getAddress() + "'" +
            ", email='" + getEmail() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            "}";
    }



}