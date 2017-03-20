package com.xyh.mix.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xyh.mix.utils.UIUtils;
import com.xyh.mix.view.LoadingPage;

/**
 * Created by xyh on 2017/3/13.
 */

public abstract class BaseFragment extends Fragment {

    private LoadingPage mLoadingPage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mLoadingPage = new LoadingPage(UIUtils.getContext());

        return mLoadingPage;

    }

}
