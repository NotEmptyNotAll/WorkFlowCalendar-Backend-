package com.kryha.springjwt.payload.response;

public class UserResponse {

    private String nameAct;

    private String date;

    private String time;

    public UserResponse() {
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public UserResponse(String date, String time) {
        this.date = date;
        this.time = time;
    }

    public UserResponse(String name, String date, String time) {
        this.nameAct = name;
        this.date = date;
        this.time = time;
    }

    public String getName() {
        return nameAct;
    }

    public void setName(String name) {
        this.nameAct = name;
    }
}
