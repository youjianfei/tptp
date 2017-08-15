package com.kymart.shop.class_;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import cn.kymart.tptp.R;

/**
 * Created by Administrator on 2017/8/15.
 */

public class PopWindowClass {
    Activity activity;
    LinearLayout layout;


    PopupWindow mPopwinsow_isPay;
    Button mButtonset,mButtoncancel;

    public PopWindowClass(Activity activity, LinearLayout layout) {
        this.activity = activity;
        this.layout = layout;
    }

    public void initpopwindow(){
        View popview = activity.getLayoutInflater().inflate(R.layout.popwindow_pay, null, false);
        mPopwinsow_isPay = new PopupWindow(popview, ViewGroup.LayoutParams.WRAP_CONTENT , ViewGroup.LayoutParams.WRAP_CONTENT, true);
        mPopwinsow_isPay.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.pop_background));// 设置背景图片，不能在布局中设置，要通过代码来设置
        mPopwinsow_isPay.setOutsideTouchable(true);// 触摸popupwindow外部，popupwindow消失
        mPopwinsow_isPay.setAnimationStyle(R.style.popwindow_anim_style); // 设置动画
        mPopwinsow_isPay.showAtLocation(layout, Gravity.CENTER, 0, 0);//定位pop位置
        setAlpha((float) 0.3);
        mButtonset= (Button) popview.findViewById(R.id.button_set);
        mButtoncancel= (Button) popview.findViewById(R.id.button_cancel);
        poplistenner();
        mPopwinsow_isPay.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setAlpha((float) 1);
            }
        });
    }

    public void poplistenner(){
        mButtonset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopwinsow_isPay.dismiss();

            }
        });
        mButtoncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopwinsow_isPay.dismiss();
            }
        });

    }
    public void setAlpha(float bgAlpha) {//设置背景遮罩颜色
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        activity. getWindow().setAttributes(lp);
    }

}
