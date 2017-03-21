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

public abstract class LoadingPage extends FrameLayout {
    //加载状态
    private static final int LOAD_STATE_UNDO = 1;
    private static final int LOAD_STATE_LOADING = 2;
    private static final int LOAD_STATE_ERROR = 3;
    private static final int LOAD_STATE_EMPTY = 4;
    private static final int LOAD_STATE_SUCCESS = 5;

    private int mCurrentState = LOAD_STATE_UNDO;
    private View mLoadingPage;
    private View mErrorPage;
    private View mEmptyPage;
    private View mSuccessPage;

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
        //加载中的布局
        if (mLoadingPage == null) {
            mLoadingPage = UIUtils.inflate(R.layout.page_loading);
            addView(mLoadingPage);
        }

        if (mErrorPage == null) {
            mErrorPage = UIUtils.inflate(R.layout.pager_error);
            addView(mErrorPage);
        }

        if (mEmptyPage == null) {
            mEmptyPage = UIUtils.inflate(R.layout.pager_empty);
            addView(mEmptyPage);
        }

        showRightPage();

    }

    private void showRightPage() {
        mLoadingPage
                .setVisibility((mCurrentState == LOAD_STATE_UNDO || mCurrentState == LOAD_STATE_LOADING) ? View.VISIBLE : View.GONE);
        mErrorPage
                .setVisibility(mCurrentState == LOAD_STATE_ERROR ? View.VISIBLE : View.GONE);
        mEmptyPage
                .setVisibility(mCurrentState == LOAD_STATE_EMPTY ? View.VISIBLE : View.GONE);

        if (mSuccessPage == null && mCurrentState == LOAD_STATE_SUCCESS) {
            mSuccessPage = onCreateSuccessView();

            if (mSuccessPage != null) {
                addView(mSuccessPage);
            }
        }

        if (mSuccessPage != null) {
            mSuccessPage
                    .setVisibility(mCurrentState == LOAD_STATE_SUCCESS ? View.VISIBLE : View.GONE);
        }
    }

    //开始加载数据
    public void loadData() {
        if (mCurrentState != LOAD_STATE_LOADING) {
            mCurrentState = LOAD_STATE_LOADING;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final ResultState resultState = onLoad();

                    UIUtils.runOnUIThread(new Runnable() {
                        @Override
                        public void run() {
                            if (resultState != null) {
                                mCurrentState = resultState.getState();
                                showRightPage();
                            }
                        }
                    });
                }
            }).start();
        }
    }

    public abstract ResultState onLoad();

    public abstract View onCreateSuccessView();

    public enum ResultState {
        STATE_SUCCESS(LOAD_STATE_SUCCESS),
        STATE_EMPTY(LOAD_STATE_EMPTY),
        STATE_ERROR(LOAD_STATE_ERROR);

        private int state;

        ResultState(int state) {
            this.state = state;
        }

        public int getState() {
            return state;
        }
    }
}
