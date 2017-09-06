package com.kymart.shop.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kymart.shop.Activity.RefundActivity;
import com.kymart.shop.Activity.WriteReturnActivity;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Bean.OrderDetailsBean;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Utils.LogUtils;

import java.util.List;

import cn.kymart.tptp.R;

import static com.kymart.shop.AppStaticData.Staticdata.refoundBean;

/**
 * Created by Administrator on 2017/7/14.
 */

public class Adapter_orderDetailsGoodslist extends  BaseAdapter{
    private List<OrderDetailsBean.ResultBean.GoodsListBean> mData;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private boolean isShowTuikuan;

    public Adapter_orderDetailsGoodslist(List mDatas, Context mContext) {
        super(mDatas, mContext);
        this.mData=mDatas;
        this.mContext=mContext;
        mLayoutInflater=LayoutInflater.from(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holdr=null;
        final OrderDetailsBean.ResultBean.GoodsListBean  bean=mData.get(position);
        if(convertView==null){
            holdr=new ViewHolder();
            convertView=mLayoutInflater.inflate(R.layout.item_orderdetail,null,false);
            holdr.mimage= (ImageView) convertView.findViewById(R.id.image_goodsPIC);
            holdr.mtext_name= (TextView) convertView.findViewById(R.id.textview_goodsname);
            holdr.mtext_num= (TextView) convertView.findViewById(R.id.textview_number);
            holdr.mtext_goodprice= (TextView) convertView.findViewById(R.id.textview_goodsprice);
            holdr.mtext_price= (TextView) convertView.findViewById(R.id.textview_price);
            holdr.mtext_tuihuo= (TextView) convertView.findViewById(R.id.text_return);
            convertView.setTag(holdr);
        }else {
            holdr= (ViewHolder) convertView.getTag();
        }
        Glide.with(mContext).load(BaseUrl.Baseimage+bean.getGoods_id()).into(holdr.mimage);
        holdr.mtext_name.setText(bean.getGoods_name());
        holdr.mtext_num.setText("×"+bean.getGoods_num());
        holdr.mtext_goodprice.setText("￥"+bean.getGoods_price());
        holdr.mtext_price.setText(bean.getGoods_price()+"×"+bean.getGoods_num());
        LogUtils.LOG("ceshi","shipeiq    "+isShowTuikuan);
        holdr.mtext_tuihuo.setVisibility(Staticdata.isrefound==1? View.VISIBLE:View.INVISIBLE);
        holdr.mtext_tuihuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtils.LOG("ceshi","退货被电击");
                Staticdata.refoundBean.setGoods_id(bean.getGoods_id());
                Staticdata.refoundBean.setOrder_id(bean.getOrder_id());
                Staticdata.refoundBean.setGoods_num(bean.getGoods_num());
                Staticdata.refoundBean.setSpec_key(bean.getSpec_key());
                Staticdata.refoundBean.setGoods_name(bean.getGoods_name());
                Staticdata.refoundBean.setGoods_price(bean.getGoods_price());
                Intent intent_tuihuo=new Intent(mContext,RefundActivity.class);
                intent_tuihuo.putExtra("orderid",bean.getOrder_id());
                mContext.startActivity(intent_tuihuo);
            }
        });
        return convertView;
    }

    class  ViewHolder  {
        TextView mtext_name,mtext_num,mtext_goodprice,mtext_price,mtext_tuihuo;
        ImageView mimage;
    }
}
