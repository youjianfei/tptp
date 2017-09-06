package com.kymart.shop.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Utils.LogUtils;

import cn.kymart.tptp.R;

public class ShouhouActivity extends BaseActivityother {
    private WebView mWebview;


    @Override
    public int setLayoutResID() {
        return R.layout.activity_shouhou;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {
        mWebview.setVerticalScrollbarOverlay(true);
        //设置WebView支持JavaScript
        mWebview.getSettings().setJavaScriptEnabled(true);

        String url = BaseUrl.BaseURL+BaseUrl.returngoodsList+ Staticdata.userBean_static.getResult().getToken();
        LogUtils.LOG("ceshi","shouhoufuwu"+url);
        mWebview.loadUrl(url);
        WebSettings settings = mWebview.getSettings();
        // 设置缩放级别
        settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        // 支持缩放
        settings.setSupportZoom(true);
        // 设置网页中可执行javascript代码
        settings.setJavaScriptEnabled(true);
        // 将网页内容以单列显示
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mWebview.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                mWebview.loadUrl(url);

                return true;
            }


        });

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebview.canGoBack()) {
            mWebview.goBack();// 返回前一个页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        mWebview= (WebView) findViewById(R.id.shouhou_web);
    }
}
