package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDBhelper extends SQLiteOpenHelper {


    private Context context;
    private static final String TABLE_NAME="USERS";
    private static final String _ID="_id";
    private static final String LOGIN="login";
    private static final String PASSWORD="password";
    private static final String BALANCE="balance";
    private static final String DB_NAME="users.db";
    private static final int DB_VERSION = 1;

    public MyDBhelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String ATMDataBase = "CREATE TABLE " + TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + LOGIN + " STRING, " + PASSWORD + " STRING, " + BALANCE + " INTEGER)";
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

        cv.put(LOGIN,    login);
        cv.put(PASSWORD, password);
        cv.put(BALANCE,  balance);

        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1){
            Toast.makeText(context , "Failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context , "Sucsess", Toast.LENGTH_SHORT).show();
        }
    }
}
