package com.weidi.jijeng.weidi.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.weidi.jijeng.weidi.guideFragment.MyFragmentone;
import com.weidi.jijeng.weidi.guideFragment.MyFragmentthree;
import com.weidi.jijeng.weidi.guideFragment.MyFragmenttwo;

/**
 * Created by Administrator on 2015/8/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private Context context;


    public ViewPagerAdapter(FragmentManager fm,Context context) {
        super(fm);
        this.context=context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment =null;
        if (position == 0)
        {
            fragment=new MyFragmentone(context);
        }else  if (position ==1)
        {
            fragment=new MyFragmenttwo(context);
        }
        else  if (position ==2)
        {
            fragment=new MyFragmentthree(context);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}

