package com.weidi.jijeng.weidi.guideFragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.weidi.jijeng.weidi.R;

public class MyFragmenttwo extends Fragment {


    private Context ctx;
    public MyFragmenttwo(){}

    @SuppressLint("ValidFragment")
    public MyFragmenttwo(Context ctx) {
        super();
        this.ctx = ctx;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = null;
        view = View.inflate(getActivity(), R.layout.activity_my_fragmenttwo, null);
        LinearLayout mLinear = (LinearLayout) view
                .findViewById(R.id.Linear_guide);
        mLinear.setBackgroundResource(R.mipmap.introduce1);
        return view;
    }
}
