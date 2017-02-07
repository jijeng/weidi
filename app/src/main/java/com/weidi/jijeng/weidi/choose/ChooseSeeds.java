package com.weidi.jijeng.weidi.choose;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.weidi.jijeng.weidi.R;
import com.weidi.jijeng.weidi.my.wo_order;

/**
 * Created by Administrator on 2015/10/15.
 */
public class ChooseSeeds extends Activity {
    private CheckBox checkBox,checkBox1,checkBox2,checkBox3;
    private Button btn_seed_finish;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseceeds);

        init();

    }

    private void init() {
        checkBox=(CheckBox)findViewById(R.id.checkBox2);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(ChooseSeeds.this,
                        isChecked?"选中了胡萝卜种子":"取消了胡萝卜种子",Toast.LENGTH_SHORT).show();
            }
        });
        checkBox1=(CheckBox)findViewById(R.id.checkBox3);
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(ChooseSeeds.this,
                        isChecked?"选中了白菜种子":"取消了白菜种子",Toast.LENGTH_SHORT).show();
            }
        });
        checkBox2=(CheckBox)findViewById(R.id.checkBox4);
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(ChooseSeeds.this,
                        isChecked?"选中了香菜种子":"取消了香菜种子",Toast.LENGTH_SHORT).show();
            }
        });
        checkBox3=(CheckBox)findViewById(R.id.checkBox5);
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(ChooseSeeds.this,
                        isChecked?"选中了草莓种子":"取消了草莓种子",Toast.LENGTH_SHORT).show();
            }
        });
        btn_seed_finish= (Button) findViewById(R.id.btn_seed_finish);
        btn_seed_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "选择种子成功", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), wo_order.class));
            }
        });
    }
}
