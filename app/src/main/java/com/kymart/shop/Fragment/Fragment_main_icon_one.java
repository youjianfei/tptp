package com.kymart.shop.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.kymart.tptp.R;

/**
 * Created by Administrator on 2017/7/16.
 */

public class Fragment_main_icon_one extends Fragment {
    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.item_fragment_main_icon_one,container,false);



        return rootView;
    }
}
