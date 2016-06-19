package com.example.neeta.databasesession;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    DBManager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDb();
        createAndInsert();
    }

    private void initDb()
    {
       db=new DBManager(MainActivity.this, DBManager.DB_EMPLOYEE, null, DBManager.DB_VERSION);
    }
    private void createAndInsert()
    {
        db.insertData(new Employee("PALLAVI","BORKAR"));
        db.insertData(new Employee("CHRIS","EVANS"));
        db.insertData(new Employee("HARRY","STYLES"));
        db.insertData(new Employee("CHRISTINA","AGUILERA"));
        db.insertData(new Employee("JOANNA","ROWLING"));
        db.insertData(new Employee("RICK","RIORDAN"));
        db.insertData(new Employee("RUCHI","KHANVILKAR"));
        db.insertData(new Employee("ABHAY","BORKAR"));
        db.insertData(new Employee("ANITA","BORKAR"));
    }
}
