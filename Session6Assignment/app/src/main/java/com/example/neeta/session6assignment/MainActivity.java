package com.example.neeta.session6assignment;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private Data[] nos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =(ListView) findViewById(R.id.name_no);
        MyAdapter adapter=new MyAdapter(getData(), R.layout.data_list_item, MainActivity.this);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
        }

            @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.assignment2, menu);
                return true;
            }

            ArrayList<Data> name_no = new ArrayList<>();

            private ArrayList<Data> getData() {
                name_no.add(new Data("Ashwin", "5679785688"));
                name_no.add(new Data("Abhishek", "7688986234"));
                name_no.add(new Data("Aarav", "5096655356"));
                name_no.add(new Data("Elissa", "8745770922"));

                return name_no;
            }

            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.red:
                        listView.setBackgroundColor(Color.RED);
                        break;
                    case R.id.blue:
                        listView.setBackgroundColor(Color.BLUE);
                        break;
                    case R.id.green:
                        listView.setBackgroundColor(Color.GREEN);
                        break;
                }
                return true;
            }

            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                super.onCreateContextMenu(menu, v, menuInfo);
                menu.setHeaderTitle("Select an option:");
                menu.add(0, 100, 1, "Call");
                menu.add(0, 101, 2, "Send SMS");
            }

            @Override
            public boolean onContextItemSelected(MenuItem item) {


                switch (item.getItemId()) {

                    case 100:
                        /*AdapterView .AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                        String no=nos[info.position].getNo();
                        String TAG="IT HAS BEEN FOUND"+no;
                        Log.d(TAG, "FOUND");
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:" +no));
                        startActivity(intent);*/
                        break;
                    case 101:
                        break;
                }

                return true;
            }
        }
