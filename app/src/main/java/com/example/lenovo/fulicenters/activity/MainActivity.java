package com.example.lenovo.fulicenters.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;

import com.example.lenovo.fulicenters.R;
import com.example.lenovo.fulicenters.fragment.NewGoodsFragment;
import com.example.lenovo.fulicenters.utils.L;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {
    private final static String TAG = MainActivity.class.getSimpleName();
    RadioButton mLayoutNewGood;
    @BindView(R.id.layout_new_good)
    RadioButton layoutNewGood;
    @BindView(R.id.layout_boutique)
    RadioButton layoutBoutique;
    @BindView(R.id.layout_category)
    RadioButton layoutCategory;
    @BindView(R.id.layout_cart)
    RadioButton layoutCart;
    @BindView(R.id.layout_personal_center)
    RadioButton layoutPersonalCenter;
    int index;
    int currentIndex;
    Fragment[] mFragments;
    NewGoodsFragment mNewGoodsFragment;
    //BoutiqueFragment mBoutiqueFragment;
   // CategoryFragment mCategoryFragment;

    RadioButton[] rbs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        L.i("MainActivity");
        super.onCreate(savedInstanceState);
        setListener();



    }

    private void initFragment() {
        mFragments=new Fragment[5];
        mNewGoodsFragment=new NewGoodsFragment();
       // mBoutiqueFragment=new BoutiqueFragment();
        //mCategoryFragment=new CategoryFragment();
        mFragments[0]=mNewGoodsFragment;
       // mFragments[1]=mBoutiqueFragment;
       // mFragments[2]=mCategoryFragment;
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container,mNewGoodsFragment)
                //.add(R.id.fragment_container,mBoutiqueFragment)
                //.add(R.id.fragment_container,mCategoryFragment)
                //.hide(mBoutiqueFragment)
                //.hide(mCategoryFragment)
                .show(mNewGoodsFragment)
                .commit();
    }

    @Override
    protected  void setListener() {

    }

    @Override
    protected  void initView() {
        rbs=new RadioButton[5];
        rbs[0]=layoutNewGood;
        rbs[1]=layoutBoutique;
        rbs[2]=layoutCategory;
        rbs[3]=layoutCart;
        rbs[4]=layoutPersonalCenter;

    }

    @Override
    protected void initData() {
        initFragment();


    }

    public void onCheckedChange(View v) {
        switch (v.getId()){
            case R.id.layout_new_good:
                index=0;
                break;
            case R.id.layout_boutique:
                index=1;
                break;
            case R.id.layout_category:
                index=2;
                break;
            case R.id.layout_cart:
                index=3;
                break;
            case R.id.layout_personal_center:
                //if (FuLiCenterApplication.getUsername()==null){
                   // MFGT.gotoLogin(this);
                //}else {
                    index=4;
                //}
                break;
        }
        setmFragments();
    }
    private void setmFragments(){
        if (index!=currentIndex){
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.hide(mFragments[currentIndex]);
            if (!mFragments[index].isAdded()){
                ft.add(R.id.fragment_container,mFragments[index]);
            }
            ft.show(mFragments[index]).commit();

        }
        setRadioButtonStatus();
        currentIndex=index;
    }


    private void setRadioButtonStatus() {
        L.e("index="+index);
        for (int i=0;i<rbs.length;i++){
            if (i==index){
                rbs[i].setChecked(true);
            }else {
                rbs[i].setChecked(false);
            }
        }
    }
    public void onBackPressed(){
        finish();

    }
}
