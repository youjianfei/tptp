package com.kymart.shop.class_;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.kymart.shop.Utils.LogUtils;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;

/**
 * Created by Administrator on 2017/8/15.
 */

public class ShareClass {

    public   UMShareListener umShareListener;
    private Activity activity;

    public ShareClass(Activity activity) {
        this.activity = activity;
    }

    /**
     * 微信分享方法
     */
    public  void shareapp(final String title, final String url_good,final  String ImageUrl) {
        LogUtils.LOG("ceshi","我是拉出来的微信分享");
//        shareJsonBean=  new Gson().fromJson(sharejson, shareJson.class);//分享json解析对象
//        imageurl=shareJsonBean.getData().getImageurl();


        umShareListener = new UMShareListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {

            }

            @Override
            public void onResult(SHARE_MEDIA platform) {
                Log.d("plat", "platform" + platform);

                Toast.makeText(activity, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(SHARE_MEDIA platform, Throwable t) {
                Toast.makeText(activity, platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
                if (t != null) {
                    Log.d("throw", "throw:" + t.getMessage());
                }
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media) {

            }
        };
        ShareBoardlistener shareBoardlistener = new ShareBoardlistener() {

            @Override
            public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                UMImage image = new UMImage(activity,ImageUrl);
                UMImage thumb = new UMImage(activity, url_good);
                image.setThumb(thumb);
                if (share_media == share_media.WEIXIN_CIRCLE) {
                    UMWeb web = new UMWeb(url_good);
                    web.setTitle(title);//标题
                    web.setDescription("开心购物,快乐分享");//描述
                    web.setThumb(image);
                    new ShareAction(activity).setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)
                            .withMedia(web)
                            .setCallback(umShareListener)
                            .share();

                }
                if (share_media == share_media.WEIXIN) {

                    UMWeb web = new UMWeb(url_good);
                    web.setTitle(title);//标题
                    web.setDescription("开心购物,快乐分享");//描述
                    web.setThumb(image);
                    new ShareAction(activity).setPlatform(SHARE_MEDIA.WEIXIN)
                            .withMedia(web)
                            .setCallback(umShareListener)
                            .share();
                }
                if (share_media == share_media.QQ) {
                    UMWeb web = new UMWeb(url_good);
                    web.setTitle(title);//标题
                    web.setThumb(thumb);  //缩略图
                    web.setDescription("开心购物,快乐分享");//描述
                    new ShareAction(activity).setPlatform(SHARE_MEDIA.QQ)
                            .withMedia(web)
                            .setCallback(umShareListener)
                            .share();
                }


            }
        };
        new ShareAction(activity)
        .setDisplayList(SHARE_MEDIA.WEIXIN,SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.QQ).
        setShareboardclickCallback(shareBoardlistener)
        .open();

    }
}
