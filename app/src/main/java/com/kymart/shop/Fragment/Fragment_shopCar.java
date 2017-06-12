package com.kymart.shop.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.kymart.shop.Adapter.Adapter_shopCarList;

import java.util.ArrayList;
import java.util.List;

import cn.kymart.tptp.R;

/**
 * Created by Administrator on 2017/6/11.
 */

public class Fragment_shopCar  extends Fragment{
    View  rootView;

    private ListView mListview_shopcar;
    Adapter_shopCarList mAdapter;
    List<String> mData;


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_shopcar,container,false);
        initview();
        initData();




        return rootView;
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
        mListview_shopcar= (ListView) rootView.findViewById(R.id.Listview_shopcar);

    }

}
