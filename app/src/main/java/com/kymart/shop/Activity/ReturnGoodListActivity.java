package com.kymart.shop.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import cn.kymart.tptp.R;

public class ReturnGoodListActivity extends BaseActivityother {

    private PullToRefreshListView mlistview_returen_goods;


    @Override
    public int setLayoutResID() {
        return R.layout.activity_return_good_list;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mlistview_returen_goods.setOnClickListener(this);
        mlistview_returen_goods.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });
    }

    @Override
    protected void initView() {
        mlistview_returen_goods= (PullToRefreshListView) findViewById(R.id.listView_returngoods);
    }
}
