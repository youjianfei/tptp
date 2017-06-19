package com.kymart.shop.Activity;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabWidget;
import android.widget.TableRow;
import android.widget.TextView;

import com.kymart.shop.Utils.LogUtils;

import cn.kymart.tptp.R;

public class AddressActivity extends BaseActivityother {
    TabLayout mTabLayout;
    TextView mTextview;

    @Override
    public int setLayoutResID() {
        return R.layout.activity_address;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtils.LOG("ceshi","点击了添加");

                TabWidget tableRow = new TabWidget(AddressActivity.this);
                TextView textView = new TextView(AddressActivity.this);
                tableRow.addView(textView);
                mTabLayout.addView(tableRow);


            }
        });
    }

    @Override
    protected void initView() {
        mTabLayout= (TabLayout) findViewById(R.id.tablayout_menu);
        mTextview= (TextView) findViewById(R.id.text_add);
        mTabLayout.addTab(mTabLayout.newTab().setText("首页").setTag(1));
    }

}
