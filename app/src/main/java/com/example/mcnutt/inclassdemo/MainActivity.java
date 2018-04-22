package com.example.mcnutt.inclassdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Button loginBtn;
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.loginBtn);
        editText = findViewById(R.id.nameEditText);
        textView = findViewById(R.id.textView);

        Log.i(TAG, "onCreate()");
    }

    public void goToSecondActivity(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(Constants.KEY_NAME, editText.getText().toString());
        intent.putExtra(Constants.KEY_AGE, 24);
        startActivity(intent);
    }

    public void onLogin(View view) {
        loginBtn.setText(R.string.Logout);
        textView.setText(String.format(getString(R.string.Welcome), editText.getText()));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.i(TAG, "onRestoreInstanceState()");
        if (savedInstanceState.containsKey(Constants.KEY_NAME)) {
            textView.setText((String)savedInstanceState.get(Constants.KEY_NAME));
        }

        if (savedInstanceState.containsKey(Constants.KEY_BUTTON_TXT)) {
            loginBtn.setText((String) savedInstanceState.get(Constants.KEY_BUTTON_TXT));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i(TAG, "onSaveInstanceState()");
        outState.putString(Constants.KEY_NAME, textView.getText().toString());
        outState.putString(Constants.KEY_BUTTON_TXT, loginBtn.getText().toString());
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
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

    public void goToWeightLayoutExample(View view) {
        Intent intent = new Intent(MainActivity.this, WeightLayoutActivity.class);
        startActivity(intent);
    }

    public void goToNestedLinearLayoutExample(View view) {
        Intent intent = new Intent(MainActivity.this, NestedLinearLayoutActivity.class);
        startActivity(intent);
    }

    public void goToRelativeNestedExample(View view) {
        Intent intent = new Intent(MainActivity.this, RelativeLayoutNestedExample.class);
        startActivity(intent);
    }

    public void goToRelativeAlignmentExample(View view) {
        Intent intent = new Intent(MainActivity.this, RelativeAlignmentExampleActivity.class);
        startActivity(intent);
    }

    public void goToFrameLayoutExample(View view) {
        Intent intent = new Intent(MainActivity.this, FrameLayoutPictureActivity.class);
        startActivity(intent);
    }

    public void goToTableLayoutExample(View view) {
        Intent intent = new Intent(MainActivity.this, TableLayoutExampleActivity.class);
        startActivity(intent);
    }

    public void goToFragmentExample(View view) {
        Intent intent = new Intent(MainActivity.this, FragmentExampleActivity.class);
        startActivity(intent);
    }

    public void goToFragmentTransactionExample(View view) {
        Intent intent = new Intent(MainActivity.this, FragmentTransactionExampleActivity.class);
        startActivity(intent);
    }

    public void goToFragmentDataExample(View view) {
        Intent intent = new Intent(MainActivity.this, FragmentDataPassingActivity.class);
        startActivity(intent);
    }
}
