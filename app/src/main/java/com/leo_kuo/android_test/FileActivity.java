package com.leo_kuo.android_test;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileActivity extends MainView
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
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
