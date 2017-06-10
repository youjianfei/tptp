package com.kymart.shop.Activity;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RelativeLayout;

import com.kymart.shop.Fragment.Fragment_classification;
import com.kymart.shop.Fragment.Fragment_main;
import cn.kymart.tptp.R;
import com.kymart.shop.Utils.LogUtils;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    /**
     * 下面按钮
     */
    private RelativeLayout mRelativeLayout_main;
    private RelativeLayout mRelativeLayout_classification;
    private RelativeLayout mRelativeLayout_ShoppingCar;
    private RelativeLayout mRelativeLayout_mine;

    /**
     * 四个Fragment
     */
    Fragment_main mFragment_main;
    Fragment_classification mFragment_classification;

    FragmentManager fragmetnmanager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListenner();
        setView();
        setData();


    }

    private void initListenner() {
        mRelativeLayout_main.setOnClickListener(this);
        mRelativeLayout_classification.setOnClickListener(this);
        mRelativeLayout_ShoppingCar.setOnClickListener(this);
        mRelativeLayout_mine.setOnClickListener(this);

    }

    private void setData() {
    }

    private void setView() {
        fragmetnmanager = getSupportFragmentManager();
        transaction = fragmetnmanager.beginTransaction();
        transaction.add(R.id.fl_main, mFragment_main).commit();

    }

    private void initData() {
        mFragment_main = new Fragment_main();
    }

    private void initView() {
        //主页下面按钮
        mRelativeLayout_main = (RelativeLayout) findViewById(R.id.rl_1);
        mRelativeLayout_classification = (RelativeLayout) findViewById(R.id.rl_2);
        mRelativeLayout_ShoppingCar = (RelativeLayout) findViewById(R.id.rl_3);
        mRelativeLayout_mine = (RelativeLayout) findViewById(R.id.rl_4);

    }

    @Override
    public void onClick(View view) {
        transaction = fragmetnmanager.beginTransaction();
        hideFragments(transaction);//隐藏所有Fragment,需要哪个显示哪一个
        switch (view.getId()) {
            case R.id.rl_1:
                ChangeBottomButton(mRelativeLayout_main);
                if (mFragment_main == null) {
                    mFragment_main = new Fragment_main();
                    transaction.add(R.id.fl_main, mFragment_main).commit();
                } else {
                    transaction.show(mFragment_main).commit();
                }
                break;
            case R.id.rl_2:
                ChangeBottomButton(mRelativeLayout_classification);
                if(mFragment_classification==null){
                    mFragment_classification=new Fragment_classification();
                    transaction.add(R.id.fl_main, mFragment_classification).commit();
                }else{
                    transaction.show(mFragment_classification).commit();
                }
                break;
            case R.id.rl_3:
                ChangeBottomButton(mRelativeLayout_ShoppingCar);

                break;
            case R.id.rl_4:
                ChangeBottomButton(mRelativeLayout_mine);

                break;

        }

    }

    private void hideFragments(FragmentTransaction transaction) {//隐藏Fragment,以便点击时展映相应的Fragment
        if (mFragment_main != null) {
            transaction.hide(mFragment_main);
        }
        if (mFragment_classification != null) {
            transaction.hide(mFragment_classification);
        }
    }

    private void ChangeBottomButton(RelativeLayout rl) {//控制底部按钮颜色的变化
        LogUtils.LOG("ceshi", "底部按钮颜色改变");
        mRelativeLayout_main.getChildAt(0).setSelected(false);
        mRelativeLayout_main.getChildAt(1).setSelected(false);
        mRelativeLayout_classification.getChildAt(0).setSelected(false);
        mRelativeLayout_classification.getChildAt(1).setSelected(false);
        mRelativeLayout_ShoppingCar.getChildAt(0).setSelected(false);
        mRelativeLayout_ShoppingCar.getChildAt(1).setSelected(false);
        mRelativeLayout_mine.getChildAt(0).setSelected(false);
        mRelativeLayout_mine.getChildAt(1).setSelected(false);
        rl.getChildAt(0).setSelected(true);
        rl.getChildAt(1).setSelected(true);
    }
}
