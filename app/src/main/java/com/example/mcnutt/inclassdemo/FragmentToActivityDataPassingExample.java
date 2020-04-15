package com.example.mcnutt.inclassdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FragmentToActivityDataPassingExample extends AppCompatActivity implements MyListener {

    private static final String TAG = FragmentToActivityDataPassingExample.class.getSimpleName();

    private FragmentManager manager;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_to_data_passing_example);

        manager = getFragmentManager();
        textView = findViewById(R.id.textViewResult);
        
        addFragmentAddNumber();
    }

    private void addFragmentAddNumber() {
        FragmentAddNumbers fragmentAddNumbers = new FragmentAddNumbers();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.containerFragmentAddNumbers, fragmentAddNumbers, "fragA");
        transaction.commit();
    }

    @Override
    public void addTwoNumbers(int num1, int num2) {
        int result = num1 + num2;

        textView.setText(String.format(getString(R.string.result_prompt), result));
    }
}
