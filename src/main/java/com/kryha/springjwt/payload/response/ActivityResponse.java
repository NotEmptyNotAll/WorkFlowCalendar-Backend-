package com.kryha.springjwt.payload.response;

public class ActivityResponse {

    private  String nameAct;

    private  String nameCateg;

    private Boolean userHas =false;

    private String status;

    public ActivityResponse() {
    }

    public ActivityResponse(String nameAct, String nameCateg, Boolean userHas, String status) {
        this.nameAct = nameAct;
        this.nameCateg = nameCateg;
        this.userHas = userHas;
        this.status = status;
    }

    public ActivityResponse(String nameAct, String nameCateg) {
        this.nameAct = nameAct;
        this.nameCateg = nameCateg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getUserHas() {
        return userHas;
    }

    public void setUserHas(Boolean userHas) {
        this.userHas = userHas;
    }

    public String getNameAct() {
        return nameAct;
    }

    public void setNameAct(String nameAct) {
        this.nameAct = nameAct;
    }

    public String getNameCateg() {
        return nameCateg;
    }

    public void setNameCateg(String nameCateg) {
        this.nameCateg = nameCateg;
    }
}
