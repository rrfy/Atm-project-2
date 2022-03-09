package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.Transliterator;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class DbPositions {
    private final static String tableName = "USERS";
    private SQLiteDatabase db;

    public DbPositions(Context ctx){
        MyDBhelper openHelperPosition = new MyDBhelper(ctx);
        this.db = openHelperPosition.getWritableDatabase();
    }


    public long insert(Position position){

        ContentValues contentValues = new ContentValues();

        contentValues.put("login", position.getLogin());
        contentValues.put("password", position.getPassword());
        contentValues.put("balance", position.getBalance());

        return db.insert(tableName, null, contentValues);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public long[] insertMany(ArrayList<Position> positions){

        long[] numbers = new long[positions.size()];

        positions.forEach(position -> {
            this.insert(position);
        });

        return numbers;
    }


    public int editOne(Position position, int balance) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("login", position.getLogin());
        contentValues.put("password", position.getPassword());
        contentValues.put("balance", position.getBalance()-balance);

        return this.db.update(tableName, contentValues, "id = " + position.getId(), null);
    }


    public Position getOne(String login, String password) {

        Cursor cursor = db.rawQuery("Select * from " + tableName + " where login = " + login + " where password = " + password, null);
        Position position;

        cursor.moveToFirst();

        long   id         = cursor.getLong(0);
        int balance = Integer.parseInt(cursor.getString(3));

        position = new Position(id, login, password, balance);

        return position;
    }

}
