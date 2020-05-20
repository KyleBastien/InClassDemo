package com.example.mcnutt.inclassdemo.datamodels;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class FirebaseHelloWorldDataModel {

    private FirebaseFirestore db;
    private List<ListenerRegistration> listeners;

    public FirebaseHelloWorldDataModel() {
        db = FirebaseFirestore.getInstance();
        listeners = new ArrayList<>();
    }

    public void getHelloWorld(Consumer<String> viewModelCallback, Consumer<FirebaseFirestoreException> viewModelErrorCallback) {
        ListenerRegistration listener = db.collection("examples")
                .document("helloWorld").addSnapshotListener(
                (documentSnapshot, e) -> {
                    if (e != null) {
                        viewModelErrorCallback.accept(e);
                    }

                    if (documentSnapshot != null) {
                        Object helloWorldField = documentSnapshot.get("helloWorld");
                        if (helloWorldField != null) {
                            String helloWorld = helloWorldField.toString();
                            viewModelCallback.accept(helloWorld);
                        }
                    }
                }
        );
        listeners.add(listener);
    }

    public void clear() {
        listeners.forEach(ListenerRegistration::remove);
    }
}
