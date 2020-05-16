package com.example.mcnutt.inclassdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;


public class FragmentAddNumbers extends Fragment {

    private EditText firstNumberText, secondNumberText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_add_numbers, container, false);

        Button btnSend = view.findViewById(R.id.btnSend);
        firstNumberText = view.findViewById(R.id.firstNumber);
        secondNumberText = view.findViewById(R.id.secondNumber);

        btnSend.setOnClickListener(v -> sendData());

        return view;
    }

    private void sendData() {
        int firstNum = Integer.parseInt(firstNumberText.getText().toString());
        int secondNum = Integer.parseInt(secondNumberText.getText().toString());

        MyListener myListener = (MyListener) getActivity();
        if (myListener != null) {
            myListener.addTwoNumbers(firstNum, secondNum);
        }
    }
}
