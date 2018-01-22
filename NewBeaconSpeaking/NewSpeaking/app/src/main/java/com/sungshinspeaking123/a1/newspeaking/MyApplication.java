package com.sungshinspeaking123.a1.newspeaking;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;

import java.util.List;
import java.util.UUID;

import android.app.ActivityManager;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;

import java.util.List;
import java.util.UUID;

/**
 * Created by 1 on 2017-08-22.
 */
public class MyApplication extends Application {

    private BeaconManager beaconManager;

    /**
     * Application을 설치할 때 실행됨.
     */
    @Override
    public void onCreate() {
        super.onCreate();
        beaconManager = new BeaconManager(getApplicationContext());

        // Application 설치가 끝나면 Beacon Monitoring Service를 시작한다.
        // Application을 종료하더라도 Service가 계속 실행된다.
        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                beaconManager.startMonitoring(new Region(
                        "monitored region",

                        // 본인이 연결 할 비콘의 아이디 부분
                        UUID.fromString("74278BDA-B644-4520-8F0C-720EAF059935"),

                        // 본인이 연결 할 비콘의 Major ID
                        0,

                        // 본인이 연결 할 비콘의 Minor ID
                        0));

                /**
                 * 비콘에게 아이디, Major, Minor를 보낼 것이다.
                 */
            }
        });

        // Android 단말이 Beacon 의 송신 범위에 들어가거나, 나왔을 때를 체크한다.
        beaconManager.setMonitoringListener(new BeaconManager.MonitoringListener() {
            @Override
            public void onEnteredRegion(Region region, List list) {

                // list.get(0).getRssi()은 수신강도입니다.
                // 0에 가까울수록 거리가 가깝습니다.
                // showNotification은 아래 메소드를 호출하는겁니다.

                showNotification("회화중독", "비콘 연결됨");

                Intent intent = new Intent(getApplicationContext(), SplashActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("executeType", "beacon");
                getApplicationContext().startActivity(intent);

            }

            @Override
            public void onExitedRegion(Region region) {
                showNotification("나감", "비콘 연결끊김");
            }
        });
    }


    /**
     * Notification으로 Beacon 의 신호가 연결되거나 끊겼음을 알림.
     *
     * @param title
     * @param message
     */
    public void showNotification(String title, String message) {

        Intent notifyIntent = new Intent(this, MainActivity.class);
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivities(
                this, 0, new Intent[]{notifyIntent}
                , PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new Notification.Builder(this)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setTicker("회화를 공부할 수 있는 장소에 도착했어요!")
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setPriority(Notification.PRIORITY_HIGH)
                .build();

        notification.defaults |= Notification.FLAG_AUTO_CANCEL;
        notification.defaults |= Notification.DEFAULT_SOUND;

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }

}