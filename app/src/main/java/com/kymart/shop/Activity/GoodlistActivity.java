package com.kymart.shop.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.kymart.shop.Adapter.Adapter_Grid_main_like;
import com.kymart.shop.Adapter.BaseAdapter;
import com.kymart.shop.Bean.Activity_goodList;
import com.kymart.shop.Bean.mainLike;
import com.kymart.shop.CustomView.MyGridView;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.Utils;
import com.kymart.shop.Utils.Volley_Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.kymart.tptp.R;

public class GoodlistActivity extends BaseActivityother {

    private PullToRefreshListView mlistview_goods;

    String url__="";
    String title="";

    private  TextView textview_title;

    List <Activity_goodList.ResultBean> AllListData;

    Adapter_list_all mAdapter;
    Adapter_Grid_goods madapter_grid;


    @Override
    public int setLayoutResID() {
        return R.layout.activity_goodlist;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {
        Intent intent=getIntent();
        url__=intent.getStringExtra("url");
        title=intent.getStringExtra("title");
        textview_title.setText(title);
        request(url__);
        AllListData=new ArrayList<>();
        mAdapter=new Adapter_list_all(AllListData,this);
        mlistview_goods.setAdapter(mAdapter);

    }
    void request(String url){
        String URL=url;
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                int  status=0;
                String msg="";
                try {
                    JSONObject object=new JSONObject(respose);
                    status = (Integer) object.get("status");//登录状态
                    msg = (String) object.get("msg");//登录返回信息
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if(status==1){
                    AllListData.addAll(new Gson().fromJson(respose,Activity_goodList.class).getResult());
                    mAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onError(int error) {

            }
        }).Http(URL,this,0);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        textview_title= (TextView) findViewById(R.id.textview_title);
        mlistview_goods= (PullToRefreshListView) findViewById(R.id.listView_goods);
    }


    public class Adapter_list_all extends BaseAdapter {
        private List<Activity_goodList.ResultBean> mdata;
        private Context mContext;
        private LayoutInflater mInflater;

        public Adapter_list_all(List mDatas, Context mContext) {
            super(mDatas, mContext);
            this. mdata=mDatas;
            this. mContext=mContext;
            mInflater=LayoutInflater.from(mContext);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder=null;
            final Activity_goodList.ResultBean bean =mdata.get(position);
            if(convertView==null){
                holder=new ViewHolder();
                convertView=mInflater.inflate(R.layout.item_activitygoodslist,null,false);
                holder.mtextview_title= (TextView) convertView.findViewById(R.id.textview_item_title);
                holder.mtextview_more= (TextView) convertView.findViewById(R.id.text_more);
                holder.myGridView= (MyGridView) convertView.findViewById(R.id.gridview_goods);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
             holder.mtextview_title.setText(bean.getMobile_name());
            if(bean.getMore_url().equals("")){
                holder.mtextview_more.setVisibility(View.INVISIBLE);
            }else {
                holder.mtextview_more.setVisibility(View.VISIBLE);
            }
            holder.mtextview_more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent_more=new Intent(getApplicationContext(),GoodSearchActivity.class);
                    intent_more.putExtra("more_url","/index.php?"+bean.getMore_url());
                    LogUtils.LOG("ceshi","more_url"+bean.getMore_url());
                    startActivity(intent_more);

                }
            });
            final List<Activity_goodList.ResultBean.ItemBean> mdata=new ArrayList<>();
            mdata.addAll(bean.getItem());
            madapter_grid=new Adapter_Grid_goods(mdata,mContext);
            holder.myGridView.setAdapter(madapter_grid);
            holder.myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent=new Intent(GoodlistActivity.this,GoodDetailsActivity.class);
                        intent.putExtra("ID",mdata.get(i).getGoods_id());

                    GoodlistActivity.this.startActivity(intent);
                }
            });

            return convertView;
        }
        class ViewHolder{
            private TextView mtextview_title,mtextview_more;
            private MyGridView myGridView;
        }


    }
    public class Adapter_Grid_goods extends BaseAdapter{
        private List<Activity_goodList.ResultBean.ItemBean> mData;
        private Context mContext;
        private LayoutInflater mInflater;

        public Adapter_Grid_goods(List mDatas, Context mContext) {
            super(mDatas, mContext);
            this.mData=mDatas;
            this.mContext=mContext;
            mInflater=LayoutInflater.from(mContext);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
           ViewHolder holder=null;
            Activity_goodList.ResultBean.ItemBean bean=mData.get(position);
            if(convertView==null){
                holder=new ViewHolder();
                convertView=mInflater.inflate(R.layout.item_gridview_12fenlei,null,false);
                holder.mImageView_icon= (ImageView) convertView.findViewById(R.id.imageview_icon);
                holder.mImage= (ImageView) convertView.findViewById(R.id.imageview_item_thing1);
                holder.mtextview_name= (TextView) convertView.findViewById(R.id.textview_item_name1);
                holder.mtextview_price= (TextView) convertView.findViewById(R.id.textview_item_price1);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            Glide.with(mContext).load(BaseUrl.BaseURL+BaseUrl.main_imgURL+bean.getGoods_id()).into(holder.mImage);
            holder.mtextview_name.setText(bean.getGoods_name());
            holder.mtextview_price.setText("￥"+bean.getShop_price());
            holder.mImageView_icon.setImageResource(Utils.selectICON(bean.getKy_type()));

            return convertView;
        }
        class ViewHolder {
            ImageView mImage;
            TextView mtextview_name;
            TextView mtextview_price;
            ImageView mImageView_icon;

        }
    }


}
