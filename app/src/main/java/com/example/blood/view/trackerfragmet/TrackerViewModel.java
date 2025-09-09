package com.example.blood.view.trackerfragmet;

import androidx.lifecycle.ViewModel;

import com.example.blood.R;
import com.example.blood.model.Tracker;

import java.util.ArrayList;
import java.util.List;

public class TrackerViewModel extends ViewModel {

    public List<Tracker> initData() {
        List<Tracker> trackers = new ArrayList<>();
        trackers.add(new Tracker(R.drawable.blood_sugar, "Blood Sugar"));
        trackers.add(new Tracker(R.drawable.blood_pressure, "Blood Pressure"));
        trackers.add(new Tracker(R.drawable.heart_hate, "Heart Rate"));
        trackers.add(new Tracker(R.drawable.bmi, " Weight & BMI"));
        return trackers;
    }

}
