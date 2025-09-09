package com.example.blood.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PressureDao {
    @Query("SELECT * FROM  PressureEntity ORDER BY id DESC")
       List<PressureEntity> getAll();

    @Insert
    long insertAll(PressureEntity pressureEntity);

    @Update
    void updateAll(PressureEntity pressureEntity);


}
