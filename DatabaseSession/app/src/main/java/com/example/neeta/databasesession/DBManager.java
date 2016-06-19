package com.example.neeta.databasesession;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Neeta on 19/02/2016.
 */
public class DBManager extends SQLiteOpenHelper {
    public static String DB_EMPLOYEE="Employee";
    public static int DB_VERSION =1;
    public static String EMPLOYEE = "Employee Table";
    public static String EMPLOYEE_ID = "Employee Id";
    public static String EMPLOYEE_FNAME = "Employee First Name";
    public static String EMPLOYEE_LNAME = "Employee Last Name";
   // public static String EMPLOYEE = "Employee Table";
    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+EMPLOYEE+"( "+EMPLOYEE_ID +" INTEGER primary key autoincrement,"+EMPLOYEE_FNAME+" TEXT,"+EMPLOYEE_LNAME+" TEXT)");
    }
    public void insertData(Employee emp)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(EMPLOYEE_FNAME,emp.getEMPLOYEEFNAME());
        values.put(EMPLOYEE_LNAME,emp.getEMPLOYEELNAME());

        db.insert(EMPLOYEE,null,values);
        db.close();
    }
}
