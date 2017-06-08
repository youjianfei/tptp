package cn.kymart.tptp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import cn.kymart.tptp.Adapter.Adapter_Grid_main_recommend;
import cn.kymart.tptp.Adapter.FragmentAdapterSecond;
import cn.kymart.tptp.Bean.MainBean;
import cn.kymart.tptp.CustomView.MyGridView;
import cn.kymart.tptp.GlideImageLoader;
import cn.kymart.tptp.Interface.Interface_volley_respose;
import cn.kymart.tptp.MainActivity;
import cn.kymart.tptp.R;
import cn.kymart.tptp.Utils.LogUtils;
import cn.kymart.tptp.Utils.ToastUtils;
import cn.kymart.tptp.Utils.Volley_Utils;

import static cn.kymart.tptp.Http.BaseUrl.BaseURL;
import static cn.kymart.tptp.Http.BaseUrl.mainURL;

/**
 * Created by PC on 2017/6/6.
 */

public class Fragment_main extends Fragment {
    View rootview;
    List<String> mImagesURL;//顶部轮播图图片下载地址数据

    List<String> mData_viewpager;//first viewpager 单独一个viewpager总数据
    List<String> mData_child;//一页viewpager中Fragment中的数据；
    List<List<String>> mData_Group;//单独一个viewpager总数据分为若干页的数据集合，传入到Fragment；


    List<String> mList_recommend;
    Adapter_Grid_main_recommend mAdapter_recommend;


    private Banner mViewpager;//顶部轮播图
    private ViewPager mViewPager_item_first;
    private ViewPager mViewPager_item_second;
    private MyGridView myGridView;


    private List<Fragment> fragments_first = new ArrayList<Fragment>();
    private List<Fragment> fragments_second = new ArrayList<Fragment>();
    private FragmentAdapter mFragmentAdapter;
    private FragmentAdapterSecond mFragmentAdapter2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_main, container, false);
        mViewpager = (Banner) rootview.findViewById(R.id.banner);//顶部轮播图
        mViewPager_item_first = (ViewPager) rootview.findViewById(R.id.viewpager_first);
        mViewPager_item_second = (ViewPager) rootview.findViewById(R.id.viewpager_second);

        myGridView = (MyGridView) rootview.findViewById(R.id.gradview_Recommend);

        initData();
        setData();

        return rootview;
    }

    private void setData() {
        /**
         * 顶部轮播图
         */
        //设置图片加载器
        mViewpager.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mViewpager.setImages(mImagesURL);
        //banner设置方法全部调用完毕时最后调用
        mViewpager.start();


        /**
         * 初始化Adapter
         */
        mFragmentAdapter = new FragmentAdapter(getFragmentManager(), fragments_first);
        mFragmentAdapter2 = new FragmentAdapterSecond(getFragmentManager(), fragments_second);
        mViewPager_item_first.setAdapter(mFragmentAdapter);
        mViewPager_item_second.setAdapter(mFragmentAdapter2);


    }

    private MainBean bean;//请求下来的全部数据
    private List<MainBean.ResultBean.AdBean> adBean;//首页轮播广告信息

    public void requestData(int cid, int count, final int page) {//主页数据网络请求  &cid=2&page=1&count=20

        LogUtils.LOG("ceshi", "请求了");
        String URL = BaseURL + mainURL;
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                bean = new Gson().fromJson(respose, MainBean.class);//请求下来的全部数据，在这里进行数据分配
                adBean = bean.getResult().getAd();


            }

            @Override
            public void onError(int error) {
                LogUtils.LOG("ceshi", error + "");
            }
        }).Http(URL, getActivity(), 0);

    }

    private void initData() {
        adBean = new ArrayList<>();//轮播广告bean
        mImagesURL = new ArrayList<>();
        mImagesURL.add("http://img2.imgtn.bdimg.com/it/u=502348296,3633422462&fm=26&gp=0.jpg");
        mImagesURL.add("http://img2.imgtn.bdimg.com/it/u=502348296,3633422462&fm=26&gp=0.jpg");
        mImagesURL.add("http://wallpapers1.hellowallpaper.com/art_black-wallpaper--01_04-1280x960.jpg");

        mData_viewpager = new ArrayList<>();//first viewpager 总数据
        mData_viewpager.add("sdfsadf");
        mData_viewpager.add("sdfsadf");
        mData_viewpager.add("sdfsadf");
        mData_viewpager.add("sdfsadf");
        mData_viewpager.add("sdfsadf");
        mData_viewpager.add("sdfsadf");
        mData_viewpager.add("sdfsadf");
        mData_Group = new ArrayList<>();
        mData_child = new ArrayList<>();
        fragments_first = new ArrayList<>();
        /**
         * 算出viewpager的页数;
         */
        int page = mData_viewpager.size() / 3;//页数，余数为0的时候
        for (int i = 1; i < page + 1; i++) {
            List<String> child = new ArrayList<>();
            for (int j = 1; j < 4; j++) {
                child.add(mData_viewpager.get(j * i - 1));
            }
            mData_Group.add(child);
            fragments_first.add(new Fragment_main_viewpager_item(mData_Group.get(i - 1)));
        }
        int yushu = mData_viewpager.size() % 3;
        if (yushu != 0) {
            List<String> child = new ArrayList<>();
            for (int i = 3 * page; i < mData_viewpager.size(); i++) {
                child.add(mData_viewpager.get(i));
            }
            mData_Group.add(child);
            fragments_first.add(new Fragment_main_viewpager_item(mData_Group.get( page)));
        }


//        fragments_second=new ArrayList<>();
//        Fragment_main_viewpager_item fragment_item4=new Fragment_main_viewpager_item(mData_viewpager);
//        Fragment_main_viewpager_item fragment_item5=new Fragment_main_viewpager_item(mData_viewpager);
//        Fragment_main_viewpager_item fragment_item6=new Fragment_main_viewpager_item(mData_viewpager);
//        fragments_second.add(fragment_item4);
//        fragments_second.add(fragment_item5);
//        fragments_second.add(fragment_item6);


        mList_recommend = new ArrayList<>();
        mList_recommend.add("sdfasdf");
        mList_recommend.add("sdfasdf");
        mList_recommend.add("sdfasdf");
        mList_recommend.add("sdfasdf");
        mList_recommend.add("sdfasdf");
        mList_recommend.add("sdfasdf");
        mAdapter_recommend = new Adapter_Grid_main_recommend(mList_recommend, getActivity());
        myGridView.setAdapter(mAdapter_recommend);

    }

    class FragmentAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments;

        public FragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        public Fragment getItem(int fragment) {
            return fragments.get(fragment);
        }

        public int getCount() {
            return fragments.size();
        }

    }
}
