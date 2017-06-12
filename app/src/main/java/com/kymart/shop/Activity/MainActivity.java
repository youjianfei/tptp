package com.kymart.shop.Activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RelativeLayout;

import com.kymart.shop.Fragment.Fragment_classification;
import com.kymart.shop.Fragment.Fragment_main;
import cn.kymart.tptp.R;

import com.kymart.shop.Fragment.Fragment_personalCenter;
import com.kymart.shop.Fragment.Fragment_shopCar;
import com.kymart.shop.Utils.LogUtils;

import static com.kymart.shop.AppStaticData.Staticdata.isLogin;

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
    Fragment_shopCar mFragment_shopCar;
    Fragment_personalCenter mFragment_personalCenter;

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
        ChangeBottomButton(mRelativeLayout_main);
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
                if(mFragment_shopCar==null){
                    mFragment_shopCar=new Fragment_shopCar();
                    transaction.add(R.id.fl_main,mFragment_shopCar).commit();
                }else{
                    transaction.show(mFragment_shopCar).commit();
                }

                break;
            case R.id.rl_4:
                if(isLogin==1){//登录状态
                    ChangeBottomButton(mRelativeLayout_mine);
                    if(mFragment_personalCenter==null){
                        mFragment_personalCenter=new Fragment_personalCenter();
                        transaction.add(R.id.fl_main,mFragment_personalCenter).commit();
                    }else{
                        transaction.show(mFragment_personalCenter).commit();
                    }
                }else{//未登录状态
                    Intent intent=new Intent(this,LoginActivity.class);
                    startActivityForResult(intent,0);
                }

                break;

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case RESULT_OK://登录成功打开我的界面的 Fragment
                ChangeBottomButton(mRelativeLayout_mine);
                transaction = fragmetnmanager.beginTransaction();
                hideFragments(transaction);
                if(mFragment_personalCenter==null){
                    mFragment_personalCenter=new Fragment_personalCenter();
                    transaction.add(R.id.fl_main,mFragment_personalCenter).commit();
                }else{
                    transaction.show(mFragment_personalCenter).commit();
                }
                break;
            default:
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
        if (mFragment_shopCar != null) {
            transaction.hide(mFragment_shopCar);
        }
        if (mFragment_personalCenter != null) {
            transaction.hide(mFragment_personalCenter);
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
