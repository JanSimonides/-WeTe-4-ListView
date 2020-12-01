package com.example.list;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbActivity extends SQLiteOpenHelper {

    private String createTblCountires =
            "CREATE TABLE " + "country" + " (" +
                    "id" + " INTEGER PRIMARY KEY," +
                    "name" + " TEXT)";

    public DbActivity(Context c) {
        super(c, "country", null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTblCountires);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void InsertCountry (String name){
        SQLiteDatabase db = this.getWritableDatabase();
        //vkladané údaje sú zapúzdrené v objekte typu ContentValues (ktoré vkladáme pomocou metódy put()
        ContentValues val = new ContentValues();
        val.put("name", name);
        //metóda insert() vkladá údaje do DB, ako parametre obsahuje názov tabulky, null-sql nedovoluje vkladať prázdny riadok-null vloží NULL hodnotu, objekt ContentValues
        long id = db.insert("country", null, val);
        db.close();
    }

    public ArrayList<String> GetCountries() {
        ArrayList<String> res = new ArrayList<String>();
        String selectQuery = "SELECT * FROM " + "country";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                res.add(cursor.getString(cursor.getColumnIndex("name")));
            } while (cursor.moveToNext());
        }
        return res;
    }
}
