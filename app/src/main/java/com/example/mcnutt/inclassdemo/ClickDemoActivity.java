package com.example.mcnutt.inclassdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// This is a comment, look how important this activity is
public class ClickDemoActivity extends AppCompatActivity {

    private static final String TAG = ClickDemoActivity.class.getSimpleName();

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_demo);

        textView = findViewById(R.id.textView3);
        button = findViewById(R.id.goToSecondActivity);

        Log.i(TAG, "onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState()");

        if (savedInstanceState.containsKey(Constants.KEY_TEXTVIEW_TEXT)) {
            textView.setText(savedInstanceState.getString(Constants.KEY_TEXTVIEW_TEXT));
        }

        if (savedInstanceState.containsKey(Constants.KEY_BUTTON_TXT)) {
            button.setText(savedInstanceState.getString(Constants.KEY_BUTTON_TXT));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i(TAG, "onSaveInstanceState()");
        outState.putString(Constants.KEY_TEXTVIEW_TEXT, textView.getText().toString());
        outState.putString(Constants.KEY_BUTTON_TXT, button.getText().toString());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

    public void goToSecondActivity(View view) {
        Intent intent = new Intent(ClickDemoActivity.this, SecondActivity.class);
        intent.putExtra(Constants.KEY_NAME, "Kyle Bastien");
        intent.putExtra(Constants.KEY_AGE, 30);
        startActivity(intent);
    }

    public void changeText(View view) {
        textView.setText(getString(R.string.jk_text_view));
        button.setText(getString(R.string.jk_button_text));
    }
}
