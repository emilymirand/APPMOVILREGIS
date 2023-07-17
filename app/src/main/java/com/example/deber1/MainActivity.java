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
    }
   public void btLimpiar (View view){
       txtCedula.setText("");
       txtNombres.setText("");
       txtFechaNacimiento.setText("");
       txtCiudad.setText("");
       radioGroupGenero.clearCheck();
       txtCorreo.setText("");
       txtTelefono.setText("");

   }
    public void btEnviar (View view){
        String cedula = txtCedula.getText().toString();
        String nombres = txtNombres.getText().toString();
        String fechaNacimiento = txtFechaNacimiento.getText().toString();
        String ciudad = txtCiudad.getText().toString();
        String genero = obtenerGeneroSeleccionado();
        String correo = txtCorreo.getText().toString();
        String telefono = txtTelefono.getText().toString();

        Intent intent = new Intent(MainActivity.this, DatosIngresadosActivity.class);
        intent.putExtra("cedula", cedula);
        intent.putExtra("nombres", nombres);
        intent.putExtra("fechaNacimiento", fechaNacimiento);
        intent.putExtra("ciudad", ciudad);
        intent.putExtra("genero", genero);
        intent.putExtra("correo", correo);
        intent.putExtra("Telefono", telefono);
        startActivity(intent);
    }

    private String obtenerGeneroSeleccionado() {
        int selectedId = radioGroupGenero.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        return radioButton.getText().toString();
    }

}
