package com.example.blood.view.intro;

import androidx.lifecycle.ViewModel;

import com.example.blood.R;
import com.example.blood.model.Intro;

import java.util.ArrayList;
import java.util.List;

public class IntrolViewModel extends ViewModel {

    public List<Intro> initData() {
        ArrayList<Intro> intros = new ArrayList<>();
        intros.add(new Intro(R.drawable.intro1, "Blood Pressure Tool", "You can track the Blood Pressure easily and exactly on report."));
        intros.add(new Intro(R.drawable.intro2, "Graph and Health Report", "See the change of your health in every bar graph on it."));
        intros.add(new Intro(R.drawable.intro3, "Blood Pressure Information", "Give you useful knowledge about blood pressure."));
        intros.add(new Intro(R.drawable.intro4, "Track your overall health", "Effortlessly monitor your health with convenience at your fingertips"));
//        data.setValue(intros);
        return intros;
    }

}
