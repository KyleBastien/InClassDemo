package com.example.mcnutt.inclassdemo.viewmodels;

import android.graphics.Bitmap;

import com.example.mcnutt.inclassdemo.datamodels.LoremIpsumModel;
import com.example.mcnutt.inclassdemo.datamodels.PlaceKittenModel;

import java.util.function.Consumer;

public class PlaceKittenViewModel {
    private PlaceKittenModel model;

    public PlaceKittenViewModel(PlaceKittenModel model) {
        this.model = model;
    }

    public void getKittenImage(final Consumer<Bitmap> resultCallback) {
        this.model.getKittenImage(
            resultCallback::accept,
            error -> System.out.println("Something bad happened.")
        );
    }
}
