package com.xyh.mix.fragment;

import android.view.View;

import com.xyh.mix.view.LoadingPage;

/**
 * Created by xyh on 2017/3/20.
 */
public class WelfareFragment extends BaseFragment {
    @Override
    public View onCreateSuccessView() {
        return null;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        return LoadingPage.ResultState.STATE_ERROR;
    }
}
