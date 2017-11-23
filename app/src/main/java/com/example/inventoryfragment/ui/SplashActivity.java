package com.example.inventoryfragment.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.inventoryfragment.R;

/**
 * Activity de Splash, de duracion mínima, para el inicio de aplicación
 *  @author Elena G (Beelzenef)
 *  */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}
