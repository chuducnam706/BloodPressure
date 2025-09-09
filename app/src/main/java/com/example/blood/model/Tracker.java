package com.example.blood.model;

public class Tracker {

    private int src;
    private String title;

    public Tracker(int src, String title) {
        this.src = src;
        this.title = title;
    }


    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
