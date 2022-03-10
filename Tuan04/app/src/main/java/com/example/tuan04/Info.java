package com.example.tuan04;

public class Info {
    private int idIMG;
    private String name;
    private String shop;

    public Info(int idIMG, String name, String shop) {
        this.idIMG = idIMG;
        this.name = name;
        this.shop = shop;
    }

    public Info() {
    }

    public int getIdIMG() {
        return idIMG;
    }

    public void setIdIMG(int idIMG) {
        this.idIMG = idIMG;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }
}
