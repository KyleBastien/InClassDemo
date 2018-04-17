package com.example.mcnutt.inclassdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
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

        Bundle bundle = new Bundle();
        bundle.putInt(Constants.KEY_FIRST_NUMBER, firstNumber);
        bundle.putInt(Constants.KEY_SECOND_NUMBER, secondNumber);

        FragmentForData fragment = new FragmentForData();
        fragment.setArguments(bundle);

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragment, "fragA");
        transaction.commit();
    }
}
