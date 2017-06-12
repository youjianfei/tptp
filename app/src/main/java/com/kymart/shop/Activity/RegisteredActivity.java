package com.kymart.shop.Activity;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;


import java.util.Timer;
import java.util.TimerTask;

import cn.kymart.tptp.R;

public class RegisteredActivity extends BaseActivityother {
    TextView mtextview_yanzhengma;


    @Override
    public int setLayoutResID() {
        return R.layout.activity_registered;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mtextview_yanzhengma.setOnClickListener(this);

    }

    @Override
    protected void initView() {
        mtextview_yanzhengma = (TextView) findViewById(R.id.textview_yanzhengma);

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.textview_yanzhengma:
                timer = new Timer();
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        mhandler.sendEmptyMessage(0);
                    }
                };
                timer.schedule(timerTask, 0, 1000);
                mtextview_yanzhengma.setEnabled(false);


                break;
        }

    }

    int time = 60;
    Timer timer;
    private Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    mtextview_yanzhengma.setTextColor(getResources().getColor(R.color.LightGrey));
                    mtextview_yanzhengma.setText("   " + time + "s");
                    time--;
                    if (time == 0) {
                        timer.cancel();
                        mtextview_yanzhengma.setText("获取验证码");
                        mtextview_yanzhengma.setTextColor(getResources().getColor(R.color.red));
                        mtextview_yanzhengma.setEnabled(true);
                        time = 60;
                    }
                    break;
            }
        }


    };
}
