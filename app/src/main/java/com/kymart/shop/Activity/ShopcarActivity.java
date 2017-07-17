package com.kymart.shop.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.kymart.shop.Adapter.BaseAdapter;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Bean.ShopCarBean;
import com.kymart.shop.Fragment.Fragment_shopCar;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.ToastUtils;
import com.kymart.shop.Utils.Volley_Utils;
import com.mcxtzhang.lib.AnimShopButton;
import com.mcxtzhang.lib.IOnAddDelListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.kymart.tptp.R;

import static com.kymart.shop.Activity.MainActivity.mMainactivity;
import static com.kymart.shop.AppStaticData.Staticdata.UUID_static;
import static com.kymart.shop.AppStaticData.Staticdata.isLogin;
import static com.kymart.shop.AppStaticData.Staticdata.userBean_static;

public class ShopcarActivity extends BaseActivityother {
    private Button mButton_add;

    private ListView mListview_shopcar;
    private TextView mTextview_jiesuan,mTextview_allPrice;
    private double price;


   Adapter_shopCarList mAdapter;

    List<ShopCarBean.ResultBean.StoreListBean> mListAllStore;
    List<ShopCarBean.ResultBean.StoreListBean.CartListBean> mData;
    @Override
    public int setLayoutResID() {
        return R.layout.activity_shopcar;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {
        map=new HashMap();
        mListAllStore=new ArrayList<>();
        mData=new ArrayList<>();


        mAdapter=new Adapter_shopCarList(mData,this);
        mListview_shopcar.setAdapter(mAdapter);
    }
    private void request(Map map) {
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi",respose);
                shopCarChange=false;
                ShopCarBean.ResultBean resuleBEan=new Gson().fromJson(respose,ShopCarBean.class).getResult();
                mTextview_allPrice.setText("￥"+resuleBEan.getTotal_price().getTotal_fee()+"元");
                price=resuleBEan.getTotal_price().getTotal_fee();
                mListAllStore.clear();
                mData.clear();
                if(resuleBEan.getStoreList()!=null){
                    mListAllStore.addAll(resuleBEan.getStoreList());
                    for(int i=0;i<mListAllStore.size();i++){
                        for(int j=0;j<mListAllStore.get(i).getCartList().size();j++){
                            mData.add(mListAllStore.get(i).getCartList().get(j));
                        }
                    }
                }
                if(mData.size()!=0){
                    mButton_add.setVisibility(View.INVISIBLE);
                    mListview_shopcar.setVisibility(View.VISIBLE);
                }else{
                    mButton_add.setVisibility(View.VISIBLE);
                    mListview_shopcar.setVisibility(View.INVISIBLE);
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(int error) {

            }
        }).postHttp(BaseUrl.BaseURL+BaseUrl.shopCarList,this,1,map);

    }
    Map map;
    @Override
    protected void initListener() {
//        mButton_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(isLogin==1){
//                    mMainactivity.onClick(ShopcarActivity.this.findViewById(R.id.rl_2));
//                }else{
//                    Intent intend=new Intent(ShopcarActivity.this, LoginActivity.class);
//                    ShopcarActivity.this.startActivity(intend);
//
//                }
//            }
//        });
        mTextview_jiesuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(price==0){
                    ToastUtils.showToast(ShopcarActivity.this,"购物车是空的");
                    return;
                }
                Intent intent_jiesuan=new Intent(ShopcarActivity.this, OrderActivity.class);
                startActivity(intent_jiesuan);
            }
        });
    }

    @Override
    protected void initView() {
        mButton_add= (Button) findViewById(R.id.add_shopCar);
        mListview_shopcar= (ListView) findViewById(R.id.Listview_shopcar);
        mTextview_jiesuan= (TextView) findViewById(R.id.text_jiesuan);
        mTextview_allPrice= (TextView) findViewById(R.id.text_allPrice);
    }
    @Override
    public void onResume() {
        super.onResume();

        if(isLogin==1){

            map.put("unique_id",UUID_static);
            map.put("user_id",userBean_static.getResult().getUser_id()+"" );
            map.put("token",userBean_static.getResult().getToken() );
            if(!shopCarChange){//判断是否是点击 加减 产生的请求，如果false，  cart_form_data字段为空
                map.put("cart_form_data","");
            }
            LogUtils.LOG("ceshi","unique_id"+UUID_static+"user_id"+userBean_static.getResult().getUser_id() +"token"+userBean_static.getResult().getToken() );

            request(map);
        }
    }


    boolean shopCarChange=false;
    class Adapter_shopCarList extends BaseAdapter {
        List<ShopCarBean.ResultBean.StoreListBean.CartListBean> mData;
        private Context mContext;
        private LayoutInflater mInflater;

        public Adapter_shopCarList(List mDatas, Context mContext) {
            super(mDatas, mContext);
            this.mData=mDatas;
            this.mContext=mContext;
            mInflater=LayoutInflater.from(mContext);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder=null;
            final ShopCarBean.ResultBean.StoreListBean.CartListBean bean = mData.get(position);
            if(convertView==null){
                holder=new ViewHolder();
                convertView=mInflater.inflate(R.layout.item_listview_shopcar,null,false);
                holder.mImage_check= (ImageView) convertView.findViewById(R.id.image_check);
                holder.mImage_goodPIC= (ImageView) convertView.findViewById(R.id.imageView);
                holder.mImage_delet= (ImageView) convertView.findViewById(R.id.image_delate);
                holder.mText_goodName= (TextView) convertView.findViewById(R.id.text_goodname);
                holder.mTextview_goodProperty= (TextView) convertView.findViewById(R.id.text_goodProperty);
                holder.mTextview_goodPrice= (TextView) convertView.findViewById(R.id.text_price);
                holder.mNumberButton= (AnimShopButton) convertView.findViewById(R.id.numberButton_count);
                convertView.setTag(holder);
            }else{
                holder= (Adapter_shopCarList.ViewHolder) convertView.getTag();
            }
            holder.mImage_check.setSelected(true);
//            holder.mNumberButton.setCurrentNumber(bean.getGoods_num());
            holder.mNumberButton.setCount(bean.getGoods_num());
            holder.mNumberButton.setOnAddDelListener(new IOnAddDelListener() {
                @Override
                public void onAddSuccess(int i) {

                    //自定义json
                    LogUtils.LOG("ceshi","点击add"+i);
                    int goods_num=bean.getGoods_num()+1;
                    String  Json="[{\"cartID\":\""+bean.getId()+"\",\"goodsNum\":\""+goods_num+"\",\"storeCount\":\""+
                            bean.getStore_count()+"\",\"selected\":\"1\"}]";

                    LogUtils.LOG("ceshi","json"+Json);

                    map.put("cart_form_data",Json);
                    shopCarChange=true;

                    request(map);
                }

                @Override
                public void onAddFailed(int i, FailType failType) {

                }

                @Override
                public void onDelSuccess(int i) {
                    LogUtils.LOG("ceshi","点击del"+i);
                    //自定义json
                    LogUtils.LOG("ceshi","点击add"+i);
                    int goods_num=bean.getGoods_num()-1;
                    String  Json="[{\"cartID\":\""+bean.getId()+"\",\"goodsNum\":\""+goods_num+"\",\"storeCount\":\""+
                            bean.getStore_count()+"\",\"selected\":\"1\"}]";

                    LogUtils.LOG("ceshi","json"+Json);

                    map.put("cart_form_data",Json);
                    shopCarChange=true;
                    request(map);
                }

                @Override
                public void onDelFaild(int i, FailType failType) {

                }
            });




            holder.mText_goodName.setText(bean.getGoods_name());
            holder.mTextview_goodPrice.setText("￥"+bean.getGoods_price());
            holder.mTextview_goodProperty.setText(bean.getSpec_key_name());
            Glide.with(mContext).load(BaseUrl.Baseimage+bean.getGoods_id()).into( holder.mImage_goodPIC);
            LogUtils.LOG("ceshi",bean.getGoods_id()+"");
            holder.mImage_delet.setOnClickListener(new View.OnClickListener() {//点击删除
                @Override
                public void onClick(View v) {
                    Map delmap=new HashMap();
                    delmap.put("ids",""+bean.getId());
                    delmap.put("token",""+ Staticdata.userBean_static.getResult().getToken());
                    delmap.put("unique_id",""+ Staticdata.UUID_static);

                    LogUtils.LOG("ceshi","删除商品信息ids...."+bean.getId()+"token..."+Staticdata.userBean_static.getResult().getToken()+"unique_id..."+Staticdata.UUID_static);

                    new Volley_Utils(new Interface_volley_respose() {
                        @Override
                        public void onSuccesses(String respose) {
                            LogUtils.LOG("ceshi","删除商品成功"+respose);
                            ToastUtils.showToast(ShopcarActivity.this,"删除成功");
                            request(map);
                        }

                        @Override
                        public void onError(int error) {

                        }
                    }).postHttp(BaseUrl.BaseURL+BaseUrl.delGood,ShopcarActivity.this,1,delmap);
                }
            });


            return convertView;
        }

        class ViewHolder {
            ImageView mImage_check;
            ImageView mImage_goodPIC;
            TextView  mText_goodName;
            TextView  mTextview_goodProperty;
            AnimShopButton mNumberButton;
            TextView mTextview_goodPrice;
            ImageView mImage_delet;
        }
    }
}
