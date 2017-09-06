package com.kymart.shop.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.kymart.shop.Activity.MessageActivity;
import com.kymart.shop.Utils.LogUtils;

import org.json.JSONException;
import org.json.JSONObject;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 2017/9/6.
 */

public class JPushReceiver extends BroadcastReceiver {
    String TYPE="";
    String ID="";
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);


        if(extras!=null){
            JSONObject jo = null;
            try {
                jo = new JSONObject(extras);
                TYPE=jo.getString("type");
                ID=jo.getString("id");

                LogUtils.LOG("ceshi","测试Jpush数据"+TYPE+"..."+ID);


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
            LogUtils.LOG("ceshi","通知点击之后"+TYPE);
            if(TYPE.equals("1")){
                Intent intentXTmessage=new Intent(context, MessageActivity.class);

                intentXTmessage.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context. startActivity(intentXTmessage);
            }else if(TYPE.equals("2")){
                Intent intentDDmessage=new Intent(context, MessageActivity.class);
                intentDDmessage.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context. startActivity(intentDDmessage);
            }

        }

    }
}
