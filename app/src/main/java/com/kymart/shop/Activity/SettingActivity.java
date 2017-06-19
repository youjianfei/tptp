package com.kymart.shop.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import cn.kymart.tptp.R;

public class SettingActivity extends BaseActivityother {
    private EditText mEdit_nicheng,mEdit_oldpassword,mEdit_newpassword;
    private Button mButton_confirm_info,mButton_password;

    LinearLayout mLinearlayout_secret,mLinearlayout_man,mLinearlayout_women;

    @Override
    public int setLayoutResID() {
        return R.layout.activity_setting;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mButton_confirm_info.setOnClickListener(this);
        mButton_password.setOnClickListener(this);
        mLinearlayout_secret.setOnClickListener(this);
        mLinearlayout_man.setOnClickListener(this);
        mLinearlayout_women.setOnClickListener(this);

    }

    @Override
    protected void initView() {
        mEdit_nicheng= (EditText) findViewById(R.id.edit_name);
        mEdit_oldpassword= (EditText) findViewById(R.id.edit_oldpassword);
        mEdit_newpassword= (EditText) findViewById(R.id.edit_newpassword);
        mButton_confirm_info= (Button) findViewById(R.id.button_confirm_info);
        mButton_password= (Button) findViewById(R.id.button_confirm_password);
        mLinearlayout_secret= (LinearLayout) findViewById(R.id.linearlayout_secret);
        mLinearlayout_man= (LinearLayout) findViewById(R.id.linearlayout_man);
        mLinearlayout_women= (LinearLayout) findViewById(R.id.linearlayout_women);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.button_confirm_info:

                break;
            case R.id.button_confirm_password:

                break;
            case R.id.linearlayout_secret:
                setNoselect();
                mLinearlayout_secret.setSelected(true);

                break;
            case R.id.linearlayout_man:
                setNoselect();
                mLinearlayout_man.setSelected(true);

                break;
            case R.id.linearlayout_women:
                setNoselect();
                mLinearlayout_women.setSelected(true);
                break;
        }
    }
    void setNoselect(){
        mLinearlayout_secret.setSelected(false);
        mLinearlayout_man.setSelected(false);
        mLinearlayout_women.setSelected(false);
    }
}
