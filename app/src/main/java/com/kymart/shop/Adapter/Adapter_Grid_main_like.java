package com.kymart.shop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kymart.shop.Bean.mainLike;
import com.kymart.shop.Http.BaseUrl;

import java.util.List;

import cn.kymart.tptp.R;

/**
 * Created by PC on 2017/6/7.
 */

public class Adapter_Grid_main_like extends BaseAdapter{
    private List<mainLike.ResultBean.FavouriteGoodsBean> mData;
    private Context mContext;
    private LayoutInflater mInflater;

    public Adapter_Grid_main_like(List mDatas, Context mContext) {
        super(mDatas, mContext);
        this.mData=mDatas;
        this.mContext=mContext;
        mInflater=LayoutInflater.from(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        mainLike.ResultBean.FavouriteGoodsBean bean=mData.get(position);
        if(convertView==null){
            holder=new ViewHolder();
            convertView=mInflater.inflate(R.layout.item_gridview_main_like,null,false);

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


        return convertView;
    }
    class ViewHolder {
        ImageView mImage;
        TextView mtextview_name;
        TextView mtextview_price;

    }
}
