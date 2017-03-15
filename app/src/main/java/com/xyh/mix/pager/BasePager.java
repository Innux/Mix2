package com.xyh.mix.pager;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by xyh on 2017/3/15.
 */

public abstract class BasePager {
    public Activity mActivity;
    public FrameLayout mFrameLayout;
    public View mRootView;

    public BasePager(Activity activity) {
        mActivity = activity;
        mRootView = initView();
    }

    public abstract View initView();

    public abstract void initData();

}
