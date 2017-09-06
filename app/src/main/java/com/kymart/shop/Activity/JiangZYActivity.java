package com.kymart.shop.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.CodeUtils;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.ToastUtils;
import com.kymart.shop.Utils.Volley_Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cn.kymart.tptp.R;

import static cn.kymart.tptp.R.id.textview_accountname;

public class JiangZYActivity extends BaseActivityother {
    TextView mTextview_title,mTextview_money,mTextview_name,mTextview_ID,mTextview_type;
    Button mButton_submit;
    EditText mEdit_moneynumber;
    int  moneyNumber=0;
    String type="";
    @Override
    public int setLayoutResID() {
        return R.layout.activity_jiang_zy;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {
        Intent intent=getIntent();
        type=intent.getStringExtra("type");
        if(type.equals("youhuiquan")){
            mTextview_title.setText("优惠券转余额");
            mTextview_type.setText("优 惠 券:");
            mTextview_money.setText("￥"+Staticdata.personCenterBean.getResult().getBonus());

        }else {
            mTextview_title.setText("推广费用转余额");
            mTextview_type.setText("推广费用:");
            mTextview_money.setText("￥"+Staticdata.personCenterBean.getResult().getBonus1());

        }

        mTextview_name.setText(Staticdata.personCenterBean.getResult().getNickname());
        mTextview_ID.setText(Staticdata.personCenterBean.getResult().getOperator_status()==0? "会员ID:"+(Staticdata.personCenterBean.getResult().getUser_id() ):"会员ID:"+(Staticdata.personCenterBean.getResult().getUser_id())+"(运营商)");

    }

    @Override
    protected void initListener() {
        mButton_submit.setOnClickListener(this);

    }

    @Override
    protected void initView() {
//        mImageview_Code= (ImageView) findViewById(R.id.image_code);
        mTextview_type= (TextView) findViewById(R.id.textView_type);
        mTextview_title= (TextView) findViewById(R.id.text_title);
        mTextview_money= (TextView) findViewById(R.id.textview_money);
        mTextview_name= (TextView) findViewById(textview_accountname);
        mTextview_ID= (TextView) findViewById(R.id.textview_id);
        mButton_submit= (Button) findViewById(R.id.button_submit);
        mEdit_moneynumber= (EditText) findViewById(R.id.editText_moneynumber);
//        mEdit_QRcode= (EditText) findViewById(R.id.edit_QRcode);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
//            case R.id.image_code:
////                mImageview_Code.setImageBitmap(CodeUtils.getInstance().createBitmap());
//                LogUtils.LOG("ceshi",CodeUtils.getInstance().getCode());
//                break;
            case R.id.button_submit:
                String money=mEdit_moneynumber.getText()+"";
                if(money.equals("")){
                    ToastUtils.showToast(this,"输入金额有误!");
                    return;
                }else {
                    moneyNumber=Integer.parseInt(mEdit_moneynumber.getText()+"");
                }
                if(moneyNumber<1){
                    ToastUtils.showToast(this,"输入金额有误!");
                    return;
                }
//                QRcode=mEdit_QRcode.getText()+"";
//                if(!QRcode.equals(CodeUtils.getInstance().getCode())){
//                    ToastUtils.showToast(this,"请输入正确的验证码!");
//                    return;
//                }

                LogUtils.LOG("ceshi","一切输入正确!");
                jzyMap.put("money",moneyNumber+"");
                request(jzyMap);
                break;

        }
    }
    Map jzyMap=new HashMap();
    void  request(Map map ){
        String  URL="";
        if(type.equals("youhuiquan")){
           URL = BaseUrl.BaseURL+BaseUrl.JiangJZY+Staticdata.UUID_static+"&token="+Staticdata.userBean_static.getResult().getToken();
        }else{
            URL = BaseUrl.BaseURL+BaseUrl.TuiguangZY+Staticdata.UUID_static+"&token="+Staticdata.userBean_static.getResult().getToken();
        }
        new  Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi","一切输入正确!"+respose);
                try {
                    JSONObject jo = new JSONObject(respose);
                    int  status = (Integer)jo.get("status");
                    String message=(String)jo.get("msg");
                    if(status==-1){
                        ToastUtils.showToast(JiangZYActivity.this,message);
                        return;
                    }else{
                        ToastUtils.showToast(JiangZYActivity.this,"操作成功");
                        finish();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

//


            }

            @Override
            public void onError(int error) {

            }
        }).postHttp(URL,this,1,map);


    }
}
