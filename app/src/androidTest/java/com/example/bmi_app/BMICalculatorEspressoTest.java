package com.example.bmi_app;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)

public class BMICalculatorEspressoTest {
    @Rule
    public ActivityScenarioRule<StartActivity> mActivityScenarioRule = new ActivityScenarioRule<>(StartActivity.class);

    @Test
    public void BMICalculatorTest() {
        ViewInteraction startBtn = onView(withId(R.id.startBtn));
        startBtn.perform(click());

        ViewInteraction BMICalculatorBtn = onView(withId(R.id.calculateBMIBtn));
        BMICalculatorBtn.perform(click());

        ViewInteraction weightInput = onView(withId(R.id.weight));
        weightInput.perform(replaceText("90"), closeSoftKeyboard());

        ViewInteraction heightInput = onView(withId(R.id.height));
        heightInput.perform(replaceText("170"), closeSoftKeyboard());

        ViewInteraction calculatorBMIBtn = onView(withId(R.id.calculateBMIBtn));
        calculatorBMIBtn.perform(click());

        ViewInteraction result = onView(withId(R.id.result));
        result.check(matches(withText("31.14")));
    }
}
