package com.example.blood.model;

public class AddPressure {

    private String status;
    private int state;
    private int imgRes;

    public AddPressure(String status, int state, int imgRes) {
        this.status = status;
        this.state = state;
        this.imgRes = imgRes;
    }

    public String getStatus() {
        return status;
    }

    public int getState() {
        return state;
    }

    public int getImgRes() {
        return imgRes;
    }

}
