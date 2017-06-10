package com.kymart.shop.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kymart.shop.class_.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import cn.kymart.tptp.R;

/**
 * Created by Administrator on 2017/6/10.
 */

public class Fragment_GoodDatails_good extends Fragment {
    View rootview;
    private Banner mBanner;
    private List<String> mImagesURL;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,  Bundle savedInstanceState) {
        rootview=inflater.inflate(R.layout.fragment_gooddetails_good,container,false);
        initview();
        setData();
        return rootview;
    }

    private void setData() {
        /**
         * 顶部轮播图
         */
        mImagesURL=new ArrayList<>();
        mImagesURL.add("http://pic.58pic.com/58pic/14/27/45/71r58PICmDM_1024.jpg");
        mImagesURL.add("http://pic17.nipic.com/20111122/6759425_152002413138_2.jpg");
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(mImagesURL);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }

    private void initview() {
        mBanner= (Banner) rootview.findViewById(R.id.Banner_goodImage);


    }
}
