package org.xiangbalao.viewpagernested.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xiangbalao.viewpagernested.R;


/**
 *
 * Created by longtaoge on 2016/6/29.
 */
public class HomeFragment extends Fragment {





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);

        return view;
    }





    public void initView(View view) {



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
