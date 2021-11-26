package com.ptit.btl.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final String dbName = "quan_ly_laptop";
    public static final String tableLaptop = "laptop";
    private static final String SQL_CREATE_ENTRIES = "" +
            "CREATE TABLE " + tableLaptop + "(id integer primary key, ten text, loai text, gia_tri integer, kich_thuoc text, man_hinh text, chip text, ram text)";

    public MySQLiteHelper(@Nullable Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}