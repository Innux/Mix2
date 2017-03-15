package com.xyh.mix.utils;

import android.content.Context;

/**
 * Created by xyh on 2017/3/15.
 */

public class CacheUtil {
    public static void setCache(String url, String json, Context context) {
        SharedPreUtils.setString(context, url, json);
    }

    public static String getCache(String url, Context context) {
        return SharedPreUtils.getString(context, url, null);
    }
}
