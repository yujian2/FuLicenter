package com.example.lenovo.fulicenters.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.lenovo.fulicenters.I;
import com.example.lenovo.fulicenters.R;
import com.example.lenovo.fulicenters.utils.L;


public class GoodsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        int goodsID = getIntent().getIntExtra(I.GoodsDetails.KEY_GOODS_ID,0);
        L.e("details","goodsid="+goodsID);
    }
}
