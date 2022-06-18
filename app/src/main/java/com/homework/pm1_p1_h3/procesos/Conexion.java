package com.homework.pm1_p1_h3.procesos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexion extends SQLiteOpenHelper {

    public Conexion(@Nullable Context ctx, @Nullable String dbName, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(ctx, dbName, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TransaccionesPersona.getCreateTableSQL());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(TransaccionesPersona.getDropTableSQL());
        onCreate(db);
    }
}
