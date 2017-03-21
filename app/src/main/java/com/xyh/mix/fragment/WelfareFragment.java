package com.xyh.mix.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.xyh.mix.Api;
import com.xyh.mix.R;
import com.xyh.mix.adapter.WelfareAdapter;
import com.xyh.mix.bean.WelfareBean;
import com.xyh.mix.utils.UIUtils;
import com.xyh.mix.view.LoadingPage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 福利
 * Created by xyh on 2017/3/20.
 */
public class WelfareFragment extends BaseFragment {

    private ArrayList<WelfareBean.WelfareDetail> mWelfares;
    private WelfareBean mData;

    @Override
    public View onCreateSuccessView() {
        initData();

        View view = View.inflate(UIUtils.getContext(), R.layout.page_recyclerview, null);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rl_news);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        WelfareAdapter adapter = new WelfareAdapter(mWelfares);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void initData() {
        getDataFromServer(Api.GANK_WELFARE);
        mWelfares = new ArrayList<>();
    }

    private void getDataFromServer(String str) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(Api.GANK_BASIC_URL + str)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Toast.makeText(UIUtils.getContext(), "请求失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String str = response.body().string();
                System.out.println("服务器返回结果" + str);

                processData(str);
            }
        });

    }

    private void processData(String json) {
        Gson gson = new Gson();
        mData = gson.fromJson(json, WelfareBean.class);
        System.out.println("解析结果:" + mData);
    }



    @Override
    public LoadingPage.ResultState onLoad() {
        return LoadingPage.ResultState.STATE_SUCCESS;
    }
}
