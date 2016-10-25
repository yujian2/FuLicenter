package com.example.lenovo.fulicenters.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.lenovo.fulicenters.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FooterViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tvFooter)
    public TextView mTvFooter;

    public FooterViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}