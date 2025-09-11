package com.example.blood.databloodpressure;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PressureEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int sys;
    private int dia;
    private int pul;
    private String note;
    private String date;
    private long time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSys() {
        return sys;
    }

    public void setSys(int sys) {
        this.sys = sys;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getPul() {
        return pul;
    }

    public void setPul(int pul) {
        this.pul = pul;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
