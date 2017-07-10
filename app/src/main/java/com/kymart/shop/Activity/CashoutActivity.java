package com.kymart.shop.Activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Utils.CodeUtils;
import com.kymart.shop.Utils.LogUtils;

import cn.kymart.tptp.R;

public class CashoutActivity extends BaseActivityother {


    private TextView textview_name,textview_ID;

    private ImageView mImage_Code;

    @Override
    public int setLayoutResID() {
        return R.layout.activity_cashout;
    }

    @Override
    protected void setData() {
        mImage_Code.setImageBitmap(CodeUtils.getInstance().createBitmap());
        LogUtils.LOG("ceshi",CodeUtils.getInstance().getCode());
    }

    @Override
    protected void initData() {
        textview_name.setText(Staticdata.personCenterBean.getResult().getNickname());
        textview_ID.setText(Staticdata.personCenterBean.getResult().getOperator_status()==0? "会员ID:"+(Staticdata.personCenterBean.getResult().getUser_id() ):"会员ID:"+(Staticdata.personCenterBean.getResult().getUser_id())+"(运营商)");

    }

    @Override
    protected void initListener() {
        mImage_Code.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        textview_name= (TextView) findViewById(R.id.textview_accountname);
        textview_ID= (TextView) findViewById(R.id.textview_id);
        mImage_Code= (ImageView) findViewById(R.id.image_code);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.image_code:
                mImage_Code.setImageBitmap(CodeUtils.getInstance().createBitmap());
                LogUtils.LOG("ceshi",CodeUtils.getInstance().getCode());
                break;
        }
    }
}
