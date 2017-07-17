package com.kymart.shop.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.kymart.shop.Adapter.Adapter_classification_right_list;
import com.kymart.shop.Bean.Classification_rightBean;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.Volley_Utils;

import java.util.ArrayList;
import java.util.List;

import cn.kymart.tptp.R;

public class FenLeiActivity extends BaseActivityother {

    int id=0;
    private ListView mListview_right;//分类  右边的列表
    private List<Classification_rightBean.ResultEntity> mData_right;//分类  右边的列表的数据
    private Adapter_classification_right_list Adapter_right;

    @Override
    public int setLayoutResID() {
        return R.layout.activity_fen_lei;
    }

    @Override
    protected void setData() {
        requestDataRight(id);
    }

    @Override
    protected void initData() {
        Intent intent=getIntent();
        id=intent.getIntExtra("ID",0);

        mData_right = new ArrayList<>();
        Adapter_right = new Adapter_classification_right_list(mData_right, this);
        mListview_right.setAdapter(Adapter_right);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        mListview_right = (ListView) findViewById(R.id.listview_right);
    }
    private void requestDataRight(int id) {//请求右边
        // 列表数据的网络请求
        LogUtils.LOG("ceshi", "点击" + id+"...."+BaseUrl.BaseURL + BaseUrl.classificationright + id);
        String URL = BaseUrl.BaseURL + BaseUrl.classificationright + id;
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                mData_right.clear();
                mData_right.addAll(new Gson().fromJson(respose, Classification_rightBean.class).getResult());
                Adapter_right.notifyDataSetChanged();
            }

            @Override
            public void onError(int error) {

            }
        }).Http(URL, this, 0);
    }

}
