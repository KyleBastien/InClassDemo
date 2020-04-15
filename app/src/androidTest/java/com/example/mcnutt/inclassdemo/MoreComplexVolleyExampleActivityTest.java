package com.example.mcnutt.inclassdemo;

import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MoreComplexVolleyExampleActivityTest {

    @Rule
    public ActivityTestRule<MoreComplexVolleyExampleActivity> activityTestRule
            = new ActivityTestRule<>(MoreComplexVolleyExampleActivity.class);

    @Test
    public void loadsStuffFromApi() throws InterruptedException {
        // TODO
        Thread.sleep(2000);

        onView(withId(R.id.kittenImage)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewForQuote)).check(matches(isDisplayed()));
    }

}