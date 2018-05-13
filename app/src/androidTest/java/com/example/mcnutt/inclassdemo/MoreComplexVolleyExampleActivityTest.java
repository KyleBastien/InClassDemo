package com.example.mcnutt.inclassdemo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

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