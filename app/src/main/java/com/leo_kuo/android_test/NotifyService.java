package com.leo_kuo.android_test;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class NotifyService extends Service
{
    private static final int NOTIFY_ID = 1;

    public NotifyService()
    {
//        super.onCreate();
        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);

        CharSequence tickerText = "記得繳錢";
        long when = System.currentTimeMillis();
//        Notification notification = new Notification(R.drawable.notify_icon, tickerText, when);
        Notification notification = new Notification(0, tickerText, when);
        Context context = getApplicationContext();
        CharSequence contentTitle = "提醒標題";
        CharSequence contentText = "點擊進入繳費清單";
        Intent notificationIntent = new Intent(this, LinearView.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
        mNotificationManager.notify(NOTIFY_ID, notification);

    }

    @Override
    public IBinder onBind(Intent intent)
    {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
