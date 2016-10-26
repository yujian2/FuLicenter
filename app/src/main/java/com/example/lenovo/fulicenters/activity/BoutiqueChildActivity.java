package com.example.lenovo.fulicenters.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.lenovo.fulicenters.I;
import com.example.lenovo.fulicenters.R;
import com.example.lenovo.fulicenters.adapter.GoodsAdapter;
import com.example.lenovo.fulicenters.bean.BoutiqueBean;
import com.example.lenovo.fulicenters.bean.NewGoodsBean;
import com.example.lenovo.fulicenters.net.NetDao;
import com.example.lenovo.fulicenters.net.OkHttpUtils;
import com.example.lenovo.fulicenters.utils.CommonUtils;
import com.example.lenovo.fulicenters.utils.ConvertUtils;
import com.example.lenovo.fulicenters.utils.L;
import com.example.lenovo.fulicenters.utils.MFGT;
import com.example.lenovo.fulicenters.view.SpaceItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class BoutiqueChildActivity extends BaseActivity {


    BoutiqueChildActivity mContext;
    GoodsAdapter mAdapter;
    ArrayList<NewGoodsBean> mList;
    int pageId = 1;
    GridLayoutManager glm;
    BoutiqueBean boutique;
    @BindView(R.id.tv_common_title)
    TextView mtvCommonTitle;
    @BindView(R.id.tv_refresh)
    TextView mtvRefresh;
    @BindView(R.id.rvNewGoods)
    RecyclerView mrvNewGoods;
    @BindView(R.id.srl)
    SwipeRefreshLayout msrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_boutichild);
        ButterKnife.bind(this);
        boutique = (BoutiqueBean) getIntent().getSerializableExtra(I.Boutique.CAT_ID);
        if (boutique == null) {
            finish();
        }
        mContext = this;
        mList = new ArrayList<>();
        mAdapter = new GoodsAdapter(mContext, mList);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        msrl.setColorSchemeColors(
                getResources().getColor(R.color.google_blue),
                getResources().getColor(R.color.google_green),
                getResources().getColor(R.color.google_red),
                getResources().getColor(R.color.google_yellow)
        );
        glm = new GridLayoutManager(mContext, I.COLUM_NUM);
        mrvNewGoods.setLayoutManager(glm);
        mrvNewGoods.setHasFixedSize(true);
        mrvNewGoods.setAdapter(mAdapter);
        mrvNewGoods.addItemDecoration(new SpaceItemDecoration(12));
        mtvCommonTitle.setText(boutique.getTitle());
    }


    @Override
    protected void setListener() {
        setPullUpListener();
        setPullDownListener();
    }

    private void setPullDownListener() {
        msrl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                msrl.setRefreshing(true);
                mtvCommonTitle.setVisibility(View.VISIBLE);
                pageId = 1;
                downloadNewGoods(I.ACTION_PULL_DOWN);
            }
        });
    }

    private void downloadNewGoods(final int action) {
        NetDao.downloadNewGoods(mContext, boutique.getId(), pageId, new OkHttpUtils.OnCompleteListener<NewGoodsBean[]>() {
            @Override
            public void onSuccess(NewGoodsBean[] result) {
                msrl.setRefreshing(false);
                mtvCommonTitle.setVisibility(View.GONE);
                mAdapter.setMore(true);
                L.e("result=" + result);
                if (result != null && result.length > 0) {
                    ArrayList<NewGoodsBean> list = ConvertUtils.array2List(result);
                    if (action == I.ACTION_DOWNLOAD || action == I.ACTION_PULL_DOWN) {
                        mAdapter.initData(list);
                    } else {
                        mAdapter.addData(list);
                    }
                    if (list.size() < I.PAGE_SIZE_DEFAULT) {
                        mAdapter.setMore(false);
                    }
                } else {
                    mAdapter.setMore(false);
                }
            }

            @Override
            public void onError(String error) {
                msrl.setRefreshing(false);
                mtvCommonTitle.setVisibility(View.GONE);
                mAdapter.setMore(false);
                CommonUtils.showShortToast(error);
                L.e("error:" + error);
            }
        });
    }

    private void setPullUpListener() {
        mrvNewGoods.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastPosition = glm.findLastVisibleItemPosition();
                if (newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastPosition == mAdapter.getItemCount() - 1
                        && mAdapter.isMore()) {
                    pageId++;
                    downloadNewGoods(I.ACTION_PULL_UP);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int firstPosition = glm.findFirstVisibleItemPosition();
                msrl.setEnabled(firstPosition == 0);
            }
        });
    }

    @Override
    protected void initData() {
        downloadNewGoods(I.ACTION_DOWNLOAD);
    }

    @OnClick(R.id.backClickArea)
    public void onClick() {
        MFGT.finish(this);
    }
}