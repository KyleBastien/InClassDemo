package com.example.mcnutt.inclassdemo;

import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

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