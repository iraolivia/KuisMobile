package com.example.kuismobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Sjenis, Snama, Snim;
    private EditText Ejenis, Enama, Enim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Sjenis = i.getStringExtra("Ijenis");
        Snama = i.getStringExtra("Inama");
        Snim = i.getStringExtra("Inim");
        Ejenis = (EditText) findViewById(R.id.updel_jenis);
        Enama = (EditText) findViewById(R.id.updel_nama);
        Enim = (EditText) findViewById(R.id.updel_nim);
        Ejenis.setText(Sjenis);
        Enama.setText(Snama);
        Enim.setText(Snim);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sjenis = String.valueOf(Ejenis.getText());
                Snama = String.valueOf(Enama.getText());
                Snim = String.valueOf(Enim.getText());
                if (Sjenis.equals("")){
                    Ejenis.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi jenis buku",
                            Toast.LENGTH_SHORT).show();
                } else if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama peminjam",
                            Toast.LENGTH_SHORT).show();
                } else if (Snim.equals("")){
                    Enim.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nim peminjam",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdatePerpustakaan(new Perpustakaan(Sid, Sjenis, Snama, Snim));Toast.makeText(MainUpdel.this, "Data telah  diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeletePerpustakaan(new Perpustakaan(Sid, Sjenis, Snama, Snim));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
