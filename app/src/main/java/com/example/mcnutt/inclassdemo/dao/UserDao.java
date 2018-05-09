package com.example.mcnutt.inclassdemo.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.mcnutt.inclassdemo.entity.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE email IN (:emails)")
    List<User> loadAllByIds(String[] emails);

    @Query("SELECT * FROM user WHERE first_name LIKE :firstName and last_name LIKE :lastName LIMIT 1")
    User findByName(String firstName, String lastName);

    @Update
    void updateUsers(User... users);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(User... users);

    @Delete
    void delete(User user);
}
