package com.example.mcnutt.inclassdemo;

import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class ClickDemoActivityTest {

    @Rule
    public ActivityTestRule<ClickDemoActivity> activityTestRule
            = new ActivityTestRule<>(ClickDemoActivity.class, true, true);

    @Test
    public void goToSecondActivity() {
        onView(withId(R.id.goToSecondActivity)).perform(scrollTo(), click());
        try {
            onView(withId(R.id.textView)).check(matches(withText("Hello \nKyle Bastien\n30 years old")));
        } catch (NoMatchingViewException e) {
            onView(withId(R.id.goToSecondActivity)).perform(scrollTo(), click());
            onView(withId(R.id.textView)).check(matches(withText("Hello \nKyle Bastien\n30 years old")));
        }
    }

    @Test
    public void retainsStateAfterRotate() {
        // Change state of buttons / textview
        onView(withId(R.id.button2)).perform(scrollTo(), click());

        // Ensure change happened
        onView(withId(R.id.goToSecondActivity)).check(matches(withText(R.string.jk_button_text)));

        TestUtils.rotateScreen(activityTestRule.getActivity());

        // Ensure change is still there
        onView(withId(R.id.goToSecondActivity)).check(matches(withText(R.string.jk_button_text)));
    }

}