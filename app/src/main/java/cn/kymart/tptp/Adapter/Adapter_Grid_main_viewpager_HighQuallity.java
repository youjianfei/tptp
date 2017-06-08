package cn.kymart.tptp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.kymart.tptp.Bean.MainBean;
import cn.kymart.tptp.Http.BaseUrl;
import cn.kymart.tptp.R;

/**
 * Created by PC on 2017/6/7.
 */

public class Adapter_Grid_main_viewpager_HighQuallity extends BaseAdapter {
    private List<MainBean.ResultBean.PromotionGoodsBean> mData;
    private Context mContext;
    private LayoutInflater mInflater;

    public Adapter_Grid_main_viewpager_HighQuallity(List mDatas, Context mContext) {
        super(mDatas, mContext);
        this.mData=mDatas;
        this.mContext=mContext;
        mInflater=LayoutInflater.from(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        MainBean.ResultBean.PromotionGoodsBean bean=mData.get(position);
        if(convertView==null){
            holder=new ViewHolder();
            convertView=mInflater.inflate(R.layout.item_gridview_main_viewpager,null,false);
            holder.mImageview= (ImageView) convertView.findViewById(R.id.imageview_item_thing1);
            holder.mtextview_name= (TextView) convertView.findViewById(R.id.textview_item_name1);
            holder.mTextview_price= (TextView) convertView.findViewById(R.id.textview_item_price1);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        Glide.with(mContext).load(BaseUrl.BaseURL+BaseUrl.main_imgURL+bean.getGoods_id()).into(holder.mImageview);
        holder.mtextview_name.setText(bean.getGoods_name());
        holder.mTextview_price.setText(bean.getShop_price());



        return convertView;
    }
    class ViewHolder {
        ImageView mImageview;
        TextView mtextview_name;
        TextView mTextview_price;

    }
}
