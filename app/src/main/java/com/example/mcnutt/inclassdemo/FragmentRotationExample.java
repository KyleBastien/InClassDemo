package com.example.mcnutt.inclassdemo;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentRotationExample extends Fragment {

    private static String TAG = FragmentRotationExample.class.getSimpleName();

    private Button button;
    private TextView textView;
    private int score;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate()");

        if(savedInstanceState != null) {
            score = savedInstanceState.getInt(Constants.KEY_SCORE, 0);
        }
        Toast.makeText(getActivity(), String.format(getString(R.string.score_value), score), Toast.LENGTH_LONG).show();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rotation_example, container, false);

        button = view.findViewById(R.id.rotationFragBtn);
        textView = view.findViewById(R.id.rotationFragTextView);

        if(savedInstanceState != null) {
            button.setText(savedInstanceState.getString(Constants.KEY_BUTTON_TXT, getString(R.string.login)));
            textView.setText(savedInstanceState.getString(Constants.KEY_TEXTVIEW_TEXT, getString(R.string.fragment_a)));
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(R.string.dummy_text);
                button.setText(R.string.Logout);

                score = 47;
                Toast.makeText(getActivity(), String.format(getString(R.string.score_value), score), Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(Constants.KEY_SCORE, score);
        outState.putString(Constants.KEY_TEXTVIEW_TEXT, textView.getText().toString());
        outState.putString(Constants.KEY_BUTTON_TXT, button.getText().toString());
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG,"onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach()");
    }

}
