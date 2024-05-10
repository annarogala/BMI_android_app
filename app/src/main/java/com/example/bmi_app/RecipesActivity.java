package com.example.bmi_app;

import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class RecipesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes);

        Button backBtn = findViewById(R.id.backBtn);


        backBtn.setOnClickListener(v -> {
            Intent intent = new Intent(RecipesActivity.this, MenuActivity.class);
            startActivity(intent);
        });

        Button recipeShowcaseButton = findViewById(R.id.buyBtn);
        recipeShowcaseButton.setOnClickListener(v -> {
            Intent intent = new Intent(RecipesActivity.this, ShoppingListActivity.class);
            startActivity(intent);
        });
    }
}