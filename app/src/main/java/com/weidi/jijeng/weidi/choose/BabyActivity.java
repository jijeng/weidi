package com.weidi.jijeng.weidi.choose;


import android.app.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


import android.view.View;
import android.widget.ImageView;

import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.weidi.jijeng.weidi.R;



/**
 * Created by Administrator on 2015/8/20.
 */
public  class BabyActivity extends Activity {
    private final  String http="http://yun.baidu.com/share/link?shareid=1526423194&uk=3947956290";

   private ListView listView;
    private ImageView iv_baby_collection;
    /**弹出商品订单信息详情*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.babydetail_a);
        initView();

    }


    private void initView() {
        TextView kefu= (TextView) findViewById(R.id.kefu);
        TextView put_in= (TextView) findViewById(R.id.put_in);

        TextView buy_now= (TextView) findViewById(R.id.buy_now);
        ImageView baicai = (ImageView) findViewById(R.id.baicai);
        ImageView luobo = (ImageView) findViewById(R.id.luobo);
        kefu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                Uri uri=Uri.parse(http);
                Toast.makeText(BabyActivity.this, "您将下载最新的微地聊天软件-微小地，进行聊天", Toast.LENGTH_SHORT).show();
                intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);

            }
        });
        put_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BabyActivity.this,"添加购物车成功",Toast.LENGTH_SHORT).show();

            }
        });

        buy_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BabyActivity.this,BuynowActivity.class);
                startActivity(intent);

            }
        });

        baicai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BabyActivity.this,Detail.class));
            }
        });
        luobo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BabyActivity.this,Detail.class));
            }
        });


    }



}
