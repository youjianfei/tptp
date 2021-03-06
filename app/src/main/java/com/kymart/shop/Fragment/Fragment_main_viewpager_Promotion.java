package com.kymart.shop.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.List;

import com.kymart.shop.Activity.GoodDetailsActivity;
import com.kymart.shop.Adapter.Adapter_Grid_main_viewpager_Promotion;
import com.kymart.shop.Bean.MainBean;
import cn.kymart.tptp.R;

/**
 * Created by PC on 2017/6/6.
 */
@SuppressLint("ValidFragment")
public class Fragment_main_viewpager_Promotion extends Fragment{
    View rootView;
    private GridView  mGridviewPager;
    private Adapter_Grid_main_viewpager_Promotion mAdapter_grid;

    private List<MainBean.ResultBean.PromotionGoodsBean>data;

    public Fragment_main_viewpager_Promotion(List<MainBean.ResultBean.PromotionGoodsBean> data) {
        this.data = data;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.item_fragment_viewpager,container,false);
        mGridviewPager= (GridView) rootView.findViewById(R.id.Gridview_viewpager);
        initdata();

        mAdapter_grid=new Adapter_Grid_main_viewpager_Promotion(data,getActivity());
        mGridviewPager.setAdapter(mAdapter_grid);
        mGridviewPager.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(), GoodDetailsActivity.class);
                intent.putExtra("ID",data.get(i).getGoods_id());
                getActivity().startActivity(intent);
            }
        });



        return rootView;
    }

    private void initdata() {

    }
}
