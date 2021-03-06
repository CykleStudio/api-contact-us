package com.contactus.model;

public class ResponseData {
    private String status;
    private String message;


    public ResponseData(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseData() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
