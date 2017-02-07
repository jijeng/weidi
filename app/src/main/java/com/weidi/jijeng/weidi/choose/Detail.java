package com.weidi.jijeng.weidi.choose;

import android.annotation.SuppressLint;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.weidi.jijeng.weidi.R;
import com.weidi.jijeng.weidi.adapter.Adapter_ListView_detail;
import com.zdp.aseo.content.AseoZdpAseo;

/**
 * Created by Administrator on 2015/9/25.
 */
public  class Detail extends FragmentActivity  {
    private final  String http="http://yun.baidu.com/share/link?shareid=1526423194&uk=3947956290";


    TextView kefu,buy_now,put_in;

    //    private int[] resId = { R.drawable.detail_show_1, R.drawable.detail_show_2, R.drawable.detail_show_3, R.drawable.detail_show_4, R.drawable.detail_show_5, R.drawable.detail_show_6 };
    private ListView listView;
    private ImageView iv_baby_collection;
    /**弹出商品订单信息详情*/

    private LinearLayout all_choice_layout = null;
    /**判断是否点击的立即购买按钮*/
    boolean isClickBuy = false;
    /**是否添加收藏*/
    private static boolean isCollection=false;
    /**ViewPager当前显示页的下标*/



//    private LayoutInflater mInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
//        getSaveCollection();
        initView();

//        mInflater = LayoutInflater.from(this);
    }

    @SuppressLint("NewApi")
    private void initView() {
//        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
//        findViewById(R.id.buy_now).setOnClickListener(this);
//        findViewById(R.id.kefu).setOnClickListener(this);
        kefu= (TextView) findViewById(R.id.kefu);
        buy_now= (TextView) findViewById(R.id.buy_now);
        put_in = (TextView) findViewById(R.id.put_in);

        iv_baby_collection=(ImageView) findViewById(R.id.iv_baby_collection);
        iv_baby_collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCollection) {
                    //提示是否取消收藏
                    cancelCollection();
                }else {
                    isCollection=true;
                    setSaveCollection();
                    //如果已经收藏，则显示收藏后的效果
                    iv_baby_collection.setImageResource(R.drawable.second_2_collection);
                    Toast.makeText(Detail.this, "收藏成功", Toast.LENGTH_SHORT).show();
                }

            }
        });
        all_choice_layout = (LinearLayout) findViewById(R.id.all_choice_layout);
        listView = (ListView) findViewById(R.id.listView_Detail);
        listView.setFocusable(false);
        listView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        listView.setAdapter(new Adapter_ListView_detail(this));
//        if (isCollection) {
//            //如果已经收藏，则显示收藏后的效果
//            iv_baby_collection.setImageResource(R.drawable.second_2_collection);
//        }
        kefu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                Uri uri=Uri.parse(http);
                Toast.makeText(Detail.this,"您将下载最新的微地聊天软件-微小地，进行聊天",Toast.LENGTH_SHORT).show();
                intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        buy_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Detail.this,BuynowActivity.class);
                startActivity(intent);
            }
        });
        put_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Detail.this,"添加购物车成功！",Toast.LENGTH_SHORT).show();
            }
        });

    }

//    @Override
//    public void onClick(View view) {
//        Uri uri=Uri.parse(http);
//        switch (view.getId()) {
//            case R.id.iv_back:
//                //返回
//                finish();
//                break;
//            case R.id.iv_baby_collection:
//                //收藏
//                if (isCollection) {
//                    //提示是否取消收藏
//                    cancelCollection();
//                }else {
//                    isCollection=true;
//                    setSaveCollection();
//                    //如果已经收藏，则显示收藏后的效果
//                    iv_baby_collection.setImageResource(R.drawable.second_2_collection);
//                    Toast.makeText(this, "收藏成功", Toast.LENGTH_SHORT).show();
//                }
//                break;
//            case R.id.put_in:
//                //添加购物车
////                isClickBuy = false;
////                setBackgroundBlack(all_choice_layout, 0);
////                popWindow.showAsDropDown(view);
//                break;
//            case R.id.buy_now:
//                //对于 苹果这种商品来说，直接跳转到 订单确认界面
//
////                isClickBuy = true;
////                setBackgroundBlack(all_choice_layout, 0);
////                popWindow.showAsDropDown(view);
//                Intent intent=new Intent(Detail.this,BuynowActivity.class);
//                startActivity(intent);
//                break;
//            case R.id.kefu:
//                Toast.makeText(Detail.this,"您将下载最新的微地聊天软件-微小地，进行聊天",Toast.LENGTH_SHORT).show();
//                intent=new Intent(Intent.ACTION_VIEW,uri);
//                startActivity(intent);
//                break;
//           default:
//               break;
//        }
//    }



    public void onClickOKPop() {
        setBackgroundBlack(all_choice_layout, 1);

        if (isClickBuy) {
            //如果之前是点击的立即购买，那么就跳转到立即购物界面
            Intent intent = new Intent(Detail.this, BuynowActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this, "添加到购物车成功", Toast.LENGTH_SHORT).show();
        }
    }

    /** 控制背景变暗 0变暗 1变亮 */
    public void setBackgroundBlack(View view, int what) {
        switch (what) {
            case 0:
                view.setVisibility(View.VISIBLE);
                break;
            case 1:
                view.setVisibility(View.GONE);
                break;
        }
    }

    /**保存是否添加收藏*/
    private void setSaveCollection(){
        SharedPreferences sp=getSharedPreferences("SAVECOLLECTION", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putBoolean("isCollection", isCollection);
        editor.commit();
    }
    /**得到保存的是否添加收藏标记*/
    private void getSaveCollection(){
        SharedPreferences sp=getSharedPreferences("SAVECOLLECTION", Context.MODE_PRIVATE);
        isCollection=sp.getBoolean("isCollection", false);

    }
    /**取消收藏*/
    private  void cancelCollection(){
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("是否取消收藏");
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                isCollection=false;
                //如果取消收藏，则显示取消收藏后的效果
                iv_baby_collection.setImageResource(R.drawable.second_2);
                setSaveCollection();
            }
        });
        dialog.setNegativeButton("取消", null);
        dialog.create().show();

    }

}
