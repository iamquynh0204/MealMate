package com.example.mealmate.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mealmate.data.entities.Diet;

import java.util.List;

@Dao
public interface DietDao {
    @Insert
    void insert(Diet diet);

    @Query("SELECT * FROM diets")
    List<Diet> getAllDiets();
}