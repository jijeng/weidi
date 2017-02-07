package com.weidi.jijeng.weidi;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import com.weidi.jijeng.weidi.adapter.ViewPagerAdapter;


public class Guide extends AppCompatActivity {
    private ViewPager mViewPager;
    public Guide()
    {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.MyViewPager);
        ViewPagerAdapter myAdapter = new ViewPagerAdapter(
                this.getSupportFragmentManager(), Guide.this);
        mViewPager.setAdapter(myAdapter);

    }

    @Override
    protected void onStop() {
//		finish();
        super.onStop();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
        }
        return true;
    }

}
