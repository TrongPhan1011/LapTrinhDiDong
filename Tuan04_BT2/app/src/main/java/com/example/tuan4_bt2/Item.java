package com.example.tuan4_bt2;

public class Item {
    private int id;
    private String name;
    private String giaSP;
    private int imgLink;
    private int danhGia;

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

    public String getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(String giaSP) {
        this.giaSP = giaSP;
    }

    public int getImgLink() {
        return imgLink;
    }

    public void setImgLink(int imgLink) {
        this.imgLink = imgLink;
    }

    public int getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(int danhGia) {
        this.danhGia = danhGia;
    }

    public Item(int id, String name, String giaSP, int imgLink, int danhGia) {
        this.id = id;
        this.name = name;
        this.giaSP = giaSP;
        this.imgLink = imgLink;
        this.danhGia = danhGia;
    }

    public Item() {
    }
}
