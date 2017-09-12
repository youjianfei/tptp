package com.kymart.shop.Http;

/**
 * Created by PC on 2017/6/7.
 */

public class BaseUrl {


//测试接口
//    public  static String checkUpdate="https://test.kymart.cn/api/index/checkupdate";//强制更新——测试接口
//    public  static String BaseURL="https://test.kymart.cn/index.php?";// 主接口——测试接口
//    public  static String BasegoodlistURL="https://test.kymart.cn";//商品列表主接口——测试接口
//    public  static String Baseimage="https://test.kymart.cn/index.php?m=api&c=goods&a=goodsThumImages&width=400&height=400&goods_id=";//图片拼接ID


//  正式接口
    public  static String checkUpdate="http://api.kymart.cn/api/index/checkupdate";//强制更新——正式接口
    public  static String BaseURL="http://api.kymart.cn/index.php?";//主接口——测试接口正式接口
    public  static String BasegoodlistURL="http://api.kymart.cn";//商品列表主接口——测试接口 http://api.kymart.cn/
    public  static String Baseimage="http://api.kymart.cn/index.php?m=api&c=goods&a=goodsThumImages&width=400&height=400&goods_id=";//图片拼接ID

    public  static String TAGURL ="http://www.kymart.cn/public/app/goods/";

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
    public static String  shareGoodDetails="m=Mobile&c=Goods&a=goodsInfo&id=";//商品详情分享  http://www.kymart.cn/index.php?m=Mobile&c=Goods&a=goodsInfo&id=3155&first_leader=user_id
    public static String  goodDetails_web="m=api&c=goods&a=goodsContent&id=";//商品详情
    public static String  addShopCar="m=Api&c=Cart&a=addCart&unique_id=";//
    public static String  shopCarList="m=Api&c=Cart&a=cartList";//购物车列表
    public static String  delGood="m=Api&c=Cart&a=delCart";//删除购物车中的某个商品


    public static String  userInfo="m=api&c=user&a=userInfo";//我的界面
    public static String  loginout="m=api&c=user&a=userInfo";//登出
//  public static String  allOrder="m=Api&c=User&a=getOrderList";//我的订单 get
    public static String  changeUserInfo="m=api&c=User&a=updateUserInfo&unique_id=";//设置 修改昵称
    public static String  changeUserPassword="m=api&c=User&a=password&unique_id=";//设置 修改密码

    public static String  addressList="m=api&c=user&a=getAddressList&unique_id=";//地址列表   +"&token="
    public static String  Address="m=api&c=other&a=region&level=";//选择地址————popwindow
    public static String  addAddress="m=api&c=user&a=addAddress&unique_id=";//添加地址    +"&token="
    public static String  delAddress="m=api&c=user&a=del_address&unique_id=";//删除地址  post   参数"id"  +"&token="
    public static String  cityId="m=Api&c=other&a=getregion&id=";//根据城市id获得城市地址等信息
    public static String  money="m=api&c=User&a=money_list&unique_id=";//我的钱包明细
    public static String  bonus="m=api&c=User&a=bonus_list&unique_id=";//我的奖金明细
    public static String  cashout="m=api&c=User&a=withdrawals&unique_id=";//  + &token=\(access_token())    申请提现  post = ["changetype":info?.changetype,"money":info?.money,"bank_name":info?.bank_name,"bank_card":info?.bank_card,"realname":info?.realname]
    public static String  cashoutlist="m=api&c=User&a=withdrawals_list&unique_id=";//  + &token=\(access_token())    提现记录
    public static String  QR_code="m=api&c=User&a=qr_code&token=";//二维码
    public static String  JiangJZY="m=api&c=User&a=changebonus&unique_id=";//奖金转余额  post  参数  "money"   &unique_id=\(SingleManager.getUUID())&token=\(access_token())"
    public static String  TuiguangZY="m=api&c=User&a=changebonus1&unique_id=";//推广转余额  post  参数  "money"   &unique_id=\(SingleManager.getUUID())&token=\(access_token())"
    public static String  DaifafangZJF="m=api&c=User&a=changepoint&unique_id=";//待发放转积分  post  参数  "money"   &unique_id=\(SingleManager.getUUID())&token=\(access_token())"
    public static String  shareFriend="m=api&c=User&a=lower_list&level=1&token=";//我的分享好友   "\(basePath)m=api&c=User&a=lower_list&level=1&token=\(access_token())&p=\(page)"
    public static String  order="m=Api&c=Cart&a=cart2&token=";//生成订单   m=Api&c=Cart&a=cart2&token=\(access_token())"
    public static String  orderprice="m=Api&c=Cart&a=cart3&token=";//订单金额信息    return "\(basePath)m=Api&c=Cart&a=cart3&token=\(access_token())"
    public static String  ordernumber="m=Api&c=Cart&a=cart4&token=";//提交订单号码  "\(basePath)m=Api&c=Cart&a=cart4&token=\(access_token())"
    public static String  alipayPay="m=Api&c=payment&a=alipay_sign&token=";//支付宝支付  \(basePath)m=Api&c=payment&a=alipay_sign&token=\(access_token())"
    public static String  alipayPay_recharge="m=Api&c=payment&a=recharge_alipay";//支付宝充值  \(basePath)m=Api&c=payment&a=alipay_sign&token=\(access_token())"
    public static String  wechatPay="m=Api&c=wxpay&a=dopay&token=";//微信支付  return "\(basePath)m=Api&c=wxpay&a=dopay&token=\(access_token())"
    public static String  wechat_recharge="m=Api&c=wxpay&a=recharge";//微信充值
    public static String  kuaiqianPay="m=api&c=Payment&a=bill&order_sn=";//快钱支付支付  order_sn=201707260855086512
    public static String  kuaiqianrecharge="m=Api&c=payment&a=recharge_bill";//快钱支付充值  https://kymart.cn/index.php?m=Api&c=payment&a=recharge_bill

    public static String  AllOrder="m=Api&c=User&a=getOrderList&token=";//订单列表  \(access_token())"
    public static String  cancleOrder="m=Api&c=user&a=cancelOrder&token=";//删除订单  \(basePath)m=Api&c=user&a=cancelOrder&token=\(access_token())"
    public static String  Orderdetail="m=Api&c=order&a=order_detail&token=";//订单详情 "\(basePath)m=Api&c=order&a=order_detail    &user_id=\(user_id)&id=\(id)&token=\(access_token())"
    public static String  logistics="m=Api&c=user&a=express&token=";//物流信息  return "\(basePath)m=Api&c=user&a=express&order_id=\(order_id)&token=\(access_token())"
    public static String  shouhuo="m=Api&c=user&a=orderConfirm&token=";//确认收货  return "\(basePath)m=Api&c=user&a=orderConfirm&token=\(access_token())"
    public static String  recharge_jilu="http://www.kymart.cn/index.php/api/user/recharge_list.html?token=";//充值记录
    public static String  returngoods="m=Api&c=Order&a=return_goods&token=";//申请退换货
    public static String  returngoodsList="m=api&c=order&a=return_goods_list&token=";//退换货列表
    public static String  refound="m=Api&c=user&a=return_goods&token=";//申请退款     "https://test.kymart.cn/index.php?m=Api&c=user&a=return_goods&token=001f6453f9ee8a6e94ca3de03797116e"
    public static String  XTmessage="m=api&c=user&a=push_system&token=";// 系统消息列表
    public static String  DDmessage="m=api&c=user&a=push_user&token=";//订单消息列表
    public static String  DDmessageDetails="m=api&c=user&a=push_user&token=";//订单消息详情       return "\(basePath)m=api&c=user&a=push_user&id=\(id)&token=\(access_token())"
    public static String  XTmessageDetails="m=api&c=user&a=push_system&token=";//系统消息详情       return "\(basePath)m=api&c=user&a=push_user&id=\(id)&token=\(access_token())"






}