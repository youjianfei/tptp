package com.kymart.shop.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kymart.shop.Adapter.Adapter_List_popwindow;
import com.kymart.shop.Bean.BuyGoodBean;
import com.kymart.shop.Bean.GoodDetailsBean;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.Volley_Utils;
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
    private TextView mTextview_GoodName;
    private  TextView mTextview_price,mTextview_result;




    private LinearLayout mLinearout_result;
    private GoodDetailsBean.Result resultBean;//请求下来的全部对象
    private GoodDetailsBean.Result.Goods  goodBean;//存放商品的对象
    private List<GoodDetailsBean.Result.Gallery> galleryBean;//存放图片地址的对象
    private List<String> mImagesURL;//图片网址集合

    private BuyGoodBean bugBean;

    private Adapter_List_popwindow mAdapter_pop;

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
        resultBean=new  GoodDetailsBean.Result();
        goodBean=new GoodDetailsBean.Result.Goods();
        galleryBean=new ArrayList<>();
        mData_Spec=new ArrayList<>();//商品属性

        bugBean=new BuyGoodBean();
        request();





    }

    private void initview() {
        mLinear_bottom= (LinearLayout) rootview.findViewById(R.id.LinearLayout_bottom);
        mBanner= (Banner) rootview.findViewById(R.id.Banner_goodImage);
        mTextview_GoodName= (TextView) rootview.findViewById(R.id.textview_goodName);
        mTextview_price= (TextView) rootview.findViewById(R.id.textview_goodPrice);
        mTextview_result= (TextView) rootview.findViewById(R.id.text_result);
        mLinearout_result= (LinearLayout) rootview.findViewById(R.id.LinearLayout_result);




    }
    void request(){
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                resultBean=new Gson().fromJson(respose,GoodDetailsBean.class).getResult();
                goodBean=resultBean.getGoods();
                galleryBean=resultBean.getGallery();
                lunBoTU();//顶部轮播图方法执行
                mTextview_GoodName.setText(goodBean.getGoods_name());

                mData_Spec=goodBean.getGoods_spec_list();


                //初始化选中数据
                bugBean.setGood_buy_id(goodBean.getGoods_id());
                bugBean.setGood_buy_count(1);
                bugBean.setGood_buy_store_count(goodBean.getStore_count());
                bugBean.setGood_buy_price(goodBean.getShop_price());
                List<BuyGoodBean.GoodsSpecList>good_buy_propertys=new ArrayList<>();
                for(int i=0;i<goodBean.getGoods_spec_list().size();i++){
                    LogUtils.LOG("ceshi","sadfsadfsdaf");
                    BuyGoodBean.GoodsSpecList buy_propertys=new BuyGoodBean.GoodsSpecList();
                    buy_propertys.setSpec_name(goodBean.getGoods_spec_list().get(i).getSpec_name());
                    GoodDetailsBean.Result.Goods.GoodsSpecList.SpecList  specList= new  GoodDetailsBean.Result.Goods.GoodsSpecList.SpecList();
                    specList=goodBean.getGoods_spec_list().get(i).getSpec_list().get(0);
                    LogUtils.LOG("ceshi","sssssss");
                    buy_propertys.setSpec_list(specList);
                    good_buy_propertys.add(buy_propertys);

                }

                bugBean.setGood_buy_propertys(good_buy_propertys);
                List<GoodDetailsBean.Result.SpecGoodsPrice>spec_goods_prices =new ArrayList<>();
                spec_goods_prices=resultBean.getSpec_goods_price();
                bugBean.setSpec_goods_prices(spec_goods_prices);
                bugBean.reload();

                afterQequest();
            }

            @Override
            public void onError(int error) {

            }
        }).Http(BaseUrl.BaseURL+BaseUrl.goodDetails+"&id=105",getActivity(),0);
    }

     void afterQequest(){
         mTextview_price.setText(bugBean.getGood_buy_price());
         mTextview_result.setText(bugBean.getGood_select_info());


     }

    void  lunBoTU(){
        /**
         * 顶部轮播图
         */
        mImagesURL=new ArrayList<>();
        for(int i=0;i<galleryBean.size();i++){
            mImagesURL.add(galleryBean.get(i).getImage_url());
        }
        mImagesURL.addAll(mImagesURL);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(mImagesURL);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }




    private ListView mListview_pop;
    private ImageView mImage_PIC,mImage_close;
    private List<GoodDetailsBean.Result.Goods.GoodsSpecList>mData_Spec;
    private void showPopwindow() {
        //初始化popwindow；
        View conView=LayoutInflater.from(getActivity()).inflate(R.layout.popwindow_gooddetail,null,false);
        mPopupWindow=new PopupWindow(conView,
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setOutsideTouchable(true);// 触摸popupwindow外部，popupwindow消失
        mPopupWindow.showAtLocation(mLinear_bottom, Gravity.BOTTOM, 0, 0);
        mListview_pop= (ListView) conView.findViewById(R.id.Listview_popwindow);
        mImage_close= (ImageView) conView.findViewById(R.id.ImageView_close);


        mAdapter_pop=new Adapter_List_popwindow(mData_Spec,getActivity());
        mListview_pop.setAdapter(mAdapter_pop);

        setAlpha((float) 0.3);

        initListenner_POP();
    }

    private void initListenner_POP() {
        mImage_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
                setAlpha((float) 1.0);
            }
        });
    }

    public void setAlpha(float bgAlpha) {//设置背景遮罩颜色
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getActivity().getWindow().setAttributes(lp);
    }
}
