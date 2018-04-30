package com.example.mcnutt.inclassdemo.datamodels;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

public class PlaceKittenModel {

    private final String placeKittenBaseApi = "https://placekitten.com/200/300";
    private RequestQueue queue;

    public PlaceKittenModel(Context context) {
        queue = Volley.newRequestQueue(context);
    }

    public void getKittenImage(Response.Listener<Bitmap> listener, Response.ErrorListener errorListener) {
        ImageRequest request = new ImageRequest(placeKittenBaseApi, listener, 200, 300, ImageView.ScaleType.CENTER, Bitmap.Config.RGB_565, errorListener);
        queue.add(request);
    }
}
