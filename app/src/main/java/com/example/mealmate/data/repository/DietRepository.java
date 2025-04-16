package com.example.mealmate.data.repository;

import android.content.Context;

import com.example.mealmate.data.dao.DietDao;
import com.example.mealmate.data.database.AppDatabase;
import com.example.mealmate.data.entities.Diet;

import java.util.List;

public class DietRepository {
    private DietDao dietDao;

    public DietRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        dietDao = db.dietDao();
    }

    public void insert(Diet diet) {
        new Thread(() -> dietDao.insert(diet)).start();
    }

    public List<Diet> getAllDiets() {
        return dietDao.getAllDiets();
    }
}