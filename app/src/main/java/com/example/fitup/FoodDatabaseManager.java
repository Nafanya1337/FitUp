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

    public void insert(String name, String type, String time, int kk){
        ContentValues cv = new ContentValues();
        databaseHelper.countlines++;
        cv.put(FoodDatabase.COLUMN_FOOD, name);
        cv.put(FoodDatabase.COLUMN_TYPE, type);
        cv.put(FoodDatabase.COLUMN_TIME, time);
        cv.put(FoodDatabase.COLUMN_KK, kk);
        db.insert(FoodDatabase.TABLE_NAME, null, cv);
    }

    public void update(String name, String type, String time, int kk){
        ContentValues cv = new ContentValues();
        cv.put(FoodDatabase.COLUMN_FOOD, name);
        cv.put(FoodDatabase.COLUMN_TYPE, type);
        cv.put(FoodDatabase.COLUMN_TIME, time);
        cv.put(FoodDatabase.COLUMN_KK, kk);
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

    public String getFoodType(){
        Cursor cursor = db.query(FoodDatabase.TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToNext();
        String name = cursor.getString(cursor.getColumnIndex(FoodDatabase.COLUMN_TYPE));
        cursor.close();
        return name;
    }

    public String getFoodTime(){
        Cursor cursor = db.query(FoodDatabase.TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToNext();
        String time = cursor.getString(cursor.getColumnIndex(FoodDatabase.COLUMN_TIME));
        cursor.close();
        return time;
    }

    public int getKK(String name){
        Cursor cursor = db.query(FoodDatabase.TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToNext();
        while (cursor.getString(cursor.getColumnIndex(FoodDatabase.TABLE_NAME)) != name) {
            if(cursor.isLast()) return 0;
            cursor.moveToNext();
        }
        int kk = cursor.getInt(cursor.getColumnIndex(FoodDatabase.COLUMN_KK));
        cursor.close();
        return kk;
    }

    public void close(){
        databaseHelper.close();
    }
}
