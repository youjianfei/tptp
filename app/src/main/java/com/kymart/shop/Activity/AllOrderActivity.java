package com.kymart.shop.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import cn.kymart.tptp.R;

public class AllOrderActivity extends BaseActivityother {
    private RelativeLayout mRelativeLayout_allOrder,mRelativelayout_noPay,mRelativelayout_noConsigment,mRelativelayout_noAccepty,mRelativeLayout_noAssess;



    @Override
    public int setLayoutResID() {
        return R.layout.activity_all_order;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mRelativeLayout_allOrder.setOnClickListener(this);
        mRelativelayout_noPay.setOnClickListener(this);
        mRelativelayout_noConsigment.setOnClickListener(this);
        mRelativelayout_noAccepty.setOnClickListener(this);
        mRelativeLayout_noAssess.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        mRelativeLayout_allOrder= (RelativeLayout) findViewById(R.id.RelativeLayout_AllOrder);
        mRelativelayout_noPay= (RelativeLayout) findViewById(R.id.RelativeLayout_NoPay);
        mRelativelayout_noConsigment= (RelativeLayout) findViewById(R.id.RelativeLayout_NoConsignment);
        mRelativelayout_noAccepty= (RelativeLayout) findViewById(R.id.RelativeLayout_NoAccept);
        mRelativeLayout_noAssess= (RelativeLayout) findViewById(R.id.RelativeLayout_NoAssess);
        mRelativeLayout_allOrder.setSelected(true);//初始 全部订单  设为选中
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        initButton();
        switch (v.getId()){
            case R.id.RelativeLayout_AllOrder:
                mRelativeLayout_allOrder.setSelected(true);


            break;
            case R.id.RelativeLayout_NoPay:
                mRelativelayout_noPay.setSelected(true);

            break;
            case R.id.RelativeLayout_NoConsignment:
                mRelativelayout_noConsigment.setSelected(true);

            break;
            case R.id.RelativeLayout_NoAccept:
                mRelativelayout_noAccepty.setSelected(true);

            break;
            case R.id.RelativeLayout_NoAssess:
                mRelativeLayout_noAssess.setSelected(true);

            break;

        }

    }
    void initButton() {
        mRelativeLayout_allOrder.setSelected(false);
        mRelativelayout_noPay.setSelected(false);
        mRelativelayout_noConsigment.setSelected(false);
        mRelativelayout_noAccepty.setSelected(false);
        mRelativeLayout_noAssess.setSelected(false);

    }
}
