package com.example.blood.view.addbloodsugar;

import androidx.lifecycle.ViewModel;

import com.example.blood.model.AddSugar;

import java.util.ArrayList;
import java.util.List;

public class AddBloodSugarViewModel extends ViewModel {


    public List<AddSugar> initData(){
        List<AddSugar> data = new ArrayList<>();

        data.add(new AddSugar("Low", "#41ACE9", "#41ACE9", "< 4.0"));
        data.add(new AddSugar("Normal", "#00C57E", "#00C57E", "4.0 - 5.5"));
        data.add(new AddSugar("Pre-diabetes", "#E9D841", "#E9D841", "5.5 - 7.0"));
        data.add(new AddSugar("Diabetes", "#FB5555", "#FB5555", "5.5 - 7.0"));

        return data;
    }
}
