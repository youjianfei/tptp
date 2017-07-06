package com.kymart.shop.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.kymart.shop.AppStaticData.Staticdata;

import cn.kymart.tptp.R;

public class CashoutActivity extends BaseActivityother {


    private TextView textview_name,textview_ID;

    @Override
    public int setLayoutResID() {
        return R.layout.activity_cashout;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {
        textview_name.setText(Staticdata.personCenterBean.getResult().getNickname());
        textview_ID.setText(Staticdata.personCenterBean.getResult().getOperator_status()==0? "会员ID:"+(Staticdata.personCenterBean.getResult().getUser_id() ):"会员ID:"+(Staticdata.personCenterBean.getResult().getUser_id())+"(运营商)");

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        textview_name= (TextView) findViewById(R.id.textview_accountname);
        textview_ID= (TextView) findViewById(R.id.textview_id);
    }
}
