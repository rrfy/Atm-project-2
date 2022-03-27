package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDBhelper extends SQLiteOpenHelper {


    private Context context;
    public static final String TABLE_NAME="USERS";
    public static final String DB_NAME="users";
    public static final int DB_VERSION = 1;
    public static final String COL_ID  = "_id";
    public static final String COL_LOGIN = "login";
    public static final String COL_PASSWORD = "password";
    public static final String COL_BALANCE = "balance";

    public MyDBhelper(@Nullable Context context) {

        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String ATMDataBase = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_LOGIN + " TEXT, " + COL_PASSWORD + " TEXT, "+ COL_BALANCE + " INTEGER);";
        db.execSQL(ATMDataBase);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    void addUser(String login, String password, int balance){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_LOGIN, login);
        cv.put(COL_PASSWORD, password);
        cv.put(COL_BALANCE, balance);
        db.insert(TABLE_NAME, null, cv);
    }
    void UpdateData(String row_id, int new_balance){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_BALANCE, new_balance);

        db.update(TABLE_NAME, cv, "_id = ?", new String[]{row_id});
    }
}
