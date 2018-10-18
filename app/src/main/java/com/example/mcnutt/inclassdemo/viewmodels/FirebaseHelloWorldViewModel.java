package com.example.mcnutt.inclassdemo.viewmodels;

import com.example.mcnutt.inclassdemo.datamodels.FirebaseHelloWorldModel;
import com.example.mcnutt.inclassdemo.models.OnGetDataListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.function.Consumer;

public class FirebaseHelloWorldViewModel {

    private FirebaseHelloWorldModel model;

    public FirebaseHelloWorldViewModel() {
        model = new FirebaseHelloWorldModel();
    }

    public void getHelloWorld(OnGetDataListener<String> activityCallback) {
        model.getHelloWorld(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                activityCallback.onSuccess(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Error reading Hello World: " + databaseError);
                activityCallback.onFailure();
            }
        });

    }

    public void clear() {
        model.clear();
    }
}
