package com.example.mcnutt.inclassdemo;

import android.content.Intent;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class GravityExampleActivityTest {
    @Rule
    public ActivityTestRule<GravityExample> activityTestRule
            = new ActivityTestRule<>(GravityExample.class);

    @Test
    public void hasButtons() {
        onView(withId(R.id.buttonOneGravity)).check(matches(withText(R.string.button1)));
    }
}
