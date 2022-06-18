package com.homework.pm1_p1_h3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.homework.pm1_p1_h3.procesos.Persona;
import com.homework.pm1_p1_h3.procesos.TransaccionesPersona;

public class ConsultaPersona extends AppCompatActivity {

    EditText etIdConsulta, etNombreConsulta, etApellidosConsulta, etEdadConsulta, etCorreoConsulta, etDireccionConsulta;
    Button btBuscarPersona, btActualizarPersona, btEliminarPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_persona);

        getLayoutElements();

        btBuscarPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String [] fields = {
                        TransaccionesPersona.NOMBRE,
                        TransaccionesPersona.APELLIDOS,
                        TransaccionesPersona.EDAD,
                        TransaccionesPersona.CORREO,
                        TransaccionesPersona.DIRECCION,
                };

                Persona p = TransaccionesPersona.getPersona(ConsultaPersona.this, etIdConsulta.getText().toString(), fields);
                if ( p != null ) {
                    llenarCampos(p);
                } else {
                    Toast.makeText(ConsultaPersona.this, "La persona no esta registrada !!", Toast.LENGTH_LONG).show();
                }
            }
        });

        btActualizarPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues valores = new ContentValues();
                valores.put(TransaccionesPersona.NOMBRE, etNombreConsulta.getText().toString());
                valores.put(TransaccionesPersona.APELLIDOS, etApellidosConsulta.getText().toString());
                valores.put(TransaccionesPersona.EDAD, etEdadConsulta.getText().toString());
                valores.put(TransaccionesPersona.CORREO, etCorreoConsulta.getText().toString());
                valores.put(TransaccionesPersona.DIRECCION, etDireccionConsulta.getText().toString());

                String [] params = { etIdConsulta.getText().toString() };

                TransaccionesPersona.modifyPersona(ConsultaPersona.this, params, valores);
            }
        });

        btEliminarPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String [] params = { etIdConsulta.getText().toString() };
                TransaccionesPersona.deletePersona(ConsultaPersona.this, params);
                limpiarCampos();
            }
        });
    }

    private void llenarCampos(Persona p) {
        etNombreConsulta.setText(p.getNombre());
        etApellidosConsulta.setText(p.getApellidos());
        etEdadConsulta.setText(p.getEdad().toString());
        etCorreoConsulta.setText(p.getCorreo());
        etDireccionConsulta.setText(p.getDireccion());
    }

    private void getLayoutElements() {
        etIdConsulta = (EditText) findViewById(R.id.etIdConsulta);
        etNombreConsulta = (EditText) findViewById(R.id.etNombreConsulta);
        etApellidosConsulta = (EditText) findViewById(R.id.etApellidosConsulta);
        etEdadConsulta = (EditText) findViewById(R.id.etEdadConsulta);
        etCorreoConsulta = (EditText) findViewById(R.id.etCorreoConsulta);
        etDireccionConsulta = (EditText) findViewById(R.id.etDireccionConsulta);

        btBuscarPersona = (Button) findViewById(R.id.btBuscarPersona);
        btActualizarPersona = (Button) findViewById(R.id.btActualizarPersona);
        btEliminarPersona = (Button) findViewById(R.id.btEliminarPersona);
    }

    private void limpiarCampos() {
        etIdConsulta.setText("");
        etNombreConsulta.setText("");
        etApellidosConsulta.setText("");
        etEdadConsulta.setText("");
        etCorreoConsulta.setText("");
        etDireccionConsulta.setText("");
    }
}