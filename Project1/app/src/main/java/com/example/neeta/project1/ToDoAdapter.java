package com.example.neeta.project1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by Neeta on 28/02/2016.
 */
public class ToDoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Todo> items;

    public ToDoAdapter(Context context, ArrayList<Todo> items) {
        this.context = context;
        this.items = items;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.listitem, null);
        }

        TextView key_title=(TextView)convertView.findViewById(R.id.title);
        TextView key_desc=(TextView)convertView.findViewById(R.id.desc);
        TextView key_date=(TextView)convertView.findViewById(R.id.date);
        CheckBox checkbx=(CheckBox)convertView.findViewById(R.id.checkbx);
        final Todo todo =items.get(position);
        key_title.setText(todo.getKey_title());
        key_desc.setText(todo.getKey_desc());
        key_date.setText(todo.getDate());
        checkbx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBManager dbManager= new DBManager(context,DBManager.DB_TODO,null,DBManager.DB_VERSION);
                dbManager.setStatus(todo.getKey_id());
            }
        });
        /*checkbx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //Todo todo=new Todo();
                        Field field;
                        int ind = 0;
                        Object obj = parent.getItemAtPosition(position);
                        try {
                            field = obj.getClass().getField("key_id");
                            ind = field.getInt(obj);
                        } catch (Exception e) {
                        }
                        dbManager.setStatus(ind);
                    }
                });

            }*/
        return convertView;
    }
}
