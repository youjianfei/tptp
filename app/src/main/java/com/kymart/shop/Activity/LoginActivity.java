package com.kymart.shop.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Bean.UserBean;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.InstalltionId;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.Volley_Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cn.kymart.tptp.R;

import static com.kymart.shop.AppStaticData.Staticdata.userBean_static;

public class LoginActivity extends BaseActivityother {
    private EditText mEdit_account,mEdit_password;
    private Button mButton_login;
    private TextView mTextview_Registered;

    String mob;
    String password;


    UserBean userbean;


    @Override
    public int setLayoutResID() {
        return R.layout.activity_login;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mButton_login.setOnClickListener(this);
        mTextview_Registered.setOnClickListener(this);

    }

    @Override
    protected void initView() {
        mEdit_account= (EditText) findViewById(R.id.edit_account);
        mEdit_password= (EditText) findViewById(R.id.edit_password);
        mButton_login= (Button) findViewById(R.id.button_login);
        mTextview_Registered= (TextView) findViewById(R.id.text_Registered);

    }


    Map<String, String> map;
    String UUID="";
    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.button_login:
                mob = mEdit_account.getText() + "";
                password = mEdit_password.getText() + "";
                 map = new HashMap<String, String>();
                map.put("username", mob);
                map.put("password", password);
                LogUtils.LOG("ceshi",mob+"..."+password);
                UUID = InstalltionId.id(LoginActivity.this);
                request_imageCode(UUID);
                break;
            case R.id.text_Registered:
                Intent intent=new Intent(this,RegisteredActivity.class);
                startActivity(intent);

                break;
        }
    }
    void request_imageCode(String uuid){
        new  Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi1","图形验证码"+respose);
                try {

                    JSONObject jsonObject = new JSONObject(respose);
                    String result=  jsonObject.getString("result");
                    map.put("unique_id", UUID);
                    map.put("capache", result);
                    map.put("capapush_id", "");
                    LogUtils.LOG("ceshi",UUID+"..."+result);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                requestlogin(map);

            }

            @Override
            public void onError(int error) {

            }
        }).Http(BaseUrl.BaseURL+BaseUrl.image_code+uuid,this,0);
    }
    void requestlogin(Map map){//登录请求\


        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                userbean= new  Gson().fromJson(respose,UserBean.class);
                userBean_static=userbean;//将用户信息写入全局变量
                Staticdata.isLogin=1;
                setResult(RESULT_OK);
                finish();
            }

            @Override
            public void onError(int error) {

            }
        }).postHttp(BaseUrl.BaseURL+BaseUrl.login,this,1,map);



    }
}
