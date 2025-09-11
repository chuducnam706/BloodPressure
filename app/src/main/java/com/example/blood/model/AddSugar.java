package com.example.blood.model;

public class AddSugar {
    private String state;
    private String stateColor;
    private String imgState;
    private String glucoseLevel;

    public AddSugar(String state, String stateColor, String imgState, String glucoseLevel) {
        this.state = state;
        this.stateColor = stateColor;
        this.imgState = imgState;
        this.glucoseLevel = glucoseLevel;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getImgState() {
        return imgState;
    }

    public void setImgState(String imgState) {
        this.imgState = imgState;
    }

    public String getGlucoseLevel() {
        return glucoseLevel;
    }

    public void setGlucoseLevel(String glucoseLevel) {
        this.glucoseLevel = glucoseLevel;
    }

    public String getStateColor() {
        return stateColor;
    }

    public void setStateColor(String stateColor) {
        this.stateColor = stateColor;
    }
}
