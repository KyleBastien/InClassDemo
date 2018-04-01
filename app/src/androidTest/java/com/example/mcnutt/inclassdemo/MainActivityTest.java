package com.example.mcnutt.inclassdemo;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void canEnterNameAndLoginWithRotate() {
        onView(withId(R.id.nameEditText)).perform(typeText("Kyle McNutt"));

        onView(withId(R.id.loginBtn)).perform(click());

        onView(withId(R.id.textView))
                .check(matches(withText("Welcome: Kyle McNutt")));

        TestUtils.rotateScreen(activityTestRule.getActivity());

        // Make sure text view still has Welcome Kyle McNutt after screen rotation
        onView(withId(R.id.textView))
                .check(matches(withText("Welcome: Kyle McNutt")));
    }

    @Test
    public void canGoToSecondActivityWithMessage() {
        onView(withId(R.id.nameEditText)).perform(typeText("Kyle McNutt"));

        Intents.init();
        onView(withId(R.id.secondActivityBtn)).perform(click());
        intended(hasComponent(SecondActivity.class.getName()));
        intended(hasExtra(Constants.KEY_NAME, "Kyle McNutt"));
        intended(hasExtra(Constants.KEY_AGE, 24));
        Intents.release();
    }

}