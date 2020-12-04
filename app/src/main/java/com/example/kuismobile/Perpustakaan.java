package com.example.kuismobile;

public class Perpustakaan {
    private String _id, _jenis, _nama, _nim;

    public Perpustakaan(String id, String jenis, String nama, String nim) {
        this._id = id;
        this._jenis = jenis;
        this._nama = nama;
        this._nim = nim;
    }
    public Perpustakaan(){
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id=_id;
    }
    public String get_jenis() {
        return _jenis;
    }
    public void set_jenis(String _jenis) {
        this._jenis=_jenis;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama=_nama;
    }
    public String get_nim() {
        return _nim;
    }
    public void set_nim(String _nim) {
        this._nim=_nim;
    }
}
