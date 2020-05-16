package com.example.mcnutt.inclassdemo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentForData extends Fragment {

    private TextView textViewResult;
    private FragmentDataPassingActivity.Operation operation;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_for_data, container, false);

        Button btnAdd = view.findViewById(R.id.btnAdd);
        textViewResult = view.findViewById(R.id.textViewResult);

        Bundle arguments = getArguments();

        if (arguments == null) {
            arguments = savedInstanceState;
        }

        if (arguments != null
                && arguments.containsKey(Constants.KEY_FIRST_NUMBER)
                && arguments.containsKey(Constants.KEY_SECOND_NUMBER)) {
            int firstNumber = arguments.getInt(Constants.KEY_FIRST_NUMBER);
            int secondNumber = arguments.getInt(Constants.KEY_SECOND_NUMBER);

            this.operation = new FragmentDataPassingActivity.Operation(firstNumber, secondNumber);
        }

        if (savedInstanceState != null
                && savedInstanceState.containsKey(Constants.KEY_RESULT)) {
            textViewResult.setText(savedInstanceState.getString(Constants.KEY_RESULT));
        }

        btnAdd.setOnClickListener(view1 -> addTwoNumbers(operation.firstNumber, operation.secondNumber));

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(Constants.KEY_RESULT, textViewResult.getText().toString());
        outState.putInt(Constants.KEY_FIRST_NUMBER, operation.firstNumber);
        outState.putInt(Constants.KEY_SECOND_NUMBER, operation.secondNumber);
    }

    private void addTwoNumbers(int firstNum, int secondNum) {
        int result = firstNum + secondNum;
        textViewResult.setText(String.format(getString(R.string.result_prompt), result));
    }

    void setOperation(FragmentDataPassingActivity.Operation operation) {
        this.operation = operation;
    }
}
