package com.example.mcnutt.inclassdemo;

import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.example.mcnutt.inclassdemo.TestUtils.getText;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class SimpleFirebaseExampleTest {

    @Rule
    public ActivityTestRule<SimpleFirebaseExample> activityTestRule
            = new ActivityTestRule<>(SimpleFirebaseExample.class);

    @Test
    public void loadsHelloWorld() throws InterruptedException {
        // TODO
        Thread.sleep(5000);

        onView(withId(R.id.helloWorldFirebase)).check(matches(not(doesNotExist())));
    }

}