package com.kymart.shop.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.kymart.shop.Adapter.Adapter_orderDetailsGoodslist;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Bean.CityIDBean;
import com.kymart.shop.Bean.OrderDetailsBean;
import com.kymart.shop.CustomView.MyListView;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.ToastUtils;
import com.kymart.shop.Utils.Volley_Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.kymart.tptp.R;

public class OrderDetail extends BaseActivityother {
    String orderID="";
    OrderDetailsBean orderDetailsBean;
    private TextView textview_dingdanzhuangtai;
    private TextView textview_dingdannumber;
    private TextView textview_peisongprice;
    private TextView textview_zhifufangshi;
    private TextView textview_fukuanyue;
    private TextView textview_shouhuoren;
    private TextView textview_phonenumber;
    private TextView textview_address;
    private TextView textview_peisongfangshi;
    private TextView textview_kuaidinumber;
    private TextView textview_dianpumingcheng;
    private TextView textview_dianpunumber;
    private TextView textview_qq;
    private TextView textview_shangpinzongjia;
    private TextView textview_peisongfeiyong;
    private TextView textview_youhuiquan;
    private TextView textview_jifen;
    private TextView textview_yue;
    private TextView textview_huodongyouhui;
    private TextView textview_yingfujine;
    private LinearLayout mLinLogistics;
    private Button  button_pay,button_cancle,button_shouhuo,button_pingjia,button_tuihui;

    private MyListView mListview;
    List<OrderDetailsBean.ResultBean.GoodsListBean>mData;
    Adapter_orderDetailsGoodslist mAdapter;



    @Override
    public int setLayoutResID() {
        return R.layout.activity_order_detail;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {
        Intent intent=getIntent();
        orderID=intent.getStringExtra("orderid");
        mData=new ArrayList<>();
        mAdapter=new Adapter_orderDetailsGoodslist(mData,this);
        mListview.setAdapter(mAdapter);
        requestOrderDetail(orderID);
    }

    @Override
    protected void initListener() {
        mLinLogistics.setOnClickListener(this);
        button_pay.setOnClickListener(this);
        button_cancle.setOnClickListener(this);
        button_shouhuo.setOnClickListener(this);
        button_pingjia.setOnClickListener(this);
        button_tuihui.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        mKProgressHUD=new KProgressHUD(this);
        textview_dingdanzhuangtai= (TextView) findViewById(R.id.textview_dingdanstate);
        textview_dingdannumber= (TextView) findViewById(R.id.dingdannumber);
        textview_peisongprice= (TextView) findViewById(R.id.peisongfeiyong);
        textview_zhifufangshi= (TextView) findViewById(R.id.textview_chifufangshi);
        textview_fukuanyue= (TextView) findViewById(R.id.textview_yingfuyue);
        textview_shouhuoren= (TextView) findViewById(R.id.textview_name);
        textview_phonenumber= (TextView) findViewById(R.id.textview_phonenumber);
        textview_address= (TextView) findViewById(R.id.textview_address);
        textview_peisongfangshi= (TextView) findViewById(R.id.textview_peisong);
        textview_kuaidinumber= (TextView) findViewById(R.id.textview_peisongnumber);
        textview_dianpumingcheng= (TextView) findViewById(R.id.textview_dianming);
        textview_dianpunumber= (TextView) findViewById(R.id.textview_shopnumber);
        textview_qq= (TextView) findViewById(R.id.textview_qq);
        textview_shangpinzongjia= (TextView) findViewById(R.id.shangpinzonge);
        textview_peisongfeiyong= (TextView) findViewById(R.id.paisongfeiyong);
        textview_youhuiquan= (TextView) findViewById(R.id.useyouhuiquan);
        textview_jifen= (TextView) findViewById(R.id.usejifen);
        textview_yue= (TextView) findViewById(R.id.useyue);
        textview_huodongyouhui= (TextView) findViewById(R.id.youhuihuodong);
        textview_yingfujine= (TextView) findViewById(R.id.orderprice);
        mLinLogistics= (LinearLayout) findViewById(R.id.linearlayout_logistics);
        mListview= (MyListView) findViewById(R.id.listview_goods);
        button_pay= (Button) findViewById(R.id.button_pay);
        button_cancle= (Button) findViewById(R.id.button_cancle);
        button_shouhuo= (Button) findViewById(R.id.button_shouhuo);
        button_pingjia= (Button) findViewById(R.id.button_pingjia);
        button_tuihui= (Button) findViewById(R.id.button_tuihuo);

    }
    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.linearlayout_logistics:
                Intent intend_logistics=new Intent(OrderDetail.this,LogisticsWebActivity.class);
                LogUtils.LOG("ceshi","wuliuID"+orderDetailsBean.getResult().getOrder_id());
                intend_logistics.putExtra("ordreID",orderDetailsBean.getResult().getOrder_id()+"");
                startActivity(intend_logistics);
                break;
            case R.id.button_pay:
                LogUtils.LOG("ceshi","pay被电击");
                Intent intent_pay=new Intent(OrderDetail.this,PayActivity.class);
                intent_pay.putExtra("ordernumber",orderDetailsBean.getResult().getOrder_sn()+"");
                intent_pay.putExtra("price",""+orderDetailsBean.getResult().getGoods_price());
                intent_pay.putExtra("type","dingdan");
                startActivity(intent_pay);
                break;
            case R.id.button_cancle:
                LogUtils.LOG("ceshi","取消被电击");
                Map map_cancleorder=new HashMap();
                map_cancleorder.put("order_id",orderDetailsBean.getResult().getOrder_id()+"");
                cancleOrder(map_cancleorder);
                break;
            case R.id.button_shouhuo:
                LogUtils.LOG("ceshi","确认收货被电击");
                Map map_shouhuo=new HashMap();
                map_shouhuo.put("order_id",orderDetailsBean.getResult().getOrder_id()+"");
                shouhuo(map_shouhuo);
                break;
            case R.id.button_pingjia:
                break;
            case R.id.button_tuihuo:
                break;
        }
    }

    void  requestOrderDetail(String ID){//订单详情请求
        String  URL= BaseUrl.BaseURL+BaseUrl.Orderdetail+ Staticdata.userBean_static.getResult().getToken()+"&user_id="+Staticdata.userBean_static.getResult().getUser_id()+"&id="+ID;
        LogUtils.LOG("ceshi","订单详情"+URL);
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi","订单详情"+respose);
                orderDetailsBean=new Gson().fromJson(respose,OrderDetailsBean.class);
                setDATA();

            }

            @Override
            public void onError(int error) {

            }
        }).Http(URL,this,0);
    }
    KProgressHUD mKProgressHUD;
    void setDATA(){
        textview_dingdanzhuangtai.setText(orderDetailsBean.getResult().getOrder_status_desc());
        textview_dingdannumber.setText(orderDetailsBean.getResult().getOrder_sn());
        textview_peisongprice.setText(orderDetailsBean.getResult().getShipping_price());
        textview_zhifufangshi.setText(orderDetailsBean.getResult().getPay_name());
        textview_fukuanyue.setText("￥："+orderDetailsBean.getResult().getOrder_prom_amount());
        textview_shouhuoren.setText(orderDetailsBean.getResult().getConsignee());
        textview_phonenumber.setText(orderDetailsBean.getResult().getMobile());
        textview_peisongfangshi.setText("配送方式："+orderDetailsBean.getResult().getShipping_name());
        textview_kuaidinumber.setText("快递单号："+orderDetailsBean.getResult().getInvoice_no());
        textview_dianpumingcheng.setText(orderDetailsBean.getResult().getStore_name());
        textview_dianpunumber.setText(orderDetailsBean.getResult().getStore_phone());
        textview_qq.setText(orderDetailsBean.getResult().getStore_qq());
        //根据地址id获得地址
        final String[] address = {"","","",""};
        mKProgressHUD.setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setCancellable(true)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
                .show();

        new  Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                final List<CityIDBean> cityList=new ArrayList<>();
                LogUtils.LOG("ceshi",respose);
                CityIDBean  cityIDBean=new  Gson().fromJson(respose,CityIDBean.class);
                LogUtils.LOG("ceshi",cityIDBean.getName());
                address[0] =cityIDBean.getName();
                textview_address.setText(address[0]);
                if(orderDetailsBean.getResult().getCity()!=0){
                    new  Volley_Utils(new Interface_volley_respose() {
                        @Override
                        public void onSuccesses(String respose) {
                            CityIDBean  cityIDBean=new  Gson().fromJson(respose,CityIDBean.class);
                            address[1] =cityIDBean.getName();
                            textview_address.setText(address[0]+" "+ address[1]);
                            if(orderDetailsBean.getResult().getDistrict()!=0){
                                new  Volley_Utils(new Interface_volley_respose() {
                                    @Override
                                    public void onSuccesses(String respose) {
                                        LogUtils.LOG("ceshi","第三层请求");
                                        CityIDBean  cityIDBean=new  Gson().fromJson(respose,CityIDBean.class);
                                        address[2] =cityIDBean.getName();
                                        textview_address.setText(address[0]+" "+ address[1]+" "+address[2]);

                                        if(orderDetailsBean.getResult().getTwon()!=0){
                                            new  Volley_Utils(new Interface_volley_respose() {
                                                @Override
                                                public void onSuccesses(String respose) {
                                                    CityIDBean  cityIDBean=new  Gson().fromJson(respose,CityIDBean.class);
                                                    address[3] =cityIDBean.getName();
                                                    textview_address.setText(address[0]+" "+ address[1]+" "+address[2]+" "+address[3]+orderDetailsBean.getResult().getAddress());
                                                    mKProgressHUD.dismiss();
                                                }

                                                @Override
                                                public void onError(int error) {

                                                }
                                            }).Http(BaseUrl.BaseURL+BaseUrl.cityId+orderDetailsBean.getResult().getTwon(),OrderDetail.this,0);
                                        }else {
                                            textview_address.setText(address[0]+" "+ address[1]+" "+address[2]+orderDetailsBean.getResult().getAddress());
                                            mKProgressHUD.dismiss();
                                        }

                                    }

                                    @Override
                                    public void onError(int error) {

                                    }
                                }).Http(BaseUrl.BaseURL+BaseUrl.cityId+orderDetailsBean.getResult().getDistrict(),OrderDetail.this,0);
                            }else {
                                textview_address.setText(address[0]+" "+ address[1]+orderDetailsBean.getResult().getAddress());
                                mKProgressHUD.dismiss();
                            }
                        }

                        @Override
                        public void onError(int error) {

                        }
                    }).Http(BaseUrl.BaseURL+BaseUrl.cityId+orderDetailsBean.getResult().getCity(),OrderDetail.this,0);
                }else {
                    textview_address.setText(address[0]+orderDetailsBean.getResult().getAddress());
                    mKProgressHUD.dismiss();
                }
            }

            @Override
            public void onError(int error) {

            }
        }).Http(BaseUrl.BaseURL+BaseUrl.cityId+orderDetailsBean.getResult().getProvince(),OrderDetail.this,0);

          mData.addAll(orderDetailsBean.getResult().getGoods_list());
        mAdapter.notifyDataSetChanged();

        textview_shangpinzongjia.setText("商品总额：￥"+orderDetailsBean.getResult().getGoods_price()+"元");
        textview_peisongfeiyong.setText("配送费用：￥"+orderDetailsBean.getResult().getShipping_price()+"元");
        textview_youhuiquan.setText("使用优惠券：￥"+orderDetailsBean.getResult().getCoupon_price()+"元");
        textview_jifen.setText("使用积分：￥"+orderDetailsBean.getResult().getIntegral_money()+"元");
        textview_yue.setText("使用余额：￥"+orderDetailsBean.getResult().getUser_money()+"元");
        textview_huodongyouhui.setText("优惠活动：￥"+orderDetailsBean.getResult().getOrder_prom_amount()+"元");
        textview_yingfujine.setText("应付金额：￥"+orderDetailsBean.getResult().getOrder_amount()+"元");
        isButton(button_pay,orderDetailsBean.getResult().getPay_btn());
        isButton(button_cancle,orderDetailsBean.getResult().getCancel_btn());
        isButton(button_shouhuo,orderDetailsBean.getResult().getReceive_btn());
        isButton(button_tuihui,orderDetailsBean.getResult().getReturn_btn());
        isButton(button_pingjia,orderDetailsBean.getResult().getComment_btn());
    }

    void isButton(Button button,int i){
        if(i==0){
            button.setVisibility(View.GONE);
        }else {
            button.setVisibility(View.VISIBLE);
        }

    }
    void cancleOrder(Map map){
        String URL=BaseUrl.BaseURL+BaseUrl.cancleOrder+Staticdata.userBean_static.getResult().getToken();
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi","取消订单"+respose);
                JSONObject object = null;
                try {
                    object = new JSONObject(respose);
                    String  msg = (String) object.get("msg");
                    ToastUtils.showToast(OrderDetail.this,msg);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(int error) {

            }
        }).postHttp(URL,this,1,map);


    }
    void shouhuo(Map map){
        String URL=BaseUrl.BaseURL+BaseUrl.shouhuo+Staticdata.userBean_static.getResult().getToken();
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi","确认收货"+respose);
                JSONObject object = null;
                try {
                    object = new JSONObject(respose);
                    String  msg = (String) object.get("msg");
                    ToastUtils.showToast(OrderDetail.this,msg);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(int error) {

            }
        }).postHttp(URL,this,1,map);


    }
}
