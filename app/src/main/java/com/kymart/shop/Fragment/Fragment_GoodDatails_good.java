package com.kymart.shop.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

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
    private LinearLayout mLinear_bottom;
    private Banner mBanner;
    private LinearLayout mLinearout_result;
    private List<String> mImagesURL;

    PopupWindow mPopupWindow;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,  Bundle savedInstanceState) {
        rootview=inflater.inflate(R.layout.fragment_gooddetails_good,container,false);
        initview();
        setData();
        initListenner();
        return rootview;
    }

    private void initListenner() {
        mLinearout_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopwindow();
            }
        });
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
        mLinear_bottom= (LinearLayout) rootview.findViewById(R.id.LinearLayout_bottom);
        mBanner= (Banner) rootview.findViewById(R.id.Banner_goodImage);
        mLinearout_result= (LinearLayout) rootview.findViewById(R.id.LinearLayout_result);




    }
    private ListView mListview_pop;
    private void showPopwindow() {
        //初始化popwindow；
        View conView=LayoutInflater.from(getActivity()).inflate(R.layout.popwindow_gooddetail,null,false);
        mPopupWindow=new PopupWindow(conView,
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setContentView(conView);
        mPopupWindow.showAtLocation(mLinear_bottom, Gravity.BOTTOM, 0, 0);

        mListview_pop= (ListView) conView.findViewById(R.id.Listview_popwindow);
    }
}
