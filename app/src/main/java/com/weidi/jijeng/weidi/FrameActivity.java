package com.weidi.jijeng.weidi;

import java.util.ArrayList;
import java.util.List;

import com.weidi.jijeng.weidi.choose.Choose;
import com.weidi.jijeng.weidi.my.MainActivity;

import com.weidi.jijeng.weidi.radar.Radar;


import android.app.ActivityGroup;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



public class FrameActivity extends ActivityGroup {

    private LinearLayout mMyBottemSearchBtn, mMyBottemTuanBtn,
            mMyBottemCheckinBtn;
    private ImageView mMyBottemSearchImg, mMyBottemTuanImg,
            mMyBottemCheckinImg;
    private TextView mMyBottemSearchTxt, mMyBottemTuanTxt, mMyBottemCheckinTxt;

    private List<View> list = new ArrayList<View>();// 相当于数据源
    private View view = null;
    private View view1 = null;
    private View view2 = null;

    private android.support.v4.view.ViewPager mViewPager;
    private PagerAdapter pagerAdapter = null;// 数据源和viewpager之间的桥梁

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_frame);
        initView();
    }
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.FramePager);
        // 查找以linearlayout为按钮作用的控件
        mMyBottemSearchBtn = (LinearLayout) findViewById(R.id.MyBottemSearchBtn);
        mMyBottemTuanBtn = (LinearLayout) findViewById(R.id.MyBottemTuanBtn);
        mMyBottemCheckinBtn = (LinearLayout) findViewById(R.id.MyBottemCheckinBtn);

        // 查找linearlayout中的imageview
        mMyBottemSearchImg = (ImageView) findViewById(R.id.MyBottemSearchImg);
        mMyBottemTuanImg = (ImageView) findViewById(R.id.MyBottemTuanImg);
        mMyBottemCheckinImg = (ImageView) findViewById(R.id.MyBottemCheckinImg);

        // 查找linearlayout中的textview
        mMyBottemSearchTxt = (TextView) findViewById(R.id.MyBottemSearchTxt);
        mMyBottemTuanTxt = (TextView) findViewById(R.id.MyBottemTuanTxt);
        mMyBottemCheckinTxt = (TextView) findViewById(R.id.MyBottemCheckinTxt);

        createView();

        // 写一个内部类pageradapter
        pagerAdapter = new PagerAdapter() {
            // 判断再次添加的view和之前的view 是否是同一个view
            // arg0新添加的view，arg1之前的
            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }

            // 返回数据源长度
            @Override
            public int getCount() {
                return list.size();
            }

            // 销毁被滑动走的view
            /**
             * ViewGroup 代表了我们的viewpager 相当于activitygroup当中的view容器， 添加之前先移除。
             * position 第几条数据 Object 被移出的view
             * */
            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                // 移除view
                container.removeView(list.get(position));
            }

            /**
             * instantiateItem viewpager要现实的view ViewGroup viewpager position
             * 第几条数据
             * */
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // 获取view添加到容器当中，并返回
                View v = list.get(position);
                container.addView(v);
                return v;
            }
        };
        // 设置我们的adapter
        mViewPager.setAdapter(pagerAdapter);

        MyBtnOnclick mytouchlistener = new MyBtnOnclick();
        mMyBottemSearchBtn.setOnClickListener(mytouchlistener);
        mMyBottemTuanBtn.setOnClickListener(mytouchlistener);
        mMyBottemCheckinBtn.setOnClickListener(mytouchlistener);


        // 设置viewpager界面切换监听,监听viewpager切换第几个界面以及滑动的
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            // arg0 获取 viewpager里面的界面切换到第几个的
            @Override
            public void onPageSelected(int arg0) {
                // 先清除按钮样式
                initBottemBtn();
                // 按照对应的view的tag来判断到底切换到哪个界面。
                // 更改对应的button状态
                int flag = (Integer) list.get((arg0)).getTag();
                if (flag == 0) {
                    mMyBottemSearchImg
                            .setImageResource(R.mipmap.main_index_search_pressed);
                    mMyBottemSearchTxt.setTextColor(Color.parseColor("#0da17f"));
                } else if (flag == 1) {
                    mMyBottemTuanImg
                            .setImageResource(R.mipmap.main_index_checkin_pressed);
                    mMyBottemTuanTxt.setTextColor(Color.parseColor("#0da17f"));
                } else if (flag == 2) {
                    mMyBottemCheckinImg
                            .setImageResource(R.mipmap.main_index_my_pressed);
                    mMyBottemCheckinTxt.setTextColor(Color
                            .parseColor("#0da17f"));
                }

            }

            /**
             * 监听页面滑动的 arg0 表示当前滑动的view arg1 表示滑动的百分比 arg2 表示滑动的距离
             * */
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            /**
             * 监听滑动状态 arg0 表示我们的滑动状态 0:默认状态 1:滑动状态 2:滑动停止
             * */
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });

    }

    // 把viewpager里面要显示的view实例化出来，并且把相关的view添加到一个list当中
    private void createView() {
        view = this
                .getLocalActivityManager()
                .startActivity("search",
                        new Intent(FrameActivity.this, Choose.class))
                .getDecorView();
        // 用来更改下面button的样式的标志
        view.setTag(0);
        list.add(view);
        view1 = FrameActivity.this
                .getLocalActivityManager()
                .startActivity("tuan",
                        new Intent(FrameActivity.this, Radar.class))
                .getDecorView();
        view1.setTag(1);
        list.add(view1);
        view2 = FrameActivity.this
                .getLocalActivityManager()
                .startActivity("sign",
                        new Intent(FrameActivity.this, MainActivity.class))
                .getDecorView();
        view2.setTag(2);
        list.add(view2);

    }

    /**
     * 用linearlayout作为按钮的监听事件
     * */
    private class MyBtnOnclick implements View.OnClickListener {

        @Override
        public void onClick(View arg0) {
            int mBtnid = arg0.getId();
            switch (mBtnid) {
                case R.id.MyBottemSearchBtn:
                    // //设置我们的viewpager跳转那个界面0这个参数和我们的list相关,相当于list里面的下标
                    mViewPager.setCurrentItem(0);
                    initBottemBtn();
                    mMyBottemSearchImg
                            .setImageResource(R.mipmap.main_index_search_pressed);
                    mMyBottemSearchTxt.setTextColor(Color.parseColor("#0da17f"));
                    break;
                case R.id.MyBottemTuanBtn:
                    mViewPager.setCurrentItem(1);
                    initBottemBtn();
                    mMyBottemTuanImg
                            .setImageResource(R.mipmap.main_index_checkin_pressed);
                    mMyBottemTuanTxt.setTextColor(Color.parseColor("#0da17f"));
                    break;
                case R.id.MyBottemCheckinBtn:
                    mViewPager.setCurrentItem(2);
                    initBottemBtn();
                    mMyBottemCheckinImg
                            .setImageResource(R.mipmap.main_index_my_pressed);
                    mMyBottemCheckinTxt.setTextColor(Color.parseColor("#0da17f"));
                    break;

            }

        }

    }

    /**
     * 初始化控件的颜色
     * */
    private void initBottemBtn() {
        mMyBottemSearchImg.setImageResource(R.drawable.search_bottem_search);
        mMyBottemTuanImg.setImageResource(R.drawable.search_bottem_checkin);
        mMyBottemCheckinImg.setImageResource(R.drawable.search_bottem_my);

        mMyBottemSearchTxt.setTextColor(getResources().getColor(
                R.color.search_bottem_textcolor));
        mMyBottemTuanTxt.setTextColor(getResources().getColor(
                R.color.search_bottem_textcolor));
        mMyBottemCheckinTxt.setTextColor(getResources().getColor(
                R.color.search_bottem_textcolor));

    }

    /**
     * 返回按钮的监听，用来询问用户是否退出程序
     * */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                Builder builder = new Builder(FrameActivity.this);
                builder.setTitle("提示");
                builder.setMessage("你确定要退出吗？");
                builder.setIcon(R.mipmap.ic_launcher);

                DialogInterface.OnClickListener dialog = new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        // TODO Auto-generated method stub
                        if (arg1 == DialogInterface.BUTTON_POSITIVE) {
                            arg0.cancel();
                        } else if (arg1 == DialogInterface.BUTTON_NEGATIVE) {
                            FrameActivity.this.finish();
                        }
                    }
                };
                builder.setPositiveButton("取消", dialog);
                builder.setNegativeButton("确定", dialog);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        }
        return false;
    }


}
