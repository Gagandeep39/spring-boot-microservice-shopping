/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-22 22:07:31
 * @modify date 2020-04-22 22:07:31
 * @desc [description]
 */
package com.gagan.shoppingfrontendservice.exception;

import java.io.IOException;

import com.gagan.shoppingfrontendservice.model.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler
    public String CustomerNotFoundException(CustomerNotFoundException exception){
        return "Error";
    }

    /**
     * @return Returns a response object with an Error code
     * All generic exceptions will be caught by this error handler
     */
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAllError(Exception exception){
        ErrorResponse response = new ErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setTimeStamp(System.currentTimeMillis());
        response.setMessage(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    

}