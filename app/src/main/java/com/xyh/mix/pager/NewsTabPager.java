package com.xyh.mix.pager;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by xyh on 2017/3/15.
 */

public class NewsTabPager {
    public Activity mActivity;
    public View mRootView;// 菜单详情页根布局

    public NewsTabPager(Activity activity) {
        mActivity = activity;
        mRootView = initView();
    }

    // 初始化布局,必须子类实现
    public View initView() {
        TextView textView = new TextView(mActivity);
        textView.setText("发现");
        textView.setGravity(Gravity.CENTER);

        return textView;
    }

    // 初始化数据
    public void initData() {

    }
}
