package com.example.neeta.project1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


/**
 * Created by Neeta on 27/02/2016.
 */
public class DBManager extends SQLiteOpenHelper {
    public static String DB_TODO="todo";
    public static int DB_VERSION=1;
    public static String TABLE_TODO="table_todo";
    public static String key_title="title";
    public static String key_desc="description";
    public static String key_date="date";
    public static String key_status="status";
    public static String key_id="id";

    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
  //  public void onShow
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_TODO + " (" + key_id + " integer primary key autoincrement," + key_title + " text," + key_desc + " text," + key_date + " date," + key_status + " integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertrec(Todo todo)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        //values.put(key_id,todo.getKey_id());
        values.put(key_title,todo.getKey_title());
        values.put(key_desc,todo.getKey_desc());
        values.put(key_date,todo.getDate());
        values.put(key_status,todo.getKey_status());

        db.insert(TABLE_TODO, null, values);
        db.close();
    }
    public ArrayList<Todo> getTicked()
    {
        ArrayList<Todo> todos=new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor= db.rawQuery("select * from " + TABLE_TODO+" where "+key_status+" = 1", null);
        if(cursor!=null && cursor.getCount()>0)
        {
            cursor.moveToFirst();
            for(int i=0;i<cursor.getCount();i++)
            {
                Todo todo=new Todo();
                todo.setKey_id(cursor.getInt(cursor.getColumnIndex(key_id)));
                todo.setKey_title(cursor.getString(cursor.getColumnIndex(key_title)));
                todo.setDate(cursor.getString(cursor.getColumnIndex(key_date)));
                todo.setKey_desc(cursor.getString(cursor.getColumnIndex(key_desc)));
                todo.setKey_status(cursor.getInt(cursor.getColumnIndex(key_status)));
                todos.add(todo);
                cursor.moveToNext();
            }
        }
        return todos;
    }
    public void setStatus(int id){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(key_status,1);
     long row=   db.update(TABLE_TODO, values, key_id+"=?", new String[]{""+id});
      // db.rawQuery("update " + TABLE_TODO + " set " + key_status + " = 1 where " + key_id + " = " + id, null);
    }
    public ArrayList<Todo> getData()
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor= db.rawQuery("select * from " + TABLE_TODO, null);
        ArrayList<Todo> todos=new ArrayList<>();
        if(cursor!=null && cursor.getCount()>0)
        {
            cursor.moveToFirst();
            for(int i=0;i<cursor.getCount();i++)
            {
                Todo todo=new Todo();
                todo.setKey_id(cursor.getInt(cursor.getColumnIndex(key_id)));
                todo.setKey_title(cursor.getString(cursor.getColumnIndex(key_title)));
                todo.setDate(cursor.getString(cursor.getColumnIndex(key_date)));
                todo.setKey_desc(cursor.getString(cursor.getColumnIndex(key_desc)));
                todo.setKey_status(cursor.getInt(cursor.getColumnIndex(key_status)));
                todos.add(todo);
                cursor.moveToNext();
            }
        }
        return todos;
    }
}
