package com.xyh.mix.fragment;

import android.view.View;

import com.xyh.mix.view.LoadingPage;

/**
 * 扩展
 * Created by xyh on 2017/3/20.
 */
public class ExtendFragment extends BaseFragment {
    @Override
    public View onCreateSuccessView() {
        return null;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        return null;
    }
}
