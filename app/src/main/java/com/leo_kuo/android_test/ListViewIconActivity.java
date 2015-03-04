package com.leo_kuo.android_test;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewIconActivity extends ActionBarActivity
{
    private ListView listView;
    private String[] list;
    private List<Map<String, Object>> mList;
    private ArrayAdapter<String> listAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_icon);

        mList = new ArrayList<Map<String, Object>>();
        list = getResources().getStringArray(R.array.weekday);
        for (int i=0; i<list.length; i++)
        {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imgView", android.R.drawable.ic_input_get);
            item.put("txtView", list[i]);
            item.put("imgView2", android.R.drawable.ic_btn_speak_now);
            mList.add(item);
        }

        SimpleAdapter adapter = new SimpleAdapter
        (
            this,
            mList,
            R.layout.list_item,
            new String[] {"imgView", "txtView", "imgView2"},
            new int[] {R.id.imgViewIcon, R.id.txtViewIcon, R.id.imgViewIcon2}
        );

        listView = (ListView)findViewById(R.id.listView2);
        // 書中範例是這行寫錯了，應該要呼叫的是 listView 底下的 setAdapter 才對
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String s = ((TextView)view.findViewById(R.id.txtViewIcon)).getText().toString();
                Toast.makeText(getApplicationContext(), "你選擇的是"+s, Toast.LENGTH_SHORT).show();
            }
        });
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
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
