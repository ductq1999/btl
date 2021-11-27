package com.ptit.btl.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final String dbName = "quan_ly_cua_han_laptop";
    public static final String tableLaptop = "laptop";
    public static final String tableHang = "hang";
    private static final String SQL_CREATE_LAPTOP = "" +
            "CREATE TABLE " + tableLaptop + "(id integer primary key, ten text, loai text, gia_tri integer, kich_thuoc text, man_hinh text, chip text, ram text)";

    private static final String SQL_CREATE_HANG = "" +
            "CREATE TABLE " + tableHang + "(id integer primary key, ten text, danh_gia text)";

    public MySQLiteHelper(@Nullable Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_LAPTOP);
        db.execSQL(SQL_CREATE_HANG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}