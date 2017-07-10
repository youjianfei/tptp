package com.kymart.shop.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kymart.shop.Bean.CashoutListBean;
import com.kymart.shop.Utils.DateUtils;

import java.util.List;

import cn.kymart.tptp.R;

/**
 * Created by Administrator on 2017/7/10.
 */

public class Adapter_CashoutList extends  BaseAdapter {
    List<CashoutListBean.ResultBean> mData;
    Context mContext;
    LayoutInflater mINflater;

    public Adapter_CashoutList(List mDatas, Context mContext) {
        super(mDatas, mContext);
        this.mData=mDatas;
        this.mContext=mContext;
        mINflater=LayoutInflater.from(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        CashoutListBean.ResultBean bean=mData.get(position);
        if(convertView==null){
            holder= new ViewHolder();
            convertView=mINflater.inflate(R.layout.item_cashoutlist,null,false);
            holder.text_number= (TextView) convertView.findViewById(R.id.text_number);
            holder.text_time= (TextView) convertView.findViewById(R.id.text_time);
            holder.text_money= (TextView) convertView.findViewById(R.id.text_money);
            holder.text_state= (TextView) convertView.findViewById(R.id.text_state);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.text_number.setText(bean.getId()+"");
        holder.text_time.setText(DateUtils.timet(bean.getCreate_time()+""));
        holder.text_money.setText(bean.getMoney()+"");
        holder.text_state.setText(bean.getStatus_text());
        return convertView;
    }
    class  ViewHolder{
        TextView text_number;
        TextView text_time;
        TextView text_money;
        TextView text_state;
    }
}
