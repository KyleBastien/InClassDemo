package com.example.mcnutt.inclassdemo;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FragmentAddNumbers extends Fragment {

    private Button btnSend;
    private EditText firstNumberText, secondNumberText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_add_numbers, container, false);

        btnSend = view.findViewById(R.id.btnSend);
        firstNumberText = view.findViewById(R.id.firstNumber);
        secondNumberText = view.findViewById(R.id.secondNumber);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });

        return view;
    }

    private void sendData() {
        int firstNum = Integer.valueOf(firstNumberText.getText().toString());
        int secondNum = Integer.valueOf(secondNumberText.getText().toString());


    }
}
