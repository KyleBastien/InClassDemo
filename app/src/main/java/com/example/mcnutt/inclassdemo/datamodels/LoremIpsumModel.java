package com.example.mcnutt.inclassdemo.datamodels;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class LoremIpsumModel {

    private final String loremIpsumBaseApi = "https://loripsum.net/api/plaintext";
    private RequestQueue queue;

    public LoremIpsumModel(Context context) {
        queue = Volley.newRequestQueue(context);
    }

    public void getLoremIpsum(Response.Listener<String> listener, Response.ErrorListener errorListener) {
        StringRequest request = new StringRequest(Request.Method.GET, loremIpsumBaseApi, listener, errorListener);
        queue.add(request);
    }
}
