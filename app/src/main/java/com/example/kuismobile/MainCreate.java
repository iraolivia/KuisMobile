package com.example.kuismobile;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainCreate extends AppCompatActivity{
    private MyDatabase db;
    private EditText Ejenis, Enama, Enim;
    private String Sjenis, Snama, Snim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Ejenis = (EditText) findViewById(R.id.create_jenis);
        Enama = (EditText) findViewById(R.id.create_nama);
        Enim = (EditText) findViewById(R.id.create_nim);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sjenis = String.valueOf(Ejenis.getText());
                Snama = String.valueOf(Enama.getText());
                Snim = String.valueOf(Enim.getText());
                if (Sjenis.equals("")) {
                    Ejenis.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi jenis buku",
                            Toast.LENGTH_SHORT).show();
                } else if (Snama.equals("")) {
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama peminjam",
                            Toast.LENGTH_SHORT).show();
                } else if (Snim.equals("")) {
                    Enim.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nim peminjam",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Ejenis.setText("");
                    Enama.setText("");
                    Enim.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreatePerpustakaan(new Perpustakaan(null, Sjenis, Snama, Snim));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}