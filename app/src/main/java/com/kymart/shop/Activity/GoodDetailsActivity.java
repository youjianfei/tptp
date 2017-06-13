package com.kymart.shop.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.kymart.shop.Fragment.Fragment_GoodDatails_good;
import com.kymart.shop.Fragment.Fragment_GoodDetails_web;
import com.kymart.shop.Utils.LogUtils;

import cn.kymart.tptp.R;

public class GoodDetailsActivity extends BaseActivityother {
    int ID=0;

    /**
     * Fragment
     * @return
     */
    public static GoodDetailsActivity goodDetailsActivity;

   public  Fragment_GoodDatails_good fragment_goodDatails_good;
    public Fragment_GoodDetails_web  fragment_goodDetails_web;


    private TextView mTextview_produce;
    private TextView mTextview_produceWeb;

    FragmentManager fragmetnmanager;
    FragmentTransaction transaction;


    @Override
    public int setLayoutResID() {
        return R.layout.activity_good_details;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initListener() {
        mTextview_produce.setOnClickListener(this);
        mTextview_produceWeb.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        goodDetailsActivity=this;
        Intent intent=getIntent();
        ID= intent.getIntExtra("ID",0);

        mTextview_produce= (TextView) findViewById(R.id.text_produce);
        mTextview_produceWeb= (TextView) findViewById(R.id.text_produceWeb);


        fragment_goodDatails_good=new Fragment_GoodDatails_good(ID);
        fragmetnmanager = getFragmentManager();
        transaction = fragmetnmanager.beginTransaction();
        transaction.add(R.id.fragment_goodDetails,fragment_goodDatails_good).commit();
    }

    @Override
    public void onClick(View v) {
        transaction = fragmetnmanager.beginTransaction();
        hideFragments(transaction);//隐藏所有Fragment,需要哪个显示哪一个
        super.onClick(v);
        switch (v.getId()){
            case R.id.text_produce:
                LogUtils.LOG("ceshi","qqqqqqqqqqqqqqq");
                mTextview_produce.setTextColor(getResources().getColor(R.color.white));
                mTextview_produceWeb.setTextColor(getResources().getColor(R.color.blank));
                if (fragment_goodDatails_good == null) {
                    fragment_goodDatails_good = new Fragment_GoodDatails_good(ID);
                    transaction.add(R.id.fragment_goodDetails, fragment_goodDatails_good).commit();
                } else {

                    transaction.show(fragment_goodDatails_good).commit();
                }
                break;

            case R.id.text_produceWeb:
                mTextview_produce.setTextColor(getResources().getColor(R.color.blank));
                mTextview_produceWeb.setTextColor(getResources().getColor(R.color.white));
                if (fragment_goodDetails_web == null) {
                    fragment_goodDetails_web = new Fragment_GoodDetails_web(ID);
                    transaction.add(R.id.fragment_goodDetails, fragment_goodDetails_web).commit();
                } else {
                    transaction.show(fragment_goodDetails_web).commit();
                }


                break;
        }
    }
    private void hideFragments(FragmentTransaction transaction) {//隐藏Fragment,以便点击时展映相应的Fragment
        LogUtils.LOG("ceshi","wwwwwwwwwwwwwwwwww");
        if (fragment_goodDatails_good != null) {
            transaction.hide(fragment_goodDatails_good);
        }
        if (fragment_goodDetails_web != null) {
            transaction.hide(fragment_goodDetails_web);
        }

    }
}
