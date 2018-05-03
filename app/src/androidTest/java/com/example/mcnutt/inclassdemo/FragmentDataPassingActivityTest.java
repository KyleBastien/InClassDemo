package com.example.mcnutt.inclassdemo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
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