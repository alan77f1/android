package com.android.cau2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
public class Databases extends SQLiteOpenHelper{


//public class Databases extends SQLiteOpenHelper {
//
//    public static final String DB_NAME = "student29_db.sqlite";
//    public static final int DB_VERSION = 1;
//
//    public static final String TBL_NAME = "Student";
//    public static final String COL_ID = "studentId";
//    public static final String COL_NAME = "studentName";
//    public static final String COL_CLASS = "studentClass";
//    public static final String COL_POINT = "studentPoint";
//
//
//
//    public Databases(@Nullable Context context) {
//        super(context, DB_NAME, null, DB_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String sql = " CREATE TABLE IF NOT EXISTS " + TBL_NAME
//                + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//                + COL_NAME + " NVARCHAR(200), "
//                + COL_CLASS + " NVARCHAR(200), "
//                + COL_POINT + " FLOAT)";
//
//       db.execSQL(sql);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//        db.execSQL("DROP TABLE IF EXISTS " + TBL_NAME);
//        onCreate(db);
//    }
//    public void QueryData(String sql){
//        SQLiteDatabase db = getWritableDatabase();
//        db.execSQL(sql);
//    }
//
//
//    public Cursor GetData(String sql) {
//        SQLiteDatabase db = getReadableDatabase();
//        return  db.rawQuery(sql, null);
//    }
//
//
//
//    public int GetNumb(){
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM " + TBL_NAME, null);
//        int count = cursor.getCount();
//        cursor.close();
//        return count;
//    }
//  public void createData(){
//       int count = this.GetNumb();
//       if(count == 0 ){
//           QueryData("INSERT INTO " + TBL_NAME + " VALUES(null, 'bui van tan 1','cntt',5)");
//           QueryData("INSERT INTO " + TBL_NAME + " VALUES(null, 'bui van tan 2','cntt',5)");
//           QueryData("INSERT INTO " + TBL_NAME + " VALUES(null, 'bui van tan 3','cntt',5)");
//           QueryData("INSERT INTO " + TBL_NAME + " VALUES(null, 'bui van tan 4','cntt',5)");
//
//       }
//  }


    public static final String DB_NAME = "student_db.sqlite";
    public static final int DB_VERSION = 1;

    public static final String TBL_NAME = "Student";
    public static final String COL_ID = "studentId";
    public static final String COL_NAME = "studentName";
    public static final String COL_CLASS = "studentClass";
    public static final String COL_POINT = "studentPoint";




    public Databases(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql =" CREATE TABLE IF NOT EXISTS " +TBL_NAME+ " ("
                + COL_ID + " INTEGER PRIMARY KEY NOT NULL, "
                + COL_NAME + " NVARCHAR(200), "
                + COL_CLASS + " NVARCHAR(200) ) ";
         db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TBL_NAME);
        onCreate(db);
    }

    public void QueryData( String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }


    public Cursor GetData( String sql){
        SQLiteDatabase db = getReadableDatabase();
       return db.rawQuery(sql, null);
    }

    public int CheckData(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TBL_NAME, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public void CreateData( ){
     int count = this.CheckData();

        if(count == 0){
            QueryData("INSERT INTO " +TBL_NAME+ " VALUES(1, 'bui van tan', 'cntt' )");
            QueryData("INSERT INTO " +TBL_NAME+ " VALUES(2, 'bui van tan33', 'cntt' )");
            QueryData("INSERT INTO " +TBL_NAME+ " VALUES(3, 'bui van tan44', 'cntt' )");
            QueryData("INSERT INTO " +TBL_NAME+ " VALUES(4, 'bui van tan55', 'cntt' )");
            QueryData("INSERT INTO " +TBL_NAME+ " VALUES(5, 'bui van tan', 'cntt' )");
        }
    }






























}
