package com.kymart.shop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kymart.shop.Bean.MoneyBean;
import com.kymart.shop.Utils.DateUtils;

import java.util.List;

import cn.kymart.tptp.R;

/**
 * Created by Administrator on 2017/6/28.
 */

public class Adapter_list_money extends BaseAdapter {
    private List<MoneyBean.ResultBean> mdata;
    private Context mContext;
    private LayoutInflater mInflater;
    int tag=0;

    public Adapter_list_money(List mDatas, Context mContext,int TAg) {
        super(mDatas, mContext);
       this. mdata=mDatas;
       this. mContext=mContext;
        this.tag=TAg;
        mInflater=LayoutInflater.from(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        MoneyBean.ResultBean bean =mdata.get(position);
        if(convertView==null){
            holder=new ViewHolder();
            convertView=mInflater.inflate(R.layout.item_list_money,null,false);
            holder.mtextview_money= (TextView) convertView.findViewById(R.id.text_money);
            holder.mtextview_time= (TextView) convertView.findViewById(R.id.text_time);
            holder.mtextview_change= (TextView) convertView.findViewById(R.id.text_change);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        if(tag==1){
            holder.mtextview_money.setText(bean.getUser_money());
            holder.mtextview_time.setText( DateUtils.timet(bean.getChange_time()+""));
            holder.mtextview_change.setText(bean.getDesc());
        }else{
            holder.mtextview_money.setText(bean.getAmount());
            holder.mtextview_time.setText( DateUtils.timet(bean.getCreate_time()+""));
            holder.mtextview_change.setText(bean.getType_text());
        }
        return convertView;
    }
    class ViewHolder{
        private TextView mtextview_money,mtextview_time,mtextview_change;
    }

}
