package com.weidi.jijeng.weidi.guideFragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.weidi.jijeng.weidi.FrameActivity;
import com.weidi.jijeng.weidi.Login;
import com.weidi.jijeng.weidi.R;
import com.weidi.jijeng.weidi.Registe;

public class MyFragmentthree extends Fragment {

    private Context ctx;
    public  MyFragmentthree(){}
    @SuppressLint("ValidFragment")

    public MyFragmentthree(Context ctx) {
        super();
        this.ctx = ctx;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        view = View.inflate(getActivity(), R.layout.activity_my_fragmentthree, null);

        view.findViewById(R.id.btnRegiste).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(ctx,Registe.class);
                ctx.startActivity(intent);
            }
        });

        view.findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(ctx, Login.class);
                ctx.startActivity(intent);
            }
        });

        view.findViewById(R.id.btn_skip).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(getActivity(), FrameActivity.class);
                ctx.startActivity(intent);
            }
        });
        return view;
    }

}
