package com.Maktaba.MyBooks.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = ModelOfTable.class, exportSchema = false, version = 2)
public abstract class BuildeRoomDatabase extends RoomDatabase {
    private final static String DB_NAME = "DB_name";
    private static BuildeRoomDatabase Instance;
    public static synchronized BuildeRoomDatabase getInstance(Context context) {
        if (Instance == null) {
            Instance = Room.databaseBuilder(context, BuildeRoomDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return Instance;
    }

    public abstract OperationDao operationDao();
}
