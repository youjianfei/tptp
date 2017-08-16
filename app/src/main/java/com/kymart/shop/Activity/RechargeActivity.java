package com.kymart.shop.Activity;



import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
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

public class RechargeActivity extends BaseActivityother {

    Button button_recharge;


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
                        Toast.makeText(RechargeActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        Toast.makeText(RechargeActivity.this, "支付失败", Toast.LENGTH_SHORT).show();
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
        return R.layout.activity_recharge;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        button_recharge.setOnClickListener(this);

    }

    @Override
    protected void initView() {
        button_recharge= (Button) findViewById(R.id.button_recharge);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.button_recharge:
                LogUtils.LOG("ceshi","支付宝充值点击");
                    Map map_pay=new HashMap();
                    map_pay.put("user_id",Staticdata.userBean_static.getResult().getUser_id()+"");//支付宝参数
                    map_pay.put("amount","0.1");//支付宝参数
                    requestAlipayPay(map_pay);
                break;
        }
    }

    void  requestAlipayPay(Map map){//请求支付宝订单
        String URL= BaseUrl.BaseURL+BaseUrl.alipayPay_recharge+"&user_id="+Staticdata.userBean_static.getResult().getUser_id()+"&amount="+"0.1";
        LogUtils.LOG("ceshi","支付宝充值"+URL);
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
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
                        ToastUtils.showToast(RechargeActivity.this,msg);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(int error) {

            }
        }).Http(URL,this,0);
    }

    void alipay_PAY(String info){//调用支付宝
        final String orderInfo = info;   // 订单信息

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(RechargeActivity.this);
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
