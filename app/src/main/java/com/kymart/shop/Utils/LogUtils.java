package com.kymart.shop.Utils;

import android.util.Log;

/**
 * Created by PC on 2017/1/10.
 */

public   class LogUtils {
    static boolean log =true;

   public static void LOG(String tag, String message){
       if(log){
           Log.i(tag,message);
       }else{
//           Log.i("ceshi","log日志关闭");
       }

   }

}
