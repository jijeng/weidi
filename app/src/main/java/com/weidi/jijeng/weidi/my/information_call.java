package com.weidi.jijeng.weidi.my;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.weidi.jijeng.weidi.R;


public class information_call extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_call);
        findViewById(R.id.rl_huicall).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



}
