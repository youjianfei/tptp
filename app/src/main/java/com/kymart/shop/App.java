package com.kymart.shop;

import android.app.Application;

import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by PC on 2017/3/6.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //开启debug模式，方便定位错误，具体错误检查方式可以查看http://dev.umeng.com/social/android/quick-integration的报错必看，正式发布，请关闭该模式
        Config.DEBUG = true;
        UMShareAPI.get(this);
    }

    {
        PlatformConfig.setWeixin("wxcf54c829295655ba", "2e1ab0bef224a0e149e35fff1f6979ee");
        PlatformConfig.setQQZone("1106145757", "EET6qPviK5XKeTwh");

    }

}
