package com.weidi.jijeng.weidi.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.weidi.jijeng.weidi.R;


public class information_user extends wo_myinformation {
    private EditText editText;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_user);
        editText=(EditText)this.findViewById(R.id.editText);
        button=(Button)this.findViewById(R.id.button);
        final Intent intent=getIntent();
        String a =intent.getStringExtra("a");
        editText.setText(a);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String b = editText.getText().toString();
                intent.putExtra("b", b);
                setResult(2, intent);
                finish();
            }
        });




        //返回information
        findViewById(R.id.ll_xiuuser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getApplicationContext(),wo_myinformation.class));
                finish();
            }
        });



    }



}
