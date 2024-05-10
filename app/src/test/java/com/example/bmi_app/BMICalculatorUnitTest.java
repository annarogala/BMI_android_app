package com.example.bmi_app;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Test;

public class BMICalculatorUnitTest {
    @Test
    public void calculateBMI_correctCalculation() {
        double weight = 75;
        double height = 1.8;
        double expectedBMI = weight / (height * height);
        double actualBMI = BMICalculator.calculateBMI(weight, height);

        assertEquals(expectedBMI, actualBMI, 0.001);
    }

    @Test
    public void calculateBMI_heightZero_returnsZero() {
        double weight = 75;
        double height = 0;
        double expectedBMI = 0;
        double actualBMI = BMICalculator.calculateBMI(weight, height);

        assertEquals(expectedBMI, actualBMI, 0.01);
    }
}
