package com.weidi.jijeng.weidi.my;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.weidi.jijeng.weidi.R;
import com.weidi.jijeng.weidi.Start;

import cn.bmob.push.BmobPush;
import cn.bmob.v3.BmobInstallation;
import cn.bmob.v3.BmobPushManager;
import cn.bmob.v3.BmobQuery;


public class make_xiaoxi extends ActionBarActivity {
    Switch tuisong;
    BmobPushManager<BmobInstallation> bmobPush;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_xiaoxi);
        BmobPush.setDebugMode(true);
        //
        BmobPush.startWork(this, Start.APPID);

        bmobPush = new BmobPushManager<BmobInstallation>(this);
        tuisong= (Switch) findViewById(R.id.switch1);
        tuisong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(isChecked)
               {
                   pushToAndroid("农家的推送消息");
               }

            }
        });
        findViewById(R.id.rl_xiaoxi_huimake).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        BmobInstallation.getCurrentInstallation(this).save();
    }

    private void pushToAndroid(String message) {
        BmobQuery<BmobInstallation> query = BmobInstallation.getQuery();
        query.addWhereEqualTo("deviceType", "android");
        bmobPush.setQuery(query);
        bmobPush.pushMessage(message);
    }


}
