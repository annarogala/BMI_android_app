package com.example.bmi_app;

public class BMICalculator {
    public static double calculateBMI(double weight, double height) {
        if (height > 0) {
            return weight / (height * height);
        } else {
            return 0;
        }
    }
}
