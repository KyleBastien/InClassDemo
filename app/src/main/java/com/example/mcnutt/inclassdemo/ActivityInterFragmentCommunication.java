package com.example.mcnutt.inclassdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ActivityInterFragmentCommunication extends AppCompatActivity implements MyListener {

    private FragmentManager manager;
    private int firstNum, secondNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter_fragment_communication);
        manager = getFragmentManager();

        addFragmentAddNumber();
        addFragmentResult();
    }

    private void addFragmentAddNumber() {
        FragmentAddNumbers fragmentAddNumbers = new FragmentAddNumbers();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.containerFragmentAddNumbers, fragmentAddNumbers, "fragA");
        transaction.commit();
    }

    private void addFragmentResult() {
        FragmentResult fragmentResult = new FragmentResult();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.containerFragmentResult, fragmentResult, "fragB");
        transaction.commit();
    }

    @Override
    public void addTwoNumbers(int num1, int num2) {
        firstNum = num1;
        secondNum = num2;
        Toast.makeText(this, String.format(getString(R.string.numbers_recieved_in_activity),
                num1, num2), Toast.LENGTH_LONG).show();
    }

    public void sendDataToFragment(View view) {
        FragmentResult fragmentResult = (FragmentResult) manager.findFragmentByTag("fragB");
        fragmentResult.addTwoNumbers(firstNum, secondNum);
    }
}
