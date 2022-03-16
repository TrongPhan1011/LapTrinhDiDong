package com.example.tuan05;

public class Donut {

    private int id;
    private String name;
    private String moTa;
    private int img;
    private double gia;
    private String loaiDonut;

    public String getLoaiDonut() {
        return loaiDonut;
    }

    public void setLoaiDonut(String loaiDonut) {
        this.loaiDonut = loaiDonut;
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public Donut(int id, String name, String moTa, int img, double gia, String loaiDonut) {
        this.id = id;
        this.name = name;
        this.moTa = moTa;
        this.img = img;
        this.gia = gia;
        this.loaiDonut = loaiDonut;
    }

    public Donut() {
    }
}
