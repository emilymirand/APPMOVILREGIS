package com.example.deber1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DatosIngresadosActivity extends AppCompatActivity {

    private TextView tvDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_ingresados);


        tvDatos = findViewById(R.id.tvDatos);

        Intent intent = getIntent();
        String cedula = intent.getStringExtra("cedula");
        String nombres = intent.getStringExtra("nombres");
        String fechaNacimiento = intent.getStringExtra("fechaNacimiento");
        String ciudad = intent.getStringExtra("ciudad");
        String genero = intent.getStringExtra("genero");
        String correo = intent.getStringExtra("correo");
        String telefono = intent.getStringExtra("Telefono");

        String datos = "Cédula: " + cedula +
                "\nNombres: " + nombres +
                "\nFecha Nacimiento: " + fechaNacimiento +
                "\nCiudad: " + ciudad +
                "\nGénero: " + genero +
                "\nCorreo: " + correo +
                "\nTeléfono: " + telefono +"\n USUARIO CREADO EXITOSAMENTE ";

        tvDatos.setText(datos);
    }
}
