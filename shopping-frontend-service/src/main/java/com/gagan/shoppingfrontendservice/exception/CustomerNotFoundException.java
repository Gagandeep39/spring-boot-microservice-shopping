package com.gagan.shoppingfrontendservice.exception;

/**
 * @author Gagandeep
 * @date 24-04-2020
 * @time 17:37
 */
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException() {
        super();
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
