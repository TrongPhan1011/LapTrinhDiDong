package com.example.tuan08;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ItemDAO {
    @Query("select * from Item")
    public List<Item> getAllItem();

    @Insert
    public void addItem(Item item);

    @Delete
    public void deleteItem(Item item);

}
