package com.example.mcnutt.inclassdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mcnutt.inclassdemo.entity.User;
import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;
import java.util.Objects;

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
        TextView userName = findViewById(R.id.userName);
        ImageView userPhoto = findViewById(R.id.userPhoto);

        userName.setText(getString(R.string.example_user_name));

        User user = new User();
        user.setEmail(Objects.requireNonNull(getString(R.string.example_user_email)));
        user.setFirstName(Objects.requireNonNull(getString(R.string.example_user_first_name)));
        user.setLastName(Objects.requireNonNull(getString(R.string.example_user_last_name)));
        user.setPhotoUrl(Objects.requireNonNull(getString(R.string.example_user_photo)));

        new SetUserTask(this, user).execute();

        if (user.getPhotoUrl() != null) {
            Picasso.get().load(user.getPhotoUrl()).into(userPhoto);
        }

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
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
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
    public void onSaveInstanceState(@NonNull Bundle outState) {
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

    public void goToFragmentToActivityDataExample(View view) {
        Intent intent = new Intent(MainActivity.this, FragmentToActivityDataPassingExample.class);
        startActivity(intent);
    }

    public void goToInterfragmentDataExample(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityInterFragmentCommunication.class);
        startActivity(intent);
    }

    public void goToFragmentScreenRotation(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityScreenRotationExample.class);
        startActivity(intent);
    }

    public void goToSimpleVolleyExample(View view) {
        Intent intent = new Intent(MainActivity.this, SimpleVolleyExampleActivity.class);
        startActivity(intent);
    }

    public void goToMoreComplexVolleyExample(View view) {
        Intent intent = new Intent(MainActivity.this, MoreComplexVolleyExampleActivity.class);
        startActivity(intent);
    }

    public void goToSimpleFirebaseExample(View view) {
        Intent intent = new Intent(MainActivity.this, SimpleFirebaseExample.class);
        startActivity(intent);
    }

    public void goToMoreComplexFirebaseDBExample(View view) {
        Intent intent = new Intent(MainActivity.this, MoreComplexFirebaseExample.class);
        startActivity(intent);
    }

    public void goToRoomPersistenceExample(View view) {
        Intent intent = new Intent(MainActivity.this, RoomPersistenceExampleActivity.class);
        startActivity(intent);
    }

    public void goToLocationExample(View view) {
        Intent intent = new Intent(MainActivity.this, LocationExampleActivity.class);
        startActivity(intent);
    }

    public void goToClickExample(View view) {
        Intent intent = new Intent(MainActivity.this, ClickDemoActivity.class);
        startActivity(intent);
    }

    private static class SetUserTask extends AsyncTask<Void, Void, User> {

        private WeakReference<Activity> weakActivity;
        private User user;

        SetUserTask(Activity activity, User user) {
            weakActivity = new WeakReference<>(activity);
            this.user = user;
        }

        @Override
        protected User doInBackground(Void... voids) {
            Activity activity = weakActivity.get();
            if(activity == null) {
                return null;
            }

            AppDatabase db = AppDatabaseSingleton.getDatabase(activity.getApplicationContext());

            db.userDao().insertAll(user);
            return user;
        }
    }
}
