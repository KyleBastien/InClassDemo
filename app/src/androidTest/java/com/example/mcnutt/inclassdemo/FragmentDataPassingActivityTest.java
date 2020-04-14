package com.example.mcnutt.inclassdemo;

import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.example.mcnutt.inclassdemo.TestUtils.getText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class FragmentDataPassingActivityTest {

    @Rule
    public ActivityTestRule<FragmentDataPassingActivity> activityTestRule
            = new ActivityTestRule<>(FragmentDataPassingActivity.class);

    @Test
    public void canSendDataToFragment() {
        onView(withId(R.id.firstNumber)).perform(typeText("15"), closeSoftKeyboard());

        onView(withId(R.id.secondNumber)).perform(typeText("25"), closeSoftKeyboard());

        onView(withId(R.id.sendDataToFragment)).perform(click());

        onView(withId(R.id.btnAdd)).perform(click());

        assertEquals(getText(withId(R.id.textViewResult)), "Result: 40");
    }

}