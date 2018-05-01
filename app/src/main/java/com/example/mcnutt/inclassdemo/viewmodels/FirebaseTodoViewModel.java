package com.example.mcnutt.inclassdemo.viewmodels;

import com.example.mcnutt.inclassdemo.datamodels.FirebaseTodoModel;
import com.example.mcnutt.inclassdemo.models.TodoItem;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.List;
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
            (DataSnapshot dataSnapshot) -> {
                ArrayList<TodoItem> todoItems = new ArrayList<>();
                for (DataSnapshot todoSnapshot : dataSnapshot.getChildren()) {
                    TodoItem item = todoSnapshot.getValue(TodoItem.class);
                    assert item != null;
                    item.uid = todoSnapshot.getKey();
                    todoItems.add(item);
                }
                responseCallback.accept(todoItems);
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
