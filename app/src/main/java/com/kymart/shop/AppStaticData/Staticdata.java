package com.kymart.shop.AppStaticData;

import com.kymart.shop.Bean.AddressListBean;
import com.kymart.shop.Bean.BuyGoodBean;
import com.kymart.shop.Bean.UserBean;
import com.kymart.shop.Bean.personCenterBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/12.
 */

public class Staticdata {
    public static UserBean userBean_static=new UserBean();//登录用户静态对象
    /**
     * UUID
     */
    public static String UUID_static="";//在登陆时候  设置

    /**
     * 判断帐号是否登录
     */
    public static int isLogin=0;//0  否  1  是

    public static BuyGoodBean bean= new BuyGoodBean();
    public static AddressListBean.ResultBean mList_address= new AddressListBean.ResultBean();
    public static personCenterBean personCenterBean= new personCenterBean();




}
