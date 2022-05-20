package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button btnMusic,
            btnCamera,
            btnFlash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        instancia();

    }

    private void instancia() {
        btnMusic = findViewById(R.id.btnMusic);
        btnCamera = findViewById(R.id.btnCamera);
        btnFlash = findViewById(R.id.btnFlash);

        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Musica nuevo = new Musica();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fcUno, nuevo);
                fragmentTransaction.commit();
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Camara nuevo = new Camara();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fcUno, nuevo);
                fragmentTransaction.commit();
            }
        });

        btnFlash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linterna nuevo = new Linterna();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fcUno, nuevo);
                fragmentTransaction.commit();
            }
        });
    }
}