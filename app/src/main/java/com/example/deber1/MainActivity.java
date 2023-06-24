package com.example.deber1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText txtCedula, txtNombres, txtFechaNacimiento, txtCiudad, txtCorreo, txtTelefono;
    private RadioGroup radioGroupGenero;
    private Button btnEnviar, btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCedula = findViewById(R.id.TxtCedula);
        txtNombres = findViewById(R.id.txtNombres);
        txtFechaNacimiento = findViewById(R.id.txtFechaNacimiento);
        txtCiudad = findViewById(R.id.txtCiudad);
        radioGroupGenero = findViewById(R.id.radioGroupGenero);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtTelefono = findViewById(R.id.txtTelefono);
        btnEnviar = findViewById(R.id.btEnviar);
        btnLimpiar = findViewById(R.id.btLimpiar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarDatos();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiarFormulario();
            }
        });
    }

    private void enviarDatos() {
        String cedula = txtCedula.getText().toString();
        String nombres = txtNombres.getText().toString();
        String fechaNacimiento = txtFechaNacimiento.getText().toString();
        String ciudad = txtCiudad.getText().toString();
        String genero = obtenerGeneroSeleccionado();
        String correo = txtCorreo.getText().toString();
        String telefono = txtCiudad.getText().toString();

        Intent intent = new Intent(MainActivity.this, DatosIngresadosActivity.class);
        intent.putExtra("cedula", cedula);
        intent.putExtra("nombres", nombres);
        intent.putExtra("fechaNacimiento", fechaNacimiento);
        intent.putExtra("ciudad", ciudad);
        intent.putExtra("genero", genero);
        intent.putExtra("correo", correo);
        intent.putExtra("telefono", telefono);
        startActivity(intent);
    }

    private String obtenerGeneroSeleccionado() {
        int selectedId = radioGroupGenero.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        return radioButton.getText().toString();
    }

    private void limpiarFormulario() {
        txtCedula.setText("");
        txtNombres.setText("");
        txtFechaNacimiento.setText("");
        txtCiudad.setText("");
        radioGroupGenero.clearCheck();
        txtCorreo.setText("");
        txtTelefono.setText("");
    }
}
