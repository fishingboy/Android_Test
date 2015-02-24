package com.leo_kuo.android_test;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Leo on 2015/2/24.
 */
public class Lib
{
    // 提示訊息
    public static void alert(View view,String str)
    {
        Toast.makeText(view.getContext(), str, Toast.LENGTH_LONG).show();
    }
}
