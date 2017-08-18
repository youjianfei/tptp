package com.kymart.shop.Activity;



import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.google.gson.Gson;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Bean.WechatPayBean;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.ToastUtils;
import com.kymart.shop.Utils.Volley_Utils;
import com.kymart.shop.class_.PayResult;
import com.kymart.shop.class_.PopWindowClass;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cn.kymart.tptp.R;

public class RechargeActivity extends BaseActivityother {
    LinearLayout linearLayout_main;

    TextView mtexyview_yue;
    String yue="";
    Button button_recharge;
    PopupWindow mPopwinsow_recharge;

    private WebView webView_recharge;

    private IWXAPI api;


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
        webview_show();
    }

    @Override
    protected void initData() {
        api = WXAPIFactory.createWXAPI(this, "wxcf54c829295655ba");
        Intent intent=getIntent();
        yue= intent.getStringExtra("yue");
        mtexyview_yue.setText(yue);
    }

    @Override
    protected void initListener() {
        button_recharge.setOnClickListener(this);

    }

    @Override
    protected void initView() {
        mtexyview_yue= (TextView) findViewById(R.id.textview_yue);
        linearLayout_main= (LinearLayout) findViewById(R.id.activity_recharge);
        button_recharge= (Button) findViewById(R.id.button_recharge);
        webView_recharge= (WebView) findViewById(R.id.webview_recharge);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.button_recharge:
                initpopwindow_recharge();

                break;
        }
    }
    void webview_show(){
        webView_recharge.setVerticalScrollbarOverlay(true);
        //设置WebView支持JavaScript
        webView_recharge.getSettings().setJavaScriptEnabled(true);

        String url = BaseUrl.recharge_jilu+Staticdata.userBean_static.getResult().getToken();
        webView_recharge.loadUrl(url);
        WebSettings settings = webView_recharge.getSettings();

        // 设置缩放级别
        settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        // 支持缩放
        settings.setSupportZoom(true);
        // 设置网页中可执行javascript代码
        settings.setJavaScriptEnabled(true);
        // 将网页内容以单列显示
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView_recharge.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                webView_recharge.loadUrl(url);

                return true;
            }


        });

    }
    int  recharge_money=0;
    int recharge=3;
    public void initpopwindow_recharge(){
        View popview = getLayoutInflater().inflate(R.layout.popwindow_recharge, null, false);
        mPopwinsow_recharge = new PopupWindow(popview, ViewGroup.LayoutParams.WRAP_CONTENT , ViewGroup.LayoutParams.WRAP_CONTENT, true);
        mPopwinsow_recharge.setBackgroundDrawable(getResources().getDrawable(R.drawable.pop_background));// 设置背景图片，不能在布局中设置，要通过代码来设置
        mPopwinsow_recharge.setOutsideTouchable(true);// 触摸popupwindow外部，popupwindow消失
        mPopwinsow_recharge.setAnimationStyle(R.style.popwindow_anim_style); // 设置动画
        mPopwinsow_recharge.showAtLocation(linearLayout_main, Gravity.CENTER, 0, 0);//定位pop位置
        setAlpha((float) 0.3);
        final EditText editText_money= (EditText) popview.findViewById(R.id.editText_moneynumber);
        Button  mButtonset= (Button) popview.findViewById(R.id.button_set);
        Button mButtoncancel= (Button) popview.findViewById(R.id.button_cancel);
        final ImageView image_select_alipay,image_select_wechatpay,image_select_kuaiqian;
        image_select_alipay= (ImageView)popview. findViewById(R.id.seclect_alipay);
        image_select_wechatpay= (ImageView) popview.findViewById(R.id.seclect_wechat);
        image_select_kuaiqian= (ImageView) popview.findViewById(R.id.seclect_kuaiqian);
        image_select_kuaiqian.setSelected(true);
        image_select_alipay.setOnClickListener(new View.OnClickListener() {//选择支付宝监听
            @Override
            public void onClick(View v) {//支付宝充值
                image_select_alipay.setSelected(true);
                image_select_wechatpay.setSelected(false);
                image_select_kuaiqian.setSelected(false);
                recharge=1;
            }
        });
        image_select_wechatpay.setOnClickListener(new View.OnClickListener() {//选择微信监听
            @Override
            public void onClick(View v) {//微信充值
                image_select_alipay.setSelected(false);
                image_select_wechatpay.setSelected(true);
                image_select_kuaiqian.setSelected(false);
                recharge=2;

            }
        });
        image_select_kuaiqian.setOnClickListener(new View.OnClickListener() {//选择快钱监听
            @Override
            public void onClick(View v) {//块钱充值
                image_select_alipay.setSelected(false);
                image_select_wechatpay.setSelected(false);
                image_select_kuaiqian.setSelected(true);
                recharge=3;

            }
        });
        mButtonset.setOnClickListener(new View.OnClickListener() {//点击确定
            @Override
            public void onClick(View v) {
                String edit=editText_money.getText()+"";
                if(!edit.equals("")){
                    recharge_money= Integer.parseInt(editText_money.getText()+"");
                    LogUtils.LOG("ceshi","充值金额"+recharge_money);
                    if(recharge==1){
                        Map map_pay=new HashMap();
                        map_pay.put("user_id",Staticdata.userBean_static.getResult().getUser_id()+"");//支付宝参数
                        map_pay.put("amount",recharge_money+"");//支付宝参数
                        requestAlipayPay(map_pay);
                        mPopwinsow_recharge.dismiss();
                    }
                    if(recharge==2){
                        Map map_pay=new HashMap();
                        map_pay.put("user_id",Staticdata.userBean_static.getResult().getUser_id()+"");//支付宝参数
                        map_pay.put("amount",recharge_money+"");
                        requestWechatPay(map_pay);
                    }
                    if(recharge==3){
                        requestQuaiqianPay(recharge_money);
                        mPopwinsow_recharge.dismiss();
                    }
                }else{
                    ToastUtils.showToast(getApplicationContext(),"请输入正确的金额");
                }



            }
        });
        mButtoncancel.setOnClickListener(new View.OnClickListener() {//点击取消
            @Override
            public void onClick(View v) {
                mPopwinsow_recharge.dismiss();

            }
        });
        mPopwinsow_recharge.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setAlpha((float) 1);
            }
        });
    }
    void  requestAlipayPay(Map map){//请求支付宝订单
        String URL= BaseUrl.BaseURL+BaseUrl.alipayPay_recharge;
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
        }).postHttp(URL,this,1,map);
    }
    void  requestQuaiqianPay(int  amount){//请求快钱充值网址
        String URL= BaseUrl.BaseURL+BaseUrl.kuaiqianrecharge+"&user_id="+Staticdata.userBean_static.getResult().getUser_id()+"&amount="+amount;
        LogUtils.LOG("ceshi","快钱URL"+URL);
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi","快钱"+respose);
                JSONObject object = null;
                try {
                    object = new JSONObject(respose);
                    int status = (Integer) object.get("status");
                    if(status==1){
                        String  url = (String) object.get("url");
                        LogUtils.LOG("ceshi","快钱"+url);
//                        popWindowClass.initpopwindow();
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url);
                        intent.setData(content_url);
                        startActivity(intent);

                    }else{
                        String  msg = (String) object.get("msg");
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
    WechatPayBean weBean;
    void requestWechatPay(Map map){//请求微信订单
        String URL=BaseUrl.BaseURL+BaseUrl.wechat_recharge;
        LogUtils.LOG("ceshi","weixin充值"+URL);
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi","weixin"+respose);
                weBean=new Gson().fromJson(respose,WechatPayBean.class);
                String appid=weBean.getResult().getAppid();
                String noncestr=weBean.getResult().getNoncestr();
                String packagex=weBean.getResult().getPackageX();
                String partnerid=weBean.getResult().getPartnerid();
                String timeStamp=weBean.getResult().getTimestamp()+"";
                String prepayid=weBean.getResult().getPrepayid();
                String sign=weBean.getResult().getSign();
//                final IWXAPI msgApi =WXAPIFactory.createWXAPI(PayActivity.this, null);
//                msgApi.registerApp(appid);// 将该app注册到微信
                PayReq request = new PayReq();
                request.appId =appid ;
                request.partnerId = partnerid;
                request.prepayId= prepayid;
                request.packageValue = packagex;
                request.nonceStr= noncestr;
                request.timeStamp= timeStamp;
                request.sign=sign;
                api.sendReq(request);
            }

            @Override
            public void onError(int error) {

            }
        }).postHttp(URL,this,1,map);


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

    @Override
    protected void onResume() {
        super.onResume();
        webview_show();
    }

    public void setAlpha(float bgAlpha) {//设置背景遮罩颜色
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);
    }
}
