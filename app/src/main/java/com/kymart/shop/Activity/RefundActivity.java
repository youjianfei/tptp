package com.kymart.shop.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Bean.OrderDetailsBean;
import com.kymart.shop.CustomView.CustomerScrollView;
import com.kymart.shop.CustomView.MyGridView;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.SizeUtils;
import com.kymart.shop.Utils.ToastUtils;
import com.kymart.shop.Utils.Volley_Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.kymart.tptp.R;

public class RefundActivity extends BaseActivityother {
    private CustomerScrollView customerScrollView;
    private TextView textview_goodname,textview_goodprice,textview_num;
    Button mButton_return;
    private EditText editText_gooderro;
    private ImageView mImageview;
    Map refoundmap;
    String des;



    @Override
    public int setLayoutResID() {
        return R.layout.activity_refund;
    }

    @Override
    protected void setData() {


    }

    @Override
    protected void initData() {
        refoundmap=new HashMap();
        Glide.with(this).load(BaseUrl.Baseimage+Staticdata.refoundBean.getGoods_id()).into(mImageview);
        textview_goodname.setText(Staticdata.refoundBean.getGoods_name());
        textview_goodprice.setText("￥"+Staticdata.refoundBean.getGoods_price());
        textview_num.setText("×"+Staticdata.refoundBean.getGoods_num());


    }

    @Override
    protected void initListener() {
        mButton_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                des=editText_gooderro.getText()+"";
                if(des.equals("")){
                    ToastUtils.showToast(RefundActivity.this,"请详细描述申请退款原因");
                    return;
                }
                refoundmap.put("goods_id",Staticdata.refoundBean.getGoods_id()+"");
                refoundmap.put("order_sn",Staticdata.refoundBean.getOrder_sn());
                refoundmap.put("order_id",Staticdata.refoundBean.getOrder_id()+"");
                refoundmap.put("spec_key",Staticdata.refoundBean.getSpec_key());
                refoundmap.put("goods_num",Staticdata.refoundBean.getGoods_num()+"");
                refoundmap.put("reason",des);
                new  Volley_Utils(new Interface_volley_respose() {
                    @Override
                    public void onSuccesses(String respose) {
                        int  status=0;
                        String msg="";
                        try {
                            JSONObject object=new JSONObject(respose);
                            status = (Integer) object.get("status");
                            msg = (String) object.get("msg");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        ToastUtils.showToast(RefundActivity.this,msg);
                    }

                    @Override
                    public void onError(int error) {

                    }
                }).postHttp(BaseUrl.BaseURL+BaseUrl.refound+Staticdata.userBean_static.getResult().getToken(),RefundActivity.this,1,refoundmap);

            }
        });

    }

    @Override
    protected void initView() {
        customerScrollView= (CustomerScrollView) findViewById(R.id.CustomerScrollView);
        textview_goodname= (TextView) findViewById(R.id.textview_goodname);
        mButton_return= (Button) findViewById(R.id.button_return);
        editText_gooderro= (EditText) findViewById(R.id.textview_errostate);
        textview_goodprice= (TextView) findViewById(R.id.textview_goodsprice);
        mImageview= (ImageView) findViewById(R.id.image_goodsppic);
        textview_num= (TextView) findViewById(R.id.textview_number);
    }
}
