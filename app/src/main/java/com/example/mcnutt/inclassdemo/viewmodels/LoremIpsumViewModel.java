package com.example.mcnutt.inclassdemo.viewmodels;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.mcnutt.inclassdemo.datamodels.LoremIpsumModel;

import java.util.function.Consumer;
import java.util.function.Function;

public class LoremIpsumViewModel {

    private LoremIpsumModel model;

    public LoremIpsumViewModel(LoremIpsumModel model) {
        this.model = model;
    }

    public void getLoremIpsum(final Consumer<String> resultCallback) {
        this.model.getLoremIpsum(
            resultCallback::accept,
            error -> System.out.println("Something bad happened.")
        );
    }
}
