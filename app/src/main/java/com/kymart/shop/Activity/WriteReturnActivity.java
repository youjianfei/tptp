package com.kymart.shop.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.kymart.shop.Adapter.BaseAdapter;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Bean.OrderDetailsBean;
import com.kymart.shop.CustomView.CustomerScrollView;
import com.kymart.shop.CustomView.MyGridView;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.SizeUtils;
import com.kymart.shop.Utils.Volley_Utils;
import com.kymart.shop.class_.GlideLoader;
import com.yancy.imageselector.ImageConfig;
import com.yancy.imageselector.ImageSelector;
import com.yancy.imageselector.ImageSelectorActivity;

import java.util.ArrayList;
import java.util.List;

import cn.kymart.tptp.R;

public class WriteReturnActivity extends BaseActivityother {

    private ArrayList<Bitmap> dataPictrue;
    private List<String> pathList;
    Bitmap bitmap_add;
    private CustomerScrollView customerScrollView;
    private TextView textview_goodname,textview_returnaddress,textview_worktime,timeview_phonrnumber;
    Button  mButton_return;
    private EditText editText_gooderro;
    private MyGridView mGrid_erropic;
    String orderID="";
    OrderDetailsBean orderDetailsBean;


    List<Bitmap> mdata;
    Adapter_mgrid_erroPIC madapter;
    @Override
    public int setLayoutResID() {
        return R.layout.activity_write_return;
    }

    @Override
    protected void setData() {

            String  URL= BaseUrl.BaseURL+BaseUrl.Orderdetail+ Staticdata.userBean_static.getResult().getToken()+"&user_id="+Staticdata.userBean_static.getResult().getUser_id()+"&id="+orderID;
            LogUtils.LOG("ceshi","订单详情"+URL);
            new Volley_Utils(new Interface_volley_respose() {
                @Override
                public void onSuccesses(String respose) {
                    LogUtils.LOG("ceshi","订单详情"+respose);
                    orderDetailsBean=new Gson().fromJson(respose,OrderDetailsBean.class);
                    setDATA();

                }

                @Override
                public void onError(int error) {

                }
            }).Http(URL,this,0);
        }


    void setDATA(){


    }

    @Override
    protected void initData() {
        LogUtils.LOG("ceshi",SizeUtils.getScreenWidthPx(this)+"..."+SizeUtils.getScreenWidthDip(this));
        int width = (SizeUtils.getScreenWidthPx(this)-SizeUtils.dip2px(this,45))/4;
        Intent intent=getIntent();
        orderID= intent.getStringExtra("orderid");
        mdata=new ArrayList<>();
        bitmap_add= BitmapFactory.decodeResource(getResources(),R.mipmap.add);
        mdata.add(bitmap_add);

        madapter=new Adapter_mgrid_erroPIC(mdata,this,width);
        mGrid_erropic.setAdapter(madapter);
    }

    @Override
    protected void initListener() {
        mButton_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mGrid_erropic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    LogUtils.LOG("ceshi","wobeidianjile ");
                    ImageConfig imageConfig
                            = new ImageConfig.Builder(new GlideLoader())
                            // 如果在 4.4 以上，则修改状态栏颜色 （默认黑色）
                            .steepToolBarColor(getResources().getColor(R.color.red))
                            // 标题的背景颜色 （默认黑色）
                            .titleBgColor(getResources().getColor(R.color.red))
                            // 提交按钮字体的颜色  （默认白色）
                            .titleSubmitTextColor(getResources().getColor(R.color.white))
                            // 标题颜色 （默认白色）
                            .titleTextColor(getResources().getColor(R.color.white))
                            .steepToolBarColor(getResources().getColor(R.color.red))
                            .titleBgColor(getResources().getColor(R.color.red))
                            .titleSubmitTextColor(getResources().getColor(R.color.white))
                            .titleTextColor(getResources().getColor(R.color.white))
                            // 开启多选   （默认为多选）
                            .mutiSelect()
                            // 多选时的最大数量   （默认 9 张）
                            //这里只允许上传3张
                            .mutiSelectMaxSize(9)
                            // 开启拍照功能 （默认关闭）
                            .showCamera()
                            // 拍照后存放的图片路径（默认 /temp/picture） （会自动创建）
                            .filePath("/ImageSelector/Pictures")
                            .build();
                    ImageSelector.open(WriteReturnActivity.this, imageConfig);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ImageSelector.IMAGE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            LogUtils.LOG("ceshi", "里面" + ImageSelector.IMAGE_REQUEST_CODE + ".." + RESULT_OK + ".." + data);

            pathList = data.getStringArrayListExtra(ImageSelectorActivity.EXTRA_RESULT);
            dataPictrue = new ArrayList<>();
            for (String path : pathList) {
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                Bitmap mBitmap = Bitmap.createScaledBitmap(bitmap, 350, 350, true);
                dataPictrue.add(mBitmap);
            }
            mdata.clear();
            mdata.add(bitmap_add);
            mdata.addAll(dataPictrue);
            madapter.notifyDataSetChanged();
        }



    }

    @Override
    protected void initView() {
        customerScrollView= (CustomerScrollView) findViewById(R.id.CustomerScrollView);
        textview_goodname= (TextView) findViewById(R.id.textview_goodname);
        textview_returnaddress= (TextView) findViewById(R.id.textview_returnaddress);
        textview_worktime= (TextView) findViewById(R.id.textview_worktime);
        timeview_phonrnumber= (TextView) findViewById(R.id.textview_phonenumber);
        mButton_return= (Button) findViewById(R.id.button_return);
        editText_gooderro= (EditText) findViewById(R.id.textview_errostate);
        mGrid_erropic= (MyGridView) findViewById(R.id.gridview_erroPIC);


    }

    public class Adapter_mgrid_erroPIC  extends BaseAdapter {
        List<Bitmap> mData;
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
            imageView_fenxiang.setImageBitmap(mData.get(position));
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
