package com.kymart.shop.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Bean.CityIDBean;
import com.kymart.shop.Bean.OrderBean;
import com.kymart.shop.Bean.OrderPriceBean;
import com.kymart.shop.Bean.cart_form_data;
import com.kymart.shop.CustomView.MyExpandableListView;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.ToastUtils;
import com.kymart.shop.Utils.Volley_Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.kymart.tptp.R;

public class OrderActivity extends BaseActivityother {

    private LinearLayout mLinearlayout_address;
    private MyExpandableListView mListview;
    OrderBean orderBean;
    private List <OrderBean.ResultBean.StoreListBean> mListDataGroup=new ArrayList();//商店数组
    private List<List<OrderBean.ResultBean.StoreListBean.CartListBean>>mListDataChildren=new  ArrayList();//每个商点的产品数组
    private ListAdapter mAdapter;
    OrderPriceBean oederpriceBean;

    private TextView name,phonenumber,address_,shangpinzonge,peisongfeiyong,useyouhuiquan,usejifen,useyue,youhuihuodong,orderprice;
    private TextView keyongyue,keyongjifen;
    private EditText edit_yue,edit_jifen;

    private Button mButton_submit,mButton_useyue,mButton_usejifen;


    @Override
    public int setLayoutResID() {
        return R.layout.activity_order;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {
        mKProgressHUD = new KProgressHUD(this);
        mAdapter=new ListAdapter(mListDataChildren,mListDataGroup,OrderActivity.this);

        mListview.setAdapter(mAdapter);
        requestOrder();

    }

    @Override
    protected void initListener() {
        mLinearlayout_address.setOnClickListener(this);
        mButton_useyue.setOnClickListener(this);
        mButton_usejifen.setOnClickListener(this);
        mButton_submit.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        mLinearlayout_address= (LinearLayout) findViewById(R.id.linearlayout_address);
        mListview= (MyExpandableListView) findViewById(R.id.MyExpandableListView);
        keyongyue= (TextView) findViewById(R.id.text_keyongyue);
        keyongjifen= (TextView) findViewById(R.id.text_keyongjifen);
        name= (TextView) findViewById(R.id.textview_name);
        phonenumber= (TextView) findViewById(R.id.textview_phonenumber);
        address_= (TextView) findViewById(R.id.textview_address);
        edit_yue= (EditText) findViewById(R.id.edit_yue);
        edit_jifen= (EditText) findViewById(R.id.edit_jifen);
        shangpinzonge= (TextView) findViewById(R.id.shangpinzonge);
        peisongfeiyong= (TextView) findViewById(R.id.paisongfeiyong);
        useyouhuiquan= (TextView) findViewById(R.id.useyouhuiquan);
        usejifen= (TextView) findViewById(R.id.usejifen);
        useyue= (TextView) findViewById(R.id.useyue);
        youhuihuodong= (TextView) findViewById(R.id.youhuihuodong);
        orderprice= (TextView) findViewById(R.id.orderprice);
        mButton_submit= (Button) findViewById(R.id.button_cobmit);
        mButton_useyue= (Button) findViewById(R.id.button_useyue);
        mButton_usejifen= (Button) findViewById(R.id.button_jifen);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.linearlayout_address:
                //点击地址跳转
                Intent intent_address=new Intent(this,AddressActivity.class);
                startActivityForResult(intent_address,0);

                break;
            case R.id.button_useyue:
                //点击使用余额按钮
                String yue=edit_yue.getText()+"";
                if(yue.equals("")){
                    ToastUtils.showToast(this,"请输入金额");
                    mapOrderSubmit.put("user_money",0+"");
                    mapOrderSubmit.put("pay_points",0+"");
                    return;
                }else{
                    mapOrderSubmit.put("user_money",yue);
                    mapOrderSubmit.put("pay_points",0+"");
                    requestOrderPrice(0);
                }
                break;
            case R.id.button_jifen:
                //点击使用积分按钮
                String jifen=edit_jifen.getText()+"";
                if(jifen.equals("")){
                    ToastUtils.showToast(this,"请输入积分");
                    mapOrderSubmit.put("user_money",0+"");
                    mapOrderSubmit.put("pay_points",0+"");
                    return;
                }else{
                    mapOrderSubmit.put("user_money",0+"");
                    mapOrderSubmit.put("pay_points",jifen+"");
                    requestOrderPrice(0);
                }
                break;
            case R.id.button_cobmit:
                //点击提交订单按钮
                String yue_=edit_yue.getText()+"";
                if(yue_.equals("")){
                    mapOrderSubmit.put("user_money",0+"");
                }else{
                    mapOrderSubmit.put("user_money",yue_);
                }
                String jifen_=edit_jifen.getText()+"";
                if(jifen_.equals("")){
                    mapOrderSubmit.put("pay_points",0+"");
                }else{
                    mapOrderSubmit.put("pay_points",jifen_+"");

                }
                requestOrderPrice(1);

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case RESULT_OK://
                LogUtils.LOG("ceshi","选择地址返回");
                orderBean.getResult().getAddressList().setAddress(data.getStringExtra("Address"));
                orderBean.getResult().getAddressList().setProvince(data.getIntExtra("Province",0));
                orderBean.getResult().getAddressList().setCity(data.getIntExtra("City",0));
                orderBean.getResult().getAddressList().setDistrict(data.getIntExtra("District",0));
                orderBean.getResult().getAddressList().setTwon(data.getIntExtra("Twon",0));
                orderBean.getResult().getAddressList().setAddress_id(data.getIntExtra("Address_id",0));
                orderBean.getResult().getAddressList().setConsignee(data.getStringExtra("Consignee"));
                orderBean.getResult().getAddressList().setMobile(data.getStringExtra("Mobile"));
                requestAddressName();
                break;
            default:
                break;
        }
    }

    KProgressHUD mKProgressHUD;
   void  requestOrder(){
       String  URL= BaseUrl.BaseURL+BaseUrl.order+ Staticdata.userBean_static.getResult().getToken();
       new Volley_Utils(new Interface_volley_respose() {
           @Override
           public void onSuccesses(String respose) {
               LogUtils.LOG("ceshi","生成订单"+respose);
               JSONObject object = null;
               try {
                   object = new JSONObject(respose);
                   int status = (Integer) object.get("status");
                   String  msg = (String) object.get("msg");
                   if(status!=1){
                       ToastUtils.showToast(OrderActivity.this,msg);
                       Intent intent_address=new Intent(OrderActivity.this,AddressActivity.class);
                       startActivity(intent_address);
                       return;
                   }
               } catch (JSONException e) {
                   e.printStackTrace();
               }



               orderBean=new Gson().fromJson(respose,OrderBean.class);



               requestAddressName();
               //商品列表数据
               mListDataGroup.clear();
               mListDataChildren.clear();
               mListDataGroup.addAll(orderBean.getResult().getStoreList());
               for(int  i=0;i<orderBean.getResult().getStoreList().size();i++){
                  List<OrderBean.ResultBean.StoreListBean.CartListBean> childern=new ArrayList<>();
                   for(int j=0;j<mListDataGroup.get(i).getCartList().size();j++){
                       childern.add(mListDataGroup.get(i).getCartList().get(j));
                   }
                   mListDataChildren.add(childern);
               }
               mAdapter.notifyDataSetChanged();
               for(int i = 0; i < mAdapter.getGroupCount(); i++){//默认展开
                   mListview.expandGroup(i);
               }

               edit_yue.setHint("可以使用的余额为"+orderBean.getResult().getUserInfo().getUser_money());
               keyongyue.setText("可用余额:￥"+orderBean.getResult().getUserInfo().getUser_money());
               edit_jifen.setHint("可以使用的积分为"+orderBean.getResult().getUserInfo().getPay_points());
                keyongjifen.setText("可用积分:"+orderBean.getResult().getUserInfo().getPay_points());

               requestOrderPrice(0);
           }

           @Override
           public void onError(int error) {

           }
       }).Http(URL,this,0);
   }
    Map mapOrderSubmit=new HashMap();
    cart_form_data  upJson=new cart_form_data();//对象转JSON

    void requestOrderPrice(final int act){
        mapOrderSubmit.put("user_id",orderBean.getResult().getUserInfo().getUser_id()+"");
        if (act == 0) {
            mapOrderSubmit.put("act","order_price");

        }else{
            mapOrderSubmit.put("act","submit_order");
        }

        mapOrderSubmit.put("address_id",orderBean.getResult().getAddressList().getAddress_id()+"");
        HashMap map_Shipping_code=new HashMap();
        for(int i=0;i<orderBean.getResult().getStoreList().size();i++){
            map_Shipping_code.put(orderBean.getResult().getStoreList().get(i).getStore_id()+"",orderBean.getResult().getStoreList().get(i).getShippingList().get(0).getShipping_code()+"");
        }
        upJson.setShipping_code(map_Shipping_code);
        HashMap map_user_note=new HashMap();
        HashMap map_couponTypeSelect=new HashMap();
        HashMap map_coupon_id=new HashMap();
        HashMap map_couponCode=new HashMap();
        for(int i=0;i<orderBean.getResult().getStoreList().size();i++){
            map_user_note.put(orderBean.getResult().getStoreList().get(i).getStore_id()+"","");
        }
        upJson.setUser_note(map_user_note);
        upJson.setCouponTypeSelect(map_couponTypeSelect);
        upJson.setCoupon_id(map_coupon_id);
        upJson.setCouponCode(map_couponCode);
        String json=new  Gson().toJson(upJson);
        LogUtils.LOG("ceshi","json"+ BaseUrl.BaseURL+BaseUrl.orderprice+Staticdata.userBean_static.getResult().getToken());
        mapOrderSubmit.put("cart_form_data",json);
        LogUtils.LOG("ceshi","hashmap"+mapOrderSubmit.toString());
        String URL=BaseUrl.BaseURL+BaseUrl.orderprice+Staticdata.userBean_static.getResult().getToken();
        new  Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                if(act==0){//金额变动
                    JSONObject object = null;
                    try {
                        object = new JSONObject(respose);
                        int status = (Integer) object.get("status");
                        String  msg = (String) object.get("msg");
                        if(status==1){
                            LogUtils.LOG("ceshi","订单金额信息"+respose);
                            oederpriceBean=new  Gson().fromJson(respose,OrderPriceBean.class);
                            shangpinzonge.setText("商品总额：￥"+oederpriceBean.getResult().getGoodsFee()+"元");
                            peisongfeiyong.setText("配送费用：￥"+oederpriceBean.getResult().getPostFee()+"元");
                            useyouhuiquan.setText("使用优惠券：￥"+oederpriceBean.getResult().getCouponFee()+"元");
                            usejifen.setText("使用积分：￥"+oederpriceBean.getResult().getPointsFee()+"元");
                            useyue.setText("使用余额：￥"+oederpriceBean.getResult().getBalance()+"元");
                            youhuihuodong.setText("优惠活动：￥"+oederpriceBean.getResult().getOrder_prom_amount()+"元");
                            orderprice.setText("应付金额：￥"+oederpriceBean.getResult().getPayables()+"元");
                        }else{
                            ToastUtils.showToast(OrderActivity.this,msg);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else{//提交订单
                    JSONObject object = null;
                    try {
                        object = new JSONObject(respose);
                        int status = (Integer) object.get("status");
                        String  msg = (String) object.get("msg");
                        if(status==1){
                            String result=(String)object.get("result");
                            ToastUtils.showToast(OrderActivity.this,msg);
                            LogUtils.LOG("ceshi","订单金额号码"+result);
                            Map map_orderNumber=new HashMap();
                            map_orderNumber.put("master_order_sn",result+"");
                            requestOrderNumber(map_orderNumber,result);
                        }else{
                            ToastUtils.showToast(OrderActivity.this,msg);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onError(int error) {

            }
        }).postHttp(URL,OrderActivity.this,1,mapOrderSubmit);
    }
    void requestAddressName(){
        //收货信息数据展示
        name.setText(orderBean.getResult().getAddressList().getConsignee());
        phonenumber.setText(orderBean.getResult().getAddressList().getMobile());
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
                address_.setText(address[0]);
                if(orderBean.getResult().getAddressList().getCity()!=0){
                    new  Volley_Utils(new Interface_volley_respose() {
                        @Override
                        public void onSuccesses(String respose) {
                            CityIDBean  cityIDBean=new  Gson().fromJson(respose,CityIDBean.class);
                            address[1] =cityIDBean.getName();
                            address_.setText(address[0]+" "+ address[1]);
                            if(orderBean.getResult().getAddressList().getDistrict()!=0){
                                new  Volley_Utils(new Interface_volley_respose() {
                                    @Override
                                    public void onSuccesses(String respose) {
                                        LogUtils.LOG("ceshi","第三层请求");
                                        CityIDBean  cityIDBean=new  Gson().fromJson(respose,CityIDBean.class);
                                        address[2] =cityIDBean.getName();
                                        address_.setText(address[0]+" "+ address[1]+" "+address[2]);

                                        if(orderBean.getResult().getAddressList().getTwon()!=0){
                                            new  Volley_Utils(new Interface_volley_respose() {
                                                @Override
                                                public void onSuccesses(String respose) {
                                                    CityIDBean  cityIDBean=new  Gson().fromJson(respose,CityIDBean.class);
                                                    address[3] =cityIDBean.getName();
                                                    address_.setText(address[0]+" "+ address[1]+" "+address[2]+" "+address[3]+orderBean.getResult().getAddressList().getAddress());
                                                    mKProgressHUD.dismiss();
                                                }

                                                @Override
                                                public void onError(int error) {

                                                }
                                            }).Http(BaseUrl.BaseURL+BaseUrl.cityId+orderBean.getResult().getAddressList().getTwon(),OrderActivity.this,0);
                                        }else {
                                            address_.setText(address[0]+" "+ address[1]+" "+address[2]+orderBean.getResult().getAddressList().getAddress());
                                            mKProgressHUD.dismiss();
                                        }

                                    }

                                    @Override
                                    public void onError(int error) {

                                    }
                                }).Http(BaseUrl.BaseURL+BaseUrl.cityId+orderBean.getResult().getAddressList().getDistrict(),OrderActivity.this,0);
                            }else {
                                address_.setText(address[0]+" "+ address[1]+orderBean.getResult().getAddressList().getAddress());
                                mKProgressHUD.dismiss();
                            }
                        }

                        @Override
                        public void onError(int error) {

                        }
                    }).Http(BaseUrl.BaseURL+BaseUrl.cityId+orderBean.getResult().getAddressList().getCity(),OrderActivity.this,0);
                }else {
                    address_.setText(address[0]+orderBean.getResult().getAddressList().getAddress());
                    mKProgressHUD.dismiss();
                }
            }

            @Override
            public void onError(int error) {

            }
        }).Http(BaseUrl.BaseURL+BaseUrl.cityId+orderBean.getResult().getAddressList().getProvince(),OrderActivity.this,0);


    }
    void requestOrderNumber(Map map, final String price){//提交订单号码跳转付款界面
        String URL=BaseUrl.BaseURL+BaseUrl.ordernumber+Staticdata.userBean_static.getResult().getToken();
        new  Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi","提交订单编号"+respose);
                JSONObject object = null;
                try {
                    object = new JSONObject(respose);
                    int status = (Integer) object.get("status");
                    String  msg = (String) object.get("msg");
                    if(status!=1){
                        ToastUtils.showToast(OrderActivity.this,msg);
                        return;
                    }
                    String result=object.get("result")+"";
                    Intent intent_pay=new Intent(OrderActivity.this,PayActivity.class);
                    intent_pay.putExtra("ordernumber",price+"");
                    intent_pay.putExtra("price",""+result);
                    intent_pay.putExtra("type","gouwuche");
                    startActivity(intent_pay);
                    finish();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(int error) {

            }
        }).postHttp(URL,this,1,map);

    }

    @Override
    protected void onResume() {
        super.onResume();
//        requestOrder();
    }

    /*适配器*/
    class ListAdapter extends BaseExpandableListAdapter {

        private List<OrderBean.ResultBean.StoreListBean> group;
        private List<List<OrderBean.ResultBean.StoreListBean.CartListBean>> children;
        private LayoutInflater mLayoutInflater;

        public ListAdapter(List<List<OrderBean.ResultBean.StoreListBean.CartListBean>> children, List<OrderBean.ResultBean.StoreListBean> group, Context context) {
            this.children = children;
            this.group = group;
            mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override // 获取ListView中组的数量
        public int getGroupCount() {
            return group.size();
        }

        @Override// 获取第groupPosition组中子item的数量
        public int getChildrenCount(int groupPosition) {
            return children.get(groupPosition).size();
        }

        @Override// 获得第groupPosition组中的数据
        public Object getGroup(int groupPosition) {
            return group.get(groupPosition);
        }

        @Override// 获取第groupPosition组中的第childPosition位置的数据
        public Object getChild(int groupPosition, int childPosition) {
            return children.get(groupPosition).get(childPosition);
        }

        @Override// 获取第groupPosition组的id
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override// 获取第groupPosition组中的第childPosition位置item的id
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override// 获取第groupPosition组的视图
        public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = mLayoutInflater.inflate(R.layout.item_expandablelistview_group, parent, false);
                holder = new ViewHolder();
                holder.mgroup_name = (TextView) convertView.findViewById(R.id.textview_storeName);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.mgroup_name.setText(group.get(groupPosition).getStore_name());
            return convertView;
        }

        @Override
        public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            ViewHolder holder;
            final OrderBean.ResultBean.StoreListBean.CartListBean childBean = children.get(groupPosition).get(childPosition);
            if (convertView == null) {
                convertView = mLayoutInflater.inflate(R.layout.item_expandablelistview_children, parent, false);
                holder = new ViewHolder();
                holder.mchild_goodPIC = (ImageView) convertView.findViewById(R.id.image_goodsPIC);
                holder.mchild_name = (TextView) convertView.findViewById(R.id.textview_goodsname);
                holder.mchild_shuxing = (TextView) convertView.findViewById(R.id.textview_goodsshuxing);
                holder.mchild_price = (TextView) convertView.findViewById(R.id.textview_goodsprice);
                holder.mchild_number = (TextView) convertView.findViewById(R.id.textview_number);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            Glide.with(OrderActivity.this).load(BaseUrl.Baseimage+childBean.getGoods_id()).into(holder.mchild_goodPIC);
            holder.mchild_name.setText(childBean.getGoods_name());
            holder.mchild_shuxing.setText(childBean.getSpec_key_name());
            holder.mchild_price.setText("￥："+childBean.getGoods_price());
            holder.mchild_number.setText(childBean.getGoods_num()+"");

            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }


        private class ViewHolder {
            TextView mgroup_name;

            ImageView mchild_goodPIC;
            TextView mchild_name;
            TextView mchild_shuxing;
            TextView mchild_number;
            TextView mchild_price;
        }
    }
}
