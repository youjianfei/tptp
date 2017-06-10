package cn.kymart.tptp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.kymart.tptp.Activity.GoodsListActivity;
import cn.kymart.tptp.Bean.Classification_rightBean;
import cn.kymart.tptp.CustomView.MyGridView;
import cn.kymart.tptp.R;
import cn.kymart.tptp.Utils.LogUtils;

/**
 * Created by Administrator on 2017/6/9.
 */

public class Adapter_classification_right_list extends BaseAdapter {
    List<Classification_rightBean.ResultEntity> mData;
    Context mContext;
    LayoutInflater mInflater;

    Adapter_Grid_classification_right mAdapter_grid;

    public Adapter_classification_right_list(List mDatas, Context mContext) {
        super(mDatas, mContext);
        this.mData = mDatas;
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Classification_rightBean.ResultEntity bean = mData.get(position);
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_listview_classification_right, null, false);
            holder.mTextview = (TextView) convertView.findViewById(R.id.textview_name);
            holder.myGridView = (MyGridView) convertView.findViewById(R.id.Gridview_right);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mTextview.setText(bean.getMobile_name());
        /**
         * 嵌套grid
         */
        final List<Classification_rightBean.ResultEntity.Sub_categoryEntity> mDatata = new ArrayList();
        mDatata.addAll(bean.getSub_category());
        mAdapter_grid = new Adapter_Grid_classification_right(mDatata, mContext);
        holder.myGridView.setAdapter(mAdapter_grid);

        holder.myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {//二级菜单分类点击
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                LogUtils.LOG("ceshi", mDatata.get(position).getMobile_name());
                Intent intent=new Intent(mContext, GoodsListActivity.class);
                intent.putExtra("id",mDatata.get(position).getId());
                LogUtils.LOG("ceshi",mDatata.get(position).getId()+"");
                mContext.startActivity(intent);
            }
        });


        return convertView;
    }

    class ViewHolder {
        TextView mTextview;
        MyGridView myGridView;
    }

}
