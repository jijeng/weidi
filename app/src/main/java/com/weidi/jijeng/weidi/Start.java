package com.weidi.jijeng.weidi;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.widget.LinearLayout;

import cn.bmob.v3.Bmob;

public class Start extends Activity {
    // WeiDi 的APPID
    public static String APPID = "efeaee9fa9372bdd1a0c4bce21f018dd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Bmob.initialize(getApplicationContext(), APPID);
        LinearLayout mLinear = (LinearLayout) findViewById(R.id.Linear_start);
        mLinear.setBackgroundResource(R.mipmap.start_home_page);

        new Thread() {
            public void run() {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Message msg = hand.obtainMessage();
                hand.sendMessage(msg);
            }

        }.start();
    };

    Handler hand = new Handler() {
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            if (isFristRun()) {
                Intent intent = new Intent(Start.this,
                        Guide.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(Start.this,
                        FrameActivity.class);
                startActivity(intent);
            }
            finish();
        };
    };

    private boolean isFristRun() {
        SharedPreferences sharedPreferences = this.getSharedPreferences(
                "share", MODE_PRIVATE);
        boolean isFirstRun = sharedPreferences.getBoolean("isFirstRun", true);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (!isFirstRun) {
            return false;
        } else {
            editor.putBoolean("isFirstRun", false);
            editor.commit();
            return true;
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {

        }
        return true;
    }
}