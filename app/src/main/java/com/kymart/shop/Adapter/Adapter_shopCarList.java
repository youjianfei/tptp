package com.kymart.shop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kymart.shop.Utils.LogUtils;

import java.util.List;

import cn.kymart.tptp.R;
import ren.qinc.numberbutton.NumberButton;

/**
 * Created by Administrator on 2017/6/12.
 */

public class Adapter_shopCarList extends BaseAdapter {
    List<String> mData;
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
        holder.mNumberButton.getChildCount();
        LogUtils.LOG("ceshi", holder.mNumberButton.getChildCount()+"个子控件");
        holder.mNumberButton.setInventory(10).setOnWarnListener(new NumberButton.OnWarnListener() {
            @Override
            public void onWarningForInventory(int inventory) {
                LogUtils.LOG("ceshi","变化");
            }

            @Override
            public void onWarningForBuyMax(int max) {
                LogUtils.LOG("ceshi","变化");

            }
        });


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
