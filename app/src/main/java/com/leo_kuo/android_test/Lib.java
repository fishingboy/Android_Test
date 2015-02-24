package com.leo_kuo.android_test;

import android.view.View;
import android.widget.Toast;

/**
 * 共用函式區
 * @author Leo Kuo <et282523@hotmail.com>
 */
public class Lib
{
    // 提示訊息
    public static void alert(View view,String str)
    {
        Toast.makeText(view.getContext(), str, Toast.LENGTH_LONG).show();
    }
}
