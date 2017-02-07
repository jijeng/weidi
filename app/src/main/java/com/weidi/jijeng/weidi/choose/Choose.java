package com.weidi.jijeng.weidi.choose;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.weidi.jijeng.weidi.MyView.AbOnItemClickListener;
import com.weidi.jijeng.weidi.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Choose extends AppCompatActivity {
    private TextView tv_top_title;
    //首页轮播
    private AbSlidingPlayView viewPager;
    private ListView listView;
    /**存储首页轮播的界面*/
    private ArrayList<View> allListView;
    /**首页轮播的界面的资源*/
    private int[] resId = { R.drawable.show_m1, R.drawable.menu_viewpager_1,
            R.drawable.menu_viewpager_2, R.drawable.menu_viewpager_3,
            R.drawable.menu_viewpager_4, R.drawable.menu_viewpager_5 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        listView=(ListView)findViewById(R.id.choose_listview);

        tv_top_title=(TextView)findViewById(R.id.tv_top_title);
        tv_top_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //挑战到宝贝搜索界面
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
            }
        });
        viewPager = (AbSlidingPlayView)findViewById(R.id.viewPager_menu);
        //设置播放方式为顺序播放
        viewPager.setPlayType(1);
        //设置播放间隔时间
        viewPager.setSleepTime(2500);
        initViewPager();

        initList();

    }
    //处理 list item 的点击事件
    private void initList(){
        SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.choose_listview,
                new String[]{"image"},new int[]{R.id.image});
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(getApplicationContext(),BabyActivity.class);
                        Choose.this.startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(Choose.this, "这是第" + position + "个界面", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(Choose.this, "这是第" + position + "个界面", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(Choose.this, "这是第" + position + "个界面", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(Choose.this, "这是第" + position + "个界面", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        break;
                }


            }
        });

    }
    private List<Map<String,Object>> getData(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("image", R.drawable.alistview0);
        list.add(map);

        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("image", R.drawable.alistview1);
        list.add(map1);

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("image", R.drawable.alistview2);
        list.add(map2);

        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("image", R.drawable.alistview3);
        list.add(map3);

        Map<String, Object> map4 = new HashMap<String, Object>();
        map4.put("image", R.drawable.alistview4);
        list.add(map4);
        return list;
    }
    private void initViewPager() {

        if (allListView != null) {
            allListView.clear();
            allListView = null;
        }
        allListView = new ArrayList<View>();

        for (int i = 0; i < resId.length; i++) {
            //导入ViewPager的布局
            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.pic_item, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.pic_item);
            imageView.setImageResource(resId[i]);
            allListView.add(view);
        }


        viewPager.addViews(allListView);
        //开始轮播
        viewPager.startPlay();
        viewPager.setOnItemClickListener(new AbOnItemClickListener() {
            @Override
            public void onClick(int position) {
                //跳转到详情界面
                Intent intent = new Intent(getApplicationContext(), BabyActivity.class);
                startActivity(intent);
            }
        });
    }





    }


