package com.kymart.shop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kymart.shop.Bean.ShopCarBean;
import com.kymart.shop.Utils.LogUtils;

import java.util.List;

import cn.kymart.tptp.R;
import ren.qinc.numberbutton.NumberButton;

/**
 * Created by Administrator on 2017/6/12.
 */

public class Adapter_shopCarList extends BaseAdapter {
    List<ShopCarBean.ResultEntity.StoreListEntity.CartListEntity> mData;
    private Context mContext;
    private LayoutInflater mInflater;

    public Adapter_shopCarList(List mDatas, Context mContext) {
        super(mDatas, mContext);
        this.mData=mDatas;
        this.mContext=mContext;
        mInflater=LayoutInflater.from(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        ShopCarBean.ResultEntity.StoreListEntity.CartListEntity bean = mData.get(position);
        if(convertView==null){
            holder=new ViewHolder();
            convertView=mInflater.inflate(R.layout.item_listview_shopcar,null,false);
            holder.mImage_check= (ImageView) convertView.findViewById(R.id.image_check);
            holder.mImage_goodPIC= (ImageView) convertView.findViewById(R.id.imageView);
            holder.mImage_delet= (ImageView) convertView.findViewById(R.id.image_delate);
            holder.mText_goodName= (TextView) convertView.findViewById(R.id.text_goodname);
            holder.mTextview_goodProperty= (TextView) convertView.findViewById(R.id.text_goodProperty);
            holder.mTextview_goodPrice= (TextView) convertView.findViewById(R.id.text_price);
            holder.mNumberButton= (NumberButton) convertView.findViewById(R.id.numberButton_count);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.mImage_check.setSelected(true);
        holder.mNumberButton.setCurrentNumber(bean.getGoods_num());
        holder.mText_goodName.setText(bean.getGoods_name());
        holder.mTextview_goodPrice.setText("￥"+bean.getGoods_price());
        holder.mTextview_goodProperty.setText(bean.getSpec_key());
        Glide.with(mContext).load("http://test.kymart.cn/index.php?"+"m=api&c=goods&a=goodsThumImages&width=400&height=400&goods_id="+bean.getGoods_id()).into( holder.mImage_goodPIC);


        return convertView;
    }
    class ViewHolder {
        ImageView mImage_check;
        ImageView mImage_goodPIC;
        TextView  mText_goodName;
        TextView  mTextview_goodProperty;
        NumberButton mNumberButton;
        TextView mTextview_goodPrice;
        ImageView mImage_delet;
    }
}
