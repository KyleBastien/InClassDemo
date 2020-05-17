package com.example.mcnutt.inclassdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mcnutt.inclassdemo.datamodels.LoremIpsumModel;
import com.example.mcnutt.inclassdemo.viewmodels.LoremIpsumViewModel;

public class SimpleVolleyExampleActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_volley_example);

        LoremIpsumModel dataModel = new LoremIpsumModel(this);
        LoremIpsumViewModel viewModel = new LoremIpsumViewModel(dataModel);

        textView = findViewById(R.id.textViewSimpleVolleyExample);

        viewModel.getLoremIpsum(text -> textView.setText(text));
    }
}
