package com.kymart.shop.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.kymart.tptp.R;

/**
 * Created by Administrator on 2017/6/11.
 */

public class Fragment_shopCar  extends Fragment{
    View  rootView;


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_shopcar,container,false);




        return rootView;
    }
}
