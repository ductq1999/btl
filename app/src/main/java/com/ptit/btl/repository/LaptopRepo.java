package com.ptit.btl.repository;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.ptit.btl.helper.MySQLiteHelper;
import com.ptit.btl.model.Laptop;

import java.util.ArrayList;
import java.util.List;

public class LaptopRepo {

    private final SQLiteOpenHelper helper;

    public LaptopRepo(SQLiteOpenHelper helper) {
        this.helper = helper;
    }

    public void add(Laptop laptop) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ten", laptop.getTen());
        values.put("chip", laptop.getChip());
        values.put("gia_tri", laptop.getGiaTri());
        values.put("loai", laptop.getLoai());
        values.put("kich_thuoc", laptop.getKichThuoc());
        values.put("man_hinh", laptop.getManHinh());
        values.put("ram", laptop.getRam());
        db.insert(MySQLiteHelper.tableLaptop, null, values);
    }

    public List<Laptop> getAll() {
        List<Laptop> list = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("select * from " + MySQLiteHelper.tableLaptop,null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(0);
                @SuppressLint("Range") String ten = cursor.getString(cursor.getColumnIndex("ten"));
                @SuppressLint("Range") String chip = cursor.getString(cursor.getColumnIndex("chip"));
                @SuppressLint("Range") int giaTri = cursor.getInt(cursor.getColumnIndex("gia_tri"));
                @SuppressLint("Range") String loai = cursor.getString(cursor.getColumnIndex("loai"));
                @SuppressLint("Range") float kichThuoc = cursor.getFloat(cursor.getColumnIndex("kich_thuoc"));
                @SuppressLint("Range") String manHinh = cursor.getString(cursor.getColumnIndex("man_hinh"));
                @SuppressLint("Range") String ram = cursor.getString(cursor.getColumnIndex("ram"));
                Laptop laptop = new Laptop(id, ten, loai, giaTri, kichThuoc, manHinh, chip, ram);
                list.add(laptop);
                cursor.moveToNext();
            }
        }
        return list;
    }


    public void delete(Laptop laptop) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete(MySQLiteHelper.tableLaptop, "id = ?", new String[] {String.valueOf(laptop.getId())});
    }

    public void update(Laptop laptop) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ten", laptop.getTen());
        values.put("loai", laptop.getLoai());
        values.put("gia_tri", laptop.getGiaTri());
        values.put("kich_thuoc", laptop.getKichThuoc());
        values.put("man_hinh", laptop.getManHinh());
        values.put("chip", laptop.getChip());
        values.put("ram", laptop.getRam());

        db.update(MySQLiteHelper.tableLaptop, values, "id = ?", new String[]{
                laptop.getId()+""
        });
    }

}
