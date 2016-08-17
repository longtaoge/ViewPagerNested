package org.xiangbalao.viewpagernested;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import org.xiangbalao.viewpagernested.fragment.CoffeeFragment_new;
import org.xiangbalao.viewpagernested.fragment.HomeFragment;
import org.xiangbalao.viewpagernested.fragment.VoiceFragment;

public class MainActivity extends AppCompatActivity {

    private FrameLayout container_activity_accept;


    private FragmentManager mFragmentManager;

    private HomeFragment mHomeFragment;
    private CoffeeFragment_new mCoffeeFragment;
    private VoiceFragment mVoiceFragment;

    private Fragment curFragment;
    private RadioGroup rg_accept;
    private FragmentTransaction transaction;//= mFragmentManager.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        transaction = mFragmentManager.beginTransaction();
        initView();
        initData();
    }

    private void initView() {
        container_activity_accept = (FrameLayout) findViewById(R.id.container_activity_accept);
        rg_accept = (RadioGroup) findViewById(R.id.rg_accept);

        rg_accept.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                transaction = mFragmentManager.beginTransaction();

                switch (checkedId) {
                    case R.id.rb_home:
                        if (mHomeFragment == null) {
                            mHomeFragment = new HomeFragment();
                        }
                        transaction.replace(R.id.container_activity_accept, mHomeFragment).commit();
                        break;

                    case R.id.rb_coffee:

                        if (mCoffeeFragment == null) {
                            mCoffeeFragment = new CoffeeFragment_new();
                        }
                        transaction.replace(R.id.container_activity_accept, mCoffeeFragment).commit();

                        break;
                    case R.id.rb_voice:
                        if (mVoiceFragment == null) {
                            mVoiceFragment = new VoiceFragment();
                        }
                        transaction.replace(R.id.container_activity_accept, mVoiceFragment).commit();
                        break;
                }

            }
        });


    }


    public void initData() {

        if (mHomeFragment == null) {
            mHomeFragment = new HomeFragment();
        }
        if (!mHomeFragment.isAdded()) {
            transaction.add(R.id.container_activity_accept, mHomeFragment).commit();
            curFragment = mHomeFragment;
        }
    }

}
