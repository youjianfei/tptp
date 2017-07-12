package com.kymart.shop.wxapi;


import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.kymart.shop.Utils.ToastUtils;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import cn.kymart.tptp.R;


public class WXPayEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {
    private IWXAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxpayentry);
        api = WXAPIFactory.createWXAPI(this, "wxcf54c829295655ba");
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        if(baseResp.getType()==ConstantsAPI.COMMAND_PAY_BY_WX){
            Log.d("ceshi","onPayFinish,errCode="+baseResp.errCode);
            if(baseResp.errCode==0){
                ToastUtils.showToast(this,"支付成功");
                finish();
            }else{
                ToastUtils.showToast(this,"支付失败");
                finish();
            }
        }

    }
}
