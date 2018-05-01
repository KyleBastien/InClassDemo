package com.example.mcnutt.inclassdemo.viewmodels;

import com.example.mcnutt.inclassdemo.datamodels.FirebaseHelloWorldModel;
import com.google.firebase.database.DataSnapshot;

import java.util.function.Consumer;

public class FirebaseHelloWorldViewModel {

    private FirebaseHelloWorldModel model;

    public FirebaseHelloWorldViewModel() {
        model = new FirebaseHelloWorldModel();
    }

    public void getHelloWorld(Consumer<String> resultCallback) {
        model.getHelloWorld(
            (DataSnapshot dataSnapshot) -> {
                String value = dataSnapshot.getValue(String.class);
                resultCallback.accept(value);
            },
            (databaseError -> System.out.println("Error reading Hello World: " + databaseError))
        );
    }

    public void clear() {
        model.clear();
    }
}
