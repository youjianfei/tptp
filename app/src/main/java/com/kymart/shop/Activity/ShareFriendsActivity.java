package com.kymart.shop.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kymart.shop.Adapter.Adapter_shareFriend;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Bean.ShareFriends;
import com.kymart.shop.CustomView.MyListView;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.ToastUtils;
import com.kymart.shop.Utils.Volley_Utils;

import java.util.ArrayList;
import java.util.List;

import cn.kymart.tptp.R;

import static cn.kymart.tptp.R.id.manualOnly;
import static cn.kymart.tptp.R.id.textview_accountname;

public class ShareFriendsActivity extends BaseActivityother {
    TextView mTextview_name,mTextview_ID,mTextview_loadmore;

    List<ShareFriends.ListBean> mListData;
    Adapter_shareFriend mAdapter;
    MyListView myListview;




    @Override
    public int setLayoutResID() {
        return R.layout.activity_share_friends;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {
        mListData=new ArrayList<>();
        mAdapter=new Adapter_shareFriend(mListData,this);
        myListview.setAdapter(mAdapter);
        mTextview_ID.setText(Staticdata.personCenterBean.getResult().getOperator_status()==0? "会员ID:"+(Staticdata.personCenterBean.getResult().getUser_id() ):"会员ID:"+(Staticdata.personCenterBean.getResult().getUser_id())+"(运营商)");
        mTextview_name.setText(Staticdata.personCenterBean.getResult().getNickname());

        request(page);//请求hao友列表
    }

    @Override
    protected void initListener() {
        mTextview_loadmore.setOnClickListener(this);

    }

    @Override
    protected void initView() {
        mTextview_ID= (TextView) findViewById(R.id.textview_id);
        mTextview_name= (TextView) findViewById(textview_accountname);
        myListview= (MyListView) findViewById(R.id.myListview);
        mTextview_loadmore= (TextView) findViewById(R.id.textview_loadmore);
    }
    void request(int  P){
        String URL= BaseUrl.BaseURL+BaseUrl.shareFriend+Staticdata.userBean_static.getResult().getToken()+"&p="+P;
        LogUtils.LOG("ceshi","我分享好有"+URL);
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi","我分享好有"+respose);
                mListData.addAll( new Gson().fromJson(respose,ShareFriends.class).getList());
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(int error) {
                ToastUtils.showToast(ShareFriendsActivity.this,"网络开小差儿了");

            }
        }).Http(URL,this,0);

    }
        int   page=1;
    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.textview_loadmore:
                page++;
                request(page);

            break;
        }
    }
}
