package com.kryha.springjwt.payload.response;

public class DailyStatisticResponse {


    private String time;

    private String nameActivity;

    private String nameUser;

    public DailyStatisticResponse() {
    }


    public DailyStatisticResponse(String time, String nameActivity, String nameUser) {
        this.time = time;
        this.nameActivity = nameActivity;
        this.nameUser = nameUser;
    }



    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNameActivity() {
        return nameActivity;
    }

    public void setNameActivity(String nameActivity) {
        this.nameActivity = nameActivity;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

}
