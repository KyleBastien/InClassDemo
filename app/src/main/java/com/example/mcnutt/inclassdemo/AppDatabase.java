package com.example.mcnutt.inclassdemo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.mcnutt.inclassdemo.dao.UserDao;
import com.example.mcnutt.inclassdemo.entity.User;

@Database(entities = {User.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
