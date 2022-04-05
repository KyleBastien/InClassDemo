package com.example.mcnutt.inclassdemo;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.mcnutt.inclassdemo.dao.UserDao;
import com.example.mcnutt.inclassdemo.entity.User;

@Database(entities = {User.class}, version = 3, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
