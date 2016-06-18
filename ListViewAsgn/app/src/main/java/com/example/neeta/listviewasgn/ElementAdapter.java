package com.example.neeta.listviewasgn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Neeta on 04/02/2016.
 */
public class ElementAdapter extends BaseAdapter {

   // public TextView txtview1;
    private int layout;
    private ArrayList<Element> element;
    private Context context;

    public ElementAdapter(int layout, ArrayList<Element> element, Context context) {
        this.layout = layout;
        this.element = element;
        this.context = context;
    }

    @Override
    public int getCount() {
        return element.size();
    }

    @Override
    public Object getItem(int position) {
        return element.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            LayoutInflater inflator= LayoutInflater.from(context);
            convertView=inflator.inflate(R.layout.list_item,null);
        }

        Element ele=element.get(position);
        TextView txtview1=(TextView) convertView.findViewById(R.id.txtview1);
        return convertView;
    }
}
