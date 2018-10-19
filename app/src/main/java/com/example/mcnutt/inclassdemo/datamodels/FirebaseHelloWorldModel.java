package com.example.mcnutt.inclassdemo.datamodels;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Function;

public class FirebaseHelloWorldModel {

    private DatabaseReference mDatabase;
    private HashMap<DatabaseReference, ValueEventListener> listeners;

    public FirebaseHelloWorldModel() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        listeners = new HashMap<>();
    }

    public void getHelloWorld(ValueEventListener viewModelCallback) {
        // This is where we can construct our path
        DatabaseReference helloWorldRef = mDatabase.child("helloWorld");
        helloWorldRef.addValueEventListener(viewModelCallback);
        listeners.put(helloWorldRef, viewModelCallback);
    }

    public void clear() {
        // Clear all the listeners onPause
        listeners.forEach(Query::removeEventListener);
    }

}
