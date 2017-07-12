package com.kymart.shop.wxapi;


import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;


public class WXPayEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {



    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        if(baseResp.getType()==ConstantsAPI.COMMAND_PAY_BY_WX){
            Log.d("ceshi","onPayFinish,errCode="+baseResp.errCode);
        }

    }
}
