package com.example.fitup;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FoodDatabase extends SQLiteOpenHelper {
    private Context context;
    private  static  final  String DATABASE_NAME = "Food.db";
    private  static  final  int DATABASE_VERSION = 1;

    private List<String> food_name= Arrays.asList(new String[]{
            "Цезарь", "Крабовый", "Оливье с мясом", "Столичный",
            "Зефир", "Пастила", "Блинчики",
            "Борщ", "Куриный", "Картофельный пюре", "Окрошка",
            "Банан", "Персик", "Ананас", "Яблоко",
            "Куриное филе с гречкой", "Макароны запеченные с грибами"
    });

    private List<String> food_type= Arrays.asList(new String[]{
            "Салат", "Салат", "Салат", "Салат",
            "Сладкое", "Сладкое", "Сладкое",
            "Суп", "Суп", "Суп", "Суп",
            "Фрукт", "Фрукт", "Фрукт", "Фрукт",
            "Второе", "Второе"
    });

    private List<String> food_time= Arrays.asList(new String[]{
            "0", "0", "0", "0",
            "0", "0", "breakfast",
            "0", "0", "0", "0",
            "0", "0", "0", "0",
            "0", "0"
    });

    int temp_kk[] = {
        304, 172, 198, 217,
                295, 301, 170,
                68, 45, 43, 72,
                95, 46, 49, 48,
                148, 123
    };

    private List<Integer> kk= Arrays.stream(temp_kk).boxed().collect(Collectors.toList());

    public  static  final  String TABLE_NAME = "food";
    public  static  final  String COLUMN_ID = "_id";
    public  static  final  String COLUMN_FOOD = "food_name";
    public  static  final  String COLUMN_TYPE = "food_type";
    public  static  final  String COLUMN_TIME = "food_time";
    public  static  final  String COLUMN_KK = "kk";  // килокалории

    public static final String TABLE_STRUCTURE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME +
            " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_FOOD + " TEXT, " +
            COLUMN_TYPE + " TEXT, " +
            COLUMN_TIME + " TEXT, " +
            COLUMN_KK + " INTEGER)";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    public int countlines = 0;

    public FoodDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public int getCountlines() {
        return countlines;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        if(db.getPageSize() == 0) {
            ContentValues cv = new ContentValues();
            this.countlines++;
            for (int i = 0; i < food_name.size(); i++) {
                cv.put(FoodDatabase.COLUMN_FOOD, food_name.get(i));
                cv.put(FoodDatabase.COLUMN_TYPE, food_type.get(i));
                cv.put(FoodDatabase.COLUMN_TIME, food_time.get(i));
                cv.put(FoodDatabase.COLUMN_KK, kk.get(i));
                db.insert(FoodDatabase.TABLE_NAME, null, cv);
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }
}
