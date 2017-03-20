package com.xyh.mix.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xyh.mix.utils.UIUtils;

/**
 * Created by xyh on 2017/3/13.
 */

public abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//         使用textview显示当前类的类名
         TextView view = new TextView(UIUtils.getContext());
         view.setText(getClass().getSimpleName());

        return view;

    }

}
