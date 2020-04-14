package com.example.mcnutt.inclassdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
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

        manager = getFragmentManager();
        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);
    }

    public void sendDataToFragment(View view) {
        int firstNumber = Integer.valueOf(this.firstNumber.getText().toString());
        int secondNumber = Integer.valueOf(this.secondNumber.getText().toString());

        FragmentForData fragment = new FragmentForData();
        fragment.setOperation(new Operation(firstNumber, secondNumber));

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragment, "fragA");
        transaction.commit();
    }

    public class Operation {
        public int firstNumber;
        public int secondNumber;

        public Operation(int firstNumber, int secondNumber) {
            this.firstNumber = firstNumber;
            this.secondNumber = secondNumber;
        }
    }
}
