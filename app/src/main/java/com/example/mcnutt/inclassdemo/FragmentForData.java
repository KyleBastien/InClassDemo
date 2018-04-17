package com.example.mcnutt.inclassdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentForData extends Fragment {

    private Button btnAdd;
    private TextView textViewResult;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_for_data, container, false);

        btnAdd = view.findViewById(R.id.btnAdd);
        textViewResult = view.findViewById(R.id.textViewResult);

        Bundle bundle = getArguments();
        final int firstNum = bundle.getInt(Constants.KEY_FIRST_NUMBER, 0);
        final int secondNum = bundle.getInt(Constants.KEY_SECOND_NUMBER, 0);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTwoNumbers(firstNum, secondNum);
            }
        });

        return view;
    }

    private void addTwoNumbers(int firstNum, int secondNum) {
        int result = firstNum + secondNum;
        textViewResult.setText(String.format(getString(R.string.result_prompt), result));
    }
}
