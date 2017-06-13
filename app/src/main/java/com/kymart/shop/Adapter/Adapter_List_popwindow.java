package com.kymart.shop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kymart.shop.Activity.GoodDetailsActivity;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Bean.BuyGoodBean;
import com.kymart.shop.Bean.GoodDetailsBean;
import com.kymart.shop.Utils.LogUtils;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.kymart.tptp.R;

/**
 * Created by Administrator on 2017/6/12.
 */

public class Adapter_List_popwindow extends BaseAdapter {
    List<GoodDetailsBean.Result.Goods.GoodsSpecList> mData;
    List<GoodDetailsBean.Result.Goods.GoodsSpecList.SpecList> mData_spec;
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
        GoodDetailsBean.Result.Goods.GoodsSpecList bean=mData.get(position);
        if(convertView==null){
            holder=new ViewHolder();
            convertView=mInflater.inflate(R.layout.item_list_gooddetail_popwin,null,false);
            holder.mTextview= (TextView) convertView.findViewById(R.id.text_title);
            holder.mTagFlow= (TagFlowLayout) convertView.findViewById(R.id.id_flowlayout);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.mTextview.setText(bean.getSpec_name());
        mData_spec=new ArrayList<>();
        mData_spec.addAll(bean.getSpec_list());
        holder.mTagFlow.setTag(position);
        // TODO: 2017/6/13
        final ViewHolder finalHolder = holder;
        TagAdapter tagAdapter=new TagAdapter(mData_spec) {
            @Override
            public View getView(FlowLayout parent, int position, Object o) {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_tag,
                        finalHolder.mTagFlow, false);
                tv.setText(mData_spec.get(position).getItem());
                return tv;
            }
        };
        holder.mTagFlow.setAdapter(tagAdapter);
        tagAdapter.setSelectedList(0);
//        holder.mTagFlow.setOnTagClickListener(new TagFlowLayout.OnTagClickListener()//点击标签的监听
//        {
//            @Override
//            public boolean onTagClick(View view, int position, FlowLayout parent)
//            {
//
//
//                return true;
//            }
//        });

        holder.mTagFlow.setOnSelectListener(new TagFlowLayout.OnSelectListener()
        {
            @Override
            public void onSelected(Set<Integer> selectPosSet)
            {//选择标签的监听
//                LogUtils.LOG("ceshi","choose:" + selectPosSet.toString());
                Iterator it = selectPosSet.iterator();
                while(it.hasNext()){
                    int i= (int) it.next();
                    LogUtils.LOG("ceshi","choose:" + mData_spec.get(i).getItem());
                    Staticdata.bean.getGood_buy_propertys().get(0).setSpec_list(mData_spec.get(i));
                    Staticdata.bean.reload();
                    GoodDetailsActivity.goodDetailsActivity.fragment_goodDatails_good.afterShowpopwinsow();
                }





            }
        });


        return convertView;
    }
    class ViewHolder {
        TextView mTextview;
        TagFlowLayout mTagFlow;
    }
}
