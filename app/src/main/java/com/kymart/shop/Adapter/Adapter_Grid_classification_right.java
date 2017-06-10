package com.kymart.shop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import com.kymart.shop.Bean.Classification_rightBean;
import cn.kymart.tptp.R;

/**
 * Created by Administrator on 2017/6/9.
 */

public class Adapter_Grid_classification_right extends BaseAdapter{
    private List<Classification_rightBean.ResultEntity.Sub_categoryEntity> mData;
    private Context mContext;
    private LayoutInflater mInflater;

    public Adapter_Grid_classification_right(List mDatas, Context mContext) {
        super(mDatas, mContext);
        this.mData=mDatas;
        this.mContext=mContext;
        mInflater=LayoutInflater.from(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        Classification_rightBean.ResultEntity.Sub_categoryEntity bean=mData.get(position);
        if(convertView==null){
            holder=new ViewHolder();
            convertView=mInflater.inflate(R.layout.item_gridview_classification_right,null,false);
            holder.mTextview= (TextView) convertView.findViewById(R.id.textview__name);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.mTextview.setText(bean.getMobile_name());

        return convertView;
    }
    class ViewHolder {
        TextView mTextview;
    }
}
