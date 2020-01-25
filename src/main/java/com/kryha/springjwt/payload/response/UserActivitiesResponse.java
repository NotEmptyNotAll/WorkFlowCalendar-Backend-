package com.kryha.springjwt.payload.response;

public class UserActivitiesResponse {

    private String nameActivity;

    private  String nameCateg;

    private String time;

    private  String date;

    public UserActivitiesResponse() {
    }

    public UserActivitiesResponse(String nameActivity, String nameCateg) {
        this.nameActivity = nameActivity;
        this.nameCateg = nameCateg;
    }

    public String getNameActivity() {
        return nameActivity;
    }

    public void setNameActivity(String nameActivity) {
        this.nameActivity = nameActivity;
    }

    public String getNameCateg() {
        return nameCateg;
    }

    public void setNameCateg(String nameCateg) {
        this.nameCateg = nameCateg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
