package com.example.tuan08;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Item")
public class Item {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(int id) {
        this.id = id;
    }

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
