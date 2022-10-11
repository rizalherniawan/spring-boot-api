package com.learn.spring.two.learningapi.pojo;

import java.util.Arrays;
import java.util.List;

public class Response<T> {
    String response;
    String message;
    int status;
    T data;

    Response(String response, String message, int status, T data) {
        this.response = response;
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public String getResponse() {
        return this.response;
    }

    public String getMessage() {
        return this.message;
    }

    public int getStatus() {
        return this.status;
    }

    public T getData() {
        return this.data;
    }

    public static <T> Response<T> sendResponse(T data) {
        if(data == null) return new Response<T>("OK", "Sucess", 200, null);
        else return new Response<T>("OK", "Success", 200, data);
    }
}
