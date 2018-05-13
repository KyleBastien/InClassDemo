package com.example.mcnutt.inclassdemo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.example.mcnutt.inclassdemo.TestUtils.getText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class SimpleFirebaseExampleTest {

    @Rule
    public ActivityTestRule<SimpleFirebaseExample> activityTestRule
            = new ActivityTestRule<>(SimpleFirebaseExample.class);

    @Test
    public void loadsHelloWorld() throws InterruptedException {
        // TODO
        Thread.sleep(2000);

        String textView = getText(withId(R.id.helloWorldFirebase));

        assertThat(textView, CoreMatchers.containsString("Hello World"));
    }

}