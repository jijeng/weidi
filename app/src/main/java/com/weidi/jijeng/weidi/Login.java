package com.weidi.jijeng.weidi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.weidi.jijeng.weidi.util.MyUser;

import java.util.HashMap;
import java.util.Map;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.SaveListener;

public class Login extends AppCompatActivity {

    private EditText et_usertel;
    private EditText et_password;
    private Button btn_login;
    private Button btn_qtlogin;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        dialog = new ProgressDialog(Login.this);
        et_usertel = (EditText) findViewById(R.id.et_usertel);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_qtlogin = (Button) findViewById(R.id.btn_qtlogin);
        // 监听多个输入框

        et_usertel.addTextChangedListener(new TextChange());
        et_password.addTextChangedListener(new TextChange());

        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.setMessage("正在登录...");
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.show();

                final String password = et_password.getText().toString().trim();
                String usertel = et_usertel.getText().toString().trim();
                BmobUser.loginByAccount(getApplicationContext(), usertel, password, new LogInListener<MyUser>() {
                    @Override
                    public void done(MyUser myUser, BmobException e) {
                        if(myUser!=null){
                            Toast.makeText(getApplicationContext(), "登录成功",Toast.LENGTH_SHORT).show();
                            Log.i("smile", "" + myUser.getUsername() + "-" + "-" + myUser.getObjectId() + "-" + myUser.getEmail());
                            dialog.dismiss();
                            startActivity(new Intent(getApplicationContext(),FrameActivity.class));
                            finish();
                        }else{
                            dialog.dismiss();
                            Toast.makeText(getApplicationContext(),"错误码：" +
                                    e.getErrorCode() + ",错误原因：" + e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });



    }



});


    }



    private class TextChange implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            boolean Sign2 = et_usertel.getText().length() > 0;
            boolean Sign3 = et_password.getText().length() > 0;

            if (Sign2 & Sign3) {
                btn_login.setTextColor(0xFFFFFFFF);
                btn_login.setEnabled(true);
            }
            // 在layout文件中，对Button的text属性应预先设置默认值，否则刚打开程序的时候Button是无显示的
            else {
                btn_login.setTextColor(0xFFD0EFC6);
                btn_login.setEnabled(false);
            }


        }
    }
}

