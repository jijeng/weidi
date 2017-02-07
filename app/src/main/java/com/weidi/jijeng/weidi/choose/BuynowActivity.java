package com.weidi.jijeng.weidi.choose;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.weidi.jijeng.weidi.R;
import com.weidi.jijeng.weidi.my.wo_order;


/**
 * Created by Administrator on 2015/8/20.
 */
public class BuynowActivity extends Activity {

    private TextView bt_ok,bt_back;
    private LinearLayout wuliu;

    /** 用于设置背景暗淡 */
    private LinearLayout all_choice_layout = null;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy_now_a);

        initView();


    }

    private void initView(){
        wuliu=(LinearLayout)findViewById(R.id.wuliu);
        bt_back=(TextView) findViewById(R.id.bt_buy_back);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
//        AseoZdpAseo.initType(this, AseoZdpAseo.INSERT_TYPE);
        bt_ok=(TextView) findViewById(R.id.tv_buy_ok);
        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                new AlertDialog.Builder(BuynowActivity.this)
                        .setTitle("支付宝支付")
                        .setIcon(R.drawable.zhifubao)
                        .setView(new EditText(BuynowActivity.this))
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "支付成功", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), ChooseSeeds.class));
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
            }
        });

        wuliu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),wuliu.class);
                startActivity(intent);


            }
        });



    }


}
