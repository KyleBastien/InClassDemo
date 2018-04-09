package com.example.mcnutt.inclassdemo;

import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void canEnterNameAndLoginWithRotate() {
        onView(withId(R.id.nameEditText)).perform(typeText("Kyle McNutt"));

        onView(withId(R.id.loginBtn)).perform(click());

        onView(withId(R.id.textView))
                .check(matches(withText("Welcome: Kyle McNutt")));

        TestUtils.rotateScreen(activityTestRule.getActivity());

        // Make sure text view still has Welcome Kyle McNutt after screen rotation
        onView(withId(R.id.textView))
                .check(matches(withText("Welcome: Kyle McNutt")));
    }

    @Test
    public void canGoToSecondActivityWithMessage() {
        onView(withId(R.id.nameEditText)).perform(typeText("Kyle McNutt"));

        try {
            Intents.init();
            onView(withId(R.id.secondActivityBtn)).perform(scrollTo(), click());
            intended(hasComponent(SecondActivity.class.getName()));
            intended(hasExtra(Constants.KEY_NAME, "Kyle McNutt"));
            intended(hasExtra(Constants.KEY_AGE, 24));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void canGoToWeightLayoutExample() {
        try {
            Intents.init();
            onView(withId(R.id.weightExampleBtn)).perform(scrollTo(), click());
            intended(hasComponent(WeightLayoutActivity.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void canGoToNestedLinearLayoutExample() {
        try {
            Intents.init();
            onView(withId(R.id.nestedExampleBtn)).perform(scrollTo(), click());
            intended(hasComponent(NestedLinearLayoutActivity.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void canGoToRelativeNestedLayoutExample() {
        try {
            Intents.init();
            onView(withId(R.id.relativeExampleBtn)).perform(scrollTo(), click());
            intended(hasComponent(RelativeLayoutNestedExample.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void canGoToFrameLayoutExample() {
        try {
            Intents.init();
            onView(withId(R.id.frameLayoutExampleBtn)).perform(scrollTo(), click());
            intended(hasComponent(FrameLayoutPictureActivity.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void canGoToTableLayoutExample() {
        try {
            Intents.init();
            onView(withId(R.id.tableLayoutExample)).perform(scrollTo(), click());
            intended(hasComponent(TableLayoutExampleActivity.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void canGoToRelativeAlignmentExample() {
        try {
            Intents.init();
            onView(withId(R.id.relativeAlignmentExampleBtn)).perform(scrollTo(), click());
            intended(hasComponent(RelativeAlignmentExampleActivity.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void canGoToWeightLayoutExample() {
        Intents.init();
        onView(withId(R.id.weightExampleBtn)).perform(click());
        intended(hasComponent(WeightLayoutActivity.class.getName()));
        Intents.release();
    }

    @Test
    public void canGoToNestedLinearLayoutExample() {
        Intents.init();
        onView(withId(R.id.nestedExampleBtn)).perform(click());
        intended(hasComponent(NestedLinearLayoutActivity.class.getName()));
        Intents.release();
    }

    @Test
    public void canGoToRelativeNestedLayoutExample() {
        Intents.init();
        onView(withId(R.id.relativeExampleBtn)).perform(click());
        intended(hasComponent(RelativeLayoutNestedExample.class.getName()));
        Intents.release();
    }

    @Test
    public void canGoToFrameLayoutExample() {
        Intents.init();
        onView(withId(R.id.frameLayoutExampleBtn)).perform(click());
        intended(hasComponent(FrameLayoutPictureActivity.class.getName()));
        Intents.release();
    }

    @Test
    public void canGoToTableLayoutExample() {
        Intents.init();
        onView(withId(R.id.tableLayoutExample)).perform(click());
        intended(hasComponent(TableLayoutExampleActivity.class.getName()));
        Intents.release();
    }

}