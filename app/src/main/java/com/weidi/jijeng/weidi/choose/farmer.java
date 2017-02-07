package com.weidi.jijeng.weidi.choose;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.weidi.jijeng.weidi.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/9/24.
 */
public class farmer extends Activity {

    GridView gridView=null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer);
        init();
        initView();
    }

    private void init() {
        gridView= (GridView) findViewById(R.id.gv_rss);


    }
    private void initView() {


    }


}
