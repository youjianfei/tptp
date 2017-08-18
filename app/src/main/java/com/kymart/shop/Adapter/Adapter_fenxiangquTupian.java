package com.kymart.shop.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.kymart.shop.Activity.GoodlistActivity;
import com.kymart.shop.Bean.MainBean;
import com.kymart.shop.Utils.SizeUtils;

import java.util.List;

import cn.kymart.tptp.R;

import static com.kymart.shop.Http.BaseUrl.BaseURL;
import static com.kymart.shop.Http.BaseUrl.BasegoodlistURL;

/**
 * Created by Administrator on 2017/8/18.
 */

public class Adapter_fenxiangquTupian  extends BaseAdapter{
    List<MainBean.ResultBean.ZoneBean> mData;
    Context mContext;
    LayoutInflater mINflater;
    int  width=0;
    int hight=0;

    public Adapter_fenxiangquTupian(List mDatas, Context mContext,int width) {
        super(mDatas, mContext);
        this.mData=mDatas;
        this.mContext=mContext;
        this.width=width;
        hight = (int) (width * 0.22);
        mINflater=LayoutInflater.from(mContext);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder holder=null;
        final MainBean.ResultBean.ZoneBean bean=mData.get(position);
        if(convertView==null){
            holder= new ViewHolder();
            convertView=mINflater.inflate(R.layout.item_fenxiangqutupian,null,false);
            holder.mRelativelayout= (RelativeLayout) convertView.findViewById(R.id.relativelayout_fenxiangqu);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        final ImageView imageView_fenxiang=new ImageView(mContext);
//       imageView_fenxiang.setImageResource(R.mipmap.fenxiangqu_);
        Glide.with(mContext).load(BasegoodlistURL+"/"+bean.getImg_url()).into(imageView_fenxiang);
        LinearLayout.LayoutParams mLayoutParams_fenxiang = new LinearLayout.LayoutParams(
                width,hight );
        holder.mRelativelayout.addView(imageView_fenxiang, mLayoutParams_fenxiang);
        holder.mRelativelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intend_fenxiangqu=new Intent(mContext,GoodlistActivity.class);
                intend_fenxiangqu.putExtra("url",BaseURL+bean.getApi_url());
                mContext.startActivity(intend_fenxiangqu);
            }
        });


        return convertView;
    }
    class  ViewHolder{
       RelativeLayout mRelativelayout;
    }
}
