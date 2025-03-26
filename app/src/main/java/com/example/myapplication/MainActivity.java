package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnTelepon;
    private Button btnBangunRuang;

    private void initComponents() {
        btnTelepon = findViewById(R.id.btnTelepon);
        btnBangunRuang = findViewById(R.id.btnBangunRuang);
    }

    // Function untuk Implisit Intent: Telepon
    public void telepon() {
        String nomor = "088212461825";
        //String test = "";
        Intent panggil = new Intent(Intent. ACTION_DIAL);
        panggil.setData(Uri.fromParts("tel",nomor,null));
        startActivity(panggil);

        // Jika ingin ada aplikasi pilihan yang di gunakan
        //Intent pilihAplikasi = Intent.createChooser(panggil, "Pilih Aplikasi Untuk Menelepon");
        //startActivity(pilihAplikasi);
    }

    // Function untuk Explicit Intent
    public void halBangunRuang(){
        Intent intentSatu = new Intent(MainActivity.this, BangunRuangActivity.class);
        startActivity(intentSatu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initComponents();

        // Event Listener untuk berpindah ke halaman kedua
        btnBangunRuang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                halBangunRuang();
            }
        });

        // Event Listener untuk melakukan telepon
        btnTelepon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                telepon();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}