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

import com.gagan.shoppingfrontendservice.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler
    public String CustomerNotFoundException(CustomerNotFoundException exception, Model model){
        if (exception.getMessage().contains("Not Found")){
            model.addAttribute("user", new User());
            model.addAttribute("error", "error");
            return "LoginPage";
        }
        return "Error";
    }

    /**
     * @return Returns a response object with an Error code
     * All generic exceptions will be caught by this error handler
     */
    @ExceptionHandler
    public String handleAllError(Exception exception, Model model){
        ErrorResponse response = new ErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setTimeStamp(System.currentTimeMillis());
        response.setMessage(exception.getMessage());
        model.addAttribute("error", response);
        return "Error";
    }

    

}