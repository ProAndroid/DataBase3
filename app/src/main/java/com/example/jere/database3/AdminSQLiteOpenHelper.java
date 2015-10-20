package com.example.jere.database3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jere on 20/10/15.
 */
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    //public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
      //  super(context, name, factory, version);
        private static final int DATABASE_VERSION=1;
        private static final String DATABASE_NAME="Cabañas.db";
        public AdminSQLiteOpenHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_CABAÑAS = "CREATE TABLE" + Cabaña.TABLE
                + Cabaña.KEY_ID + "INTIGER PRIMARY KEY AUTOINCRIMENT,"
                + Cabaña.KEY_name + "TEXT,"
                + Cabaña.KEY_checkin + "TEXT,"
                + Cabaña.KEY_checkout + "TEXT";
        db.execSQL(CREATE_TABLE_CABAÑAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IS EXISTS"+ Cabaña.TABLE);
        onCreate(db);

    }
}
