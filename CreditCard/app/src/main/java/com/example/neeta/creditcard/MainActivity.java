package com.example.neeta.creditcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button1, button2;
    EditText edttext1, edittext2,edttext3;
    private final String TAG= getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        edttext1= (EditText) findViewById(R.id.edttext1);
        final int strn=Integer.parseInt(edttext1.getText().toString());
        final int rate=Integer.parseInt(edittext2.getText().toString());
        final int payment=Integer.parseInt(edttext3.getText().toString());
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                edittext2.setText(strn);
                    }
        });
    }
}
