package com.example.mcnutt.inclassdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mcnutt.inclassdemo.datamodels.InspirationalQuoteModel;
import com.example.mcnutt.inclassdemo.datamodels.PlaceKittenModel;
import com.example.mcnutt.inclassdemo.viewmodels.InspirationalQuotesViewModel;
import com.example.mcnutt.inclassdemo.viewmodels.PlaceKittenViewModel;

public class MoreComplexVolleyExampleActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_complex_volley_example);

        PlaceKittenModel dataModel = new PlaceKittenModel(this);
        PlaceKittenViewModel placeKittenViewModel = new PlaceKittenViewModel(dataModel);

        InspirationalQuoteModel quoteModel = new InspirationalQuoteModel(this);
        InspirationalQuotesViewModel inspirationalQuotesViewModel = new InspirationalQuotesViewModel(quoteModel);

        imageView = findViewById(R.id.kittenImage);
        textView = findViewById(R.id.textViewForQuote);

        placeKittenViewModel.getKittenImage(bitmap -> imageView.setImageBitmap(bitmap));

        inspirationalQuotesViewModel.getInspirationalQuote(quote -> textView.setText(quote));
    }
}
