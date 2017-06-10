package com.kymart.shop.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.kymart.shop.Fragment.Fragment_GoodDatails_good;

import cn.kymart.tptp.R;

public class GoodDetailsActivity extends BaseActivityother {
    /**
     * Fragment
     * @return
     */
    Fragment_GoodDatails_good fragment_goodDatails_good;

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

    }

    @Override
    protected void initView() {
        fragment_goodDatails_good=new Fragment_GoodDatails_good();
        fragmetnmanager = getFragmentManager();
        transaction = fragmetnmanager.beginTransaction();
        transaction.add(R.id.fragment_goodDetails,fragment_goodDatails_good).commit();
    }
}
