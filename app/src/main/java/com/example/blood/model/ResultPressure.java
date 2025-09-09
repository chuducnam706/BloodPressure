package com.example.blood.model;

public class ResultPressure {

    private String title;
    private String content;
    private int imgRes;
    private String status;
    private int colorState;

    public ResultPressure(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public ResultPressure(String status, int imgRes, int colorState) {
        this.status = status;
        this.imgRes = imgRes;
        this.colorState = colorState;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() { return content; }

    public String getStatus() { return status;  }

    public int getImgRes() {return imgRes; }

    public void setContent(String content) {
        this.content = content;
    }

    public int getColorState() {return colorState; }
}
