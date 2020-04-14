package com.example.mcnutt.inclassdemo;

import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class LocationExampleActivityTest {
    @Rule
    public ActivityTestRule<LocationExampleActivity> activityTestRule
            = new ActivityTestRule<>(LocationExampleActivity.class);

    @Test
    public void canClickNetworkButton() {
        onView(withId(R.id.locationControllerNetwork)).perform(click());
    }
}