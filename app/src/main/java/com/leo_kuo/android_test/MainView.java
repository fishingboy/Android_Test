package com.leo_kuo.android_test;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainView extends ActionBarActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_blank, menu);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // 顯示 Toast (類似 alert)
    public void showToast(View view)
    {
        String str = this.getTxt();
        if (str.length()> 0)
            Lib.alert(view, str);
        else
            Lib.alert(view, "您沒有輸入資料！");
    }

    // 取得輸入方塊的值
    public String getTxt()
    {
        EditText txt = (EditText) findViewById(R.id.txt1);
        return txt.getText().toString();
    }

    // 顯示 Linear 測試畫面
    public void showLinear(View view)
    {
        Intent intent = new Intent();
        intent.setClass(this, LinearView.class);
        startActivity(intent);
    }
}
