package com.example.neeta.project1;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    DBManager dbManager;
    private ListView listview;
    private ToDoAdapter adapter;
    EditText titlefr, descfr;
    Button submit_button, cancel_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initdb();
        listview = (ListView)findViewById(R.id.listview);
        adapter = new ToDoAdapter(MainActivity.this, dbManager.getData());
        listview.setAdapter(adapter);
    }
    public void initdb()
    {
        dbManager=new DBManager(MainActivity.this,DBManager.DB_TODO,null,DBManager.DB_VERSION);
    }
    public void CreateAndInsert(Todo todo)
    {
        dbManager.insertrec(todo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.topmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.add:  final Dialog alert= new Dialog(MainActivity.this);
                alert.setTitle("Details:");
                alert.setContentView(R.layout.fragment_blank);
                titlefr=(EditText)alert.findViewById(R.id.titlefr);
                descfr=(EditText)alert.findViewById(R.id.descfr);
                cancel_button=(Button)alert.findViewById(R.id.cancel_button);
                submit_button=(Button)alert.findViewById(R.id.submit_button);

                submit_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String title=titlefr.getText().toString();
                        String desc=descfr.getText().toString();
                        DatePicker datePicker = (DatePicker)alert.findViewById(R.id.datepick);
                        int day = datePicker.getDayOfMonth();
                        int mon = datePicker.getMonth() + 1;
                        int year = datePicker.getYear();

                        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd-MM-yyyy");
                        SimpleDateFormat simpleDateFormat1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        try{
                        String date=simpleDateFormat1.format(simpleDateFormat.parse(day + "-" + mon + "-" + year));
                            Todo todo=new Todo(0,title,desc,date);
                            CreateAndInsert(todo);
                            alert.dismiss();
                        }
                        catch(Exception e){}

                        listview=(ListView) findViewById(R.id.listview);
                        adapter=new ToDoAdapter(MainActivity.this, dbManager.getData());
                        listview.setAdapter(adapter);
                    }
                });


                cancel_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alert.dismiss();
                    }
                });
                alert.show();
                break;
            case R.id.comp: listview=(ListView) findViewById(R.id.listview);
                adapter=new ToDoAdapter(MainActivity.this, dbManager.getTicked());
                listview.setAdapter(adapter);
                break;
        }
        return true;
    }

}
