package org.xiangbalao.viewpagernested.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.xiangbalao.viewpagernested.R;
import org.xiangbalao.viewpagernested.SecondActivity;


/**
 * 我的
 * Created by longtaoge on 2016/6/29.
 */
public class VoiceFragment extends Fragment {


    private LinearLayout ll_root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_voice, container, false);
        initView(view);

        return view;
    }


    public void initView(View view) {


        ll_root = (LinearLayout) view.findViewById(R.id.ll_root);
        ll_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent =new Intent(getActivity(), SecondActivity.class);
                startActivity(mIntent);
            }
        });
    }


    @Override
    public void onPause() {

        super.onPause();

    }

    @Override
    public void onResume() {

        super.onResume();

    }


}
