package com.example.mcnutt.inclassdemo;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

public class AppDatabaseSingleton {

    private static AppDatabase db;

    public static AppDatabase getDatabase(Context context) {
        if(db == null) {
            db = Room.databaseBuilder(context,
                    AppDatabase.class, "sample-database")
                    .addMigrations(MIGRATION_2_3)
                    .build();
        }

        return db;
    }

    private static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE user ADD COLUMN last_name TEXT");
            database.execSQL("ALTER TABLE user ADD COLUMN first_name TEXT");

            database.execSQL("update user\n" +
                    "set last_name=substr(display_name, instr(display_name, ' ')+1, length(display_name)-(instr(display_name, ' ')-1))");

            database.execSQL("update user\n" +
                    "set first_name=substr(display_name, 1, instr(display_name, ' ')-1)");

            database.execSQL("ALTER TABLE user RENAME TO temp_user;");

            database.execSQL("CREATE TABLE user (\n" +
                    " email TEXT NOT NULL PRIMARY KEY,\n" +
                    " first_name TEXT,\n" +
                    " last_name TEXT," +
                    " photo_url TEXT\n" +
                    ");");

            database.execSQL("INSERT INTO user \n" +
                    "SELECT\n" +
                    " email, first_name, last_name, photo_url\n" +
                    "FROM\n" +
                    " temp_user;");

            database.execSQL("\n" +
                    "DROP TABLE temp_user;");
        }
    };
}
