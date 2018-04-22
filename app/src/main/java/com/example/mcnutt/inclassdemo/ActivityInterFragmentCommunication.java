package com.example.mcnutt.inclassdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityInterFragmentCommunication extends AppCompatActivity implements MyListener {

    private FragmentManager manager;

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

    }

    public void sendDataToFragment(View view) {
    }
}
