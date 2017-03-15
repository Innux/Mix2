package com.xyh.mix.pager;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.xyh.mix.R;

/**
 * Created by xyh on 2017/3/15.
 */

public class ExplorePager extends BasePager {
    public ExplorePager(Activity activity) {
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
        System.out.println("加载发现页面");
        TextView textView = new TextView(mActivity);
        textView.setText("发现");
        textView.setGravity(Gravity.CENTER);

        mFrameLayout.addView(textView);
    }
}
