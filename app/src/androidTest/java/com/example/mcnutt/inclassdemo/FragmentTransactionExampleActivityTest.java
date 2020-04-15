package com.example.mcnutt.inclassdemo;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

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

    @Test
    public void canUseDummyBackButtonToGoBackInStack() {
        onView(withId(R.id.addFragmentA)).perform(click());

        onView(withId(R.id.fragmentAText)).check(matches(isDisplayed()));

        onView(withId(R.id.dummyBackButtonClick)).perform(click());

        onView(withId(R.id.fragmentAText)).check(doesNotExist());
    }

    @Test
    public void popAddFragAInclusiveRemovesAllAddsInlcudingFragA() {
        onView(withId(R.id.addFragmentA)).perform(click());

        onView(withId(R.id.fragmentAText)).check(matches(isDisplayed()));

        onView(withId(R.id.addFragmentB)).perform(click());

        onView(withId(R.id.fragmentBText)).check(matches(isDisplayed()));

        onView(withId(R.id.popAddAInclusive)).perform(click());

        onView(withId(R.id.fragmentAText)).check(doesNotExist());

        onView(withId(R.id.fragmentBText)).check(doesNotExist());
    }

    @Test
    public void popAddFragBExclusive() {
        onView(withId(R.id.addFragmentB)).perform(click());

        onView(withId(R.id.fragmentBText)).check(matches(isDisplayed()));

        onView(withId(R.id.addFragmentA)).perform(click());

        onView(withId(R.id.fragmentAText)).check(matches(isDisplayed()));

        onView(withId(R.id.popAddBExclusive)).perform(click());

        onView(withId(R.id.fragmentAText)).check(doesNotExist());

        onView(withId(R.id.fragmentBText)).check(matches(isDisplayed()));
    }

    @Test
    public void backButtonRemovesFragment() {
        onView(withId(R.id.addFragmentA)).perform(click());

        onView(withId(R.id.fragmentAText)).check(matches(isDisplayed()));

        pressBack();

        onView(withId(R.id.fragmentAText)).check(doesNotExist());
    }

    @Test
    public void canPressBackImmedietly() {
        try {
            pressBack();
        } catch(Exception e) {}
    }

}