package com.example.blood.model;

public class Intro {

    private int imageSrc;
    private String title;
    private String content;
    private boolean isImageMessage;

    public Intro(int imageSrc, String title, String content) {
        this.imageSrc = imageSrc;
        this.title = title;
        this.content = content;
    }

    public int getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(int imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
