package com.sungshinspeaking123.a1.newspeaking;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.estimote.sdk.SystemRequirementsChecker;

import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private Button refresh;
    private BeaconManager beaconManager;
    private Region region;

    private TextView tvId;
    private boolean isConnected;
    private Button SchoolBtn;
    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        SchoolBtn = (Button) findViewById(R.id.SchoolBtn);
//        SchoolBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), CafeActivity.class);
//                startActivity(intent);
//            }
//        });

        beaconManager = new BeaconManager(this);

        refresh = (Button) findViewById(R.id.refreshBtn);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beaconManager.startMonitoring(new Region("new region",
                        UUID.fromString("24DDF411-8CF1-440C-87CD-E368DAF9C93E"), null, null));
            }
        });


        beaconManager.setRangingListener(new BeaconManager.RangingListener() {
            @Override
            public void onBeaconsDiscovered(Region region, List<Beacon> list) {
                if (!list.isEmpty()) {
                    Beacon nearestBeacon = list.get(0);
                    Log.d("Airport", "Nearest places: " + nearestBeacon.getMinor());


                    // nearestBeacon.getRssi() : 비콘의 수신 강도
//                    tvId.setText(nearestBeacon.getMinor() + "");

                    if ( !isConnected && nearestBeacon.getRssi() > -70 ) {
                        isConnected = true;
                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("알림")
                                .setTitle("비콘이 연결되었습니다.")
                                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                }).create().show();

                        if (nearestBeacon.getMinor() == 26341){
                            //카페 액티비티로 넘어감
                            Intent intent = new Intent(getApplicationContext(), CafeActivity.class);
                            startActivity(intent);
                        }
                        else if (nearestBeacon.getMinor() == 26343) {
                            //병원 액티비티로 넘어감
                            Intent intent = new Intent(getApplicationContext(), HospitalActivity.class);
                            startActivity(intent);
                        }
                        else if (nearestBeacon.getMinor() == 26338) {
                            //학교 액티비티로 넘어감
                            Intent intent = new Intent(getApplicationContext(), SchoolActivity.class);
                            startActivity(intent);
                        }
                    }
                    else if( nearestBeacon.getRssi() < -70 ){
                        Toast.makeText(MainActivity.this, "연결이 끊어졌습니다.", Toast.LENGTH_SHORT).show();
                        imgView.setImageResource(R.drawable.nobeacon);
                        isConnected = false;
                    }
                }
            }
        });


        region = new Region("ranged region",
                UUID.fromString("24DDF411-8CF1-440C-87CD-E368DAF9C93E"), null, null); // 본인이 연결할 Beacon의 ID와 Major / Minor Code를 알아야 한다.
    }

    @Override
    protected void onResume() {
        super.onResume();

        // 블루투스 권한 및 활성화 코드드
        SystemRequirementsChecker.checkWithDefaultDialogs(this);

        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                beaconManager.startRanging(region);
            }
        });
    }

    @Override
    protected void onPause() {
        //beaconManager.stopRanging(region);

        super.onPause();
    }

}
