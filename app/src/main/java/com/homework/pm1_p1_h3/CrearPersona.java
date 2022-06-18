package com.homework.pm1_p1_h3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.homework.pm1_p1_h3.procesos.Conexion;
import com.homework.pm1_p1_h3.procesos.TransaccionesPersona;

public class CrearPersona extends AppCompatActivity {

    EditText etNombre, etApellidos, etEdad, etCorreo, etDireccion;
    Button btCrearPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_persona);

        getLayoutElements();

        btCrearPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues valores = new ContentValues();
                valores.put(TransaccionesPersona.NOMBRE, etNombre.getText().toString());
                valores.put(TransaccionesPersona.APELLIDOS, etApellidos.getText().toString());
                valores.put(TransaccionesPersona.EDAD, etEdad.getText().toString());
                valores.put(TransaccionesPersona.CORREO, etCorreo.getText().toString());
                valores.put(TransaccionesPersona.DIRECCION, etDireccion.getText().toString());

                TransaccionesPersona.createPersona(CrearPersona.this, valores);
                limpiarCampos();
            }
        });
    }


    private void getLayoutElements() {
        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellidos = (EditText) findViewById(R.id.etApellidos);
        etEdad = (EditText) findViewById(R.id.etEdad);
        etCorreo = (EditText) findViewById(R.id.etCorreo);
        etDireccion = (EditText) findViewById(R.id.etDireccion);
        btCrearPersona = (Button) findViewById(R.id.btCrearPersona);
    }

    private void limpiarCampos() {
        etNombre.setText("");
        etApellidos.setText("");
        etEdad.setText("");
        etCorreo.setText("");
        etDireccion.setText("");
    }
}