package com.weidi.jijeng.weidi.choose;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.weidi.jijeng.weidi.R;




/**
 * Created by Administrator on 2015/8/21.
 */
public class SearchActivity extends Activity {

    private EditText mEditText = null;
    private ImageButton mImageButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_search);
        findViewById();
        initView();
    }


    protected void findViewById() {
        // TODO Auto-generated method stub
        mEditText = (EditText) findViewById(R.id.search_edit);
        mImageButton = (ImageButton) findViewById(R.id.search_button);
    }


    protected void initView() {
        // TODO Auto-generated method stub
        mEditText.requestFocus();
        mImageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(SearchActivity.this, "亲，该功能暂未开放",Toast.LENGTH_SHORT);
            }
        });
    }
}
