package com.example.tuan06;

public class Shoe {
    private int id;
    private String name;
    private int img;
    private String description;

    public Shoe(int id, String name, int img, String description) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.description = description;
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

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Shoe() {
    }
}
