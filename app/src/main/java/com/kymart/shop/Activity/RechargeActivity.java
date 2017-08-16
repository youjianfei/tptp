package com.kymart.shop.Activity;


import android.view.View;
import android.widget.AbsListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import cn.kymart.tptp.R;

public class RechargeActivity extends BaseActivityother {

    private PullToRefreshListView mListview_recharge;
    private View headView;


    @Override
    public int setLayoutResID() {
        return R.layout.activity_recharge;
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
        mListview_recharge= (PullToRefreshListView) findViewById(R.id.listView_recharge);
        mListview_recharge.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);
        headView = getLayoutInflater().inflate(R.layout.headview_listviewrecharege, mListview_recharge, false);//填充头式图布局
        headView.setLayoutParams(layoutParams);
//        mTextview_yue= (TextView) headView.findViewById(R.id.textview_yue);
//        mtextview_mm= (TextView) headView.findViewById(R.id.textview_mm);
        mListview_recharge.getRefreshableView().addHeaderView(headView);//添加头式图；
    }
}
