package com.learn.spring.two.learningapi.handler;

public class RequestException extends RuntimeException {
    
    public RequestException(String message) {
        super(message);
    }

    public RequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
