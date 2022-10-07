package com.example.fitup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseManager {
    private Context context;
    private final DatabaseHelper databaseHelper;
    private SQLiteDatabase db;


    public  MyDatabaseManager(Context context) {
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
    }

    public void open(){
        db = databaseHelper.getWritableDatabase();
    }

    public void insert(String name, String surname, int weight, int height, int age){
        ContentValues cv = new ContentValues();

        cv.put(DatabaseHelper.COLUMN_NAME, name);
        cv.put(DatabaseHelper.COLUMN_SURNAME, surname);
        cv.put(DatabaseHelper.COLUMN_WEIGHT, weight);
        cv.put(DatabaseHelper.COLUMN_HEIGHT, height);
        cv.put(DatabaseHelper.COLUMN_AGE, age);
        db.insert(DatabaseHelper.TABLE_NAME, null, cv);
    }

    public String getName(){
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToNext();
        String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME));
        cursor.close();
        return name;
    }

    public String getSurname(){
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToNext();
        String surname = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_SURNAME));
        cursor.close();
        return surname;
    }

    public int getWeight(){
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToNext();
        int weight = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_WEIGHT));
        cursor.close();
        return weight;
    }

    public int getHeight(){
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToNext();
        int height = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_HEIGHT));
        cursor.close();
        return height;
    }

    public int getAge(){
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToNext();
        int age = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_AGE));
        cursor.close();
        return age;
    }

    public void close(){
        databaseHelper.close();
    }
}
