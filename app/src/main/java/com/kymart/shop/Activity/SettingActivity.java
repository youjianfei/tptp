package com.kymart.shop.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.kymart.shop.Utils.ToastUtils;

import cn.kymart.tptp.R;

public class SettingActivity extends BaseActivityother {
    private EditText mEdit_nicheng,mEdit_oldpassword,mEdit_newpassword;
    private Button mButton_confirm_info,mButton_password;

    LinearLayout mLinearlayout_secret,mLinearlayout_man,mLinearlayout_women;

    String name="",oldpassword="",newpassword="";
    int sex=0;

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
                name=mEdit_nicheng.getText()+"";


                break;
            case R.id.button_confirm_password:
                oldpassword=mEdit_oldpassword.getText()+"";
                newpassword=mEdit_newpassword.getText()+"";
                if(!oldpassword.equals("")&&!newpassword.equals("")&&!oldpassword.equals(newpassword)){

                }else{
                    ToastUtils.showToast(this,"请填写完整或者两次密码相同");
                }

                break;
            case R.id.linearlayout_secret:
                setNoselect();
                mLinearlayout_secret.setSelected(true);
                sex=1;//保密

                break;
            case R.id.linearlayout_man:
                setNoselect();
                mLinearlayout_man.setSelected(true);
                sex=2;//男
                break;
            case R.id.linearlayout_women:
                setNoselect();
                mLinearlayout_women.setSelected(true);
                sex=3;//女
                break;
        }
    }
    void setNoselect(){
        mLinearlayout_secret.setSelected(false);
        mLinearlayout_man.setSelected(false);
        mLinearlayout_women.setSelected(false);
    }
}
