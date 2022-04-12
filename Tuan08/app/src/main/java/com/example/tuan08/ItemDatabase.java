package com.example.tuan08;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Item.class},version = 1)
public abstract class ItemDatabase extends RoomDatabase {

    private static final String dbName = "itemDB.db";
    private static ItemDatabase instance;

    public static synchronized ItemDatabase getInstance(Context context){
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),ItemDatabase.class,dbName)
                            .allowMainThreadQueries().build();

        }
        return instance;
    }

    public abstract ItemDAO itemDAO();




}
