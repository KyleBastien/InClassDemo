package com.example.mcnutt.inclassdemo.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mcnutt.inclassdemo.AppDatabase;
import com.example.mcnutt.inclassdemo.AppDatabaseSingleton;
import com.example.mcnutt.inclassdemo.entity.User;

import java.util.List;

public class UserViewModel extends ViewModel {

    public LiveData<List<User>> loadAllByIds(Context context, String[] emailIds) {
        AppDatabase db = AppDatabaseSingleton.getDatabase(context);
        return db.userDao().loadAllByIds(emailIds);
    }

    public void updateUsers(Context context, User... users) {
        AppDatabase db = AppDatabaseSingleton.getDatabase(context);
        db.getTransactionExecutor().execute(() -> {
            db.userDao().updateUsers(users);
        });
    }

    public void deleteUser(Context context, User user) {
        AppDatabase db = AppDatabaseSingleton.getDatabase(context);
        db.getTransactionExecutor().execute(() -> {
            db.userDao().delete(user);
        });
    }

    public void insertAll(Context context, User... users) {
        AppDatabase db = AppDatabaseSingleton.getDatabase(context);
        db.getTransactionExecutor().execute(() -> {
            db.userDao().insertAll(users);
        });
    }
}
