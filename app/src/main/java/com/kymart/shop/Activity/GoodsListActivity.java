package com.kymart.shop.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.kymart.shop.Http.BaseUrl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.kymart.shop.Adapter.Adapter_Grid_goodsList;
import com.kymart.shop.Bean.Goods_ListBean;
import com.kymart.shop.CustomView.MyGridView;
import com.kymart.shop.Interface.Interface_volley_respose;
import cn.kymart.tptp.R;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.ToastUtils;
import com.kymart.shop.Utils.Volley_Utils;

public class GoodsListActivity extends BaseActivityother {
    private RelativeLayout mRelativeLayout_Latest, mRelativeLayout_Sales, mRelativeLayout_Price, mRelativeLayout_Comments;//顶部四个按钮控件
    private LinearLayout mLinearlayout_search;
    private PullToRefreshGridView mGridview;
    private EditText medit_view;


    private List<Goods_ListBean.ResultBean.GoodsListBean> mDate;//grid数据集合
    private Goods_ListBean.ResultBean  resultBean;
    private Adapter_Grid_goodsList mAdapter;


    @Override
    public int setLayoutResID() {
        return R.layout.activity_goods_list;
    }

    @Override
    protected void setData() {
        requestData(page);

    }


    String url="";//后面拼接网址，四个按钮有四个
    int ID=0;
    int page=1;
    void requestData(final int page ){
        String URLl= BaseUrl.BasegoodlistURL+url+page;
        LogUtils.LOG("ceshi","商品列表网址"+URLl);

        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                if (mGridview.isRefreshing()) {
                    mGridview.onRefreshComplete();
                }
                resultBean=new Gson().fromJson(respose,Goods_ListBean.class).getResult();
                LogUtils.LOG("ceshi","商品列表"+respose);
                LogUtils.LOG("ceshi","url"+BaseUrl.BasegoodlistURL+url+page);
                LogUtils.LOG("ceshi",resultBean.getSort()+respose);
                if(resultBean.getGoods_list()==null||resultBean.getGoods_list().size()==0){
                    ToastUtils.showToast(GoodsListActivity.this,"没有更多了");
                }
                if(page==1&&resultBean.getGoods_list()!=null){
                    mDate.clear();

                    mDate.addAll(resultBean.getGoods_list());
                    mAdapter.notifyDataSetChanged();

                }else if(page!=1&&resultBean.getGoods_list()!=null){
                    mDate.addAll(resultBean.getGoods_list());
                    mAdapter.notifyDataSetChanged();

                }

            }
            @Override
            public void onError(int error) {
                if (mGridview.isRefreshing()) {
                    mGridview.onRefreshComplete();
                }
            }
        }).Http(URLl,this,0);
    }

    @Override
    protected void initData() {

        Intent intent=getIntent();
        ID=intent.getIntExtra("id",1);
        if(ID==0){

            url="/index.php?m=Api&c=Goods&a=goodsList&p=";
        }else{
            url="/index.php/api/Goods/goodsList/id/"+ID+"/sort/is_new/sort_asc/desc/p/";
        }
        mDate=new ArrayList<>();
        mAdapter=new Adapter_Grid_goodsList(mDate,this);
        mGridview.setAdapter(mAdapter);
    }

    @Override
    protected void initListener() {
        mRelativeLayout_Latest.setOnClickListener(this);
        mRelativeLayout_Sales.setOnClickListener(this);
        mRelativeLayout_Price.setOnClickListener(this);
        mRelativeLayout_Comments.setOnClickListener(this);
        mLinearlayout_search.setOnClickListener(this);

        mGridview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
                requestData(1);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                requestData(++page);
            }
        });

        mGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(GoodsListActivity.this,GoodDetailsActivity.class);
                intent.putExtra("ID",mDate.get(i).getGoods_id());
                GoodsListActivity.this.startActivity(intent);
            }
        });
    }

    @Override
    protected void initView() {
        mRelativeLayout_Latest = (RelativeLayout) findViewById(R.id.RelativeLayout_Latest);
        mRelativeLayout_Sales = (RelativeLayout) findViewById(R.id.RelativeLayout_Sales);
        mRelativeLayout_Price = (RelativeLayout) findViewById(R.id.RelativeLayout_Price);
        mRelativeLayout_Comments = (RelativeLayout) findViewById(R.id.RelativeLayout_Comments);
        mLinearlayout_search= (LinearLayout) findViewById(R.id.linearlayout_search);
        medit_view= (EditText) findViewById(R.id.edit_serach);
        mGridview= (PullToRefreshGridView) findViewById(R.id.GridView_goodslist);
        mRelativeLayout_Latest.setSelected(true);//初始最新  设为选中

    }
    String search_name="";//转码前搜索的文字
    String afterchange="";//转码后的文字
    @Override
    public void onClick(View v) {
        super.onClick(v);

        switch (v.getId()) {
            case R.id.RelativeLayout_Latest:
                initButton();
                mRelativeLayout_Latest.setSelected(true);
                url=resultBean.getOrderby_is_new()+"/p/";
                if(url.contains(search_name)){
                    url =   url.replace(search_name,afterchange);
                }

                page=1;
                requestData(1);
                break;
            case R.id.RelativeLayout_Sales:
                initButton();
                mRelativeLayout_Sales.setSelected(true);
                url=resultBean.getOrderby_sales_sum()+"/p/";
                if(url.contains(search_name)){
                    LogUtils.LOG("ceshi",url);
                   url =url.replace(search_name,afterchange);
                }
                page=1;
                requestData(1);
                break;
            case R.id.RelativeLayout_Price:
                initButton();
                mRelativeLayout_Price.setSelected(true);
                url=resultBean.getOrderby_price()+"/p/";
                if(url.contains(search_name)){
                    url =  url.replace(search_name,afterchange);
                }
                page=1;
                requestData(1);
                break;
            case R.id.RelativeLayout_Comments:
                initButton();
                mRelativeLayout_Comments.setSelected(true);
                url=resultBean.getOrderby_comment_count()+"/p/";
                if(url.contains(search_name)){
                    url = url.replace(search_name,afterchange);
                }
                page=1;
                requestData(1);
                break;

            case R.id.linearlayout_search:

                Intent intent_seach=new Intent(this,GoodSearchActivity.class);
                intent_seach.putExtra("search_kt",0);
                startActivity(intent_seach);
                break;

        }
    }

    void initButton() {
        mRelativeLayout_Latest.setSelected(false);
        mRelativeLayout_Sales.setSelected(false);
        mRelativeLayout_Price.setSelected(false);
        mRelativeLayout_Comments.setSelected(false);

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
