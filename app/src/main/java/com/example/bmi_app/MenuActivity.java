package com.example.bmi_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button calculateBMIBtn = findViewById(R.id.calculateBMIBtn);
        calculateBMIBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, BMIActivity.class);
            startActivity(intent);

        });

        Button calculateCaloriesBtn = findViewById(R.id.calculateCaloriesBtn);
        calculateCaloriesBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, CaloriesActivity.class);
            startActivity(intent);
        });

        Button showRecipesBtn = findViewById(R.id.showRecipesBtn);
        showRecipesBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, RecipesActivity.class);
            startActivity(intent);

        });
    }
}
