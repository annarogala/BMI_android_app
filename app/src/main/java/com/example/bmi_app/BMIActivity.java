package com.example.bmi_app;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import java.util.Locale;
import android.webkit.WebSettings;
import android.webkit.WebView;

import android.os.Bundle;

public class BMIActivity extends AppCompatActivity {
    private EditText weight;
    private EditText height;
    private TextView resultTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);


        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        Button CalculateBtn = findViewById(R.id.calculateBMIBtn);
        resultTxt = findViewById(R.id.result);

        Button backBtn = findViewById(R.id.backBtn);

        CalculateBtn.setOnClickListener(v -> calculateAndDisplayBMI());

        backBtn.setOnClickListener(v -> finish());

        WebView chart = findViewById(R.id.chart);
        WebSettings webSettings = chart.getSettings();
        (webSettings).setJavaScriptEnabled(true);
        chart.loadUrl("file:///android_asset/html/chart.html");

    }

    private void calculateAndDisplayBMI() {
        String weightStr = weight.getText().toString();
        String heightStr = height.getText().toString();

        if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
            double weight = Double.parseDouble(weightStr);
            double height = Double.parseDouble(heightStr) / 100;
            double bmi = BMICalculator.calculateBMI(weight, height);
            resultTxt.setText(String.format(Locale.getDefault(), "%.2f", bmi));
        } else {
            resultTxt.setText("PROVIDE WEIGHT AND HEIGHT");
        }
    }
}
