package com.example.blood.model;

public class Language {

    private int imageSrc;
    private String nameLanguage;

    public Language(int imageSrc, String nameLanguage) {
        this.imageSrc = imageSrc;
        this.nameLanguage = nameLanguage;
    }

    public int getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(int imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getNameLanguage() {
        return nameLanguage;
    }

    public void setNameLanguage(String nameLanguage) {
        this.nameLanguage = nameLanguage;
    }

}
