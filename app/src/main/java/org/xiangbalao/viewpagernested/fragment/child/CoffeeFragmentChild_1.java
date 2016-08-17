package org.xiangbalao.viewpagernested.fragment.child;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.xiangbalao.viewpagernested.R;
import org.xiangbalao.viewpagernested.SecondActivity;


/**
 * 常跑线路
 * Created by longtaoge on 2016/6/29.
 */
public class CoffeeFragmentChild_1 extends Fragment {


    private ImageView iv_image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_coffee_child_1, container, false);


        initView(view);
        return view;
    }


    @Override
    public void onPause() {

        super.onPause();

    }

    @Override
    public void onResume() {

        super.onResume();

    }


    private void initView(View view) {
        iv_image = (ImageView) view.findViewById(R.id.iv_image);
        iv_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent =new Intent(getActivity(), SecondActivity.class);
                startActivity(mIntent);
            }
        });

    }
}
