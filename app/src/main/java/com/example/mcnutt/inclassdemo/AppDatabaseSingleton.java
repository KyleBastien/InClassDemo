package com.example.mcnutt.inclassdemo;

import android.arch.persistence.room.Room;
import android.content.Context;

public class AppDatabaseSingleton {

    private static AppDatabase db;

    public static AppDatabase getDatabase(Context context) {
        if(db == null) {
            db = Room.databaseBuilder(context,
                    AppDatabase.class, "sample-database").build();
        }

        return db;
    }
}
