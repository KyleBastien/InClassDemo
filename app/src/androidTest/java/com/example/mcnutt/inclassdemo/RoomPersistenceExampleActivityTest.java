package com.example.mcnutt.inclassdemo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class RoomPersistenceExampleActivityTest {

    @Rule
    public ActivityTestRule<RoomPersistenceExampleActivity> activityTestRule
            = new ActivityTestRule<>(RoomPersistenceExampleActivity.class);

    @Test
    public void canUpdateAndDelete() {
        onView(withId(R.id.delete)).perform(click());
        onView(withId(R.id.update)).perform(click());

        onView(withId(R.id.email)).check(matches(withText("fakeuser@google.com")));
        onView(withId(R.id.displayName)).check(matches(withText("Thisis afakeuser")));
        onView(withId(R.id.photoUrl)).check(matches(withText("https://i.imgur.com/ZYVZT1d.jpg")));
    }

}