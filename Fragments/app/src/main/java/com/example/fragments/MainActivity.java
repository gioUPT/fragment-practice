package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNombre, etPassword;

    Button btnIngreso;

    Context con;

    String usuario = "gio",
            password = "123321";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicio();

        instancia();

        botonIngreso();

    }

    private void botonIngreso() {

        btnIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuarioIn = etNombre.getText().toString();
                String passwordIn = etPassword.getText().toString();

                //Archivo preference para almacenar información del contacto de confianza
                SharedPreferences sharedPreferences = getSharedPreferences("Data",con.MODE_PRIVATE);

                //Verifica si hay algun registro guardado.
                SharedPreferences cond = getPreferences(con.MODE_PRIVATE);
                String usuarioOut = cond.getString("usuario", "NoHay");
                String passwordOut = cond.getString("password", "NoHay");

                if (usuarioIn.equals(usuarioOut) && passwordIn.equals(passwordOut)){
                    senial("¡Has ingresado correctamente! :)");

                    Intent intent = new Intent(MainActivity.this, Menu.class);
                    startActivity(intent);
                }else{
                    senial("Datos inválidos, por favor verifica");
                }
            }
        });

    }

    private void senial(String s) {
        Toast.makeText(con, s, Toast.LENGTH_LONG).show();
    }

    private void instancia() {
        etNombre = (EditText) findViewById(R.id.etNombre);
        etPassword = (EditText) findViewById(R.id.etPassword);

        btnIngreso = (Button) findViewById(R.id.btnIngreso);

    }

    private void inicio() {
        //Contexto de la apliación
        con = getApplicationContext();

        //Archivo preference para almacenar información del contacto de confianza
        SharedPreferences sharedPreferences = getSharedPreferences("Data",con.MODE_PRIVATE);

        //Verifica si hay algun registro guardado.
        SharedPreferences cond = getPreferences(con.MODE_PRIVATE);
        String condi = cond.getString("usuario", "NoHay");

        if(condi.equals("NoHay")){
            SharedPreferences shared = getPreferences(con.MODE_PRIVATE);
            SharedPreferences.Editor edit = shared.edit();

            edit.putString("usuario", usuario);
            edit.putString("password", password);
            edit.commit();
        }
    }
}