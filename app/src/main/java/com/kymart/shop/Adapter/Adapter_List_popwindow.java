package com.kymart.shop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

import cn.kymart.tptp.R;

/**
 * Created by Administrator on 2017/6/12.
 */

public class Adapter_List_popwindow extends BaseAdapter {
    List<String> mData;
    Context mContext;
    LayoutInflater mInflater;

    public Adapter_List_popwindow(List mDatas, Context mContext) {
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
            convertView=mInflater.inflate(R.layout.item_list_gooddetail_popwin,null,false);
            holder.mTextview= (TextView) convertView.findViewById(R.id.text_title);
            holder.mTagFlow= (TagFlowLayout) convertView.findViewById(R.id.id_flowlayout);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
//        holder.mTagFlow.setAdapter(new TagAdapter() {
//            @Override
//            public View getView(FlowLayout parent, int position, Object o) {
//                return null;
//            }
//        });
//        mFlowLayout.setAdapter(new TagAdapter<String>(mVals)
//        {
//            @Override
//            public View getView(FlowLayout parent, int position, String s)
//            {
//                TextView tv = (TextView) mInflater.inflate(R.layout.tv,
//                        mFlowLayout, false);
//                tv.setText(s);
//                return tv;
//            }
//        });
        return convertView;
    }
    class ViewHolder {
        TextView mTextview;
        TagFlowLayout mTagFlow;
    }
}
