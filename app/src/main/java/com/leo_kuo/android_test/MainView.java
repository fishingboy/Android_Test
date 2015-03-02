package com.leo_kuo.android_test;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

    // 顯示狀態列提示
    public void showNotify(View view)
    {
        final int notifyID = 1; // 通知的識別號碼
        final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // 取得系統的通知服務
        final Notification notification = new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.notify_icon).setContentTitle("內容標題").setContentText("內容文字").build(); // 建立通知
        notificationManager.notify(notifyID, notification); // 發送通知
    }

    // 顯示狀態列提示
    // TODO: 把這個功能修正，現在不 Work!!
    public void showNotifyByService(View view)
    {
        Intent i = new Intent(this, NotifyService.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startService(i);
    }

    // 顯示 Table Layout 測試畫面
    public void showTable(View view)
    {
        Intent intent = new Intent();
        intent.setClass(this, TableActivity.class);
        startActivity(intent);
    }

    // 顯示 Relative Layout 測試畫面
    public void showRelative(View view)
    {
        Intent intent = new Intent();
        intent.setClass(this, RelativeActivity.class);
        startActivity(intent);
    }

    public void writeSharedPreferences(View view)
    {
        SharedPreferences data = getSharedPreferences("data", MODE_PRIVATE);
        data.edit().putString("msg", "Hello Shared Preferences!").commit();
        Lib.alert(view, "writeSharedPreferences Finish!");
    }

    public void readSharedPreferences(View view)
    {
        SharedPreferences data = getSharedPreferences("data", MODE_PRIVATE);
        String msg = data.getString("msg", "no msg...");
        Lib.alert(view, "msg = " + msg);
    }
}
