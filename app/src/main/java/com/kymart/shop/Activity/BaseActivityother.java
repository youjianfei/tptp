package com.kymart.shop.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import cn.kymart.tptp.R;


/**
 * Created by PC on 2017/1/10.
 */

public abstract class BaseActivityother extends Activity implements OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(setLayoutResID());
        initView();
        initData();
        setData();
        initListener();
        dealCommon();
    }
    /**
     * 处理相同逻辑
     */
    private void dealCommon() {

        View back = findViewById(R.id.iv_back);
        if (back != null)
            back.setOnClickListener(this);
    }

    /**
     * @return 返回一个int类型的布局id
     */
    public abstract int setLayoutResID();

    /**
     * 设置数据
     */
    protected abstract void setData();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化监听
     */
    protected abstract void initListener();

    /**
     * 初始化布局
     */
    protected abstract void initView();

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;

        }
    }
}
