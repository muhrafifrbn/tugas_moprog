package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BangunRuangActivity extends AppCompatActivity {
    private Button btnHasilHitung, btnBack;
    private EditText sisi;

//    private TextView luasKubus;
//
//    private TextView volumeKubus;

    public static final String EXTRA_VOLUME = "com.example.myapplication.EXTRA_VOLUME";
    public static final String EXTRA_LUAS = "com.example.myapplication.EXTRA_LUAS";
    private void initComponents() {
        btnHasilHitung = findViewById(R.id.btnHitung);
        sisi = findViewById(R.id.editSisi);
        btnBack = findViewById(R.id.btnBack);
    }


    // Function Explicit Intent ke halaman hasilHitung
    public void halHasilHitung(){
        initComponents();
        Intent intent = new Intent(BangunRuangActivity.this, HasilHitungActivity.class);
        double sisiFinal = Double.parseDouble(sisi.getText().toString());
        double setVolumeKubus = volumeKubus(sisiFinal);
        double setLuasKubus = luasKubus(sisiFinal);
        intent.putExtra(EXTRA_VOLUME,setVolumeKubus);
        intent.putExtra(EXTRA_LUAS,setLuasKubus);
        startActivity(intent);
    }


    // Function Perhitungan Volume Kubus
    public double volumeKubus(double sisi){
    double volume = sisi * sisi * sisi;
    return volume;
    }

    // Function Perhitungan Luas Kubus
    public double luasKubus(double sisi){
        double luas = 6 * (sisi * sisi);
        return luas;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bangun_ruang);

        initComponents();
        // Event Listener ke halaman hasil hitung
        btnHasilHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                halHasilHitung();
            }
        });

        btnBack.setOnClickListener((v) -> {
            Intent intentBack = new Intent(BangunRuangActivity.this, MainActivity.class);
            startActivity(intentBack);
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.bangunRuang), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}