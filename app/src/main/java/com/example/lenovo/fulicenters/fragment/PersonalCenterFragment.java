package com.example.lenovo.fulicenters.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.fulicenters.FuLiCenterApplication;
import com.example.lenovo.fulicenters.R;
import com.example.lenovo.fulicenters.activity.MainActivity;
import com.example.lenovo.fulicenters.bean.User;
import com.example.lenovo.fulicenters.utils.ImageLoader;
import com.example.lenovo.fulicenters.utils.L;
import com.example.lenovo.fulicenters.utils.MFGT;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by clawpo on 2016/10/24.
 */

public class PersonalCenterFragment extends BaseFragment {
    private static final String TAG = PersonalCenterFragment.class.getSimpleName();
    @BindView(R.id.iv_user_avatar)
    ImageView mIvUserAvatar;
    @BindView(R.id.tv_user_name)
    TextView mTvUserName;

    MainActivity mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_personal_center, container, false);
        ButterKnife.bind(this, layout);
        mContext = (MainActivity) getActivity();
        super.onCreateView(inflater, container, savedInstanceState);
        return layout;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        User user = FuLiCenterApplication.getUser();
        L.e(TAG, "user=" + user);
        if (user == null) {
            MFGT.gotoLogin(mContext);
        } else {
            ImageLoader.setAvatar(ImageLoader.getAvatarUrl(user), mContext, mIvUserAvatar);
            mTvUserName.setText(user.getMuserNick());
        }
    }

    @Override
    protected void setListener() {

    }

    @OnClick({R.id.tv_center_settings,R.id.iv_user_avatar})
    public void onClick() {
        MFGT.gotoSettings(mContext);
    }
}