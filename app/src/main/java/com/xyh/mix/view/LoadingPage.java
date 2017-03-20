package com.xyh.mix.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.xyh.mix.R;
import com.xyh.mix.utils.UIUtils;

/**
 * Created by xyh on 2017/3/20.
 */

public class LoadingPage extends FrameLayout {
    //加载状态
    private static final int LOAD_STATE_UNDO = 1;
    private static final int LOAD_STATE_LOADING = 2;
    private static final int LOAD_STATE_ERROR = 3;
    private static final int LOAD_STATE_EMPTY = 4;
    private static final int LOAD_STATE_SUCCESS = 5;

    private int mCurrentState = LOAD_STATE_UNDO;
    private View mLoadingPage;

    public LoadingPage(Context context) {
        super(context);
        initView();
    }

    public LoadingPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();

    }

    public LoadingPage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        //出事话加载中的布局
        if (mLoadingPage == null) {
            mLoadingPage = UIUtils.inflate(R.layout.page_loading);
            addView(mLoadingPage);
        }
    }
}
