package com.kymart.shop.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kymart.shop.Utils.LogUtils;

import cn.kymart.tptp.R;

public class PayActivity extends BaseActivityother {
    String  orderNumber="",price="";
    TextView mTextview_number,mTextview_price;

    ImageView image_select_alipay,image_select_wechatpay;

    @Override
    public int setLayoutResID() {
        return R.layout.activity_pay;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {
        Intent intent=getIntent();
        orderNumber=intent.getStringExtra("ordernumber");
        price=intent.getStringExtra("price");
        LogUtils.LOG("ceshi","intend得到"+orderNumber+".."+price);
        mTextview_number.setText(orderNumber);
        mTextview_price.setText("￥"+price);
    }

    @Override
    protected void initListener() {
        image_select_alipay.setOnClickListener(this);
        image_select_wechatpay.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        mTextview_number= (TextView) findViewById(R.id.text_ordernumber);
        mTextview_price= (TextView) findViewById(R.id.text_orderPrice);
        image_select_alipay= (ImageView) findViewById(R.id.seclect_alipay);
        image_select_wechatpay= (ImageView) findViewById(R.id.seclect_wechat);
        image_select_alipay.setSelected(true);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.seclect_alipay:
                image_select_alipay.setSelected(true);
                image_select_wechatpay.setSelected(false);
                break;
            case R.id.seclect_wechat:
                image_select_alipay.setSelected(false);
                image_select_wechatpay.setSelected(true);
                break;
        }
    }
}
