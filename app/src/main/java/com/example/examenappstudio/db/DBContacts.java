package com.example.examenappstudio.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.examenappstudio.entidades.usuarios;

import java.util.ArrayList;

public class DBContacts extends dbHelper {

    Context context;

    public DBContacts(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarUsuario(String username, String password) {
        long id = 0;
        try {
            dbHelper dbHelper = new dbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("username", username);
            values.put("password", password);

            id = db.insert(TABLE_USUARIO, null, values);
        } catch (Exception ex) {
            ex.toString();
        }
        return id;
    }

    public ArrayList<usuarios> MostrarUsuarios() {
        dbHelper dbHelper = new dbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<usuarios> listausuarios = new ArrayList<usuarios>();
        usuarios users = null;
        Cursor cursorUsuarioz = null;

        cursorUsuarioz = db.rawQuery("SELECT * FROM " + TABLE_USUARIO, null);

        if(cursorUsuarioz.moveToFirst()){
            do{
                users = new usuarios();
                users.setId(Integer.parseInt(cursorUsuarioz.getString(0)));
                users.setUsername(cursorUsuarioz.getString(1));
                users.setPassword(cursorUsuarioz.getString(2));
                listausuarios.add(users);
            }while (cursorUsuarioz.moveToNext());
        }
        cursorUsuarioz.close();

        return listausuarios;
    }
}
