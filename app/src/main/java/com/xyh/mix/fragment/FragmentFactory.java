package com.xyh.mix.fragment;

import java.util.HashMap;

/**
 * Created by xyh on 2017/3/20.
 */

public class FragmentFactory {
    private static HashMap<Integer, BaseFragment> mFragmentMap = new HashMap<Integer, BaseFragment>();

    public static BaseFragment createFragment(int pos) {
        BaseFragment fragment = mFragmentMap.get(pos);

        if (fragment == null) {
            switch (pos) {
                case 0:
                    fragment = new WelfareFragment();
                    break;
                case 1:
                    fragment = new AndroidFragment();
                    break;
                case 2:
                    fragment = new iOSFragment();
                    break;
                case 3:
                    fragment = new ExtendFragment();
                    break;
                case 4:
                    fragment = new FrontFragment();
                    break;
                default:
                    break;
            }

            mFragmentMap.put(pos, fragment);// 将fragment保存在集合中
        }

        return fragment;
    }
}
