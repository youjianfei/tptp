package com.kymart.shop.Activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

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
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.concurrent.ExecutionException;

import cn.kymart.tptp.R;

public class QRcodeActivity extends BaseActivityother {
    private RelativeLayout mainREL;
    private String URL_QRcode="";
    private String shareTitle="";
    private String shareContent="";
    private String share_url="";
    private ImageView share_weixin,share_weixincircle,share_qq;
    public UMShareListener umShareListener;
    @Override
    public int setLayoutResID() {
        return R.layout.activity_qrcode;
    }

    @Override
    protected void setData() {
        /**
         * 判断是否有存储权限
         */
        if (Build.VERSION.SDK_INT >= 23) {  //判断当前系统的版本 ，动态添加权限

            LogUtils.LOG("version", "version大于23");
            int checkWriteStoragePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);//获取系统是否被授予该种权限
            if (checkWriteStoragePermission != PackageManager.PERMISSION_GRANTED) {//如果没有被授予
                ToastUtils.showToast(this,"请打开应用的存储权限");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0x123);
                return;//请求获取该种权限
            }
        }

    }

    @Override
    protected void initData() {
        ToastUtils.showToast(this,"图片正在加载，点击图片可以下载到本地相册");
        umShareListener = new UMShareListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {

            }

            @Override
            public void onResult(SHARE_MEDIA platform) {
                Log.d("plat", "platform" + platform);

                Toast.makeText(getApplicationContext(), platform + " 分享成功啦", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(SHARE_MEDIA platform, Throwable t) {
                Toast.makeText(getApplicationContext(), platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
                if (t != null) {
                    Log.d("throw", "throw:" + t.getMessage());
                }
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media) {

            }
        };

    }
    void share(int share){
        UMImage image = new UMImage(QRcodeActivity.this, URL_QRcode);//第一张图片URL
        UMImage thumb = new UMImage(QRcodeActivity.this, share_url);
        image.setThumb(thumb);
        if (share == 2) {
            UMWeb web = new UMWeb(share_url);
            web.setTitle(shareTitle);//标题
            web.setDescription(shareContent);//描述
            web.setThumb(image);
            new ShareAction(QRcodeActivity.this).setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)
                    .withMedia(web)
                    .setCallback(umShareListener)
                    .share();

        }
        if (share == 1) {

            UMWeb web = new UMWeb(share_url);
            web.setTitle(shareTitle);//标题
            web.setDescription(shareContent);//描述
            web.setThumb(image);
            new ShareAction(QRcodeActivity.this).setPlatform(SHARE_MEDIA.WEIXIN)
                    .withMedia(web)
                    .setCallback(umShareListener)
                    .share();
        }
        if (share == 3) {
            UMWeb web = new UMWeb(share_url);
            web.setTitle(shareTitle);//标题
            web.setThumb(thumb);  //缩略图
            web.setDescription(shareContent);//描述
            new ShareAction(QRcodeActivity.this).setPlatform(SHARE_MEDIA.QQ)
                    .withMedia(web)
                    .setCallback(umShareListener)
                    .share();
        }


    }

    @Override
    protected void initListener() {
        share_weixin.setOnClickListener(this);
        share_weixincircle.setOnClickListener(this);
        share_qq.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.share_weixin:
                share(1);

                break;
            case R.id.share_weixincircle:
                share(2);

                break;
            case R.id.share_qq:
                share(3);

                break;
        }

    }

    @Override
    protected void initView() {
        requestIMG();
        mainREL= (RelativeLayout) findViewById(R.id.REL_QRcode);
        share_weixin= (ImageView) findViewById(R.id.share_weixin);
        share_weixincircle= (ImageView) findViewById(R.id.share_weixincircle);
        share_qq= (ImageView) findViewById(R.id.share_qq);

    }
   void  requestIMG(){
       String URL=BaseUrl.BaseURL+BaseUrl.QR_code+ Staticdata.userBean_static.getResult().getToken();
       LogUtils.LOG("ceshi","推广二维码"+URL);
       new Volley_Utils(new Interface_volley_respose() {
           @Override
           public void onSuccesses(String respose) {
               //解析json
               JSONObject jo = null;
               try {
                   jo = new JSONObject(respose);
                   int status=(Integer) jo.get("status");
                   if(status==1){
                       URL_QRcode = (String) jo.get("url");//图片地址
                       shareTitle =(String) jo.get("title");
                       shareContent =(String) jo.get("content");
                       share_url =(String) jo.get("share_url");
                   }

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
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                ToastUtils.showToast(QRcodeActivity.this,"图片已经下载到本地相册");
                            }
                        });
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
