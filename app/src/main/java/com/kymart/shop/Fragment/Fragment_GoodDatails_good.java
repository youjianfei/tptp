package com.kymart.shop.Fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.kymart.shop.Activity.LoginActivity;
import com.kymart.shop.Activity.ShopcarActivity;
import com.kymart.shop.Adapter.Adapter_List_popwindow;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Bean.BuyGoodBean;
import com.kymart.shop.Bean.GoodDetailsBean;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.ToastUtils;
import com.kymart.shop.Utils.Utils;
import com.kymart.shop.Utils.Volley_Utils;
import com.kymart.shop.class_.GlideImageLoader;
import com.youth.banner.Banner;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.kymart.tptp.R;
import ren.qinc.numberbutton.NumberButton;

import static com.kymart.shop.AppStaticData.Staticdata.isLogin;
import static com.kymart.shop.AppStaticData.Staticdata.userBean_static;

/**
 * Created by Administrator on 2017/6/10.
 */
@SuppressLint("ValidFragment")
public class Fragment_GoodDatails_good extends Fragment {
    View rootview;
    private int Id;
    private LinearLayout mLinear_bottom;
    private Banner mBanner;
    private TextView mTextview_GoodName;
    private TextView mTextview_price,mTextview_result,mtextview_Addshopcar,mtextview_buynow;
    private ImageView mImageview_icon;



    private LinearLayout mLinearout_result;
    private GoodDetailsBean.ResultBean resultBean;//请求下来的全部对象
    private GoodDetailsBean.ResultBean.GoodsBean  goodBean;//存放商品的对象
    private List<GoodDetailsBean.ResultBean.GalleryBean> galleryBean;//存放图片地址的对象
    private List<String> mImagesURL;//图片网址集合


    private Adapter_List_popwindow mAdapter_pop;

    PopupWindow mPopupWindow;

    public Fragment_GoodDatails_good(int id) {
       this. Id = id;
    }

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
        mtextview_Addshopcar.setOnClickListener(new View.OnClickListener() {//点击外面的加入购物车
            @Override
            public void onClick(View v) {
                if(isLogin==1) {//登录状态,添加到购物车
                    Map map;
                    map=count();
                    if(map!=null){
                        request_addShopCar(map,false);
                    }

                }else{
                    Intent intent=new Intent(getActivity(),LoginActivity.class);
                    getActivity(). startActivity(intent);
                }
            }
        });
        mtextview_buynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isLogin==1) {//登录状态,添加到购物车
                    Map map;
                    map=count();
                    if(map!=null){
                        request_addShopCar(map,true);
                    }

                }else{
                    Intent intent=new Intent(getActivity(),LoginActivity.class);
                    getActivity(). startActivity(intent);

                }
            }
        });
    }

    private void setData() {
        resultBean=new  GoodDetailsBean.ResultBean();
        goodBean=new GoodDetailsBean.ResultBean.GoodsBean();
        galleryBean=new ArrayList<>();
        mData_Spec=new ArrayList<>();//商品属性

        request();





    }

    private void initview() {
        mLinear_bottom= (LinearLayout) rootview.findViewById(R.id.LinearLayout_bottom);
        mBanner= (Banner) rootview.findViewById(R.id.Banner_goodImage);
        mImageview_icon= (ImageView) rootview.findViewById(R.id.imageview_icon);
        mTextview_GoodName= (TextView) rootview.findViewById(R.id.textview_goodName);
        mTextview_price= (TextView) rootview.findViewById(R.id.textview_goodPrice);
        mTextview_result= (TextView) rootview.findViewById(R.id.text_result);
        mLinearout_result= (LinearLayout) rootview.findViewById(R.id.LinearLayout_result);
        mtextview_Addshopcar= (TextView) rootview.findViewById(R.id.textview_Addshopcar);
        mtextview_buynow= (TextView) rootview.findViewById(R.id.textview_buy);

    }
    void request(){
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi","商品详情url:"+BaseUrl.BaseURL+BaseUrl.goodDetails+"&id="+Id);
                LogUtils.LOG("ceshi","商品详情："+respose);

                if(resultBean==null){
                    return;
                }
                resultBean=new Gson().fromJson(respose,GoodDetailsBean.class).getResult();
                if(goodBean==null){
                    return;
                }
                goodBean=resultBean.getGoods();

                if(galleryBean==null){
                    return;
                }
                galleryBean=resultBean.getGallery();
                mImageview_icon.setImageResource(Utils.selectICON(goodBean.getKy_type()));
                lunBoTU();//顶部轮播图方法执行
                mTextview_GoodName.setText(goodBean.getGoods_name());

                mData_Spec=resultBean.getGoods_spec_list();

                Initialization();//初始化选中数据


            }

            @Override
            public void onError(int error) {

            }
        }).Http(BaseUrl.BaseURL+BaseUrl.goodDetails+"&id="+Id,getActivity(),0);
        LogUtils.LOG("ceshi","商品详情接口"+BaseUrl.BaseURL+BaseUrl.goodDetails+"&id="+Id);
    }
    void Initialization(){//初始化数据
        //初始化选中数据
        Staticdata.bean.setGood_buy_id(goodBean.getGoods_id());
        Staticdata.bean.setGood_buy_count(1);
        Staticdata.bean.setGood_buy_store_count(goodBean.getStore_count());
        Staticdata.bean.setGood_buy_price(goodBean.getShop_price());
        List<BuyGoodBean.GoodsSpecList>good_buy_propertys=new ArrayList<>();
        if(resultBean.getGoods_spec_list()==null){
            return;
        }
        for(int i=0;i<resultBean.getGoods_spec_list().size();i++){
            BuyGoodBean.GoodsSpecList buy_propertys=new BuyGoodBean.GoodsSpecList();
            buy_propertys.setSpec_name(resultBean.getGoods_spec_list().get(i).getSpec_name());
            GoodDetailsBean.ResultBean.GoodsSpecListBean.SpecListBean  specList= new  GoodDetailsBean.ResultBean.GoodsSpecListBean.SpecListBean();
            specList=resultBean.getGoods_spec_list().get(i).getSpec_list().get(0);
            buy_propertys.setSpec_list(specList);
            good_buy_propertys.add(buy_propertys);

        }

        Staticdata.bean.setGood_buy_propertys(good_buy_propertys);
        List<GoodDetailsBean.ResultBean.SpecGoodsPriceBean>spec_goods_prices =new ArrayList<>();
        spec_goods_prices=resultBean.getSpec_goods_price();
        Staticdata.bean.setSpec_goods_prices(spec_goods_prices);
        Staticdata.bean.reload();

        afterQequest();
    }


    public  void afterQequest(){
         mTextview_price.setText("￥"+Staticdata.bean.getGood_buy_price());
         mTextview_result.setText(Staticdata.bean.getGood_select_info());

     }

    void  lunBoTU(){
        /**
         * 顶部轮播图
         */
        mImagesURL=new ArrayList<>();
        if(galleryBean!=null||galleryBean.size()!=0){
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

    }




    private TextView mTextview_price_pop,mTextview_goodNumber,mTextview_addShopCar;
    private ListView mListview_pop;
    private ImageView mImage_PIC,mImage_close;
    private List<GoodDetailsBean.ResultBean.GoodsSpecListBean>mData_Spec;
    private NumberButton mNumberButton;
    private void showPopwindow() {

        Initialization();
        //初始化popwindow；
        View conView=LayoutInflater.from(getActivity()).inflate(R.layout.popwindow_gooddetail,null,false);
        mPopupWindow=new PopupWindow(conView,
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setOutsideTouchable(true);// 触摸popupwindow外部，popupwindow消失
        mPopupWindow.showAtLocation(mLinear_bottom, Gravity.BOTTOM, 0, 0);
        mListview_pop= (ListView) conView.findViewById(R.id.Listview_popwindow);
        mImage_close= (ImageView) conView.findViewById(R.id.ImageView_close);
        mImage_PIC= (ImageView) conView.findViewById(R.id.image_goodIPC);
        mTextview_price_pop= (TextView) conView.findViewById(R.id.text_price_pop);
        mTextview_goodNumber= (TextView) conView.findViewById(R.id.textview_goodsNumber);
        mNumberButton= (NumberButton) conView.findViewById(R.id.numberButton);
        mTextview_addShopCar= (TextView) conView.findViewById(R.id.textview_addShopcar);


        mNumberButton.setCurrentNumber(1);//数量按钮 设置初始化数量


        mAdapter_pop=new Adapter_List_popwindow(mData_Spec,getActivity());
        mListview_pop.setAdapter(mAdapter_pop);

        Initialization();//初始化选中数据；

        setAlpha((float) 0.3);
        afterShowpopwinsow();
        initListenner_POP();
    }
    public   void afterShowpopwinsow(){

        Glide.with(getActivity()).load(BaseUrl.BaseURL+BaseUrl.main_imgURL+Id).into(mImage_PIC);//设置pop 商品图片
        LogUtils.LOG("ceshi",Staticdata.bean.getGood_buy_price()+"手机的价格");
        mTextview_price_pop.setText("￥"+Staticdata.bean.getGood_buy_price());
        mTextview_goodNumber.setText("商品编号 "+goodBean.getGoods_sn());


    }

     Map  count(){//加入购物车之前   得到de选择
         int goodCount=1;
         if(mNumberButton!=null){
              goodCount=mNumberButton.getNumber();
         }

        String goodCount_="";//添加的数量

        if(goodCount>Staticdata.bean.getGood_buy_store_count()){
            ToastUtils.showToast(getActivity(),"当前库存为"+Staticdata.bean.getGood_buy_store_count());
            return null;
        }else{
            goodCount_=goodCount+"";
        }


        String goodID=Staticdata.bean.getGood_buy_id()+"";//添加的商品ＩＤ;
         Map<String,Object> map=new HashMap();
        if(Staticdata.bean.getGood_buy_propertys_copy()!=null||Staticdata.bean.getGood_buy_propertys_copy().size()!=0){
            int i=Staticdata.bean.getGood_buy_propertys_copy().size();
            LogUtils.LOG("ceshi","添加购物车的属性"+Staticdata.bean.getGood_buy_propertys_copy()+"属性个数"+i);
//            String goodPropertys_addShop[]=new  String[i];
            List<String> goodPropertys_addShop=new ArrayList<>();//添加的商品属性 数组
            for(int j=0;j<i;j++){
                goodPropertys_addShop.add(Staticdata.bean.getGood_buy_propertys_copy().get(j).getSpec_list().getItem_id()+"");
                LogUtils.LOG("ceshi11",goodPropertys_addShop.toString()+"集合");
            }
            map.put("goods_num",goodCount_);
            map.put("goods_id",goodID);
            map.put("goods_spec",goodPropertys_addShop);
        }else{
            map.put("goods_num",goodCount_);
            map.put("goods_id",goodID);
            map.put("goods_spec","[]");
        }



        return map;
    }


    private void initListenner_POP() {
        mImage_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
                setAlpha((float) 1.0);
            }
        });
        mTextview_addShopCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isLogin==1) {//登录状态,添加到购物车
                    Map map=new HashMap();
                    map=count();
                    if(map!=null){
                        request_addShopCar(map,false);
                    }

                }else{
                    Intent intent=new Intent(getActivity(),LoginActivity.class);
                    getActivity(). startActivity(intent);

                }
            }
        });


        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setAlpha((float) 1.0);
            }
        });
    }

    RequestQueue requestQueue ;


    void request_addShopCar(Map<String ,Object> map, final boolean isbuynow){
        LogUtils.LOG("ceshi","postMap"+map.toString());
        requestQueue = Volley.newRequestQueue(getActivity());

        JSONObject jsonObject = new JSONObject(map);
        JsonRequest<JSONObject> jsonRequest = new JsonObjectRequest(Request.Method.POST,BaseUrl.BaseURL+BaseUrl.addShopCar+Staticdata.UUID_static+"&token="+userBean_static.getResult().getToken(), jsonObject,

                new Response.Listener<JSONObject>() {

                    @Override

                    public void onResponse(JSONObject response) {
                        if(mPopupWindow!=null&&mPopupWindow.isShowing()){
                            mPopupWindow.dismiss();
                        }
                        JSONObject object = null;
                        try {
                            object = new JSONObject(response.toString());
                            int status = (Integer) object.get("status");
                            String  msg = (String) object.get("msg");
                            LogUtils.LOG("ceshi","添加购物车成功"+response);
                            ToastUtils.showToast(getActivity(),msg);
                            if(isbuynow&&status==1){//如果是立即购买
                            Intent intent=new Intent(getActivity(), ShopcarActivity.class);
                                startActivity(intent);
                                getActivity().finish();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                }, new Response.ErrorListener() {

            @Override

            public void onErrorResponse(VolleyError error) {

                ToastUtils.showToast(getActivity(),"添加购物车失败");
            }

        });

        requestQueue.add(jsonRequest);
    }




    public void setAlpha(float bgAlpha) {//设置背景遮罩颜色
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getActivity().getWindow().setAttributes(lp);
    }
}
