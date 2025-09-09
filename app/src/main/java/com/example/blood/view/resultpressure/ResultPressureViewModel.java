package com.example.blood.view.resultpressure;

import androidx.lifecycle.ViewModel;

import com.example.blood.R;
import com.example.blood.model.ResultPressure;

import java.util.ArrayList;
import java.util.List;

public class ResultPressureViewModel extends ViewModel {

    public List<ResultPressure> intiData() {
        List<ResultPressure> data = new ArrayList<>();

        data.add(new ResultPressure("Introduction", "Blood pressure disorders often have no visible my symptims, which can be dangerous because high or low blood pressure can lead to life - threatening conditions like heart attack to stroke. However, you can prevents or treat them early through monitoring your blood pressure levels. Early diagnosis and healthy lifestyle changes can help you maintain good blood pressure and prevent health problems."));

        data.add(new ResultPressure("What is blood Pressure?", " Blood pressure refers to the force that blood exerts against the walls of your arteries it is pumped out from the heart. Checking your heart is working and is an essential part of a general health assessment. Proper medication management and blood pressure monitoring are critical for people with high blood pressure."));

        data.add(new ResultPressure("How is high Blood Pressure Diagnosed", "The only way to know if you have high blood pressure is to get regular checks from a healthcare provider. If your blood pressure is normal, your providers should check it at every annual checkup. If your readings are high, your provider may ask you to monitor your blood pressure at home several times a day or once a week."));

        return data;
    }

    public ResultPressure checkBloodPressure(int sys, int dia) {
        String status;
        int img;
        int colorState;

        if (sys < 120 && dia < 60) {
            status = "Normal Blood Pressure";
            img = R.drawable.normal_blood_pressure;
            colorState = R.color.Normal;
        } else if ((sys >= 120 && sys <= 129) && (dia >= 60 && dia <= 79)) {
            status = "Elevated Blood Pressure";
            img = R.drawable.elevated_blood;
            colorState = R.color.bp_elevated;
        } else if ((sys >= 130 && sys <= 139) || (dia >= 80 && dia <= 89)) {
            status = "High Blood Pressure - Stage 1";
            img = R.drawable.high_blood_stoge1;
            colorState = R.color.bp_stage1;
        } else if ((sys >= 140 && sys <= 180) || (dia >= 90 && dia <= 120)) {
            status = "High Blood Pressure - Stage 2";
            img = R.drawable.high_blood_stoge2;
            colorState = R.color.bp_stage2;
        } else if (sys > 180 || dia > 120) {
            status = "Dangerously High Blood Pressure";
            img = R.drawable.high_blood_stoge2;
            colorState = R.color.bp_danger;
        } else {
            status = "Normal Blood Pressure";
            img = R.drawable.normal_blood_pressure;
            colorState = R.color.Normal;
        }

        return new ResultPressure(status, img, colorState);
    }

}
