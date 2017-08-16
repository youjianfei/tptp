package com.kymart.shop.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.kymart.shop.Adapter.Adapter_list_money;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Bean.MoneyBean;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.Volley_Utils;

import java.util.ArrayList;
import java.util.List;

import cn.kymart.tptp.R;

public class MoneyActivity extends BaseActivityother {

    private TextView mTextview_title,mtextview_mm, mTextview_yue;
    private View headView;
    private PullToRefreshListView mListview_money;
    List<MoneyBean.ResultBean >  mListdata;
    String yue="";
    int  TAG=0;

    private Adapter_list_money mAdapter;

    @Override
    public int setLayoutResID() {
        return R.layout.activity_money;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {
        Intent intend_money=getIntent();
        yue= intend_money.getStringExtra("yue");
        TAG=intend_money.getIntExtra("id",0);
        if(TAG==1){
            mTextview_title.setText("我的钱包");
            mtextview_mm.setText("账户余额");
            URL= BaseUrl.BaseURL+BaseUrl.money+ Staticdata.UUID_static+"&token="+Staticdata.userBean_static.getResult().getToken();
        }else{
            mTextview_title.setText("优惠券明细");
            mtextview_mm.setText("优惠券");
            URL= BaseUrl.BaseURL+BaseUrl.bonus+ Staticdata.UUID_static+"&token="+Staticdata.userBean_static.getResult().getToken();
        }
        mTextview_yue.setText(yue);
        mListdata=new ArrayList<>();
        mAdapter=new Adapter_list_money(mListdata,this,TAG);
        mListview_money.setAdapter(mAdapter);

        request_money(URL,1);

    }
    String URL;
    int  page=1;
    private void request_money(String mURL,int page) {
        mURL=mURL+"&page="+page;
        LogUtils.LOG("ceshi",mURL);
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi",respose);
                mListdata.addAll(new Gson().fromJson(respose,MoneyBean.class).getResult());
                mAdapter.notifyDataSetChanged();
                mListview_money.onRefreshComplete();
            }

            @Override
            public void onError(int error) {

            }
        }).Http(mURL,this,0);
    }

    @Override
    protected void initListener() {
        mListview_money.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {//监听listview 刷新
                page++;
                request_money(URL,page);

            }
        });
    }

    @Override
    protected void initView() {
        mTextview_title= (TextView) findViewById(R.id.textview_title);

        mListview_money= (PullToRefreshListView) findViewById(R.id.listView_money);
        mListview_money.setMode(PullToRefreshBase.Mode.PULL_FROM_END);

        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);
        headView = getLayoutInflater().inflate(R.layout.headview_listviewmoney, mListview_money, false);//填充头式图布局
        headView.setLayoutParams(layoutParams);
        mTextview_yue= (TextView) headView.findViewById(R.id.textview_yue);
        mtextview_mm= (TextView) headView.findViewById(R.id.textview_mm);
        mListview_money.getRefreshableView().addHeaderView(headView);//添加头式图；

    }
}
