package com.kymart.shop.Activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.ImageDownLoadCallBack;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.DownLoadImage;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.SizeUtils;
import com.kymart.shop.Utils.ToastUtils;
import com.kymart.shop.Utils.Volley_Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.concurrent.ExecutionException;

import cn.kymart.tptp.R;

public class QRcodeActivity extends BaseActivityother {
    private RelativeLayout mainREL;
    private String URL_QRcode;
    @Override
    public int setLayoutResID() {
        return R.layout.activity_qrcode;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {
        ToastUtils.showToast(this,"图片正在加载，点击图片可以下载到本地相册");

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        requestIMG();
        mainREL= (RelativeLayout) findViewById(R.id.REL_QRcode);

    }
   void  requestIMG(){
       String URL=BaseUrl.BaseURL+BaseUrl.QR_code+ Staticdata.userBean_static.getResult().getToken();
       new Volley_Utils(new Interface_volley_respose() {
           @Override
           public void onSuccesses(String respose) {
               //解析json
               JSONObject jo = null;
               try {
                   jo = new JSONObject(respose);
                   URL_QRcode = (String) jo.get("url");//图片地址
               } catch (JSONException e) {
                   e.printStackTrace();
               }

               int width = SizeUtils.getScreenWidthPx(QRcodeActivity.this);
               int height = (int) (width * 1.77);
               final ImageView imageView=new ImageView(QRcodeActivity.this);
               Glide.with(QRcodeActivity.this).load(BaseUrl.BasegoodlistURL+URL_QRcode).into(imageView);


               LinearLayout.LayoutParams mLayoutParams = new LinearLayout.LayoutParams(
                       width, height);
               imageView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       onDownLoad(BaseUrl.BasegoodlistURL+URL_QRcode);
                   }
               });
               mainREL.addView(imageView, mLayoutParams);
           }

           @Override
           public void onError(int error) {

           }
       }).Http(URL,this,0);

    }
    private void onDownLoad(String url) {
        DownLoadImage service = new DownLoadImage(getApplicationContext(),
                url,
                new ImageDownLoadCallBack() {

                    @Override
                    public void onDownLoadSuccess(File file) {
                    }

                    @Override
                    public void onDownLoadSuccess(Bitmap bitmap) {//图片下载成功之后

                        ToastUtils.showToast(QRcodeActivity.this,"图片已经下载到本地相册");

                    }

                    @Override
                    public void onDownLoadFailed() {
                        // 图片保存失败
                        LogUtils.LOG("ceshi", "图片下载失败");

                    }
                });
        //启动图片下载线程
        new Thread(service).start();
    }
}
