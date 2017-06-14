package com.kymart.shop.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kymart.shop.Activity.LoginActivity;
import com.kymart.shop.Adapter.Adapter_shopCarList;
import com.kymart.shop.Bean.ShopCarBean;
import com.kymart.shop.Bean.UserBean;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.Volley_Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.kymart.tptp.R;

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
                     map=new HashMap();
                    map.put("unique_id",UUID_static);
                    map.put("user_id",userBean_static.getResult().getUser_id()+"" );
                    map.put("token",userBean_static.getResult().getToken() );


                    LogUtils.LOG("ceshi","unique_id"+UUID_static+"user_id"+userBean_static.getResult().getUser_id() +"token"+userBean_static.getResult().getToken() );

                    request(map);

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
                    if(mData.size()!=0){
                        mButton_add.setVisibility(View.INVISIBLE);
                        mListview_shopcar.setVisibility(View.VISIBLE);

                    }

                    mAdapter.notifyDataSetChanged();
                }


            }

            @Override
            public void onError(int error) {

            }
        }).postHttp(BaseUrl.BaseURL+BaseUrl.shopCarList,getActivity(),1,map);

    }

    private void initData() {
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
        request(map);
    }
}
