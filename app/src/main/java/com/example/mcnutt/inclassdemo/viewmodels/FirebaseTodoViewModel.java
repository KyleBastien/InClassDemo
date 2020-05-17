package com.example.mcnutt.inclassdemo.viewmodels;

import com.example.mcnutt.inclassdemo.datamodels.FirebaseTodoModel;
import com.example.mcnutt.inclassdemo.models.TodoItem;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.function.Consumer;

public class FirebaseTodoViewModel {

    private FirebaseTodoModel todoModel;

    public FirebaseTodoViewModel() {
        todoModel = new FirebaseTodoModel();
    }

    public void addTodoItem(TodoItem item) {
        todoModel.addTodoItem(item);
    }

    public void getTodoItems(Consumer<ArrayList<TodoItem>> responseCallback) {
        todoModel.getTodoItems(
            (QuerySnapshot querySnapshot) -> {
                if (querySnapshot != null) {
                    ArrayList<TodoItem> todoItems = new ArrayList<>();
                    for (DocumentSnapshot todoSnapshot : querySnapshot.getDocuments()) {
                        TodoItem item = todoSnapshot.toObject(TodoItem.class);
                        assert item != null;
                        item.uid = todoSnapshot.getId();
                        todoItems.add(item);
                    }
                    responseCallback.accept(todoItems);
                }
            },
            (databaseError -> System.out.println("Error reading Todo Items: " + databaseError))
        );
    }

    public void updateTodoItem(TodoItem item) {
        todoModel.updateTodoItemById(item);
    }

    public void clear() {
        todoModel.clear();
    }
}
