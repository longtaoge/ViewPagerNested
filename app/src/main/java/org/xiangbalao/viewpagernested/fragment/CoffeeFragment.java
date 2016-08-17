package org.xiangbalao.viewpagernested.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xiangbalao.viewpagernested.R;
import org.xiangbalao.viewpagernested.fragment.child.CoffeeFragmentChild_1;
import org.xiangbalao.viewpagernested.fragment.child.CoffeeFragmentChild_2;
import org.xiangbalao.viewpagernested.fragment.child.CoffeeFragmentChild_3;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * Created by longtaoge on 2016/6/29.
 */
public class CoffeeFragment extends Fragment {


    List<Fragment> fragmentList = new ArrayList<Fragment>();

    List<String> titleList = new ArrayList<String>();
    private ViewPager viewPager;
    private PagerTabStrip pt;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_coffee, container, false);
        initView(view);

        return view;
    }


    public void initView(View view) {


        viewPager = (ViewPager) view.findViewById(R.id.viewPager);


        fragmentList.add(new CoffeeFragmentChild_1());
        fragmentList.add(new CoffeeFragmentChild_2());
        fragmentList.add(new CoffeeFragmentChild_3());
        titleList.add("小马");
        titleList.add("快快");
        titleList.add("过河");
      //  viewPager.setAdapter(new PagerAdapter(getChildFragmentManager(), fragmentList, titleList));
        viewPager.setAdapter(new PagerAdapter( fragmentList, titleList));
        pt = (PagerTabStrip) view.findViewById(R.id.pt);
        pt.setTabIndicatorColorResource(R.color.colorAccent);
    }


    @Override
    public void onPause() {

        super.onPause();

    }

    @Override
    public void onResume() {

        super.onResume();

    }

    /**
     * 定义适配器
     */
    class PagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragmentList;
        private List<String> titleList;

        public PagerAdapter( List<Fragment> fragmentList, List<String> titleList) {
            super(getFragmentManager());
            this.fragmentList = fragmentList;
            this.titleList = titleList;
        }

        /**
         * 得到每个页面
         */
        @Override
        public Fragment getItem(int arg0) {
            return (fragmentList == null || fragmentList.size() == 0) ? null : fragmentList.get(arg0);
        }

        /**
         * 每个页面的title
         */
        @Override
        public CharSequence getPageTitle(int position) {
            SpannableStringBuilder ssb = new SpannableStringBuilder(" "
                    + titleList.get(position)); // space added before text for
            ForegroundColorSpan fcs = new ForegroundColorSpan( 0xFFFF4081);//字体颜色设置为绿色
            ssb.setSpan(fcs, 1, ssb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);//设置字体颜色
            ssb.setSpan(new RelativeSizeSpan(1.2f), 1, ssb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            return ssb;

            // return (titleList.size() > position) ? titleList.get(position) : "";
        }

        /**
         * 页面的总个数
         */
        @Override
        public int getCount() {
            return fragmentList == null ? 0 : fragmentList.size();
        }
    }


}
