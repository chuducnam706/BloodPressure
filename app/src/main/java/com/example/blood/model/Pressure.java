package com.example.blood.model;

public class Pressure {

    private  String background;
    private  int state;

    public Pressure(String background, int state) {
        this.background = background;
        this.state = state;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
