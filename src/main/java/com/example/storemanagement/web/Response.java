package com.example.storemanagement.web;

import org.springframework.http.HttpStatus;

public class Response<T> {
    public HttpStatus status;
    public T responseBody;
    public String message;

    public Response(HttpStatus status, T responseBody, String message) {
        this.status = status;
        this.responseBody = responseBody;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public T getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(T responseBody) {
        this.responseBody = responseBody;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
