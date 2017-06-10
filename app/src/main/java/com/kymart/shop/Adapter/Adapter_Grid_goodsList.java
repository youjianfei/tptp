package com.kymart.shop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kymart.shop.Bean.Goods_ListBean;
import com.kymart.shop.Http.BaseUrl;

import java.util.List;

import cn.kymart.tptp.R;

/**
 * Created by Administrator on 2017/6/9.
 */

public class Adapter_Grid_goodsList extends BaseAdapter{
    List<Goods_ListBean.ResultBean.GoodsListBean>mData;
    Context mContext;
    LayoutInflater mInflater;

    public Adapter_Grid_goodsList(List mDatas, Context mContext) {
        super(mDatas, mContext);
        this.mData=mDatas;
        this.mContext=mContext;
        mInflater=LayoutInflater.from(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        Goods_ListBean.ResultBean.GoodsListBean bean =mData.get(position);
        if(convertView==null){
            holder=new  ViewHolder();
            convertView=mInflater.inflate(R.layout.item_gridview_goodslist,null,false);
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


        return convertView;
    }
    class ViewHolder {
        ImageView mImageView;
        TextView mTextview_name;
        TextView mTextview_price;
    }
}
