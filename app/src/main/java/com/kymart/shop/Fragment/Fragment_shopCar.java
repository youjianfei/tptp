package com.kymart.shop.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.kymart.shop.Activity.LoginActivity;
import com.kymart.shop.Adapter.Adapter_shopCarList;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.Volley_Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.kymart.tptp.R;

import static com.kymart.shop.AppStaticData.Staticdata.isLogin;

/**
 * Created by Administrator on 2017/6/11.
 */

public class Fragment_shopCar  extends Fragment{
    View  rootView;
    private Button mButton_add;

    private ListView mListview_shopcar;


    Adapter_shopCarList mAdapter;
    List<String> mData;


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_shopcar,container,false);
        initview();
        initData();
        setData();
        initListener();




        return rootView;
    }

    private void initListener() {
        mButton_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isLogin==1){

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

            }

            @Override
            public void onError(int error) {

            }
        }).postHttp(BaseUrl.BaseURL+BaseUrl.shopCarList,getActivity(),1,map);

    }

    private void initData() {
        mData=new ArrayList<>();

        mData.add("asdfasd");
        mData.add("asdfasd");
        mData.add("asdfasd");
        mData.add("asdfasd");
        mAdapter=new Adapter_shopCarList(mData,getContext());
        mListview_shopcar.setAdapter(mAdapter);


    }

    private void initview() {
        mButton_add= (Button) rootView.findViewById(R.id.add_shopCar);
        mListview_shopcar= (ListView) rootView.findViewById(R.id.Listview_shopcar);

    }

}
