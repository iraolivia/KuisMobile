package com.example.kuismobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Perpustakaan> ListPerpustakaan = new ArrayList<Perpustakaan>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);adapter_off = new CustomListAdapter(this, ListPerpustakaan );
        mListView = (ListView) findViewById(R.id.list_perpustakaan);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListPerpustakaan.clear();
        List<Perpustakaan> contacts = db.ReadPerpustakaan();
        for (Perpustakaan cn : contacts) {
            Perpustakaan judulModel = new Perpustakaan();
            judulModel.set_id(cn.get_id());
            judulModel.set_jenis(cn.get_jenis());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_nim(cn.get_nim());
            ListPerpustakaan.add(judulModel);
            if ((ListPerpustakaan.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i,
                            long l) {
        Object o = mListView.getItemAtPosition(i);
        Perpustakaan obj_itemDetails = (Perpustakaan) o;
        String Sid = obj_itemDetails.get_id();
        String Sjenis = obj_itemDetails.get_jenis();
        String Snama = obj_itemDetails.get_nama();
        String Snim = obj_itemDetails.get_nim();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Ijenis", Sjenis);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Inim", Snim);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListPerpustakaan.clear();
        mListView.setAdapter(adapter_off);
        List<Perpustakaan> contacts = db.ReadPerpustakaan();
        for (Perpustakaan cn : contacts) {
            Perpustakaan judulModel = new Perpustakaan();
            judulModel.set_id(cn.get_id());
            judulModel.set_jenis(cn.get_jenis());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_nim(cn.get_nim());
            ListPerpustakaan.add(judulModel);
            if ((ListPerpustakaan.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
