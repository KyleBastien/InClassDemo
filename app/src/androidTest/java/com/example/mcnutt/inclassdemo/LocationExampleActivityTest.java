package com.example.mcnutt.inclassdemo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

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