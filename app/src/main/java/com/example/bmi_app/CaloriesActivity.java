package com.example.bmi_app;

import java.util.Locale;

import android.widget.Button;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CaloriesActivity extends AppCompatActivity {
    private EditText weightEditText;
    private EditText heightEditText;
    private EditText ageEditText;
    private CheckBox maleCheckBox;
    private CheckBox femaleCheckBox;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calories);

        femaleCheckBox = findViewById(R.id.femaleCheckbox);
        maleCheckBox = findViewById(R.id.maleCheckbox);
        ageEditText = findViewById(R.id.ageNumber);
        weightEditText = findViewById(R.id.WeightNumber);
        heightEditText = findViewById(R.id.HeightNumber);
        Button calculateBtn = findViewById(R.id.CalculateBtn);
        resultTextView = findViewById(R.id.ResultText);
        Button backBtn = findViewById(R.id.backBtn);


        femaleCheckBox.setOnClickListener(v -> {
            if (femaleCheckBox.isChecked()) {
                maleCheckBox.setChecked(false);
            }
        });

        maleCheckBox.setOnClickListener(v -> {
            if (maleCheckBox.isChecked()) {
                femaleCheckBox.setChecked(false);
            }
        });

        calculateBtn.setOnClickListener(v ->
                calculateCalories());

        backBtn.setOnClickListener(v -> finish());
    }

    private void calculateCalories() {
        String weightStr = weightEditText.getText().toString();
        String heightStr = heightEditText.getText().toString();
        String ageStr = ageEditText.getText().toString();

        if (!weightStr.isEmpty() && !heightStr.isEmpty() && !ageStr.isEmpty()) {
            double weight = Double.parseDouble(weightStr);
            double height = Double.parseDouble(heightStr);
            int age = Integer.parseInt(ageStr);

            double bmr;
            boolean isMaleChecked = maleCheckBox.isChecked();
            boolean isFemaleChecked = femaleCheckBox.isChecked();

            if (isMaleChecked) {
                bmr = 5 + (10 * weight) + (6.25 * height) - (5 * age);
            } else if (isFemaleChecked) {
                bmr = -161 + (10 * weight) + (6.25 * height) - (5 * age);
            } else {
                return;
            }

            resultTextView.setText(String.format(Locale.getDefault(), "%.2f", bmr));
        }
    }
}
