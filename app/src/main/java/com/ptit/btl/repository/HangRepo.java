package com.ptit.btl.repository;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.ptit.btl.helper.MySQLiteHelper;
import com.ptit.btl.model.Hang;

import java.util.ArrayList;
import java.util.List;

public class HangRepo {

    private final SQLiteOpenHelper helper;

    public HangRepo(SQLiteOpenHelper helper) {
        this.helper = helper;
    }

    public void add(Hang hang) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ten", hang.getTen());
        values.put("danh_gia", hang.getDanhGia());
        db.insert(MySQLiteHelper.tableHang, null, values);
    }

    public List<Hang> getAll() {
        List<Hang> list = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("select * from " + MySQLiteHelper.tableHang,null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(0);
                @SuppressLint("Range") String ten = cursor.getString(cursor.getColumnIndex("ten"));
                @SuppressLint("Range") String danhGia = cursor.getString(cursor.getColumnIndex("danh_gia"));
                Hang hang = new Hang(id, ten, danhGia);
                list.add(hang);
                cursor.moveToNext();
            }
        }
        return list;
    }


    public void delete(Hang hang) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete(MySQLiteHelper.tableHang, "id = ?", new String[] {String.valueOf(hang.getId())});
    }

    public void update(Hang hang) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ten", hang.getTen());
        values.put("danh_gia", hang.getDanhGia());
        db.update(MySQLiteHelper.tableHang, values, "id = ?", new String[]{
                hang.getId()+""
        });
    }

}
