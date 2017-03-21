package com.xyh.mix.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xyh.mix.R;
import com.xyh.mix.bean.WelfareBean;
import com.xyh.mix.utils.UIUtils;

import java.util.ArrayList;

/**
 * Created by xyh on 2017/3/21.
 */

public class WelfareAdapter extends RecyclerView.Adapter<WelfareAdapter.ViewHolder> {

    private ArrayList<WelfareBean.WelfareDetail> mWelfares;


    public ImageView mImageView;

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_welfare);
            mImageView = (ImageView) itemView.findViewById(R.id.img_welfare);
        }

    }

    public WelfareAdapter(ArrayList<WelfareBean.WelfareDetail> welfares) {
        mWelfares = welfares;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(UIUtils.getContext()).inflate(R.layout.page_item_welfare, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        WelfareBean.WelfareDetail welfareDetail = mWelfares.get(position);
        holder.mTextView.setText(welfareDetail.source);
        //Picasso.with(context).load("http://i.imgur.com/1opCuAV.jpg").into(imageView);
        Picasso.with(UIUtils.getContext()).load(welfareDetail.url);
    }


    @Override
    public int getItemCount() {
        return mWelfares.size();
    }
}
