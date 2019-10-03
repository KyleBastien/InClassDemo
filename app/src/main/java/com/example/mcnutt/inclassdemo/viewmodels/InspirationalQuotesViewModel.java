package com.example.mcnutt.inclassdemo.viewmodels;

import android.graphics.Bitmap;

import com.example.mcnutt.inclassdemo.datamodels.InspirationalQuoteModel;
import com.example.mcnutt.inclassdemo.datamodels.PlaceKittenModel;
import com.example.mcnutt.inclassdemo.models.InspirationalQuote;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.function.Consumer;

public class InspirationalQuotesViewModel {
    private InspirationalQuoteModel model;

    public InspirationalQuotesViewModel(InspirationalQuoteModel model) {
        this.model = model;
    }

    public void getInspirationalQuote(final Consumer<String> resultCallback) {
        this.model.getRandomInspirationalQuote(
            (JSONArray jsonArray) -> {
                Gson gson = new Gson();
                // Hardcoding 0 because I know the API URL will only return me 1 response
                JSONObject object = null;
                try {
                    object = jsonArray.getJSONObject(0);
                    InspirationalQuote quote = gson.fromJson(object.toString(), InspirationalQuote.class);
                    resultCallback.accept(quote.getContent().getRendered());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            },
            error -> System.out.println("Something bad happened.")
        );
    }
}
