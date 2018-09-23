package com.example.mcnutt.inclassdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mcnutt.inclassdemo.viewmodels.FirebaseHelloWorldViewModel;

public class SimpleFirebaseExample extends AppCompatActivity {

    private FirebaseHelloWorldViewModel vm;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_firebase_example);
        vm = new FirebaseHelloWorldViewModel();

        textView = findViewById(R.id.helloWorldFirebase);

        vm.getHelloWorld((response) -> textView.setText(response));
    }

    @Override
    protected void onPause() {
        vm.clear();
        super.onPause();
    }
}
