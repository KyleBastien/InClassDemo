package com.example.mcnutt.inclassdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityScreenRotationExample extends AppCompatActivity {

    private static final String TAG = ActivityScreenRotationExample.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_rotation_example);
    }
}
