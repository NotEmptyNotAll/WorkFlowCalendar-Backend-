package com.kryha.springjwt.payload.response;

public class MessageSuccessfullyResponse {

    private  String message;

    public MessageSuccessfullyResponse() {
    }

    public MessageSuccessfullyResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
