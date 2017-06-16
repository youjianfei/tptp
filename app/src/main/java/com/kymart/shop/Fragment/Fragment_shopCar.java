package com.kymart.shop.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.kymart.shop.Activity.LoginActivity;
import com.kymart.shop.Adapter.BaseAdapter;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Bean.ShopCarBean;
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
import ren.qinc.numberbutton.NumberButton;

import static com.kymart.shop.Activity.MainActivity.mMainactivity;
import static com.kymart.shop.AppStaticData.Staticdata.UUID_static;
import static com.kymart.shop.AppStaticData.Staticdata.isLogin;
import static com.kymart.shop.AppStaticData.Staticdata.userBean_static;

/**
 * Created by Administrator on 2017/6/11.
 */

public class Fragment_shopCar  extends Fragment{
    View  rootView;
    private Button mButton_add;

    private ListView mListview_shopcar;
    private TextView mTextview_jiesuan,mTextview_allPrice;


    Adapter_shopCarList mAdapter;

    List<ShopCarBean.ResultEntity.StoreListEntity> mListAllStore;
    List<ShopCarBean.ResultEntity.StoreListEntity.CartListEntity> mData;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_shopcar,container,false);
        initview();
        initData();
        setData();
        initListener();




        return rootView;
    }
    Map map;
    private void initListener() {
        mButton_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isLogin==1){
                mMainactivity.onClick(getActivity().findViewById(R.id.rl_2));
                }else{
                    Intent intend=new Intent(getActivity(), LoginActivity.class);
                    getActivity().startActivity(intend);

                }
            }
        });
    }

    private void setData() {



    }

    private void request(Map map) {
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi",respose);
                shopCarChange=false;
                ShopCarBean.ResultEntity resuleBEan=new Gson().fromJson(respose,ShopCarBean.class).getResult();
                mTextview_allPrice.setText("￥"+resuleBEan.getTotal_price().getTotal_fee()+"元");
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
        }).postHttp(BaseUrl.BaseURL+BaseUrl.shopCarList,getActivity(),1,map);

    }

    private void initData() {
        map=new HashMap();
        mListAllStore=new ArrayList<>();
        mData=new ArrayList<>();


        mAdapter=new Adapter_shopCarList(mData,getContext());
        mListview_shopcar.setAdapter(mAdapter);


    }

    private void initview() {
        mButton_add= (Button) rootView.findViewById(R.id.add_shopCar);
        mListview_shopcar= (ListView) rootView.findViewById(R.id.Listview_shopcar);
        mTextview_jiesuan= (TextView) rootView.findViewById(R.id.text_jiesuan);
        mTextview_allPrice= (TextView) rootView.findViewById(R.id.text_allPrice);
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
        List<ShopCarBean.ResultEntity.StoreListEntity.CartListEntity> mData;
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
            final ShopCarBean.ResultEntity.StoreListEntity.CartListEntity bean = mData.get(position);
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
                holder= (ViewHolder) convertView.getTag();
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
            Glide.with(mContext).load("http://test.kymart.cn/index.php?"+"m=api&c=goods&a=goodsThumImages&width=400&height=400&goods_id="+bean.getGoods_id()).into( holder.mImage_goodPIC);
            LogUtils.LOG("ceshi",bean.getGoods_id()+"");
            holder.mImage_delet.setOnClickListener(new View.OnClickListener() {//点击删除
                @Override
                public void onClick(View v) {
                    Map delmap=new HashMap();
                    delmap.put("ids",""+bean.getId());
                    delmap.put("token",""+ Staticdata.userBean_static.getResult().getToken());
                    delmap.put("unique_id",""+ Staticdata.UUID_static);

                    LogUtils.LOG("ceshi","删除商品信息ids...."+bean.getId()+"token..."+Staticdata.userBean_static.getResult().getToken()+"unique_id..."+Staticdata.UUID_static);

                    new  Volley_Utils(new Interface_volley_respose() {
                        @Override
                        public void onSuccesses(String respose) {
                            LogUtils.LOG("ceshi","删除商品成功"+respose);
                            ToastUtils.showToast(getActivity(),"删除成功");
                            request(map);
                        }

                        @Override
                        public void onError(int error) {

                        }
                    }).postHttp(BaseUrl.BaseURL+BaseUrl.delGood,getActivity(),1,delmap);
                }
            });


            return convertView;
        }

//        public void shopcarChange( Map map_change){//编辑商品数量
//            new Volley_Utils(new Interface_volley_respose() {
//                @Override
//                public void onSuccesses(String respose) {
//
//                }
//
//                @Override
//                public void onError(int error) {
//
//                }
//            }).postHttp(BaseUrl.BaseURL+BaseUrl.shopCarList,mContext,1,map_change);
//
//        }
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
