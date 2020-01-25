package com.kryha.springjwt.payload.request;

public class AdminActionRequest {

    private Integer id;

    private String action;

    private String nameActivity;

    private String username;

    private  boolean agree;

    public AdminActionRequest() {
    }

    public AdminActionRequest(Integer id, String action, String nameActivity, String username, boolean agree) {
        this.id = id;
        this.action = action;
        this.nameActivity = nameActivity;
        this.username = username;
        this.agree = agree;
    }

    public boolean getAgree() {
        return agree;
    }

    public void setAgree(boolean agree) {
        this.agree = agree;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNameActivity() {
        return nameActivity;
    }

    public void setNameActivity(String nameActivity) {
        this.nameActivity = nameActivity;
    }
}
