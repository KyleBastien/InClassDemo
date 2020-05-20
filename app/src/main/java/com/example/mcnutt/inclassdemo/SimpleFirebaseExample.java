package com.example.mcnutt.inclassdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mcnutt.inclassdemo.models.OnGetDataListener;
import com.example.mcnutt.inclassdemo.viewmodels.FirebaseHelloWorldViewModel;
import com.example.mcnutt.inclassdemo.viewmodels.FirebaseHelloWorldViewModel2;

public class SimpleFirebaseExample extends AppCompatActivity {

    private TextView textView;
    private FirebaseHelloWorldViewModel2 viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_firebase_example);

        viewModel = new FirebaseHelloWorldViewModel2();

        textView = findViewById(R.id.helloWorldFirebase);

        viewModel.getHelloWorld((helloWorld) -> textView.setText(helloWorld));
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.clear();
    }
}
