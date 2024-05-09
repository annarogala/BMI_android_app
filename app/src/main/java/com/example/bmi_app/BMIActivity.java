package com.example.bmi_app;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import java.util.Locale;

import android.os.Bundle;

public class BMIActivity extends AppCompatActivity {
    private EditText Weight;
    private EditText Height;
    private TextView ResultTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);


        Height = findViewById(R.id.height);
        Weight = findViewById(R.id.weight);
        Button CalculateBtn = findViewById(R.id.startBtn);
        ResultTxt = findViewById(R.id.result);

        Button backBtn = findViewById(R.id.backBtn);

        CalculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndDisplayBMI();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void calculateAndDisplayBMI() {
        String weightStr = Weight.getText().toString();
        String heightStr = Height.getText().toString();

        if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
            double weight = Double.parseDouble(weightStr);
            double height = Double.parseDouble(heightStr) / 100;

            if (height > 0) {
                double bmi = weight / (height * height);
                ResultTxt.setText(String.format(Locale.getDefault(), "%.2f", bmi));
            }
        } else {
            ResultTxt.setText("PROVIDE WEIGHT AND HEIGHT");
        }
    }
}
