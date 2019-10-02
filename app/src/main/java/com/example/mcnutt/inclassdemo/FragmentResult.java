package com.example.mcnutt.inclassdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentResult extends Fragment {

    private static final String TAG = FragmentResult.class.getSimpleName();

    private TextView textViewResult;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        textViewResult = view.findViewById(R.id.textResult);

        return view;
    }

    public void addTwoNumbers(int num1, int num2) {
        int result = num1 + num2 + num1;
        textViewResult.setText(String.format(getString(R.string.result_prompt), result));
    }
}
