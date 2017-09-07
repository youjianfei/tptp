package com.kymart.shop.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Bean.MessageDetailsBean;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.DateUtils;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.SharedPreferencesUtils;
import com.kymart.shop.Utils.StreamUtils;
import com.kymart.shop.Utils.ToastUtils;
import com.kymart.shop.Utils.Volley_Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import cn.kymart.tptp.R;

public class MessageDetailsActivity extends BaseActivityother {
    private TextView mtextview_title;
    private WebView mWebview_detail;
    int ID;
    int TYPE;
    String URL;
    MessageDetailsBean messageDetailsBean;
    String webdate;

    @Override
    public int setLayoutResID() {
        return R.layout.activity_message_details;
    }

    @Override
    protected void setData() {
        if(TYPE==1){
            URL= BaseUrl.BaseURL+BaseUrl.XTmessageDetails+ SharedPreferencesUtils.getString(this,"kymt","token")+"&id="+ID;
        }else {
            URL= BaseUrl.BaseURL+BaseUrl.DDmessageDetails+ SharedPreferencesUtils.getString(this,"kymt","token")+"&id="+ID;
        }

        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi","推送详情"+respose);
                int  status=0;
                String msg="";
                try {
                    JSONObject object=new JSONObject(respose);
                    status = (Integer) object.get("status");//登录状态
                    msg = (String) object.get("msg");//登录返回信息
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if(status==1){
                    messageDetailsBean=new Gson().fromJson(respose,MessageDetailsBean.class);
                    webdate=messageDetailsBean.getResult().getContent();
                    setupWebViewData();
                }else {
                    ToastUtils.showToast(MessageDetailsActivity.this,msg);
                }


            }

            @Override
            public void onError(int error) {

            }
        }).Http(URL,MessageDetailsActivity.this,0);
    }

    @Override
    protected void initData() {
        Intent intent=getIntent();
        TYPE=intent.getIntExtra("type",0);
        ID=intent.getIntExtra("id",0);
        if(TYPE==1){
            mtextview_title.setText("系统公告");
        }else {
            mtextview_title.setText("订单消息");

        }

        // 新闻正文
        WebSettings webSettings = mWebview_detail.getSettings();


        // 设置缩放级别
        webSettings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        // 支持缩放
        webSettings.setSupportZoom(true);
        // 设置网页中可执行javascript代码
        webSettings.setJavaScriptEnabled(true);
        // 将网页内容以单列显示
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        webSettings.setJavaScriptEnabled(true);
        mWebview_detail.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
//                // 隐藏加载进度条
//                mProgressBar.setVisibility(View.INVISIBLE);
//                // 网页加载完成才去加载其他UI
//                setupDetailData();
                // 加载网页缓存图片
//                getImageFromDownloaderOrDiskByImageUrlArray();
//                // 页面滑动到顶部
//                mScrollView.fullScroll(ScrollView.FOCUS_UP);
            }

        });


    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        mtextview_title= (TextView) findViewById(R.id.text_title);
        mWebview_detail= (WebView) findViewById(R.id.webview_message);

    }


    /**
     * 配置webView数据
     */
    private void setupWebViewData() {

        String html = "";
        if(TYPE==1){
            html += "<h2 class=\"contTitle\">"+messageDetailsBean.getResult().getTitle()+"</h2>";
            html += "<div class=\"subTitle\"><span class=\"text-mini text-gray m-l-sm\">"+ DateUtils.timet(messageDetailsBean.getResult().getCreate_time()+"")+"</span>";
            html += "</div><div class=\"content\"><div><p>"+messageDetailsBean.getResult().getContent()+"</p></div></div></div>";
        }else{
            html +="</div><div class=\"content\"><div><p>"+messageDetailsBean.getResult().getContent()+"</p></div></div></div>"
            ;


        }

        String localHtml = null;
        try {
            InputStream inputStream = getAssets().open("template/details.html");
            localHtml = StreamUtils.InputStreanToString(inputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 本地html加载一定要成功
        if (localHtml == null) {
//            ProgressHUD.showInfo(mContext, "解析数据失败");
            return;
        }

        // 将拼接好的正文html插入本地网页模板
        html = localHtml.replace("<p>mainnews</p>", html);

        // 加载页面
        mWebview_detail.loadDataWithBaseURL("file:///android_asset/template/details.html", filterHtml(html), "text/html", "utf-8", null);

    }
    /**
     * 过滤html
     *
     * @param original html源字符串
     * @return 过滤后的字符串
     */
    private String filterHtml(String original) {
        String tempHtml = original.replace("<p>&nbsp;</p>", "");
        tempHtml = tempHtml.replace("<p>&nbsp;</p>", " style=\"text-indent: 2em;\"");
        Log.i("ceshi","wangzhi"+tempHtml);
        return tempHtml;
    }
}
