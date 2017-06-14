package com.kymart.shop.Fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.kymart.shop.Http.BaseUrl;

import cn.kymart.tptp.R;

/**
 * Created by Administrator on 2017/6/13.
 */
@SuppressLint("ValidFragment")
public class Fragment_GoodDetails_web  extends Fragment{
    int ID=0;

    View rootView;
    WebView mWebview;

    public Fragment_GoodDetails_web(int ID) {
        this.ID = ID;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_gooddetails_web,container,false);
        mWebview= (WebView) rootView.findViewById(R.id.goods_web);
        mWebview.setVerticalScrollbarOverlay(true);
        //设置WebView支持JavaScript
        mWebview.getSettings().setJavaScriptEnabled(true);

        String url = BaseUrl.BaseURL+BaseUrl.goodDetails_web+ID;
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

        return rootView;
    }
}
