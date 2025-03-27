package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HasilHitungActivity extends AppCompatActivity {
    private TextView txtVolume,txtLuas;
    Button btnBack;
    private void initComponents(){
        txtVolume = (TextView) findViewById(R.id.volumeKubus);
        txtLuas = (TextView) findViewById(R.id.luasKubus);
        btnBack = findViewById(R.id.btnBack);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hasil_hitung);
        initComponents();
        Intent intent = getIntent();
        double volume = intent.getDoubleExtra(BangunRuangActivity.EXTRA_VOLUME,0);
        double luas = intent.getDoubleExtra(BangunRuangActivity.EXTRA_LUAS,0);

        txtVolume.setText(String.valueOf(volume));
        txtLuas.setText(String.valueOf(luas));


        btnBack.setOnClickListener((v) -> {
            Intent intentBack = new Intent(HasilHitungActivity.this, BangunRuangActivity.class);
            startActivity(intentBack);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}