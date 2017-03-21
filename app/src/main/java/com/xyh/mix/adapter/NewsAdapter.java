package com.xyh.mix.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xyh.mix.R;
import com.xyh.mix.bean.NewsBean;
import com.xyh.mix.utils.UIUtils;

import java.util.ArrayList;

/**
 * Created by xyh on 2017/3/21.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private ArrayList<NewsBean> mNews;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView newsTitle;

        public ViewHolder(View itemView) {
            super(itemView);

            newsTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public NewsAdapter(ArrayList<NewsBean> news) {
        mNews = news;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(UIUtils.getContext()).inflate(R.layout.page_item_news, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewsBean news = mNews.get(position);
        holder.newsTitle.setText(news.title);
    }

    @Override
    public int getItemCount() {
        return mNews.size();
    }
}
