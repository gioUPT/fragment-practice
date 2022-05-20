package com.example.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Musica extends Fragment {

    View vista;

    Button btnPlay;

    MediaPlayer m1;

    int contador = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_musica, container, false);

        btnPlay = vista.findViewById(R.id.btnPlay);

        m1 = MediaPlayer.create(getContext(), R.raw.panconlechedemo1);



        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (contador%2 == 0){
                    m1.start();
                }else{
                    m1.pause();
                }
                contador++;
            }
        });

        return vista;
    }

    private void senial(String s) {
        Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
    }
}