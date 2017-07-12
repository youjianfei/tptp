package com.kymart.shop.Activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.alipay.sdk.app.Result;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.ToastUtils;
import com.kymart.shop.Utils.Volley_Utils;
import com.kymart.shop.class_.PayResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cn.kymart.tptp.R;

public class PayActivity extends BaseActivityother {
    String  orderNumber="",price="";
    TextView mTextview_number,mTextview_price;

    ImageView image_select_alipay,image_select_wechatpay;

    Button button_pay;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        Toast.makeText(PayActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        Toast.makeText(PayActivity.this, "支付失败", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }

                default:
                    break;
            }


        };
    };
    @Override
    public int setLayoutResID() {
        return R.layout.activity_pay;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {
        Intent intent=getIntent();
        orderNumber=intent.getStringExtra("ordernumber");
        price=intent.getStringExtra("price");
        LogUtils.LOG("ceshi","intend得到"+orderNumber+".."+price);
        mTextview_number.setText(orderNumber);
        mTextview_price.setText("￥"+price);
    }

    @Override
    protected void initListener() {
        image_select_alipay.setOnClickListener(this);
        image_select_wechatpay.setOnClickListener(this);
        button_pay.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        mTextview_number= (TextView) findViewById(R.id.text_ordernumber);
        mTextview_price= (TextView) findViewById(R.id.text_orderPrice);
        image_select_alipay= (ImageView) findViewById(R.id.seclect_alipay);
        image_select_wechatpay= (ImageView) findViewById(R.id.seclect_wechat);
        image_select_alipay.setSelected(true);
        button_pay= (Button) findViewById(R.id.button_submit);
    }
    int  pay=1;
    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.seclect_alipay:
                image_select_alipay.setSelected(true);
                image_select_wechatpay.setSelected(false);
                pay=1;
                break;
            case R.id.seclect_wechat:
                image_select_alipay.setSelected(false);
                image_select_wechatpay.setSelected(true);
                pay=2;
                break;
            case R.id.button_submit:
                Map map_pay=new HashMap();
                map_pay.clear();
                if(pay==1){
                    map_pay.put("order_sn",orderNumber);

                }else{
                    map_pay.put("master_order_sn",orderNumber);
                }
                requestPay(map_pay,pay);
                break;
        }
    }
    void  requestPay(Map map, final int pay){
        String URL= BaseUrl.BaseURL+BaseUrl.alipayPay+ Staticdata.userBean_static.getResult().getToken();
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                if(pay==1){
                    LogUtils.LOG("ceshi","支付宝"+respose);
                    JSONObject object = null;
                    try {
                        object = new JSONObject(respose);
                        int status = (Integer) object.get("status");
                        String  msg = (String) object.get("msg");
                        if(status==1){
                            String result=(String) object.get("result");
                            alipay_PAY(result);
                        }else{
                            ToastUtils.showToast(PayActivity.this,msg);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }


            }

            @Override
            public void onError(int error) {

            }
        }).postHttp(URL,this,1,map);


    }

    void alipay_PAY(String info){
        final String orderInfo = info;   // 订单信息

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(PayActivity.this);
                Map<String, String> result =  alipay.payV2(orderInfo,true);

                Message msg = new Message();
                msg.what = 1;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }
}
