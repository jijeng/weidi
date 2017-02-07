package com.weidi.jijeng.weidi.choose;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.weidi.jijeng.weidi.R;

/**
 * Created by Administrator on 2015/8/20.
 */
public class PictrueFragment extends Fragment {

    private int resId;

    @SuppressLint("ValidFragment")
    public PictrueFragment(int resId){

        this.resId=resId;
    }
    public PictrueFragment()
    {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=LayoutInflater.from(getActivity()).inflate(R.layout.scale_pic_item, null);
        initView(view);
        return view;
    }

    private void initView(View view){
        ImageView imageView=(ImageView) view.findViewById(R.id.scale_pic_item);
        imageView.setImageResource(resId);

    }



}
