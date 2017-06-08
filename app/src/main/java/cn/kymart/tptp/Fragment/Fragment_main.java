package cn.kymart.tptp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import cn.kymart.tptp.Adapter.Adapter_Grid_main_like;
import cn.kymart.tptp.Adapter.FragmentAdapterSecond;
import cn.kymart.tptp.Bean.MainBean;
import cn.kymart.tptp.Bean.mainLike;
import cn.kymart.tptp.CustomView.MyGridView;
import cn.kymart.tptp.class_.GlideImageLoader;
import cn.kymart.tptp.Interface.Interface_volley_respose;
import cn.kymart.tptp.R;
import cn.kymart.tptp.Utils.LogUtils;
import cn.kymart.tptp.Utils.Volley_Utils;

import static cn.kymart.tptp.Http.BaseUrl.BaseURL;
import static cn.kymart.tptp.Http.BaseUrl.mainURL;
import static cn.kymart.tptp.Http.BaseUrl.main_like;

/**
 * Created by PC on 2017/6/6.
 */

public class Fragment_main extends Fragment {
    View rootview;
    List<String> mImagesURL;//顶部轮播图图片下载地址数据

    //1
    List<MainBean.ResultBean.PromotionGoodsBean> mData_viewpager_promotion;// viewpager 精品推荐viewpager总数据
    List<List<MainBean.ResultBean.PromotionGoodsBean>> mData_Group_promotion;//单独一个viewpager精品推荐总数据分为若干页的数据集合，传入到Fragment；
    //2
    List<MainBean.ResultBean.HighQualityGoodsBean> mData_viewpager_highQuality;// viewpager 精品推荐viewpager总数据
    List<List<MainBean.ResultBean.HighQualityGoodsBean>> mData_Group_highQuality;//单独一个viewpager精品推荐总数据分为若干页的数据集合，传入到Fragment；





    List<mainLike.ResultBean.FavouriteGoodsBean> mList_like;//猜你喜欢 数据
    Adapter_Grid_main_like mAdapter_main_like;//猜你喜欢数据网格列表


    private Banner mViewpager;//顶部轮播图
    private ViewPager mViewPager_item_first;
    private ViewPager mViewPager_item_second;
    private MyGridView myGridView;


    private List<Fragment> fragments_first = new ArrayList<Fragment>();
    private List<Fragment> fragments_second = new ArrayList<Fragment>();
    private FragmentAdapter mFragmentAdapter;
    private FragmentAdapterSecond mFragmentAdapter2;



    private TextView mTextviewLoadmore;//底部加载更多


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_main, container, false);
        mViewpager = (Banner) rootview.findViewById(R.id.banner);//顶部轮播图
        mViewPager_item_first = (ViewPager) rootview.findViewById(R.id.viewpager_first);
        mViewPager_item_second = (ViewPager) rootview.findViewById(R.id.viewpager_second);

        myGridView = (MyGridView) rootview.findViewById(R.id.gradview_Recommend);

        mTextviewLoadmore= (TextView) rootview.findViewById(R.id.textview_loadmore);

        adBean = new ArrayList<>();//轮播广告bean
        mData_viewpager_promotion = new ArrayList<>();//促销商品 viewpager 总数据
        mData_viewpager_highQuality = new ArrayList<>();//促销商品 viewpager 总数据
        mList_like = new ArrayList<>();//猜你喜欢数据

        requestData();
        initListenner();

        return rootview;
    }
        int  main_like_page=1;
    private void initListenner() {
        mTextviewLoadmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//  猜你喜欢  点击加载更多监听
                main_like_page++;
                requestLikeData(main_like_page);
            }
        });
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

    private MainBean mainbean;//请求下来的全部数据
    private List<MainBean.ResultBean.AdBean> adBean;//首页轮播广告信息

    public void requestData() {//主页数据网络请求  &cid=2&page=1&count=20

        String URL = BaseURL + mainURL;
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {

                LogUtils.LOG("ceshi","main网络请求成功");
                mainbean = new Gson().fromJson(respose, MainBean.class);//请求下来的全部数据，在这里进行数据分配
                adBean = mainbean.getResult().getAd();//添加广告轮播视图
                mData_viewpager_promotion=mainbean.getResult().getPromotion_goods();//促销产品数据添加
                mData_viewpager_highQuality=mainbean.getResult().getHigh_quality_goods();

                initData();
                setData();
                requestLikeData(1);//请求  猜你喜欢   数据

            }

            @Override
            public void onError(int error) {
                LogUtils.LOG("ceshi", error + "");
            }
        }).Http(URL, getActivity(), 0);

    }
    private mainLike mainLikeBean;
    public void requestLikeData(int  page){//请求猜你喜欢数据

        String URL = BaseURL + main_like+page;
        new  Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi","mainLike网络请求成功");
                mainLikeBean=new  Gson().fromJson(respose,mainLike.class);
                mList_like.addAll(mainLikeBean.getResult().getFavourite_goods());
                mAdapter_main_like.notifyDataSetChanged();


            }

            @Override
            public void onError(int error) {

            }
        }).Http(URL,getActivity(),0);


    }
    /**
     * 促销商品viewpager数据初始化
     */
    private void initDataPromotion(){
        mData_Group_promotion = new ArrayList<>();
        fragments_first = new ArrayList<>();
        //算出viewpager的页数
        int page = mData_viewpager_promotion.size() / 3;//页数，余数为0的时候
        //将数据分发到每一页的fragment
        for (int i = 1; i < page + 1; i++) {
            List<MainBean.ResultBean.PromotionGoodsBean> child = new ArrayList<>();
            for (int j = 1; j < 4; j++) {
                child.add(mData_viewpager_promotion.get(j * i - 1));
            }
            mData_Group_promotion.add(child);
            fragments_first.add(new Fragment_main_viewpager_Promotion(mData_Group_promotion.get(i - 1)));
        }
        // 数据总和不是3的倍数需要另外处理
        int yushu_promotion = mData_viewpager_promotion.size() % 3;
        if (yushu_promotion != 0) {
            List<MainBean.ResultBean.PromotionGoodsBean> child = new ArrayList<>();
            for (int i = 3 * page; i < mData_viewpager_promotion.size(); i++) {
                child.add(mData_viewpager_promotion.get(i));
            }
            mData_Group_promotion.add(child);
            fragments_first.add(new Fragment_main_viewpager_Promotion(mData_Group_promotion.get( page)));
        }
    }
    /**
     * 精品推荐viewpager数据初始化
     */
    private void initDataHighQuality(){
        mData_Group_highQuality = new ArrayList<>();
        fragments_second = new ArrayList<>();
        //算出viewpager的页数
        int page = mData_viewpager_highQuality.size() / 3;//页数，余数为0的时候
        //将数据分发到每一页的fragment
        for (int i = 1; i < page + 1; i++) {
            List<MainBean.ResultBean.HighQualityGoodsBean> child = new ArrayList<>();
            for (int j = 1; j < 4; j++) {
                child.add(mData_viewpager_highQuality.get(j * i - 1));
            }
            mData_Group_highQuality.add(child);
            fragments_second.add(new Fragment_main_viewpager_HighQuallity(mData_Group_highQuality.get(i - 1)));
        }
        // 数据总和不是3的倍数需要另外处理
        int yushu = mData_viewpager_highQuality.size() % 3;
        if (yushu != 0) {
            List<MainBean.ResultBean.HighQualityGoodsBean> child = new ArrayList<>();
            for (int i = 3 * page; i < mData_viewpager_highQuality.size(); i++) {
                child.add(mData_viewpager_highQuality.get(i));
            }
            mData_Group_highQuality.add(child);
            fragments_second.add(new Fragment_main_viewpager_HighQuallity(mData_Group_highQuality.get( page)));
        }
    }

    private void initData() {
        /**
         * 轮播图数据初始化
         */
        mImagesURL = new ArrayList<>();
        LogUtils.LOG("ceshi","图片数量"+adBean.size());
        for(int i=0;i<adBean.size();i++){
            LogUtils.LOG("ceshi","图片网址"+adBean.get(i).getAd_code());
            mImagesURL.add(adBean.get(i).getAd_code());

        }
        initDataPromotion();
        initDataHighQuality();



        mAdapter_main_like = new Adapter_Grid_main_like(mList_like, getActivity());
        myGridView.setAdapter(mAdapter_main_like);


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
