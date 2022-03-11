package com.example.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLData;
import java.sql.SQLDataException;

public class DataBaseManager {

    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DataBaseManager(Context ctx){
        context=ctx;
    }

    public DataBaseManager open() throws SQLDataException {
        dbHelper =new DatabaseHelper(context);
        database= dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();
    }

    public void insert(String name,String address,Integer phone){
        ContentValues contentValues=new ContentValues();
        contentValues .put(DatabaseHelper.NAME,name);
        contentValues .put(DatabaseHelper.ADDRESS,name);
        contentValues .put(DatabaseHelper.PHONE,name);
        database.insert(DatabaseHelper.DATABASE_TABLE,null,contentValues);

    }

    public Cursor fetch(){
        String[] columns=new String[]{DatabaseHelper.ID,DatabaseHelper.NAME,DatabaseHelper.ADDRESS,DatabaseHelper.PHONE};
        Cursor cursor=database.query(DatabaseHelper.DATABASE_TABLE,columns,null,null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;

    }

    public int update(long id,String name,String address,long phone){
        ContentValues contentValues=new ContentValues();
        contentValues .put(DatabaseHelper.NAME,name);
        contentValues .put(DatabaseHelper.ADDRESS,name);
        contentValues .put(DatabaseHelper.PHONE,name);
       int ret=database.update(DatabaseHelper.DATABASE_TABLE,contentValues,DatabaseHelper.ID+"="+id,null);
       return ret;
    }

    public void delete(long id){
        database.delete(DatabaseHelper.DATABASE_TABLE,DatabaseHelper.ID+"="+id,null);

    }
}
