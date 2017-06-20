package com.kymart.shop.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.ToastUtils;
import com.kymart.shop.Utils.Volley_Utils;

import java.util.HashMap;
import java.util.Map;

import cn.kymart.tptp.R;

public class SettingActivity extends BaseActivityother {
    private EditText mEdit_nicheng,mEdit_oldpassword,mEdit_newpassword;
    private Button mButton_confirm_info,mButton_password;

    LinearLayout mLinearlayout_secret,mLinearlayout_man,mLinearlayout_women;

    String name="",oldpassword="",newpassword="";
    int sex=0;
    Map nikeMap;
    Map passwordMap;

    @Override
    public int setLayoutResID() {
        return R.layout.activity_setting;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {
        nikeMap= new HashMap();//修改昵称的map
        passwordMap= new HashMap();//修改密码的map
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

        mLinearlayout_secret.setSelected(true);//默认性别保密
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.button_confirm_info:
                name=mEdit_nicheng.getText()+"";
                if(!name.equals("")){
                    nikeMap.put("nickname",name);
                    request_changeNike(nikeMap);
                }else{
                    ToastUtils.showToast(this,"昵称不能为空！");
                }


                break;
            case R.id.button_confirm_password:
                oldpassword=mEdit_oldpassword.getText()+"";
                newpassword=mEdit_newpassword.getText()+"";
                if(!oldpassword.equals("")&&!newpassword.equals("")&&!oldpassword.equals(newpassword)){
                    passwordMap.put("old_password",oldpassword);
                    passwordMap.put("new_password",newpassword);
                    request_changePassword(passwordMap);
                }else{
                    ToastUtils.showToast(this,"没有填写完整或者两次密码相同");
                }

                break;
            case R.id.linearlayout_secret:
                setNoselect();
                mLinearlayout_secret.setSelected(true);
                sex=0;//保密
                nikeMap.put("sex","0");

                break;
            case R.id.linearlayout_man:
                setNoselect();
                mLinearlayout_man.setSelected(true);
                sex=1;//男
                nikeMap.put("sex","1");
                break;
            case R.id.linearlayout_women:
                setNoselect();
                mLinearlayout_women.setSelected(true);
                sex=2;//女
                nikeMap.put("sex","2");
                break;
        }
    }
    void setNoselect(){
        mLinearlayout_secret.setSelected(false);
        mLinearlayout_man.setSelected(false);
        mLinearlayout_women.setSelected(false);
    }
    void request_changeNike(Map nMap){
        String Url= BaseUrl.BaseURL+BaseUrl.changeUserInfo+ Staticdata.UUID_static+"&token="+Staticdata.userBean_static.getResult().getToken();
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                ToastUtils.showToast(SettingActivity.this,"昵称修改成功！");
            }

            @Override
            public void onError(int error) {

            }
        }).postHttp(Url,this,1,nMap);


    }
    void request_changePassword(Map pMap){
        String URL=BaseUrl.BaseURL+BaseUrl.changeUserPassword+ Staticdata.UUID_static+"&token="+Staticdata.userBean_static.getResult().getToken();
        new  Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {

                ToastUtils.showToast(SettingActivity.this,"密码修改成功！");
            }

            @Override
            public void onError(int error) {

            }
        }).postHttp(URL,this,1,pMap);
    }
}
