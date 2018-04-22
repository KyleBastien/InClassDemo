package com.example.mcnutt.inclassdemo;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isNotChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

public class FragmentTransactionExampleActivityTest {
    @Rule
    public ActivityTestRule<FragmentTransactionExampleActivity> activityTestRule
            = new ActivityTestRule<>(FragmentTransactionExampleActivity.class);

    @Test
    public void canAddRemoveFragmentA() {
        onView(withId(R.id.addFragmentA)).perform(click());

        onView(withId(R.id.fragmentAText)).check(matches(isDisplayed()));

        onView(withId(R.id.removeFragmentA)).perform(click());

        onView(withId(R.id.fragmentAText)).check(doesNotExist());
    }

    @Test
    public void canAddRemoveFragmentB() {
        onView(withId(R.id.addFragmentB)).perform(click());

        onView(withId(R.id.fragmentBText)).check(matches(isDisplayed()));

        onView(withId(R.id.removeFragmentB)).perform(click());

        onView(withId(R.id.fragmentBText)).check(doesNotExist());
    }

    @Test
    public void canReplaceFragmentAAndB() {
        onView(withId(R.id.replaceWithFragmentA)).perform(click());

        onView(withId(R.id.fragmentAText)).check(matches(isDisplayed()));

        onView(withId(R.id.replaceWithFragmentB)).perform(click());

        onView(withId(R.id.fragmentBText)).check(matches(isDisplayed()));
    }

    @Test
    public void canAttachAndDetachFragmentA() {
        onView(withId(R.id.addFragmentA)).perform(click());

        onView(withId(R.id.fragmentAText)).check(matches(isDisplayed()));

        onView(withId(R.id.detachFragmentA)).perform(click());

        onView(withId(R.id.fragmentAText)).check(doesNotExist());

        onView(withId(R.id.attachFragmentA)).perform(click());

        onView(withId(R.id.fragmentAText)).check(matches(isDisplayed()));
    }

    @Test
    public void canShowHideFragmentA() {
        onView(withId(R.id.addFragmentA)).perform(click());

        onView(withId(R.id.fragmentAText)).check(matches(isDisplayed()));

        onView(withId(R.id.hideFragmentA)).perform(click());

        onView(withId(R.id.fragmentAText)).check(matches(not(isDisplayed())));

        onView(withId(R.id.showFragmentA)).perform(click());

        onView(withId(R.id.fragmentAText)).check(matches(isDisplayed()));
    }

}