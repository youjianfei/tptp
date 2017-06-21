package com.kymart.shop.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.Volley_Utils;

import cn.kymart.tptp.R;

public class AddressActivity extends BaseActivityother {
    TextView mTextview_addAddress;

    ListView mListview_address;


    @Override
    public int setLayoutResID() {
        return R.layout.activity_address;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {
        requestAddressList();

    }



    @Override
    protected void initListener() {
        mTextview_addAddress.setOnClickListener(this);

    }

    @Override
    protected void initView() {
        mTextview_addAddress= (TextView) findViewById(R.id.text_addAddress);
        mListview_address= (ListView) findViewById(R.id.listview_addressList);

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.text_addAddress:
                Intent intent=new Intent(this,AddAddressActivity.class);
                this.startActivity(intent);
                break;
        }
    }
    private void requestAddressList() {
        String URL_addressList= BaseUrl.BaseURL+BaseUrl.addressList+ Staticdata.UUID_static+"&token="+Staticdata.userBean_static.getResult().getToken();
        LogUtils.LOG("ceshi","addressList"+URL_addressList);
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi","addressList"+respose);

            }

            @Override
            public void onError(int error) {

            }
        }).Http(URL_addressList,this,0);


    }
}
