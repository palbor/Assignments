package com.example.neeta.session6assignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Neeta on 08/02/2016.
 */
public class MyAdapter extends BaseAdapter {
    private ArrayList<Data> mylist;
    private int layout;
    Context context;
    public MyAdapter(ArrayList<Data> mylist,int layout,Context context) {
        this.layout=layout;
        this.mylist=mylist;
        this.context=context;
    }

    @Override
    public Object getItem(int position) {
        return mylist.get(position);
    }

    @Override
    public int getCount() {
        return mylist.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView=inflater.inflate(R.layout.data_list_item, null);
        }
        Data data= mylist.get(position);
        TextView textview1=(TextView) convertView.findViewById(R.id.textview1);
        textview1.setText(data.getName());

        TextView textview2=(TextView) convertView.findViewById(R.id.textview2);
        textview2.setText(data.getNo());

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
