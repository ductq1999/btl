package com.ptit.btl.model;

import java.io.Serializable;

public class Hang implements Serializable {

    private int id;

    private String ten;

    private String danhGia;

    public Hang(int id, String ten, String danhGia) {
        this.id = id;
        this.ten = ten;
        this.danhGia = danhGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }
}
