package cn.kymart.tptp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.List;

import cn.kymart.tptp.Adapter.Adapter_Grid_main_viewpager;
import cn.kymart.tptp.Bean.MainBean;
import cn.kymart.tptp.R;

/**
 * Created by PC on 2017/6/6.
 */

public class Fragment_main_viewpager_item extends Fragment{
    View rootView;
    private GridView  mGridviewPager;
    private Adapter_Grid_main_viewpager mAdapter_grid;

    private List<MainBean.ResultBean.PromotionGoodsBean>data;

    public Fragment_main_viewpager_item(List<MainBean.ResultBean.PromotionGoodsBean> data) {
        this.data = data;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.item_fragment_viewpager,container,false);
        mGridviewPager= (GridView) rootView.findViewById(R.id.Gridview_viewpager);
        initdata();
        mAdapter_grid=new Adapter_Grid_main_viewpager(data,getActivity());
        mGridviewPager.setAdapter(mAdapter_grid);



        return rootView;
    }

    private void initdata() {

    }
}
