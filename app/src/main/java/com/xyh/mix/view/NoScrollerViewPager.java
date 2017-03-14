package com.xyh.mix.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by xyh on 2017/3/14.
 */

public class NoScrollerViewPager extends ViewPager {

    public NoScrollerViewPager(Context context) {
        super(context);
    }

    public NoScrollerViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //对滑动事件的禁用
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return true;
    }
}
