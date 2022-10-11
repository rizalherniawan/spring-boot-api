package com.learn.spring.two.learningapi.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.learn.spring.two.learningapi.handler.RequestException;

@ControllerAdvice
public class ApiExceptionHandler {
    
    @ExceptionHandler(value = {RequestException.class})
    public ResponseEntity<Object> handleApiRequestException(RequestException e) {
        ApiException exception = new ApiException(e.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}
