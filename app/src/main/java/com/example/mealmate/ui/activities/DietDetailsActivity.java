package com.example.mealmate.ui.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mealmate.R;

public class DietDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_details);

        String dietName = getIntent().getStringExtra("diet_name");
        String dietDescription = getIntent().getStringExtra("diet_description");

        TextView nameTextView = findViewById(R.id.diet_name);
        TextView descriptionTextView = findViewById(R.id.diet_description);

        nameTextView.setText(dietName);
        descriptionTextView.setText(dietDescription);

        findViewById(R.id.back_button).setOnClickListener(v -> finish());
    }
}