package com.example.mcnutt.inclassdemo;

import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.example.mcnutt.inclassdemo.TestUtils.getText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class SimpleVolleyExampleActivityTest {

    @Rule
    public ActivityTestRule<SimpleVolleyExampleActivity> activityTestRule
            = new ActivityTestRule<>(SimpleVolleyExampleActivity.class);

    @Test
    public void loadsTextFromApi() throws InterruptedException {
        // TODO
        Thread.sleep(2000);

        String textView = getText(withId(R.id.textViewSimpleVolleyExample));

        assertThat(textView, CoreMatchers.containsString("Lorem ipsum"));
    }

}