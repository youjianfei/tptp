package com.kymart.shop.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import com.kymart.shop.Adapter.Adapter_classification_left;
import com.kymart.shop.Adapter.Adapter_classification_right_list;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Bean.Classifacation_leftBean;
import com.kymart.shop.Bean.Classification_rightBean;
import com.kymart.shop.Bean.MainBean;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import cn.kymart.tptp.R;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.Volley_Utils;

/**
 * Created by PC on 2017/6/6.
 */

public class Fragment_classification extends Fragment {
    public static Fragment_classification fragment_classification;
    View rootview;

    private ListView mListview_left;//分类  左边的列表
    private List<Classifacation_leftBean.ResultEntity> mData_left;//分类  左边的列表的数据
    private Adapter_classification_left Adapter_left;//分类  左边的列表的数据的适配器

    private ListView mListview_right;//分类  右边的列表
    private List<Classification_rightBean.ResultEntity> mData_right;//分类  右边的列表的数据
    private Adapter_classification_right_list Adapter_right;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_classification, container, false);

        mListview_left = (ListView) rootview.findViewById(R.id.listview_left);
        mListview_right = (ListView) rootview.findViewById(R.id.listview_right);

        initData();
        initListenner();
        LogUtils.LOG("ceshi","kljkljklj");
        repuestDataLeft(Staticdata.left_position);

        return rootview;
    }

    /**
     * 网络请求
     */
    public void repuestDataLeft(final int leftposition) {//请求左边列表数据的网络请求
        String URL = BaseUrl.BaseURL + BaseUrl.classificationleft;
//        LogUtils.LOG("ceshi","左边"+fragment_classification.getActivity());

        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi","请求左侧数据");
                mData_left.clear();
                mData_left.addAll(new Gson().fromJson(respose, Classifacation_leftBean.class).getResult());
                Adapter_left.setSelectedPosition(leftposition);//传入点击的条目位置
                Adapter_left.notifyDataSetInvalidated();//重新加载到listview
                Adapter_left.notifyDataSetChanged();
                requestDataRight(mData_left.get(leftposition).getId());
            }

            @Override
            public void onError(int error) {

            }
        }).Http(URL, getActivity(), 0);
    }

    private void requestDataRight(int id) {//请求右边
        // 列表数据的网络请求
        LogUtils.LOG("ceshi", "点击" + id+"...."+BaseUrl.BaseURL + BaseUrl.classificationright + id);
        String URL = BaseUrl.BaseURL + BaseUrl.classificationright + id;
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                mData_right.clear();
                mData_right.addAll(new Gson().fromJson(respose, Classification_rightBean.class).getResult());
                Adapter_right.notifyDataSetChanged();
            }

            @Override
            public void onError(int error) {

            }
        }).Http(URL, getContext(), 0);
    }

    /**
     * 监听
     */
    private void initListenner() {
        mListview_left.setOnItemClickListener(new AdapterView.OnItemClickListener() {//监听左边列表的点击  颜色变化
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//监听左边列表点击
                LogUtils.LOG("ceshi","条目点击的位置"+position);
                Adapter_left.setSelectedPosition(position);//传入点击的条目位置
                Adapter_left.notifyDataSetInvalidated();//重新加载到listview

                requestDataRight(mData_left.get(position).getId());
            }
        });

    }

    /**
     * 初始化数据
     */
    private void initData() {
        fragment_classification=this;
        LogUtils.LOG("ceshi","kljkljklj");
        mData_left = new ArrayList<>();
        Adapter_left = new Adapter_classification_left(mData_left, getContext());
        mListview_left.setAdapter(Adapter_left);


        mData_right = new ArrayList<>();
        Adapter_right = new Adapter_classification_right_list(mData_right, getContext());
        mListview_right.setAdapter(Adapter_right);

    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
