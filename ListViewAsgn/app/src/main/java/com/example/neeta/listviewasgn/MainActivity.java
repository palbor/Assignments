package com.example.neeta.listviewasgn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.math.BigInteger;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ElementAdapter adapter=new ElementAdapter(R.layout.list_item,getElement(),MainActivity.this);
        listview.setAdapter(adapter);
    }


    private ArrayList getElement()
    {
        ArrayList<Element> element=new ArrayList<>();

        element.add(new Element( new BigInteger("0998877665"), "Archana"));
        element.add(new Element(new BigInteger("1223344556"), "Abhishek"));
        element.add(new Element(new BigInteger("2334455667"), "Benedict"));
        element.add(new Element(new BigInteger("3445567678"), "Catherine"));
        element.add(new Element(new BigInteger("4556677889"), "Derrick"));
        element.add(new Element(new BigInteger("5667788990"), "Elvis"));
        element.add(new Element(new BigInteger("6778899001"), "Farah"));

        return element;
    }
}
