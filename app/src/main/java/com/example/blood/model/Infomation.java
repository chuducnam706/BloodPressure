package com.example.blood.model;

public class Infomation {

    private String title;
    private int src;
    private String backGroundColor;


    public Infomation(String title, int src, String backGroundColor) {
        this.title = title;
        this.src = src;
        this.backGroundColor = backGroundColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public String getBackGroundColor() {
        return backGroundColor;
    }

    public void setBackGroundColor(String backGroundColor) {
        this.backGroundColor = backGroundColor;
    }
}
