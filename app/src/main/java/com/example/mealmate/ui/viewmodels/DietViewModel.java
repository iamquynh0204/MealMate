package com.example.mealmate.ui.viewmodels;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mealmate.data.entities.Diet;
import com.example.mealmate.data.repository.DietRepository;
import com.example.mealmate.model.DietModel;

import java.util.ArrayList;
import java.util.List;

public class DietViewModel extends AndroidViewModel {
    private DietRepository repository;
    private MutableLiveData<List<DietModel>> dietsLiveData;

    public DietViewModel(Application application) {
        super(application);
        repository = new DietRepository(application);
        dietsLiveData = new MutableLiveData<>();
        loadDiets();
    }

    public LiveData<List<DietModel>> getDiets() {
        return dietsLiveData;
    }

    private void loadDiets() {
        List<Diet> diets = repository.getAllDiets();
        List<DietModel> dietModels = new ArrayList<>();
        for (Diet diet : diets) {
            dietModels.add(new DietModel(diet.getName(), diet.getDescription()));
        }
        if (dietModels.isEmpty()) {
            // Dữ liệu mẫu nếu cơ sở dữ liệu trống
            dietModels.add(new DietModel("Low-Carb Diet", "A diet low in carbs, high in protein and healthy fats."));
            dietModels.add(new DietModel("Keto Diet", "A very low-carb, high-fat diet to promote ketosis."));
            dietModels.add(new DietModel("High-Protein Diet", "Focuses on high protein intake for muscle growth."));
            dietModels.add(new DietModel("Mediterranean Diet", "Rich in vegetables, fruits, and healthy fats."));
            dietModels.add(new DietModel("Vegetarian Diet", "Excludes meat, focuses on plant-based foods."));
            // Lưu vào cơ sở dữ liệu
            for (DietModel model : dietModels) {
                repository.insert(new Diet(model.getName(), model.getDescription()));
            }
        }
        dietsLiveData.setValue(dietModels);
    }
}