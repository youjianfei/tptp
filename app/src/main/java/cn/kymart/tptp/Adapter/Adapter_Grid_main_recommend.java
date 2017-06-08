package cn.kymart.tptp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.kymart.tptp.R;

/**
 * Created by PC on 2017/6/7.
 */

public class Adapter_Grid_main_recommend extends BaseAdapter{
    private List<String> mData;
    private Context mContext;
    private LayoutInflater mInflater;

    public Adapter_Grid_main_recommend(List mDatas, Context mContext) {
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
            convertView=mInflater.inflate(R.layout.item_gridview_main_recommend,null,false);
            holder.mtextview_name= (TextView) convertView.findViewById(R.id.textview_item_name1);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
    class ViewHolder {
        TextView mtextview_name;
    }
}
