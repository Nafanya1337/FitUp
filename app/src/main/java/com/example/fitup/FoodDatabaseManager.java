package com.example.fitup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FoodDatabaseManager {
    private Context context;
    private final FoodDatabase databaseHelper;
    private SQLiteDatabase db;


    public  FoodDatabaseManager(Context context) {
        this.context = context;
        databaseHelper = new FoodDatabase(context);
    }

    public void open(){
        db = databaseHelper.getWritableDatabase();
    }

    public void insert(String name, String surname, int u, int b, int zh){
        ContentValues cv = new ContentValues();
        databaseHelper.countlines++;
        cv.put(FoodDatabase.COLUMN_FOOD, name);
        cv.put(FoodDatabase.COLUMN_U, u);
        cv.put(FoodDatabase.COLUMN_B, b);
        cv.put(FoodDatabase.COLUMN_ZH, zh);
        db.insert(FoodDatabase.TABLE_NAME, null, cv);
    }

    public void update(String name, int u, int b, int zh){
        ContentValues cv = new ContentValues();
        cv.put(FoodDatabase.COLUMN_FOOD, name);
        cv.put(FoodDatabase.COLUMN_U, u);
        cv.put(FoodDatabase.COLUMN_B, b);
        cv.put(FoodDatabase.COLUMN_ZH, zh);
        db.update(FoodDatabase.TABLE_NAME, cv, "_id = ?",new String[]{Integer.toString(1)});
    }

    public int getCountlines(){return databaseHelper.countlines;}

    public void delete(int id){
        databaseHelper.countlines--;
        db.delete(FoodDatabase.TABLE_NAME, "_id = ?",new String[]{Integer.toString(id)});
    }

    public String getFoodName(){
        Cursor cursor = db.query(FoodDatabase.TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToNext();
        String name = cursor.getString(cursor.getColumnIndex(FoodDatabase.COLUMN_FOOD));
        cursor.close();
        return name;
    }


    public int getU(){
        Cursor cursor = db.query(FoodDatabase.TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToNext();
        int weight = cursor.getInt(cursor.getColumnIndex(FoodDatabase.COLUMN_U));
        cursor.close();
        return weight;
    }

    public int getB(){
        Cursor cursor = db.query(FoodDatabase.TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToNext();
        int height = cursor.getInt(cursor.getColumnIndex(FoodDatabase.COLUMN_B));
        cursor.close();
        return height;
    }

    public int getZH(){
        Cursor cursor = db.query(FoodDatabase.TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToNext();
        int age = cursor.getInt(cursor.getColumnIndex(FoodDatabase.COLUMN_ZH));
        cursor.close();
        return age;
    }

    public void close(){
        databaseHelper.close();
    }
}
