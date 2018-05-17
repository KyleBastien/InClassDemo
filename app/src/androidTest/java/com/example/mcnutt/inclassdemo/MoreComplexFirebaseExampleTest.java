package com.example.mcnutt.inclassdemo;

import android.support.test.espresso.contrib.RecyclerViewActions;
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
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.example.mcnutt.inclassdemo.TestUtils.first;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MoreComplexFirebaseExampleTest {

    @Rule
    public ActivityTestRule<MoreComplexFirebaseExample> activityTestRule
            = new ActivityTestRule<>(MoreComplexFirebaseExample.class);

    @Test
    public void canAddTodoItem() throws InterruptedException {
        onView(withId(R.id.newTodoItemText)).perform(typeText("Todo Item"));

        onView(withId(R.id.addTodoItem)).perform(click());

        Thread.sleep(5000);

        closeSoftKeyboard();
    }

}