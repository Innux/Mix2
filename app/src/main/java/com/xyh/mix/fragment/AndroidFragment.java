package com.xyh.mix.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.xyh.mix.R;
import com.xyh.mix.adapter.NewsAdapter;
import com.xyh.mix.bean.NewsBean;
import com.xyh.mix.utils.UIUtils;
import com.xyh.mix.view.LoadingPage;

import java.util.ArrayList;

/**
 * android
 * Created by xyh on 2017/3/20.
 */
public class AndroidFragment extends BaseFragment {

    private ArrayList<NewsBean> mNews = new ArrayList<>();

    @Override
    public View onCreateSuccessView() {

        View view = View.inflate(UIUtils.getContext(), R.layout.page_recyclerview, null);
        initNews();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rl_news);
        LinearLayoutManager manager = new LinearLayoutManager(UIUtils.getContext());
        recyclerView.setLayoutManager(manager);
        NewsAdapter adapter = new NewsAdapter(mNews);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void initNews() {
        for (int i = 0; i < 100; i++) {
            NewsBean news1 = new NewsBean();
            news1.title = "title 1";
            mNews.add(news1);

            NewsBean news2 = new NewsBean();
            news2.title = "title 2";
            mNews.add(news2);

            NewsBean news3 = new NewsBean();
            news3.title = "title 3";
            mNews.add(news3);
        }
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        return LoadingPage.ResultState.STATE_SUCCESS;
    }
}
