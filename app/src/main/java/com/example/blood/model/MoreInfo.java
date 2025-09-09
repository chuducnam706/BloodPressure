package com.example.blood.model;

import android.graphics.Color;

public class MoreInfo {

    private int img;
    private String bgColor;
    private String Systolic;
    private String Diastolic;
    private String Status;
    private String andOr;

    public MoreInfo(int img, String bgColor, String systolic, String diastolic, String status, String andOr) {
        this.img = img;
        this.bgColor = bgColor;
        Systolic = systolic;
        Diastolic = diastolic;
        Status = status;
        this.andOr = andOr;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDiastolic() {
        return Diastolic;
    }

    public void setDiastolic(String diastolic) {
        Diastolic = diastolic;
    }

    public String getSystolic() {
        return Systolic;
    }

    public void setSystolic(String systolic) {
        Systolic = systolic;
    }

    public int getBgColor() {
        return Color.parseColor(bgColor);
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getAndOr() {
        return andOr;
    }

    public void setAndOr(String andOr) {
        this.andOr = andOr;
    }

}
