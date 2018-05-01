package com.example.mcnutt.inclassdemo.datamodels;

import com.example.mcnutt.inclassdemo.models.TodoItem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.function.Consumer;

public class FirebaseTodoModel {

    private DatabaseReference mDatabase;
    private HashMap<DatabaseReference, ValueEventListener> listeners;

    public FirebaseTodoModel() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        listeners = new HashMap<>();
    }

    public void addTodoItem(TodoItem item) {
        DatabaseReference todoItemsRef = mDatabase.child("todoItems");
        todoItemsRef.push().setValue(item);
    }

    public void getTodoItems(Consumer<DataSnapshot> dataChangedCallback, Consumer<DatabaseError> dataErrorCallback) {
        DatabaseReference todoItemsRef = mDatabase.child("todoItems");
        ValueEventListener todoItemsListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataChangedCallback.accept(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                dataErrorCallback.accept(databaseError);
            }
        };
        todoItemsRef.addValueEventListener(todoItemsListener);
        listeners.put(todoItemsRef, todoItemsListener);
    }

    public void updateTodoItemById(TodoItem item) {
        DatabaseReference todoItemsRef = mDatabase.child("todoItems");
        todoItemsRef.child(item.uid).setValue(item);
    }

    public void clear() {
        // Clear all the listeners onPause
        listeners.forEach(Query::removeEventListener);
    }
}
