package com.kymart.shop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kymart.shop.Bean.ShareFriends;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Utils.DateUtils;

import java.util.List;

import cn.kymart.tptp.R;

/**
 * Created by Administrator on 2017/7/10.
 */

public class Adapter_shareFriend extends  BaseAdapter{
    private List<ShareFriends.ListBean>mData;
    private LayoutInflater mInflater;
    private Context mContext;

    public Adapter_shareFriend(List mDatas, Context mContext) {
        super(mDatas, mContext);
        this.mData=mDatas;
        this.mContext=mContext;
        mInflater=LayoutInflater.from(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        ShareFriends.ListBean bean=mData.get(position);
        if(convertView==null){
            holder=new ViewHolder();
            convertView=mInflater.inflate(R.layout.itemmysharefriens,null,false);
            holder.mimage_head= (ImageView) convertView.findViewById(R.id.imageview_head);
            holder.mtext_nick= (TextView) convertView.findViewById(R.id.text_nickname);
            holder.mtext_time= (TextView) convertView.findViewById(R.id.text_time);
            holder.mtext_ID= (TextView) convertView.findViewById(R.id.text_ID);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        Glide.with(mContext).load(BaseUrl.BasegoodlistURL+bean.getHead_pic()).error(R.mipmap.user68).into(holder.mimage_head);
        holder.mtext_nick.setText("昵称："+bean.getNickname());
        holder.mtext_time.setText("加盟时间："+ DateUtils.timet(bean.getReg_time()+""));
        holder.mtext_ID.setText("会员ID："+bean.getUser_id());

        return convertView;
    }
    class  ViewHolder{
        ImageView mimage_head;
        TextView mtext_nick;
        TextView mtext_time;
        TextView mtext_ID;
    }
}
