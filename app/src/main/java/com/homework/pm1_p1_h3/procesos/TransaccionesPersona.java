package com.homework.pm1_p1_h3.procesos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class TransaccionesPersona {
    // db and table
    public static final String DB_NAME = "mp1";
    public static final String TABLE = "p1h3";

    // fields
    public static final String ID = "id";
    public static final String NOMBRE = "nombre";
    public static final String APELLIDOS = "apellidos";
    public static final String EDAD = "edad";
    public static final String CORREO = "correo";
    public static final String DIRECCION = "direccion";

    // sql to create table
    public static String getCreateTableSQL() {
        // return "CREATE TABLE " + TABLE + "(" + ID + " INTEGER AUTOINCREMENT PRIMARY KEY," + NOMBRE + " TEXT," + APELLIDOS + " TEXT," + EDAD + " TEXT," + CORREO + " TEXT," + DIRECCION + " TEXT)";
        return "CREATE TABLE " + TABLE + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                NOMBRE + " TEXT," +
                APELLIDOS + " TEXT," +
                EDAD + " INTEGER," +
                CORREO + " TEXT," +
                DIRECCION + " TEXT)";
    }

    // sql to drop table
    public static String getDropTableSQL() {
        return "DROP TABLE IF EXISTS " + TABLE;
    }

    public static ArrayList<Persona> getPersonaList(Context ctx) {
        ArrayList<Persona> personas = new ArrayList<>();

        try {
            Conexion cnn = new Conexion(ctx, DB_NAME, null, 1);
            SQLiteDatabase db = cnn.getReadableDatabase();
            Cursor c = db.rawQuery("SELECT * FROM " + TABLE, null);

            Persona p = null;
            while(c.moveToNext()) {
                p = new Persona();
                p.setId(c.getInt(0));
                p.setNombre(c.getString(1));
                p.setApellidos(c.getString(2));
                p.setEdad(c.getInt(3));
                p.setCorreo(c.getString(4));
                p.setDireccion(c.getString(5));

                personas.add(p);
            }

            c.close();
        } catch (Exception ex) {
            Toast.makeText(ctx,"ha ocurrido un inconveniente!!",Toast.LENGTH_LONG).show();
        }

        return personas;
    }

    public static ArrayList<String> getPersonaStringList(Context ctx) {
        ArrayList<String> personaStringList = new ArrayList<>();
        ArrayList<Persona> personas = getPersonaList(ctx);

        for(int i=0; i<personas.size(); i++) {
            personaStringList.add(personas.get(i).getId().toString() + " - " + personas.get(i).getNombre() + " " + personas.get(i).getApellidos() + " - " + personas.get(i).getCorreo());
        }

        return personaStringList;
    }

    public static Persona getPersona(Context ctx, String id, String [] fields) {
        Persona p = null;

        try {
            Conexion cnn = new Conexion(ctx, TransaccionesPersona.DB_NAME, null, 1);
            SQLiteDatabase db = cnn.getReadableDatabase();

            String [] params = {id};
            String filter = TransaccionesPersona.ID + "=?";

            Cursor c = db.query(TABLE, fields, filter, params, null, null, null);

            if (c.getCount() > 0) {
                c.moveToFirst();

                p = new Persona();
                p.setNombre(c.getString(0));
                p.setApellidos(c.getString(1));
                p.setEdad(c.getInt(2));
                p.setCorreo(c.getString(3));
                p.setDireccion(c.getString(4));
            }

            db.close();
        } catch (Exception ex) {
            Toast.makeText(ctx,"ha ocurrido un inconveniente!!",Toast.LENGTH_LONG).show();
        }

        return p;
    }

    public static void createPersona(Context ctx, ContentValues values) {
        try {
            Conexion cnn = new Conexion(ctx, TransaccionesPersona.DB_NAME, null, 1);
            SQLiteDatabase db = cnn.getWritableDatabase();
            Long resultado = db.insert(TransaccionesPersona.TABLE, TransaccionesPersona.ID, values);
            db.close();
            Toast.makeText(ctx, "PERSONA CREADA", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            Toast.makeText(ctx,"ha ocurrido un inconveniente!!",Toast.LENGTH_LONG).show();
        }
    }

    public static void modifyPersona(Context ctx, String [] params, ContentValues values) {
        try {
            Conexion cnn = new Conexion(ctx, TransaccionesPersona.DB_NAME, null, 1);
            SQLiteDatabase db = cnn.getWritableDatabase();
            Integer resultado = db.update(TransaccionesPersona.TABLE, values, "id=?", params);
            db.close();
            Toast.makeText(ctx, "PERSONA ACTUALIZADA", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            Toast.makeText(ctx,"ha ocurrido un inconveniente!!",Toast.LENGTH_LONG).show();
        }
    }

    public static void deletePersona(Context ctx, String [] params) {
        try {
            Conexion cnn = new Conexion(ctx, TransaccionesPersona.DB_NAME, null, 1);
            SQLiteDatabase db = cnn.getWritableDatabase();
            Integer resultado = db.delete(TransaccionesPersona.TABLE, "id=?", params);
            db.close();
            Toast.makeText(ctx, "PERSONA ELIMINADA", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            Toast.makeText(ctx,"ha ocurrido un inconveniente!!",Toast.LENGTH_LONG).show();
        }
    }
}
