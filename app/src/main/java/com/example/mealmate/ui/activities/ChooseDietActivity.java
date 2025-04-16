package com.example.mealmate.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mealmate.R;
import com.example.mealmate.ui.adapters.DietAdapter;
import com.example.mealmate.ui.viewmodels.DietViewModel;

public class ChooseDietActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_diet);

        RecyclerView recyclerView = findViewById(R.id.diet_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DietViewModel viewModel = new ViewModelProvider(this).get(DietViewModel.class);
        DietAdapter adapter = new DietAdapter(diet -> {
            Intent intent = new Intent(ChooseDietActivity.this, DietDetailsActivity.class);
            intent.putExtra("diet_name", diet.getName());
            intent.putExtra("diet_description", diet.getDescription());
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);

        viewModel.getDiets().observe(this, adapter::setDiets);

        findViewById(R.id.back_button).setOnClickListener(v -> finish());
    }
}