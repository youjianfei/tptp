package com.kymart.shop.Activity;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;


import cn.kymart.tptp.R;

public class AddAddressActivity extends BaseActivityother {
    TextView mTextview_area;


    PopupWindow mPopupWindow;
    LinearLayout mLinearLayout_bottom;



    @Override
    public int setLayoutResID() {
        return R.layout.activity_add_address;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initListener() {
        mTextview_area.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        mLinearLayout_bottom= (LinearLayout) findViewById(R.id.activity_add_address);
        mTextview_area= (TextView) findViewById(R.id.text_area);

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.text_area:
                showPopwindow();

                break;
        }
    }
    private void showPopwindow() {

        //初始化popwindow；
        View conView= LayoutInflater.from(this).inflate(R.layout.popwindow_select_address,null,false);
        mPopupWindow=new PopupWindow(conView,
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setOutsideTouchable(true);// 触摸popupwindow外部，popupwindow消失
        mPopupWindow.showAtLocation(mLinearLayout_bottom, Gravity.BOTTOM, 0, 0);


        setAlpha((float) 0.3);
    }
    public void setAlpha(float bgAlpha) {//设置背景遮罩颜色
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        this.getWindow().setAttributes(lp);
    }
}
