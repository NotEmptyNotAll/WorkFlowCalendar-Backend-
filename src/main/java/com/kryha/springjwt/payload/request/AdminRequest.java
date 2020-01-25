package com.kryha.springjwt.payload.request;

public class AdminRequest {

    private  String nameUser;

    private  String date;

    public AdminRequest(String nameUser, String date) {
        this.nameUser = nameUser;
        this.date = date;
    }

    public AdminRequest() {
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
