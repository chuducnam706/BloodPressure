package com.example.blood.databloodpressure;

import android.content.Context;

import androidx.room.Room;

public class DataManager {

    private static DataManager dataManager;
    private AppDatabase appDatabase;

    public DataManager() {
    }

    public static DataManager getInstance() {
        if (dataManager == null) {
            dataManager = new DataManager();
        }
        return dataManager;
    }

    public AppDatabase createDataBase(Context context){
        return Room.databaseBuilder(context, AppDatabase.class, "db")
                .fallbackToDestructiveMigration().allowMainThreadQueries().build();
    }

}
