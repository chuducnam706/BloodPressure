package com.example.blood.view.moreinfo;

import androidx.lifecycle.ViewModel;

import com.example.blood.R;
import com.example.blood.model.MoreInfo;

import java.util.ArrayList;
import java.util.List;

public class MoreInfoViewModel extends ViewModel {


    public List<MoreInfo> initData() {
        List<MoreInfo> data = new ArrayList<>();
        data.add(new MoreInfo(R.drawable.normal_blood_pressure, "#00C57E", "< 120", "< 60", "Normal Blood Pressure", "and"));
        data.add(new MoreInfo(R.drawable.elevated_blood, "#E9D841", "< 120 - 129", "< 60 -79", "Elevated Blood Pressure", "and"));
        data.add(new MoreInfo(R.drawable.high_blood_stoge1, "#FEC415", "< 130 - 139", "< 80 - 89", "High Blood Pressure - Stage 1", "or"));
        data.add(new MoreInfo(R.drawable.high_blood_stoge2, "#FA9C0F", "< 140 - 180", "< 90 - 120", "High Blood Pressure - Stage 2", "or"));
        data.add(new MoreInfo(R.drawable.dangerously_high_blood, "#FB5555", "> 180", "> 120", "Dangerously High Blood Pressure" ,"and/or"));
        return data;
    }


}

