package com.example.mcnutt.inclassdemo;

import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

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