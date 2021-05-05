package com.example.mcnutt.inclassdemo;

import android.content.Intent;
import android.net.Uri;
import androidx.test.espresso.intent.Intents;
import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static org.hamcrest.Matchers.not;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private FirebaseAuth firebaseAuth;

    private FirebaseUser firebaseUser;

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule
            = new ActivityTestRule<>(MainActivity.class, true, false);

    @Rule
    public ControlledActivityTestRule<MainActivity> mainActivityControlledActivityTestRule
            = new ControlledActivityTestRule<>(MainActivity.class);

    @Before
    public void init() {
        firebaseAuth = mock(FirebaseAuth.class);
        firebaseUser = mock(FirebaseUser.class);

        FirebaseAuthGetter.setFirebaseAuth(firebaseAuth);
        when(firebaseAuth.getCurrentUser()).thenReturn(firebaseUser);
        when(firebaseUser.getDisplayName()).thenReturn("Kyle Guy");
        when(firebaseUser.getPhotoUrl()).thenReturn(Uri.parse("https://image.flaticon.com/icons/png/128/149/149452.png"));
        when(firebaseUser.getEmail()).thenReturn("foo@google.com");

        Intent intent = new Intent();
        activityTestRule.launchActivity(intent);
    }

    @Test
    public void canEnterNameAndLoginWithRotate() {
        onView(withId(R.id.nameEditText)).perform(typeText("Kyle McNutt"));

        onView(withId(R.id.loginBtn)).perform(click());

        onView(withId(R.id.textView))
                .check(matches(withText("Welcome: Kyle McNutt")));

        TestUtils.rotateScreen(activityTestRule.getActivity());

        // Make sure text view still has Welcome Kyle McNutt after screen rotation
        onView(withId(R.id.textView))
                .check(matches(not(withText("Welcome: Kyle McNutt"))));
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
    public void canGoToBasicFragmentExample() {
        try {
            Intents.init();
            onView(withId(R.id.fragmentExampleBtn)).perform(scrollTo(), click());
            intended(hasComponent(FragmentExampleActivity.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void canGoToFragmentTransactionExample() {
        try {
            Intents.init();
            onView(withId(R.id.fragmentTransactionExampleBtn)).perform(scrollTo(), click());
            intended(hasComponent(FragmentTransactionExampleActivity.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void canGoToFragmentDataExample() {
        try {
            Intents.init();
            onView(withId(R.id.fragmentDataPassingExampleBtn)).perform(scrollTo(), click());
            intended(hasComponent(FragmentDataPassingActivity.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void canGoToFragmentToActivityExample() {
        try {
            Intents.init();
            onView(withId(R.id.fragmentToActivityDataExampleBtn)).perform(scrollTo(), click());
            intended(hasComponent(FragmentToActivityDataPassingExample.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void canGoToInterFragmentDataExample() {
        try {
            Intents.init();
            onView(withId(R.id.fragmentToFragmentDataExampleBtn)).perform(scrollTo(), click());
            intended(hasComponent(ActivityInterFragmentCommunication.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void canGoToFragmentScreenRotationExample() {
        try {
            Intents.init();
            onView(withId(R.id.fragmentScreenRotationExampleBtn)).perform(scrollTo(), click());
            intended(hasComponent(ActivityScreenRotationExample.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void goToSimpleVolleyExample() {
        try {
            Intents.init();
            onView(withId(R.id.simpleVolleyExample)).perform(scrollTo(), click());
            intended(hasComponent(SimpleVolleyExampleActivity.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void goToMoreComplexVolleyExample() {
        try {
            Intents.init();
            onView(withId(R.id.moreComplexVolleyExample)).perform(scrollTo(), click());
            intended(hasComponent(MoreComplexVolleyExampleActivity.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void goToSimpleFirebaseExample() {
        try {
            Intents.init();
            onView(withId(R.id.simpleFirebaseDBExample)).perform(scrollTo(), click());
            intended(hasComponent(SimpleFirebaseExample.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void goToMoreComplexFirebaseDBExample() {
        try {
            Intents.init();
            onView(withId(R.id.complexFirebaseDBExample)).perform(scrollTo(), click());
            intended(hasComponent(MoreComplexFirebaseExample.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void goToRoomPersistenceExample() {
        try {
            Intents.init();
            onView(withId(R.id.roomPersistenceExample)).perform(scrollTo(), click());
            intended(hasComponent(RoomPersistenceExampleActivity.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void goToLocationExample() {
        try {
            Intents.init();
            onView(withId(R.id.locationExample)).perform(scrollTo(), click());
            intended(hasComponent(LocationExampleActivity.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void goToClickExample() {
        try {
            Intents.init();
            onView(withId(R.id.clickDemoExample)).perform(scrollTo(), click());
            intended(hasComponent(ClickDemoActivity.class.getName()));
        } finally {
            Intents.release();
        }
    }

}