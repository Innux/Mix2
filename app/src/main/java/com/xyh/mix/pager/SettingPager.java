package com.xyh.mix.pager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.xyh.mix.R;

/**
 * Created by xyh on 2017/3/15.
 */

public class SettingPager extends BasePager {
    public SettingPager(Activity activity) {
        super(activity);
    }

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.base_pager, null);
        mFrameLayout = (FrameLayout) view.findViewById(R.id.fl_pager_content);
        return view;
    }

    @Override
    public void initData() {
        System.out.println("加载设置页面");
        TextView textView = new TextView(mActivity);
        textView.setText("设置");
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);


        mFrameLayout.addView(textView);
    }
}
