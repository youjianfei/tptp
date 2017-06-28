package com.kymart.shop.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
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

    private TextView mTextview_title, mTextview_yue;
    private ListView mListview_money;
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
            URL= BaseUrl.BaseURL+BaseUrl.money+ Staticdata.UUID_static+"&token="+Staticdata.userBean_static.getResult().getToken();
        }else{
            mTextview_title.setText("奖金明细");
            URL= BaseUrl.BaseURL+BaseUrl.bonus+ Staticdata.UUID_static+"&token="+Staticdata.userBean_static.getResult().getToken();
        }
        mTextview_yue.setText(yue);
        mListdata=new ArrayList<>();
        mAdapter=new Adapter_list_money(mListdata,this,TAG);
        mListview_money.setAdapter(mAdapter);

        request_money(URL);

    }
    String URL;
    private void request_money(String URL) {
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi",respose);
                mListdata.clear();
                mListdata.addAll(new Gson().fromJson(respose,MoneyBean.class).getResult());
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(int error) {

            }
        }).Http(URL,this,0);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        mTextview_title= (TextView) findViewById(R.id.textview_title);
        mTextview_yue= (TextView) findViewById(R.id.textview_yue);
        mListview_money= (ListView) findViewById(R.id.listView_money);

    }
}
