package com.example.bmi_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        Button startBtn = findViewById(R.id.startBtn);
        startBtn.setOnClickListener(v -> {
            Intent intent = new Intent(StartActivity.this, MenuActivity.class);
            startActivity(intent);
        });
    }
}
/*Author: Anna Rogala s21487*/