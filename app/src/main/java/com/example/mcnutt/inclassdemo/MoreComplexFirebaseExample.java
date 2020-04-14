package com.example.mcnutt.inclassdemo;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.example.mcnutt.inclassdemo.models.TodoItem;
import com.example.mcnutt.inclassdemo.viewmodels.FirebaseTodoViewModel;

import java.util.ArrayList;

import static com.example.mcnutt.inclassdemo.TodoItemFragment.ARG_DATA_SET;

public class MoreComplexFirebaseExample extends AppCompatActivity implements TodoItemFragment.OnListFragmentInteractionListener {

    private FirebaseTodoViewModel viewModel;
    private EditText newTodoItemText;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_complex_firebase_example);

        viewModel = new FirebaseTodoViewModel();

        newTodoItemText = findViewById(R.id.newTodoItemText);
        frameLayout = findViewById(R.id.todoItemListFragmentContainer);

        viewModel.getTodoItems(
            (ArrayList<TodoItem> todoItems) -> {
                FragmentManager manager = getSupportFragmentManager();
                TodoItemFragment fragment = (TodoItemFragment) manager.findFragmentByTag("todoItemFragment");

                if (fragment != null) {
                    // Remove fragment to re-add it
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.remove(fragment);
                    transaction.commit();
                }

                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList(ARG_DATA_SET, todoItems);

                TodoItemFragment todoItemFragment = new TodoItemFragment();
                todoItemFragment.setArguments(bundle);

                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.todoItemListFragmentContainer, todoItemFragment, "todoItemFragment");
                transaction.commit();
            }
        );
    }

    public void addTodoItem(View view) {
        String title = newTodoItemText.getText().toString();
        TodoItem item = new TodoItem(title, false);
        viewModel.addTodoItem(item);
    }

    @Override
    public void onListFragmentInteraction(TodoItem item) {
        item.done = true;
        viewModel.updateTodoItem(item);
    }

    @Override
    protected void onPause() {
        viewModel.clear();
        super.onPause();
    }
}
