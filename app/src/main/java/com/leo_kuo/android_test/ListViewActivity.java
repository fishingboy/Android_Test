package com.leo_kuo.android_test;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class ListViewActivity extends ActionBarActivity
{
    private ListView listView;
    private String[] list = {"鉛筆","原子筆","鋼筆","毛筆","彩色筆"};
    private ArrayAdapter<String> listAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = (ListView)findViewById(R.id.listView);
        listAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(getApplicationContext(), "你選擇的是"+list[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_view, menu);
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
}
