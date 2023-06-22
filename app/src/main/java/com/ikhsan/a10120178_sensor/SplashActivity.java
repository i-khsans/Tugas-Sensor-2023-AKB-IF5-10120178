package com.ikhsan.a10120178_sensor;

/*
 * NIM  : 10120178
 *Nama  : Muhammad Noer Ikhsan Hidayat
 *Kelas : IF5
 *Email : muhammadnoerikhsanh@gmail.com
 * */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.ikhsan.a10120178_sensor.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(decorView.SYSTEM_UI_FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, ViewpagerActivity.class));
                finish();
            }
        }, 4000);
    }
}