package com.example.fitup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private  static  final  String DATABASE_NAME = "User.db";
    private  static  final  int DATABASE_VERSION = 1;

    public  static  final  String TABLE_NAME = "person";
    public  static  final  String COLUMN_ID = "_id";
    public  static  final  String COLUMN_NAME = "person_name";
    public  static  final  String COLUMN_SURNAME = "person_surname";
    public  static  final  String COLUMN_WEIGHT = "person_weight";
    public  static  final  String COLUMN_HEIGHT = "person_height";
    public  static  final  String COLUMN_AGE = "person_age";
    public static final String TABLE_STRUCTURE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME +
            " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NAME + " TEXT, " +
            COLUMN_SURNAME + " TEXT, " +
            COLUMN_WEIGHT + " INTEGER, " +
            COLUMN_HEIGHT + " INTEGER, " +
            COLUMN_AGE + " INTEGER)";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private int countlines = 0;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public int getCountlines() {
        return countlines;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_STRUCTURE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

}
