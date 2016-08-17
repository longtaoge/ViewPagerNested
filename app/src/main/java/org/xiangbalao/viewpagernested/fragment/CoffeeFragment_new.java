package org.xiangbalao.viewpagernested.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import org.xiangbalao.viewpagernested.R;
import org.xiangbalao.viewpagernested.fragment.child.CoffeeFragmentChild_1;
import org.xiangbalao.viewpagernested.fragment.child.CoffeeFragmentChild_2;
import org.xiangbalao.viewpagernested.fragment.child.CoffeeFragmentChild_3;


/**
 *
 * Created by longtaoge on 2016/6/29.
 */
public class CoffeeFragment_new extends Fragment {



    private RadioGroup rg_accept1;
    private FrameLayout layout_container_cheld;
    private FragmentManager mFragmentManager;


    private CoffeeFragmentChild_1 mCoffeeFragmentChild_1;

    private CoffeeFragmentChild_2 mCoffeeFragmentChild_2;
    private CoffeeFragmentChild_3 mCoffeeFragmentChild_3;
    private Fragment curFragment;
    private int lastButtonId;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_coffee_new, container, false);
        initView(view);
        initData();
        return view;
    }


    public void initView(View view) {

        mFragmentManager =   getActivity().getSupportFragmentManager(); // getFragmentManager();   //getChildFragmentManager();

        rg_accept1 = (RadioGroup) view.findViewById(R.id.rg_accept1);

        layout_container_cheld = (FrameLayout) view.findViewById(R.id.layout_container);

        rg_accept1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = mFragmentManager.beginTransaction();
                switch (checkedId){
                    case R.id.rb_coffee1:

                        if (mCoffeeFragmentChild_2==null){
                            mCoffeeFragmentChild_2=new CoffeeFragmentChild_2();

                        }
                        addOrShowFragment(transaction,mCoffeeFragmentChild_2);

                        lastButtonId=R.id.rb_coffee1;

                        break;
                    case R.id.rb_search:



                        if (mCoffeeFragmentChild_1==null){

                            mCoffeeFragmentChild_1 =new CoffeeFragmentChild_1();
                        }

                        addOrShowFragment(transaction,mCoffeeFragmentChild_1);

                        lastButtonId=R.id.rb_search;
                        break;
                    case R.id.rb_voice1:

                        if (mCoffeeFragmentChild_3==null){

                            mCoffeeFragmentChild_3=new CoffeeFragmentChild_3();
                        }

                        addOrShowFragment(transaction,mCoffeeFragmentChild_3);

                        lastButtonId=R.id.rb_voice1;
                        break;

                }



            }
        });




    }

    /**
     * 切换中间布局
     *
     * @param fragment
     */
    private void addOrShowFragment(FragmentTransaction transaction,
                                   Fragment fragment) {
        if (curFragment == fragment)
            return;

        if (mFragmentManager == null) {
           // mFragmentManager = getChildFragmentManager();
            mFragmentManager =  getActivity().getSupportFragmentManager();//getFragmentManager();
        }
        transaction.replace(R.id.layout_container, fragment,fragment.getClass().getSimpleName());
        transaction.addToBackStack(null);
        transaction.commit();
        curFragment = fragment;
    }



    public void initData() {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (mCoffeeFragmentChild_1 == null) {
            mCoffeeFragmentChild_1 = new CoffeeFragmentChild_1();
        }
        if (!mCoffeeFragmentChild_1.isAdded()) {
            transaction.add(R.id.layout_container, mCoffeeFragmentChild_1).commit();
            curFragment = mCoffeeFragmentChild_1;
        }
    }

    @Override
    public void onPause() {

        super.onPause();

    }

    @Override
    public void onResume() {

        super.onResume();
        if (lastButtonId != 0) {
            rg_accept1.check(lastButtonId);
        }

    }




}
