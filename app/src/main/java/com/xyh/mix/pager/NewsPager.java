package com.xyh.mix.pager;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.xyh.mix.Api;
import com.xyh.mix.R;
import com.xyh.mix.bean.ClassifyBean;
import com.xyh.mix.utils.CacheUtil;

import java.io.IOException;

/**
 * Created by xyh on 2017/3/15.
 */

public class NewsPager extends BasePager {

    private ViewPager mViewPager;

    public NewsPager(Activity activity) {
        super(activity);
    }

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.pager_news, null);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_pager_news);

        return view;
    }

    @Override
    public void initData() {
        String cache = CacheUtil.getCache(Api.TIANGOU_CLASSIFY, mActivity);

        if (!TextUtils.isEmpty(cache)) {
            System.out.print("发现缓存.......");
            processData(cache);
        }
        getDataFromServer();
    }

    private void getDataFromServer() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(Api.TIANGOU_CLASSIFY)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Toast.makeText(mActivity, "请求失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String str =response.body().string();
                //TODO 数据测试
                System.out.println("服务器返回结果" + str);
                processData(str);
                //TODO 写缓存
                CacheUtil.setCache(Api.TIANGOU_CLASSIFY, str, mActivity);
            }
        });
    }

    private void processData(String json) {
        Gson gson = new Gson();
        ClassifyBean data = gson.fromJson(json, ClassifyBean.class);
        System.out.println("解析结果:" + data);
    }

    class NewsPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return null;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
