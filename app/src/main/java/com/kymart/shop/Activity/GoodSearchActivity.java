package com.kymart.shop.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kymart.shop.Adapter.Adapter_Grid_goodsList;
import com.kymart.shop.Bean.Goods_ListBean;
import com.kymart.shop.CustomView.MyGridView;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.ToastUtils;
import com.kymart.shop.Utils.Volley_Utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import cn.kymart.tptp.R;

public class GoodSearchActivity extends BaseActivityother {

    private MyGridView mGridview;
    private TextView mTextVIew_loadMore,mTextview_search;//加载更多控件
    private EditText medit_view;


    private List<Goods_ListBean.ResultBean.GoodsListBean> mDate;//grid数据集合
    private Goods_ListBean.ResultBean  resultBean;
    private Adapter_Grid_goodsList mAdapter;


    @Override
    public int setLayoutResID() {
        return R.layout.activity_good_search;
    }

    @Override
    protected void setData() {

    }


    String url="";//后面拼接网址，四个按钮有四个
    int search_kt=0;
    int page=1;
    void requestData(final int page ){
        String URLl= BaseUrl.BasegoodlistURL+url+page;
        LogUtils.LOG("ceshi","商品列表网址"+URLl);

        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {

                resultBean=new Gson().fromJson(respose,Goods_ListBean.class).getResult();
                LogUtils.LOG("ceshi","商品列表"+respose);
                LogUtils.LOG("ceshi","url"+BaseUrl.BasegoodlistURL+url+page);
                LogUtils.LOG("ceshi",resultBean.getSort()+respose);
                if(page==1&&resultBean.getGoods_list()!=null){
                    mDate.clear();

                    mDate.addAll(resultBean.getGoods_list());
                    mAdapter.notifyDataSetChanged();
                    if(mDate.size()==0){
                        ToastUtils.showToast(GoodSearchActivity.this,"没有该商品");
                    }
                }else if(page!=1&&resultBean.getGoods_list()!=null){
                    mDate.addAll(resultBean.getGoods_list());
                    mAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onError(int error) {

            }
        }).Http(URLl,this,0);

    }

    @Override
    protected void initData() {

        Intent intent=getIntent();
        search_kt=intent.getIntExtra("search_kt",0);
        mDate=new ArrayList<>();
        mAdapter=new Adapter_Grid_goodsList(mDate,this);
        mGridview.setAdapter(mAdapter);
    }

    @Override
    protected void initListener() {
        mTextVIew_loadMore.setOnClickListener(this);
        mTextview_search.setOnClickListener(this);

        mGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(GoodSearchActivity.this,GoodDetailsActivity.class);
                intent.putExtra("ID",mDate.get(i).getGoods_id());
                GoodSearchActivity.this.startActivity(intent);
            }
        });
    }

    @Override
    protected void initView() {
        mTextview_search= (TextView) findViewById(R.id.text_serach);
        medit_view= (EditText) findViewById(R.id.edit_serach);
        mGridview= (MyGridView) findViewById(R.id.GridView_goodslist);
        mTextVIew_loadMore= (TextView) findViewById(R.id.textview_loadmore);

    }
    String search_name="";//转码前搜索的文字
    String afterchange="";//转码后的文字
    @Override
    public void onClick(View v) {
        super.onClick(v);

        switch (v.getId()) {


            case R.id.textview_loadmore://加载更多
                requestData(++page);
                break;
            case R.id.text_serach:
                search_name =medit_view.getText()+"";
                if(!search_name.equals("")){
                    afterchange= ZhuanMa(search_name);
                    url="/index.php?m=Api&c=goods&a=search&q="+afterchange+"&kt="+search_kt+"&p=";
                    requestData(1);
                }

                break;
        }
    }


    /**
     * 汉字转为url编码  原因   volley不支持含有汉字的网址
     */
    public String  ZhuanMa(String string){

        //URL编码
        String nameStr= null;
        try {
            nameStr = new String(URLEncoder.encode(string,"utf-8").getBytes());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return nameStr;
    }
}
