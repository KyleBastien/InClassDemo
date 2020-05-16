package com.example.mcnutt.inclassdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FragmentDataPassingActivity extends AppCompatActivity {

    private FragmentManager manager;
    private EditText firstNumber, secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_data_passing);

        manager = getSupportFragmentManager();
        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);
    }

    public void sendDataToFragment(View view) {
        int firstNumber = Integer.parseInt(this.firstNumber.getText().toString());
        int secondNumber = Integer.parseInt(this.secondNumber.getText().toString());

        FragmentForData fragment = new FragmentForData();
        Operation operation = new Operation(firstNumber, secondNumber);
        fragment.setOperation(operation);

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragment, "fragA");
        transaction.commit();
    }

    public static class Operation {
        int firstNumber;
        int secondNumber;

        Operation(int firstNumber, int secondNumber) {
            this.firstNumber = firstNumber;
            this.secondNumber = secondNumber;
        }
    }
}
