package com.example.mcnutt.inclassdemo.datamodels;

import com.example.mcnutt.inclassdemo.models.TodoItem;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class FirebaseTodoModel {

    private FirebaseFirestore db;
    private List<ListenerRegistration> listeners;

    public FirebaseTodoModel() {
        db = FirebaseFirestore.getInstance();
        listeners = new ArrayList<>();
    }

    public void addTodoItem(TodoItem item) {
        CollectionReference todoItemsRef = db.collection("todoItems");
        todoItemsRef.add(item);
    }

    public void getTodoItems(Consumer<QuerySnapshot> dataChangedCallback, Consumer<FirebaseFirestoreException> dataErrorCallback) {
        ListenerRegistration listener = db.collection("todoItems")
                .addSnapshotListener((queryDocumentSnapshots, e) -> {
                    if (e != null) {
                        dataErrorCallback.accept(e);
                    }

                    dataChangedCallback.accept(queryDocumentSnapshots);
                });
        listeners.add(listener);
    }

    public void updateTodoItemById(TodoItem item) {
        DocumentReference todoItemRef = db.collection("todoItems").document(item.uid);
        Map<String, Object> data = new HashMap<>();
        data.put("title", item.title);
        data.put("done", item.done);
        todoItemRef.update(data);
    }

    public void clear() {
        // Clear all the listeners onPause
        listeners.forEach(ListenerRegistration::remove);
    }
}
