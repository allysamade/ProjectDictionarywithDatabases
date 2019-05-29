package com.allysa.projectdictionarywithdatabases;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataDictionary extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbDictionary";
    public static final String INGGRIS= "Inggris";
    public static final String INDONESIA = "Indonesia";

    public DataDictionary(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void createTable(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS kamus");
        db.execSQL("CREATE TABLE if not exists kamus (id INTEGER PRIMARY KEY AUTOINCREMENT, inggris TEXT, indonesia TEXT);");
    }

    public void generateData(SQLiteDatabase db){
        ContentValues cv=new ContentValues();
        cv.put(INGGRIS, "run");
        cv.put(INDONESIA, "lari");
        db.insert("kamus", INGGRIS, cv);
        cv.put(INGGRIS, "walk");
        cv.put(INDONESIA, "jalan");
        db.insert("kamus", INGGRIS, cv);
        cv.put(INGGRIS, "read");
        cv.put(INDONESIA, "membaca");
        db.insert("kamus", INGGRIS, cv);
        cv.put(INGGRIS, "white");
        cv.put(INDONESIA, "putih");
        db.insert("kamus", INGGRIS, cv);
        cv.put(INGGRIS, "green");
        cv.put(INDONESIA, "hijau");
        db.insert("kamus", INGGRIS, cv);
        cv.put(INGGRIS, "blue");
        cv.put(INDONESIA, "biru");
        db.insert("kamus", INGGRIS, cv);
        cv.put(INGGRIS, "yellow");
        cv.put(INDONESIA, "kuning");
        db.insert("kamus", INGGRIS, cv);
        cv.put(INGGRIS, "black");
        cv.put(INDONESIA, "hitam");
        db.insert("kamus", INGGRIS, cv);
        cv.put(INGGRIS, "brown");
        cv.put(INDONESIA, "coklat");
        db.insert("kamus", INGGRIS, cv);
        cv.put(INGGRIS, "red");
        cv.put(INDONESIA, "merah");
        db.insert("kamus", INGGRIS, cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
    }
}

