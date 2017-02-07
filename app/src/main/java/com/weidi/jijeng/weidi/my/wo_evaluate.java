package com.weidi.jijeng.weidi.my;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.weidi.jijeng.weidi.R;


public class wo_evaluate extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wo_evaluate);
        findViewById(R.id.rl_huievaluate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



}
