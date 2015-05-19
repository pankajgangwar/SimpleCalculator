package com.test.testapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by iriemo on 7/5/15.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "test.db";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_TABLE_HISTORY = "CREATE TABLE " +DatabaseContract.HistoryEntry.TABLE_NAME+ " ("+ DatabaseContract.HistoryEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                    DatabaseContract.HistoryEntry.COLUMN_HISTORY_COMPLETE +" VARCHAR(25)," +
                                                    DatabaseContract.HistoryEntry.COLUMN_HISTORY_RESULT +" VARCHAR(25));";
        db.execSQL(SQL_CREATE_TABLE_HISTORY);

    }

    public Cursor getHistory(){
        SQLiteDatabase database = getReadableDatabase();
        String query = "SELECT * FROM "+ DatabaseContract.HistoryEntry.TABLE_NAME;
        return  database.rawQuery(query, null);
    }

    public int clearHistory(){
        SQLiteDatabase database = getReadableDatabase();
        return  database.delete(DatabaseContract.HistoryEntry.TABLE_NAME,null,null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS history");
        onCreate(db);
    }
}
