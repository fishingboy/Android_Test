package com.leo_kuo.android_test;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class FileActivity extends ActionBarActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_file, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void file_read(View view)
    {
        Lib.alert(view, "file read called.");
        String filename = "output.txt";
        FileInputStream fp;
//        try
//        {
//            fp = openFileInput(filename, Context.MODE_APPEND);
//            int m = fp.read();
//            fp.close();
//
//            Lib.alert(view, "123");
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
    }

    public void file_write(View view)
    {
        Lib.alert(view, "file write called.");
        String filename = "output.txt";
        String msg = "Hello world!!";

        FileOutputStream fp;
        try
        {
            fp = openFileOutput(filename, Context.MODE_APPEND);
            fp.write(msg.getBytes());
            fp.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.e("Write File Error", "Error!!");
        }
    }
}
