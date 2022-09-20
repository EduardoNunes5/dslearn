package com.devsuperior.dslearnbds.dto;

public class CustomErrorResponse {

    private String message;

    public CustomErrorResponse() {
    }

    public CustomErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
