package com.kymart.shop.Http;

/**
 * Created by PC on 2017/6/7.
 */

public class BaseUrl {
    //https://www.kymart.cn/  正式接口


    public  static String checkUpdate="http://test.kymart.cn/api/index/checkupdate";//强制更新——测试接口
    public  static String BaseURL="http://test.kymart.cn/index.php?";// 主接口——测试接口
    public  static String BasegoodlistURL="http://test.kymart.cn";//商品列表主接口——测试接口

//
//    public  static String checkUpdate="https://www.kymart.cn/api/index/checkupdate";//强制更新——正式接口
//    public  static String BaseURL="https://www.kymart.cn/index.php?";//主接口——测试接口正式接口
//    public  static String BasegoodlistURL="https://www.kymart.cn";//商品列表主接口——测试接口


    public  static String mainURL="m=api&c=Index&a=homePage";
    public static String  main_imgURL="m=api&c=goods&a=goodsThumImages&width=400&height=400&goods_id=";//main  轮播
    public static String  main_like="m=api&c=Index&a=favourite&p=";//猜你喜欢
    public static String  classificationleft="m=api&c=goods&a=goodsCategoryList";//分类左边列表
    public static String  classificationright="m=api&c=goods&a=goodsSecAndThirdCategoryList&parent_id=";//分类右边列表
    public static String  image_code="m=api&c=User&a=verify&unique_id=";//图形验证码
    public static String  login="m=Api&c=User&a=login";//图形验证码
    public static String  messageCode="m=Home&c=Api&a=send_validate_code&scene=1&type=mobile";//注册使用的短信验证码
    public static String  register="m=Api&c=User&a=reg";//注册帐号
    public static String  messageCode_find="m=Home&c=Api&a=send_validate_code&scene=2&type=mobile";//找回密码使用的短信验证码
    public static String  findPassword="m=api&c=user&a=forgetPassword";//找回密码使用的短信验证码
    public static String  goodDetails="m=Api&c=Goods&a=goodsInfo";//商品详情
    public static String  goodDetails_web="m=api&c=goods&a=goodsContent&id=";//商品详情
    public static String  addShopCar="m=Api&c=Cart&a=addCart&unique_id=";//
    public static String  shopCarList="m=Api&c=Cart&a=cartList";//购物车列表
    public static String  delGood="m=Api&c=Cart&a=delCart";//删除购物车中的某个商品


    public static String  userInfo="m=api&c=user&a=userInfo";//我的界面
    public static String  loginout="m=api&c=user&a=userInfo";//登出
//    public static String  allOrder="m=Api&c=User&a=getOrderList";//我的订单 get
    public static String  changeUserInfo="m=api&c=User&a=updateUserInfo&unique_id=";
    public static String  changeUserPassword="m=api&c=User&a=password&unique_id=";







}