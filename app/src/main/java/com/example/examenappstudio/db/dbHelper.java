package com.example.examenappstudio.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {

private static final int DATABASE_VERSION = 2;
private static final String DATABASE_USER = "ExamenAppStudio";
public static final String TABLE_USUARIO = "t_usuario";

    public dbHelper(@Nullable Context context) {
        super(context, DATABASE_USER, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_USUARIO + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
    "username TEXT NOT NULL," +
                "password TEXT NOT NULL)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){

        sqLiteDatabase.execSQL("DROP TABLE "+ TABLE_USUARIO);
        onCreate(sqLiteDatabase);
    }
}
