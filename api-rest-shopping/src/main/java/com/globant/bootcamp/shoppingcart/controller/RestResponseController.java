package com.globant.bootcamp.shoppingcart.controller;
import java.util.Optional;

import com.globant.bootcamp.shoppingcart.exception.ProductNotFoundException;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class RestResponseController extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(IllegalArgumentException.class) 
    public ResponseEntity < VndErrors > assertionException(final IllegalArgumentException e) {
        return error(e, HttpStatus.NOT_FOUND, e.getLocalizedMessage());
    }

    @ExceptionHandler(ProductNotFoundException.class) 
    public ResponseEntity < VndErrors > assertionException(final ProductNotFoundException e) {
        return error(e, HttpStatus.NOT_FOUND, e.getLocalizedMessage());
    }
   
    private ResponseEntity < VndErrors > error(final Exception exception, final HttpStatus httpStatus, final String logRef) {
        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity < > (new VndErrors(logRef, message), httpStatus);
    }
} 
