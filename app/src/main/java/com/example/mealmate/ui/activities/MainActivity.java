package com.example.mealmate.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import com.example.mealmate.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Xử lý nút "Choose Diet"
        findViewById(R.id.choose_diet_button).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ChooseDietActivity.class);
            startActivity(intent);
        });

        // Xử lý nút "Settings"
        findViewById(R.id.settings_icon).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

        // Xử lý nút "Change Language"
        findViewById(R.id.language_icon).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        });
    }
}