package com.kymart.shop.Activity;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.InstalltionId;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.ToastUtils;
import com.kymart.shop.Utils.Volley_Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import cn.kymart.tptp.R;

public class RegisteredActivity extends BaseActivityother {
    TextView mtextview_yanzhengma;
    EditText mEdit_account,mEdit_password,mEdit_pasagain,mEdit_yanzhengma;
    Button mButton_register;

    String UUID="";
    String mob="",password="",pasAgain="",yanzhengma="";
    Map map;
    @Override
    public int setLayoutResID() {
        return R.layout.activity_registered;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {
        UUID = InstalltionId.id(RegisteredActivity.this);

    }

    @Override
    protected void initListener() {
        mtextview_yanzhengma.setOnClickListener(this);
        mButton_register.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        mtextview_yanzhengma = (TextView) findViewById(R.id.textview_yanzhengma);
        mEdit_account= (EditText) findViewById(R.id.edittext_phonenumber);
        mEdit_password= (EditText) findViewById(R.id.edit_pas);
        mEdit_pasagain= (EditText) findViewById(R.id.pas_again);
        mEdit_yanzhengma= (EditText) findViewById(R.id.edit_yanzhengma);
        mButton_register= (Button) findViewById(R.id.button_register);

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){

            case R.id.textview_yanzhengma://点击获取验证码
                mob=mEdit_account.getText()+"";
                if(mob.equals("")){
                    ToastUtils.showToast(this,"请输入正确的手机号");
                    return;
                }

                requestImgCode(UUID);
                timer = new Timer();
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        mhandler.sendEmptyMessage(0);
                    }
                };
                timer.schedule(timerTask, 0, 1000);
                mtextview_yanzhengma.setEnabled(false);
                break;
            case R.id.button_register://点击注册按钮
                yanzhengma=mEdit_yanzhengma.getText()+"";
                if(yanzhengma.equals("")){
                    ToastUtils.showToast(this,"请输入正确的验证码");
                    return;
                }
                password=mEdit_password.getText()+"";
                pasAgain=mEdit_pasagain.getText()+"";
                if(pasAgain.equals(password)&&!pasAgain.equals("")){
                    map.put("username",mob);
                    map.put("password",password);
                    map.put("code",yanzhengma);

                    requestRegister(map);
                }else{
                    ToastUtils.showToast(this,"两次密码不一致");
                    return;
                }



                break;
        }

    }
    void requestImgCode(final String uuid){//请求图片验证码
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                map=new HashMap();
                try {

                    JSONObject jsonObject = new JSONObject(respose);
                    String result=  jsonObject.getString("result");
                    map.put("capache",result);
                    map.put("mobile",mob);
                    map.put("unique_id",uuid);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                requestMessageCode(map);//请求短信验证码
            }

            @Override
            public void onError(int error) {
                ToastUtils.showToast(RegisteredActivity.this,"请输入正确的手机号");

            }
        }).Http(BaseUrl.BaseURL+BaseUrl.image_code+uuid,this,0);
    }
    void requestMessageCode(Map map){//发送短信验证码
        new  Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {

            }

            @Override
            public void onError(int error) {
                ToastUtils.showToast(RegisteredActivity.this,"请输入正确的手机号");
            }
        }).postHttp(BaseUrl.BaseURL+BaseUrl.messageCode,this,1,map);
    }
    void requestRegister(Map map){//注册按钮点击
        new  Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {

                LogUtils.LOG("ceshi","注册成功"+respose);
                finish();

            }

            @Override
            public void onError(int error) {

            }
        }).postHttp(BaseUrl.BaseURL+BaseUrl.register,this,1,map);

    }

    int time = 60;
    Timer timer;
    private Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    mtextview_yanzhengma.setTextColor(getResources().getColor(R.color.LightGrey));
                    mtextview_yanzhengma.setText("   " + time + "s");
                    time--;
                    if (time == 0) {
                        timer.cancel();
                        mtextview_yanzhengma.setText("获取验证码");
                        mtextview_yanzhengma.setTextColor(getResources().getColor(R.color.red));
                        mtextview_yanzhengma.setEnabled(true);
                        time = 60;
                    }
                    break;
            }
        }


    };








}
