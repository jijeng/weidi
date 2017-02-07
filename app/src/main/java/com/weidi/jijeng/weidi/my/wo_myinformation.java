package com.weidi.jijeng.weidi.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.weidi.jijeng.weidi.R;


public class wo_myinformation extends MainActivity {
    private RelativeLayout rl_userxiu;
    private final static int REQUESTCODE=1;
    private TextView textView2;
    private RelativeLayout rl_prewo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wo_myinformation);
        rl_userxiu=(RelativeLayout)this.findViewById(R.id.rl_userxiu);
        textView2=(TextView)this.findViewById(R.id.textView2);
        rl_prewo=(RelativeLayout)this.findViewById(R.id.rl_prewo);
        rl_userxiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a =textView2.getText().toString();
                Intent intent=new Intent(wo_myinformation.this,information_user.class);
                intent.putExtra("a",a);
                startActivityForResult(intent,REQUESTCODE);
            }
        });
        rl_prewo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                String b =textView2.getText().toString();
                intent.putExtra("b",b);
                setResult(2,intent);
                finish();
            }
        });



        //链接到修改地址
        findViewById(R.id.rl_xiuaddress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),information_address.class));

            }
        });
        //链接到修改手机号
        findViewById(R.id.rl_xiucall).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),information_call.class));

            }
        });
        //链接到修改登录密码
        findViewById(R.id.rl_xiupassword).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),change_password.class));

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==2){
            if (requestCode==REQUESTCODE){
                String b=data.getStringExtra("b");
                textView2.setText(String.valueOf(b));

            }
        }
    }
}