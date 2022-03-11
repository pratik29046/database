package com.example.sqlitedatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    static final String database_name="Data";
    static final int version=1;
    static final String DATABASE_TABLE="Students";
    static final String ID="ID";
    static final String NAME="NAME";
    static final String ADDRESS="ADDRESS";
    static final String PHONE="PHONE";


    private static final String CreateDB=" CREATE TABLE "+ DATABASE_TABLE +"("+ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+"TEXT NOT NULL,"
            +ADDRESS+"TEXT NOT NULL,"+PHONE+"INTEGER NOT NULL"+");";

    public DatabaseHelper(Context context) {
        super(context, database_name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CreateDB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE );

    }
}
