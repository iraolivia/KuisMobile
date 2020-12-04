package com.example.kuismobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_peminjaman";
    private static final String tb_perpustakaan = "tb_perpustakaan";
    private static final String tb_perpus_id = "id";
    private static final String tb_perpus_jenis = "jenis";
    private static final String tb_perpus_nama = "nama";
    private static final String tb_perpus_nim = "nim";
    private static final String CREATE_TABLE_Perpustakaan = "CREATE TABLE " +
            tb_perpustakaan + "("
            + tb_perpus_id + " INTEGER PRIMARY KEY ,"
            + tb_perpus_jenis + " TEXT,"
            + tb_perpus_nama + " TEXT,"
            + tb_perpus_nim + " TEXT " + ")";

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_Perpustakaan);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void CreatePerpustakaan(Perpustakaan mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_perpus_id, mdNotif.get_id());
        values.put(tb_perpus_jenis, mdNotif.get_jenis());
        values.put(tb_perpus_nama, mdNotif.get_nama());
        values.put(tb_perpus_nim, mdNotif.get_nim());
        db.insert(tb_perpustakaan, null, values);
        db.close();
    }

    public List<Perpustakaan> ReadPerpustakaan() {
        List<Perpustakaan> judulModelList = new ArrayList<Perpustakaan>();
        String selectQuery = "SELECT * FROM " + tb_perpustakaan;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Perpustakaan mdKontak = new Perpustakaan();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_jenis(cursor.getString(1));
                mdKontak.set_nama(cursor.getString(2));
                mdKontak.set_nim(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }

    public int UpdatePerpustakaan(Perpustakaan mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_perpus_jenis, mdNotif.get_jenis());
        values.put(tb_perpus_nama, mdNotif.get_nama());
        values.put(tb_perpus_nim, mdNotif.get_nim());
        return db.update(tb_perpustakaan, values, tb_perpus_id + " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
    }

    public void DeletePerpustakaan(Perpustakaan mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_perpustakaan, tb_perpus_id + " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}
