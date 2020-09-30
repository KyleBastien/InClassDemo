package com.example.mcnutt.inclassdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mcnutt.inclassdemo.models.OnGetDataListener;
import com.example.mcnutt.inclassdemo.viewmodels.FirebaseHelloWorldViewModel;

public class SimpleFirebaseExample extends AppCompatActivity {

    private FirebaseHelloWorldViewModel vm;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_firebase_example);
        vm = new FirebaseHelloWorldViewModel();

        tv = findViewById(R.id.helloWorldFirebase);

        vm.getHelloWorld(new OnGetDataListener<String>() {
            @Override
            public void onSuccess(String dataResponse) {
                tv.setText(dataResponse);
            }

            @Override
            public void onFailure() {
                System.out.println("Looks like some error happened when we tried to get helloWorld");
            }
        });
    }

    @Override
    protected void onPause() {
        vm.clear();
        super.onPause();
    }
}
