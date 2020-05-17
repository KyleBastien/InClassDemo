package com.example.mcnutt.inclassdemo;

import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.mcnutt.inclassdemo.models.TodoItem;
import com.example.mcnutt.inclassdemo.viewmodels.FirebaseTodoViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.Consumer;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MoreComplexFirebaseExampleTest {

    @Rule
    public ActivityTestRule<MoreComplexFirebaseExample> activityTestRule
            = new ActivityTestRule<>(MoreComplexFirebaseExample.class);

    @Before
    public void setup() {
        FirebaseTodoViewModel vm = activityTestRule.getActivity().getViewModel();
        FirebaseTodoViewModel spyVm = Mockito.spy(vm);

        ArrayList<TodoItem> todoItems = new ArrayList<>();
        todoItems.add(new TodoItem("Foo", false));
        todoItems.add(new TodoItem("Bar", true));

        Mockito.doAnswer((Answer<Void>) invocation-> {
            Consumer<ArrayList<TodoItem>> callback = invocation.getArgumentAt(1, Consumer.class);
            callback.accept(todoItems);
            return null;
        }).when(spyVm).getTodoItems(Mockito.anyObject());

        Mockito.doNothing().when(spyVm).clear();

        Mockito.doNothing().when(spyVm).addTodoItem(Mockito.any(TodoItem.class));

        activityTestRule.getActivity().setViewModel(spyVm);
    }

    @Test
    public void canAddTodoItem() throws InterruptedException {
        onView(withId(R.id.newTodoItemText)).perform(typeText("Todo Item"));

        onView(withId(R.id.addTodoItem)).perform(click());

        Thread.sleep(5000);

        closeSoftKeyboard();
    }

}