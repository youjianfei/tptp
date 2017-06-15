package com.kymart.shop.Activity;

import android.app.ProgressDialog;
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
import com.kymart.shop.Utils.SharedPreferencesUtils;
import com.kymart.shop.Utils.ToastUtils;
import com.kymart.shop.Utils.Volley_Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cn.kymart.tptp.R;

import static com.kymart.shop.AppStaticData.Staticdata.UUID_static;
import static com.kymart.shop.AppStaticData.Staticdata.userBean_static;

public class LoginActivity extends BaseActivityother {
    private EditText mEdit_account,mEdit_password;
    private Button mButton_login;
    private TextView mTextview_Registered,mTextview_findpassword;

    String mob;
    String password;


    UserBean userbean;

    ProgressDialog pd;


    @Override
    public int setLayoutResID() {
        return R.layout.activity_login;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {
        pd = new ProgressDialog(LoginActivity.this);
        pd.setMessage("正在登录");
        pd.setCanceledOnTouchOutside(false);

        mob=SharedPreferencesUtils.getString(this,"kymt","account");
        password=SharedPreferencesUtils.getString(this,"kymt","password");
        mEdit_account.setText(mob);
        mEdit_password.setText(password);

    }

    @Override
    protected void initListener() {
        mButton_login.setOnClickListener(this);
        mTextview_Registered.setOnClickListener(this);
        mTextview_findpassword.setOnClickListener(this);

    }

    @Override
    protected void initView() {
        mEdit_account= (EditText) findViewById(R.id.edit_account);
        mEdit_password= (EditText) findViewById(R.id.edit_password);
        mButton_login= (Button) findViewById(R.id.button_login);
        mTextview_Registered= (TextView) findViewById(R.id.text_Registered);
        mTextview_findpassword= (TextView) findViewById(R.id.text_Forgetpassword);

    }


    Map<String, String> map;
    String UUID="";
    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.button_login:
                pd.show();
                mob = mEdit_account.getText() + "";
                password = mEdit_password.getText() + "";
                 map = new HashMap<String, String>();
                map.put("username", mob);
                map.put("password", password);
                LogUtils.LOG("ceshi",mob+"..."+password);
                UUID = InstalltionId.id(LoginActivity.this);
                UUID_static=UUID;//将UUID添加全局变量
                request_imageCode(UUID);
                break;
            case R.id.text_Registered:
                Intent intent=new Intent(this,RegisteredActivity.class);
                startActivity(intent);

                break;
            case R.id.text_Forgetpassword:
                Intent intent2=new Intent(this,FindPasswordActivity.class);
                startActivity(intent2);

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
                if (pd.isShowing()) {
                    pd.dismiss();
                }
            }
        }).Http(BaseUrl.BaseURL+BaseUrl.image_code+uuid,this,0);
    }
    void requestlogin(Map map){//登录请求\


        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                int  status=0;
                String msg="";
                try {
                    JSONObject object=new JSONObject(respose);
                      status = (Integer) object.get("status");//登录状态
                        msg = (String) object.get("msg");//登录返回信息
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if(status==1){
                    userbean= new  Gson().fromJson(respose,UserBean.class);
                    LogUtils.LOG("ceshi","登录成功"+respose);
                    userBean_static=userbean;//将用户信息写入全局变量
                    //记住帐号密码,下次自动登录
                    SharedPreferencesUtils.putString(LoginActivity.this,"kymt","account", mEdit_account.getText() + "");
                    SharedPreferencesUtils.putString(LoginActivity.this,"kymt","password", mEdit_password.getText() + "");
                    Staticdata.isLogin=1;
                    setResult(RESULT_OK);
                    finish();
                }else{
                    ToastUtils.showToast(LoginActivity.this,msg);
                    if (pd.isShowing()) {
                        pd.dismiss();
                    }
                }
            }

            @Override
            public void onError(int error) {
                if (pd.isShowing()) {
                    pd.dismiss();
                }

            }
        }).postHttp(BaseUrl.BaseURL+BaseUrl.login,this,1,map);



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (pd.isShowing()) {
            pd.dismiss();
        }
    }
}
