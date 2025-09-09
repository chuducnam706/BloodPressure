package com.example.blood.view.language;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.blood.R;
import com.example.blood.model.Language;

import java.util.ArrayList;

public class LanguageViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Language>> data ;

    public MutableLiveData<ArrayList<Language>> getData() {
        if(data == null){
            data = new MutableLiveData<>();
        }
        return data;
    }

    public void initData(){
        ArrayList<Language>  languages = new ArrayList<>();
        languages.add(new Language(R.drawable.english_flag, "English"));
        languages.add(new Language(R.drawable.spalish_flag, "Spanish"));
        languages.add(new Language(R.drawable.french_flag, "French"));
        languages.add(new Language(R.drawable.india_flag, "Hindi"));
        data.setValue(languages);
    }
}
