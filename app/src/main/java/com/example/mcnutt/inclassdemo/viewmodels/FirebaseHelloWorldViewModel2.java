package com.example.mcnutt.inclassdemo.viewmodels;

import com.example.mcnutt.inclassdemo.datamodels.FirebaseHelloWorldDataModel;

import java.util.function.Consumer;

public class FirebaseHelloWorldViewModel2 {

    private FirebaseHelloWorldDataModel dataModel;

    public FirebaseHelloWorldViewModel2() {
        dataModel = new FirebaseHelloWorldDataModel();
    }

    public void getHelloWorld(Consumer<String> activityCallback) {
        dataModel.getHelloWorld(
                (helloWorld) -> activityCallback.accept(helloWorld),
                (error) -> System.out.println(error.toString())
        );
    }

    public void clear() {
        dataModel.clear();
    }
}
