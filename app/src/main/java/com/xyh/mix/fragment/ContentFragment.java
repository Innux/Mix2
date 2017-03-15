package com.xyh.mix.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.xyh.mix.R;
import com.xyh.mix.pager.BasePager;
import com.xyh.mix.pager.ExplorePager;
import com.xyh.mix.pager.NewsPager;
import com.xyh.mix.pager.SettingPager;
import com.xyh.mix.pager.SocialPager;

import java.util.ArrayList;

/**
 * Created by xyh on 2017/3/13.
 */

public class ContentFragment extends BaseFragment {
    private ViewPager mViewPager;
    private ArrayList<BasePager> mPagers;
    private RadioGroup mRadioGroup;

    @Override
    public void initData() {
        mPagers = new ArrayList<BasePager>();
        mPagers.add(new NewsPager(mActivity));
        mPagers.add(new ExplorePager(mActivity));
        mPagers.add(new SocialPager(mActivity));
        mPagers.add(new SettingPager(mActivity));

        mViewPager.setAdapter(new ContentAdapter());

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rbtn_news:
                        mViewPager.setCurrentItem(0, false);
                        break;
                    case R.id.rbtn_explore:
                        mViewPager.setCurrentItem(1, false);
                        break;
                    case R.id.rbtn_social:
                        mViewPager.setCurrentItem(2, false);
                        break;
                    case R.id.rbtn_settings:
                        mViewPager.setCurrentItem(3, false);
                        break;
                    default:
                        break;
                }
            }
        });

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                BasePager pager = mPagers.get(position);
                pager.initData();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //手动加载第一页数据
        mPagers.get(0).initData();

    }

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_content, null);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_content);
        mRadioGroup = (RadioGroup) view.findViewById(R.id.rg_group);

        return view;
    }

    private class ContentAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return mPagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager basePager = mPagers.get(position);
            View view = basePager.mRootView;
            container.addView(view);

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
