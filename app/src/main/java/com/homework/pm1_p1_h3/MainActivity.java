package com.homework.pm1_p1_h3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.homework.pm1_p1_h3.procesos.Persona;
import com.homework.pm1_p1_h3.procesos.TransaccionesPersona;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvPersonas;
    Button btCrearPersona, btCosultaPersona, btRefrescarLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLayoutElements();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, TransaccionesPersona.getPersonaStringList(this));
        lvPersonas.setAdapter(adapter);

        btCrearPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CrearPersona.class);
                startActivity(i);
            }
        });

        btCosultaPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ConsultaPersona.class);
                startActivity(i);
            }
        });

        btRefrescarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, TransaccionesPersona.getPersonaStringList(MainActivity.this));
                lvPersonas.setAdapter(adapter);
            }
        });
    }

    private void getLayoutElements() {
        lvPersonas = (ListView) findViewById(R.id.lvPersonas);
        btCrearPersona = (Button) findViewById(R.id.btCrearPersona);
        btCosultaPersona = (Button) findViewById(R.id.btConsultaPersona);
        btRefrescarLista = (Button) findViewById(R.id.btRefrescarLista);
    }
}