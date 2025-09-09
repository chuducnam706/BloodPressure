package com.example.blood.view.infofragment;

import androidx.lifecycle.ViewModel;

import com.example.blood.R;
import com.example.blood.model.Infomation;

import java.util.ArrayList;
import java.util.List;

public class InfoViewModel extends ViewModel {
    //MutableLiveData

    public List<Infomation> initData() {
        ArrayList<Infomation> theInfomation = new ArrayList<>();
        theInfomation.add(new Infomation("About Blood Pressure", R.drawable.img_blood_pressure, "#0AB678"));
        theInfomation.add(new Infomation("About Blood Sugar", R.drawable.sugar_info, "#8296FF"));
        theInfomation.add(new Infomation("About Heart Rate", R.drawable.heart_info, "#FDE400"));
        theInfomation.add(new Infomation("About Weight & BMI", R.drawable.img_bmi, "#F7B11E"));
        // dong bo, postValue: bat dong bo
        return theInfomation;
    }
}
