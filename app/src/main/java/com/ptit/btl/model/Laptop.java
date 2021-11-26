package com.ptit.btl.model;

import java.io.Serializable;

public class Laptop implements Serializable {

    private int id;

    private String ten;

    private String loai;

    private int giaTri;

    private String kichThuoc;

    private String manHinh;

    private String chip;

    private String ram;

    public Laptop(int id, String ten, String loai, int giaTri, String kichThuoc, String manHinh, String chip, String ram) {
        this.id = id;
        this.ten = ten;
        this.loai = loai;
        this.giaTri = giaTri;
        this.kichThuoc = kichThuoc;
        this.manHinh = manHinh;
        this.chip = chip;
        this.ram = ram;
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

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public int getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(int giaTri) {
        this.giaTri = giaTri;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getManHinh() {
        return manHinh;
    }

    public void setManHinh(String manHinh) {
        this.manHinh = manHinh;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }
}
