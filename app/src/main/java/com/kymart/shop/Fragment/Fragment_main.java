package com.kymart.shop.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kymart.shop.Activity.GoodDetailsActivity;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import com.kymart.shop.Adapter.Adapter_Grid_main_like;
import com.kymart.shop.Bean.MainBean;
import com.kymart.shop.Bean.mainLike;
import com.kymart.shop.CustomView.MyGridView;
import com.kymart.shop.class_.GlideImageLoader;
import com.kymart.shop.Interface.Interface_volley_respose;
import cn.kymart.tptp.R;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.Volley_Utils;

import static com.kymart.shop.Http.BaseUrl.BaseURL;
import static com.kymart.shop.Http.BaseUrl.mainURL;
import static com.kymart.shop.Http.BaseUrl.main_like;

/**
 * Created by PC on 2017/6/6.
 */

public class Fragment_main extends Fragment {
    View rootview;
    List<String> mImagesURL;//顶部轮播图图片下载地址数据


    List<MainBean.ResultBean.PromotionGoodsBean> mData_viewpager_promotion;// viewpager 精品推荐viewpager总数据
    List<MainBean.ResultBean.PromotionGoodsBean> mData_viewpager_highQuality;// viewpager 精品推荐viewpager总数据
    List<MainBean.ResultBean.PromotionGoodsBean> mData_viewpager_flashSale;// viewpager 新品上市viewpager总数据
    List<MainBean.ResultBean.PromotionGoodsBean> mData_viewpager_hot;// viewpager 热销商品viewpager总数据


    List<mainLike.ResultBean.FavouriteGoodsBean> mList_like;//猜你喜欢 数据
    Adapter_Grid_main_like mAdapter_main_like;//猜你喜欢数据网格列表


    private Banner mViewpager;//顶部轮播图
    private ViewPager mViewPager_item_first;
    private ViewPager mViewPager_item_second;
    private ViewPager mViewPager_item_thred;
    private ViewPager mViewPager_item_fouth;
    private LinearLayout viewpager_dot_first;
    private LinearLayout viewpager_dot_second;
    private LinearLayout viewpager_dot_third;
    private LinearLayout viewpager_dot_fouth;



    private MyGridView myGridView;



    List< List<Fragment>> fragments=new ArrayList<>();//用来存放4个 fragment集合 的集合



    private TextView mTextviewLoadmore;//底部加载更多


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_main, container, false);
        mViewpager = (Banner) rootview.findViewById(R.id.banner);//顶部轮播图
        mViewPager_item_first = (ViewPager) rootview.findViewById(R.id.viewpager_first);
        mViewPager_item_second = (ViewPager) rootview.findViewById(R.id.viewpager_second);
        mViewPager_item_thred = (ViewPager) rootview.findViewById(R.id.viewpager_thred);
        mViewPager_item_fouth = (ViewPager) rootview.findViewById(R.id.viewpager_fouth);

        viewpager_dot_first= (LinearLayout) rootview.findViewById(R.id.dot_group_first);
        viewpager_dot_second= (LinearLayout) rootview.findViewById(R.id.dot_group_second);
        viewpager_dot_third= (LinearLayout) rootview.findViewById(R.id.dot_group_third);
        viewpager_dot_fouth= (LinearLayout) rootview.findViewById(R.id.dot_group_fouth);


        myGridView = (MyGridView) rootview.findViewById(R.id.gradview_Recommend);

        mTextviewLoadmore= (TextView) rootview.findViewById(R.id.textview_loadmore);

        adBean = new ArrayList<>();//轮播广告bean
        mData_viewpager_promotion = new ArrayList<>();//促销商品 viewpager 总数据
        mData_viewpager_highQuality = new ArrayList<>();//精品推荐 viewpager 总数据
        mData_viewpager_flashSale=new ArrayList<>();//新品上市 viewpager 总数据
        mData_viewpager_hot=new ArrayList<>();//热销商品  viewpager总数据

        mList_like = new ArrayList<>();//猜你喜欢数据

        requestData();
        initListenner();

        return rootview;
    }
        int  main_like_page=1;//猜你喜欢接口的  页数  默认第一页
    private void initListenner() {
        /**
         * Grid猜你喜欢  点击 加载更多的监听
         */
        mTextviewLoadmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//  猜你喜欢  点击加载更多监听
                main_like_page++;
                requestLikeData(main_like_page);
            }
        });

        mViewPager_item_first.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i=0;i<fragments.get(0).size();i++){
                    viewpager_dot_first.getChildAt(i).setEnabled(false);//把上一个小圆点设为false
                }
                viewpager_dot_first.getChildAt(position).setEnabled(true);//设置小点为白色
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mViewPager_item_second.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i=0;i<fragments.get(1).size();i++){
                    viewpager_dot_second.getChildAt(i).setEnabled(false);//把上一个小圆点设为false
                }
                viewpager_dot_second.getChildAt(position).setEnabled(true);//设置小点为白色

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mViewPager_item_thred.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i=0;i<fragments.get(2).size();i++){
                    viewpager_dot_third.getChildAt(i).setEnabled(false);//把上一个小圆点设为false
                }
                viewpager_dot_third.getChildAt(position).setEnabled(true);//设置小点为白色

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mViewPager_item_fouth.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i=0;i<fragments.get(3).size();i++){
                    viewpager_dot_fouth.getChildAt(i).setEnabled(false);//把上一个小圆点设为false
                }
                viewpager_dot_fouth.getChildAt(position).setEnabled(true);//设置小点为白色

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {//坚挺猜你喜欢点击事件
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(), GoodDetailsActivity.class);
                intent.putExtra("ID",mList_like.get(i).getGoods_id());
                LogUtils.LOG("ceshi",mList_like.get(i).getGoods_id()+"IIIIDDDDD");
                getActivity().startActivity(intent);
            }
        });


    }

    private void setData() {
        /**
         * 顶部轮播图
         */
        if(mImagesURL.size()==0){
            mViewpager.setVisibility(View.GONE);
        }else{

            //设置图片加载器
            mViewpager.setImageLoader(new GlideImageLoader());
            //设置图片集合
            mViewpager.setImages(mImagesURL);
            //banner设置方法全部调用完毕时最后调用
            mViewpager.start();
        }




        /**
         * 初始化Adapter
         */
        FragmentAdapter mFragmentAdapter1 = new FragmentAdapter(getFragmentManager(), fragments.get(0));
        FragmentAdapter mFragmentAdapter2 = new FragmentAdapter(getFragmentManager(), fragments.get(1));
        FragmentAdapter mFragmentAdapter3 = new FragmentAdapter(getFragmentManager(), fragments.get(2));
        FragmentAdapter mFragmentAdapter4 = new FragmentAdapter(getFragmentManager(), fragments.get(3));
        mViewPager_item_first.setAdapter(mFragmentAdapter1);
        mViewPager_item_second.setAdapter(mFragmentAdapter2);
        mViewPager_item_thred.setAdapter(mFragmentAdapter3);
        mViewPager_item_fouth.setAdapter(mFragmentAdapter4);

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
                mData_viewpager_highQuality=mainbean.getResult().getHigh_quality_goods();//精品推荐 数据添加
                mData_viewpager_flashSale=mainbean.getResult().getNew_goods();//新品上市数据添加
                mData_viewpager_hot=mainbean.getResult().getHot_goods();//热销产品数据添加
                initData();
                setData();
                requestLikeData(1);//请求  猜你喜欢 数据

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
     *促销商品viewpager数据初始化
     * @param mlist  每个viewpager的总数居
     * @param viewpager_dots 放小白点的linearlayout
     * @param count viewpager里的fragment数量
     */
    private void initDataPromotion(List<MainBean.ResultBean.PromotionGoodsBean> mlist,LinearLayout viewpager_dots,int count){

         List<Fragment> fragments_first = new ArrayList<Fragment>();//存放fragment  viewpager需要适配使用
        List<List<MainBean.ResultBean.PromotionGoodsBean>> mData_Group_promotion;//单独一个viewpager总数据分为若干页的数据集合，传入到Fragment；

        mData_Group_promotion = new ArrayList<>();
        //算出viewpager的页数
        int page = mlist.size() / 3;//页数，余数为0的时候
        //将数据分发到每一页的fragment
        for (int i = 1; i < page + 1; i++) {
            List<MainBean.ResultBean.PromotionGoodsBean> child = new ArrayList<>();
            for (int j = 1; j < 4; j++) {
                child.add(mlist.get(j * i - 1));//每一组添加3个数据
            }
            mData_Group_promotion.add(child);//将数据添加到group中
            //将group中的list数据通过构造方法传入fragment
            fragments_first.add(new Fragment_main_viewpager_Promotion(mData_Group_promotion.get(i - 1)));
        }
        // 数据总和不是3的倍数需要另外处理
        int yushu_promotion = mlist.size() % 3;
        if (yushu_promotion != 0) {
            List<MainBean.ResultBean.PromotionGoodsBean> child = new ArrayList<>();
            for (int i = 3 * page; i < mlist.size(); i++) {
                child.add(mlist.get(i));
            }
            mData_Group_promotion.add(child);
            fragments_first.add(new Fragment_main_viewpager_Promotion(mData_Group_promotion.get(page)));
        }
        fragments.add(fragments_first);
       addDot(viewpager_dots ,count);
    }

    /**
     * 添加小白点到viewpager
     * @param viewpager_dot 放小白点的linearlayout
     * @param count  viewpager里的fragment数量
     */
    void addDot( LinearLayout viewpager_dot,int count){
        View dotview;
        for(int i=0;i<fragments.get(count).size();i++){
            //准备小圆点的数据
            dotview=new View(getContext());
            dotview.setBackgroundResource(R.drawable.dot_selector);
            //设置小圆点的宽和高
            LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(15,15);
            if(i!=0){
                params.leftMargin=10;//设置小白点间距
            }
            dotview.setLayoutParams(params);
            //设置小圆点的状态
            if(i==0){
                dotview.setEnabled(true);//第一个小白点初始化
            }else{
                dotview.setEnabled(false);
            }
            //把小圆点添加到线性布局中
            viewpager_dot.addView(dotview);

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
        //初始化数据   四种类型  初始化四次
        if(mData_viewpager_promotion.size()==0){
            mViewPager_item_first.setVisibility(View.GONE);
        }
        if(mData_viewpager_highQuality.size()==0){
            mViewPager_item_second.setVisibility(View.GONE);
        }
        if(mData_viewpager_flashSale.size()==0){
            mViewPager_item_thred.setVisibility(View.GONE);
        }
        if(mData_viewpager_hot.size()==0){
            mViewPager_item_fouth.setVisibility(View.GONE);
        }
        initDataPromotion(mData_viewpager_promotion,viewpager_dot_first,0);
        initDataPromotion(mData_viewpager_highQuality,viewpager_dot_second,1);
        initDataPromotion(mData_viewpager_flashSale,viewpager_dot_third,2);
        initDataPromotion(mData_viewpager_hot,viewpager_dot_fouth,3);

        mAdapter_main_like = new Adapter_Grid_main_like(mList_like, getActivity());//猜你喜欢 网格列表 适配器
        myGridView.setAdapter(mAdapter_main_like);///绑定适配器


    }

    class FragmentAdapter extends FragmentPagerAdapter {//viewpager fangmentAdapter
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
