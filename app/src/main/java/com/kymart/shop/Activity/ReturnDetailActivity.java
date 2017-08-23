package com.kymart.shop.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kymart.shop.Adapter.BaseAdapter;
import com.kymart.shop.CustomView.MyGridView;
import com.kymart.shop.Utils.SizeUtils;

import java.util.ArrayList;
import java.util.List;

import cn.kymart.tptp.R;

public class ReturnDetailActivity extends BaseActivityother {
    TextView mtextview_goodname,mtextview_errostate,mtextview_errodescribe,mtextview_erroRemark;
    ImageView mimage_goodPIC;
    MyGridView mGrid_erropic;

    List<String> mdata;
    Adapter_mgrid_erroPIC madapter;


    @Override
    public int setLayoutResID() {
        return R.layout.activity_return_detail;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {
        int width = SizeUtils.getScreenWidthPx(this)/3;
        mdata=new ArrayList<>();
        mdata.add("http://img2.imgtn.bdimg.com/it/u=3065427448,1631649236&fm=26&gp=0.jpg");
        mdata.add("http://img.r1.market.hiapk.com/data/upload/2014/09_25/4/201409250424519735.jpg");
        mdata.add("http://www.zhlzw.com/UploadFiles/Article_UploadFiles/201303/2013030914472860.jpg");
        mdata.add("http://img.taopic.com/uploads/allimg/140126/235002-14012609350290.jpg");
        madapter=new Adapter_mgrid_erroPIC(mdata,this,width);
        mGrid_erropic.setAdapter(madapter);
    }

    @Override
    protected void initListener() {


    }

    @Override
    protected void initView() {
        mimage_goodPIC= (ImageView) findViewById(R.id.image_goodsppic);
        mtextview_goodname= (TextView) findViewById(R.id.textview_goodname);
        mtextview_errostate= (TextView) findViewById(R.id.textview_errostate);
        mtextview_errodescribe= (TextView) findViewById(R.id.textview_errodescribe);
        mtextview_erroRemark= (TextView) findViewById(R.id.textview_erroRemark);
        mGrid_erropic= (MyGridView) findViewById(R.id.gridview_erroPIC);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }

    public class Adapter_mgrid_erroPIC  extends BaseAdapter {
        List<String> mData;
        Context mContext;
        LayoutInflater mINflater;
        int  width=0;


        public Adapter_mgrid_erroPIC(List mDatas, Context mContext,int width) {
            super(mDatas, mContext);
            this.mData=mDatas;
            this.mContext=mContext;
            this.width=width;
            mINflater=LayoutInflater.from(mContext);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder=null;
            if(convertView==null){
                holder= new ViewHolder();
                convertView=mINflater.inflate(R.layout.item_grid_erropic,null,false);
                holder.mRelativelayout= (RelativeLayout) convertView.findViewById(R.id.relativelayout_erropic);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            final ImageView imageView_fenxiang=new ImageView(mContext);
            imageView_fenxiang.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Glide.with(mContext).load(mData.get(position)).into(imageView_fenxiang);
            LinearLayout.LayoutParams mLayoutParams_fenxiang = new LinearLayout.LayoutParams(
                    width,width );
            holder.mRelativelayout.addView(imageView_fenxiang, mLayoutParams_fenxiang);

            return convertView;
        }
        class  ViewHolder{
            RelativeLayout mRelativelayout;
        }
    }
}
