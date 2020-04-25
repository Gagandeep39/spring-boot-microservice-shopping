/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-24 16:43:33
 * @modify date 2020-04-24 16:43:33
 * @desc [description]
 */
package com.gagan.shoppingfrontendservice.exception;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

@Component
public class RestResponseErrorHandler implements ResponseErrorHandler {

    Logger logger = LoggerFactory.getLogger(RestResponseErrorHandler.class);

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        // System.out.println(response.getStatusText());
//        logger.error("Has Error: " + response.getBody().toString());
        return false;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        // System.out.println(response.getStatusText());
        logger.error("Handle Error: " + response.getBody().toString());
        // logger.info(response.getBody() + "");

    }

}