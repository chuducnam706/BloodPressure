package com.example.blood.databloodpressure;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {PressureEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PressureDao pressureDao();

}
