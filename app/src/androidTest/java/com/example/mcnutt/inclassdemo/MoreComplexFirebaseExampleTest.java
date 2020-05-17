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
import static androidx.test.espresso.matcher.ViewMatchers.withId;

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