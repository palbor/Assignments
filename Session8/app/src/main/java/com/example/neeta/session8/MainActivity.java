package com.example.neeta.session8;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btndownload, settingsbutton;
    EditText edtxt;
    ProgressDialog progress;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settingsbutton= (Button)findViewById(R.id.settingsbutton);
        settingsbutton.setOnClickListener(this);
        btndownload=(Button) findViewById(R.id.btndownload);
        edtxt=(EditText)findViewById(R.id.edtxt);
        btndownload.setOnClickListener( this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.settingsbutton:
                Intent intent = new Intent(MainActivity.this, settings.class);
                startActivity(intent);
                break;
            case R.id.btndownload:
                MyTask task=new MyTask();
                progress=new ProgressDialog(this);
                progress.setMessage("Downloading");
                progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progress.show();
                task.execute("http://google.com");

        }

    }

    class MyTask extends AsyncTask<String, Integer, Boolean>
    {
        @Override
        protected void onPostExecute(Boolean success) {
            super.onPostExecute(success);
            if(success)
                edtxt.setText("Download Complete");
            else
                edtxt.setText("Download Error");
           // progress.dismiss();
        }

        @Override
       protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progress.setProgress(values[0]);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            edtxt.setText("Starting download");
           // progress= ProgressDialog.show(MainActivity.this,"Downloading", "");
        }

        @Override
        protected Boolean doInBackground(String... params) {

                for (int i=0;i<=100;i++) {
                    try{
                    Thread.sleep(10);
                    publishProgress(i);
                }
            catch(Exception e)
            {
                e.printStackTrace();
            }}
            return true;
        }
    }

}
