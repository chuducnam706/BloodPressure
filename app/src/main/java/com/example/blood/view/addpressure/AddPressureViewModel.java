package com.example.blood.view.addpressure;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.blood.R;
import com.example.blood.databloodpressure.AppDatabase;
import com.example.blood.databloodpressure.DataManager;
import com.example.blood.databloodpressure.PressureEntity;
import com.example.blood.model.Pressure;
import com.example.blood.model.AddPressure;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AddPressureViewModel extends ViewModel {

    private AppDatabase db;
    private final MutableLiveData<Long> preMutableLiveData = new MutableLiveData<>();
    private PressureEntity entity = new PressureEntity();

    public PressureEntity getEntity() {
        return entity;
    }

    public void insertPressureEntityId(long id){
        entity.setId((int) id);
    }

    public void insertPressureEntitySys(int sys) {
        entity.setSys(sys);
    }

    public void insertPressureEntityDia(int dia) {
        entity.setDia(dia);
    }

    public void insertPressureEntityPul(int pul) {
        entity.setPul(pul);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void updateTime(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime localTime = LocalTime.parse(time, formatter);
        long timestamp = localTime.toSecondOfDay() * 1000L;
        entity.setTime(timestamp);
    }

    public void insertDate(String date){
        entity.setDate(date);
    }

    public void insertNote(String note){
        entity.setNote(note);
    }

    public MutableLiveData<Long> getPreMutableLiveData() {
        return preMutableLiveData;
    }

    public long insert(Context context) {
        if (!checkData()){
            return -1L;
        }
        db = DataManager.getInstance().createDataBase(context);
        long id = db.pressureDao().insertAll(entity);
        preMutableLiveData.postValue(id);
        return id;
    }

    public List<Pressure> initData() {
        List<Pressure> data = new ArrayList<>();
        data.add(new Pressure("#00C57E", 0));
        data.add(new Pressure("#E9D841", 1));
        data.add(new Pressure("#FEC415", 2));
        data.add(new Pressure("#FA9C0F", 3));
        data.add(new Pressure("#FB5555", 4));
        return data;
    }

    public AddPressure checkBloodPressure(int sys, int dia) {
        String status;
        int state;
        int img;

        if (sys < 120 && dia < 60) {
            status = "Normal Blood Pressure";
            img = R.drawable.normal_blood_pressure;
            state = 0;
        } else if ((sys >= 120 && sys <= 129) && (dia >= 60 && dia <= 79)) {
            status = "Elevated Blood Pressure";
            img = R.drawable.elevated_blood;
            state = 1;
        } else if ((sys >= 130 && sys <= 139) || (dia >= 80 && dia <= 89)) {
            status = "High Blood Pressure - Stage 1";
            img = R.drawable.high_blood_stoge1;
            state = 2;
        } else if ((sys >= 140 && sys <= 180) || (dia >= 90 && dia <= 120)) {
            status = "High Blood Pressure - Stage 2";
            img = R.drawable.high_blood_stoge2;
            state = 3;
        } else if (sys > 180 || dia > 120) {
            status = "Dangerously High Blood Pressure";
            img = R.drawable.high_blood_stoge2;
            state = 4;
        } else {
            status = "Normal Blood Pressure";
            img = R.drawable.normal_blood_pressure;
            state = 0;
        }

        return new AddPressure(status, state, img);
    }

    private boolean checkData() {
        if (entity.getNote() == null){
            return false;
        } else if (entity.getSys() == 0) {
            return false;
        } else if (entity.getDia() == 0) {
            return false;
        } else if (entity.getPul() == 0) {
            return false;
        } else if (entity.getDate() == null) {
            return false;
        } else if (entity.getTime() == 0) {
            return false;
        }
        return true;
    }
}
