package com.example.mealmate.ui.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mealmate.R;
import com.example.mealmate.utils.LanguageHelper;

public class SettingsActivity extends AppCompatActivity {

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        preferences = getSharedPreferences("settings", MODE_PRIVATE);
        String currentLanguage = preferences.getString("language", "en");

        RadioGroup languageRadioGroup = findViewById(R.id.language_radio_group);
        RadioButton englishRadioButton = findViewById(R.id.radio_english);
        RadioButton vietnameseRadioButton = findViewById(R.id.radio_vietnamese);
        RadioButton spanishRadioButton = findViewById(R.id.radio_spanish);

        // Đặt trạng thái ban đầu của radio buttons
        switch (currentLanguage) {
            case "vi":
                vietnameseRadioButton.setChecked(true);
                break;
            case "es":
                spanishRadioButton.setChecked(true);
                break;
            default:
                englishRadioButton.setChecked(true);
                break;
        }

        languageRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            String languageCode;
            if (checkedId == R.id.radio_english) {
                languageCode = "en";
            } else if (checkedId == R.id.radio_vietnamese) {
                languageCode = "vi";
            } else {
                languageCode = "es";
            }

            // Lưu ngôn ngữ đã chọn
            preferences.edit().putString("language", languageCode).apply();
            LanguageHelper.setLocale(this, languageCode);

            // Làm mới toàn bộ ứng dụng
            recreate();
        });

        findViewById(R.id.back_button).setOnClickListener(v -> finish());
    }
}