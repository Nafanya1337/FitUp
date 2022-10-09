package com.example.fitup;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class FoodDatabase extends SQLiteOpenHelper {
    private Context context;
    private  static  final  String DATABASE_NAME = "Food.db";
    private  static  final  int DATABASE_VERSION = 1;

    public  static  final  String TABLE_NAME = "food";
    public  static  final  String COLUMN_ID = "_id";
    public  static  final  String COLUMN_FOOD = "food_name";
    public  static  final  String COLUMN_U = "person_weight"; // углеводы
    public  static  final  String COLUMN_B = "person_height"; // белки
    public  static  final  String COLUMN_ZH = "person_age";  // жиры
    public static final String TABLE_STRUCTURE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME +
            " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_FOOD + " TEXT, " +
            COLUMN_U + " INTEGER, " +
            COLUMN_B + " INTEGER, " +
            COLUMN_ZH + " INTEGER)";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    public int countlines = 0;

    public FoodDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public int getCountlines() {
        return countlines;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }
}
