package com.kymart.shop.Utils;

import cn.kymart.tptp.R;

/**
 * Created by Administrator on 2017/7/17.
 */

public class Utils {


    public static int selectICON(int type){
        switch (type){
            case 0:
                return R.mipmap.fenxiang_s;
            case 1:
                return R.mipmap.miaosha_s;

            case 3:
                return R.mipmap.cuxiao_s;
        }
        return 0;

    }

}
