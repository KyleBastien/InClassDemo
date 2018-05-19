package com.example.mcnutt.inclassdemo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ActivityInterFragmentCommunicationTest {

    @Rule
    public ActivityTestRule<ActivityInterFragmentCommunication> activityTestRule
            = new ActivityTestRule<>(ActivityInterFragmentCommunication.class);

    @Test
    public void canAddNumbers() {
        onView(withId(R.id.firstNumber)).perform(typeText("21"));

        closeSoftKeyboard();

        onView(withId(R.id.secondNumber)).perform(typeText("30"));

        closeSoftKeyboard();

        onView(withId(R.id.btnSend)).perform(click());

        onView(withId(R.id.sendDataToFragmentBtn)).perform(click());

        onView(withId(R.id.textResult)).check(matches(withText("Result: 51")));
    }

}