package com.example.sql1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import javax.xml.transform.sax.SAXResult;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="students.db";
    public static final String TABLE_NAME="students_data";
    public static final String col1="ID";
    public static final String col2="NAME";
    public static final String col3="ADDRESS";
    public static final String col4="PHONE";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
//        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"( ID INTEGER,NAME TEXT,ADDRESS TEXT,PHONE INTEGER )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS "+TABLE_NAME );
        onCreate(db);


    }

    public boolean insert(String id,String name,String add,String phone){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col1,id);
        contentValues.put(col2,name);
        contentValues.put(col3,add);
        contentValues.put(col4,phone);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result== -1){
            return false;
        }else{
            return true;
        }

    }

    public Cursor data_get(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean update(String id, String name, String add,String phone){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col1,id);
        contentValues.put(col2,name);
        contentValues.put(col3,add);
        contentValues.put(col4,phone);
       db.update(TABLE_NAME,contentValues,"id=?",new String[]{id});
       return true;


    }

    public Integer delete(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME,"id=?",new String[]{id});


    }
}
