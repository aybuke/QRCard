package com.example.aybuke.qrcard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aybuke on 10.12.2015.
 */
public class CardDB extends SQLiteOpenHelper {
    public CardDB(Context context) {
        super(context, "card.db", null, 1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE cards (_id INTEGER PRIMARY_KEY AUTO_INCREMENT, name TEXT NOT NULL, mail TEXT NOT NULL, passwd TEXT NOT NULL, vip INTEGER NOT NULL DEFAULT 0);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
