package com.kymart.shop.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.kymart.shop.Adapter.Adapter_Grid_goodsList;
import com.kymart.shop.Adapter.BaseAdapter;
import com.kymart.shop.Bean.GoodList_ModouleBean;
import com.kymart.shop.Bean.Goods_ListBean;
import com.kymart.shop.CustomView.MyGridView;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.Utils;
import com.kymart.shop.Utils.Volley_Utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import cn.kymart.tptp.R;

public class GoodList_moduleActivity extends BaseActivityother {

    private MyGridView mGridview;
    private TextView mTextVIew_loadMore;//加载更多控件
    private LinearLayout mLinearlayout_search;


    private List<GoodList_ModouleBean.ResultBean> mDate;//grid数据集合
    private GoodList_ModouleBean  Bean;//  促销  秒杀使用
    private Goods_ListBean.ResultBean  resultBean;//搜索使用
    private Adapter_Grid_goodsList_modouble mAdapter;


    @Override
    public int setLayoutResID() {
        return R.layout.activity_good_list_module;
    }

    @Override
    protected void setData() {
        requestData(TYPE,page);

    }


    String url="";
    String TYPE="";
    int search_kt=0;
    int page=1;
    void requestData(String type,final int page ){
        String URLl= BaseUrl.BasegoodlistURL+url+page;
        LogUtils.LOG("ceshi","商品列表网址"+URLl);

        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {

                Bean=new Gson().fromJson(respose,GoodList_ModouleBean.class);
                LogUtils.LOG("ceshi","商品列表"+respose);
                LogUtils.LOG("ceshi","url"+BaseUrl.BasegoodlistURL+url+page);


                if(page==1&&Bean.getResult()!=null){
                    search_kt=Bean.getSearch_kt();
                    mDate.clear();
                    mDate.addAll(Bean.getResult());
                    mAdapter.notifyDataSetChanged();
                }else if(page!=1&&Bean.getResult()!=null){
                    search_kt=Bean.getSearch_kt();
                    mDate.addAll(Bean.getResult());
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
        TYPE=intent.getStringExtra("type");
        url="/index.php?m=Api&c=activity&a="+TYPE+"&p=";
        mDate=new ArrayList<>();
        mAdapter=new Adapter_Grid_goodsList_modouble(mDate,this);
        mGridview.setAdapter(mAdapter);
    }

    @Override
    protected void initListener() {
        mTextVIew_loadMore.setOnClickListener(this);
        mLinearlayout_search.setOnClickListener(this);
        mGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(GoodList_moduleActivity.this,GoodDetailsActivity.class);
                intent.putExtra("ID",mDate.get(i).getGoods_id());
                GoodList_moduleActivity.this.startActivity(intent);
            }
        });
    }

    @Override
    protected void initView() {
        mGridview= (MyGridView) findViewById(R.id.GridView_goodslist);
        mTextVIew_loadMore= (TextView) findViewById(R.id.textview_loadmore);
        mLinearlayout_search= (LinearLayout) findViewById(R.id.linearlayout_search);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);

        switch (v.getId()) {


            case R.id.textview_loadmore://加载更多
                requestData(TYPE,++page);
                break;
            case R.id.linearlayout_search:
                Intent intent_seach=new Intent(this,GoodSearchActivity.class);
                intent_seach.putExtra("search_kt",search_kt);
                startActivity(intent_seach);
                break;
        }
    }

    class Adapter_Grid_goodsList_modouble extends BaseAdapter {
        List<GoodList_ModouleBean.ResultBean>mData;
        Context mContext;
        LayoutInflater mInflater;

        public Adapter_Grid_goodsList_modouble(List mDatas, Context mContext) {
            super(mDatas, mContext);
            this.mData=mDatas;
            this.mContext=mContext;
            mInflater=LayoutInflater.from(mContext);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder=null;
            GoodList_ModouleBean.ResultBean bean =mData.get(position);
            if(convertView==null){
                holder=new ViewHolder();
                convertView=mInflater.inflate(R.layout.item_gridview_goodslist,null,false);
                holder.mImageView_icon= (ImageView) convertView.findViewById(R.id.imageview_icon);
                holder.mImageView= (ImageView) convertView.findViewById(R.id.image_goods);
                holder.mTextview_name= (TextView) convertView.findViewById(R.id.text_name);
                holder.mTextview_price= (TextView) convertView.findViewById(R.id.textview_price);
                convertView.setTag(holder);
            }else {
                holder= (ViewHolder) convertView.getTag();
            }
            holder.mTextview_name.setText(bean.getGoods_name());
            holder.mTextview_price.setText(bean.getShop_price()+"元");
            Glide.with(mContext).load(BaseUrl.BaseURL+BaseUrl.main_imgURL+bean.getGoods_id()).into(holder.mImageView);
            holder.mImageView_icon.setImageResource(Utils.selectICON(bean.getKy_type()));

            return convertView;
        }
        class ViewHolder {
            ImageView mImageView;
            ImageView mImageView_icon;
            TextView mTextview_name;
            TextView mTextview_price;
        }
    }
}
