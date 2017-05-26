package com.example.aryan.saarangapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aryan on 26/5/17.
 */

public class RegestrationDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="regesration.db";
    public static final int DATABASE_VERSION=1;
    public RegestrationDbHelper(Context context){super(context,DATABASE_NAME,null,DATABASE_VERSION);}
    @Override
    public void onCreate(SQLiteDatabase db) {



        String SQL_CREATE_REGESTRATION_TABLE = "CREATE TABLE " + RegestrationContract.RegestrationEntry.TABLE_NAME +
                "(" +
                RegestrationContract.RegestrationEntry._ID + " INTEGER PRIMARY KEY," + // Define a primary key
                RegestrationContract.RegestrationEntry.COLUMN_REGESTRATION_NAME+ " TEXT," +// Define a foreign key
                RegestrationContract.RegestrationEntry.COLUMN_REGESTRATION_EMAIL_ID + " TEXT," +
                RegestrationContract.RegestrationEntry.COLUMN_REGESTRATION_CONTACT + " TEXT," +
                RegestrationContract.RegestrationEntry.COLUMN_REGESTRATION_CATAGORY+ " INTEGER,"+
                RegestrationContract.RegestrationEntry.COLUMN_REGESTRATION_EVENT+ " INTEGER"+
                ")";
        db.execSQL(SQL_CREATE_REGESTRATION_TABLE);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
