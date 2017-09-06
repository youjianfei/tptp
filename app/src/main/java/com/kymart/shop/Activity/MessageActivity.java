package com.kymart.shop.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.kymart.shop.Adapter.Adapter_CashoutList;
import com.kymart.shop.Adapter.BaseAdapter;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Bean.MessageBean;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.DateUtils;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.ToastUtils;
import com.kymart.shop.Utils.Volley_Utils;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cn.kymart.tptp.R;

public class MessageActivity extends BaseActivityother {
    private TextView mTextview_XTmessage,mTextview_DDmessage;

    PullToRefreshListView  mListview;
    List <MessageBean.ResultBean> mData;
    Adapter mAdapter;

    int type=0;
    int page=1;
    String messageURL="";


    @Override
    public int setLayoutResID() {
        return R.layout.activity_message;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {
        mData=new ArrayList<>();
        mAdapter=new Adapter(mData,this);
        mListview.setAdapter(mAdapter);
        request(1);
    }

    @Override
    protected void initListener() {
        mTextview_XTmessage.setOnClickListener(this);
        mTextview_DDmessage.setOnClickListener(this);
        mListview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                request(1);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page++;
                request(page);

            }
        });

    }

    @Override
    protected void initView() {
        mTextview_XTmessage= (TextView) findViewById(R.id.text_XTmessage);
        mTextview_DDmessage= (TextView) findViewById(R.id.text_DDmessage);
        mListview= (PullToRefreshListView) findViewById(R.id.ListView_message);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.text_XTmessage:
                mTextview_XTmessage.setBackgroundResource(R.drawable.btn_leftfind);
                mTextview_XTmessage.setTextColor(getResources().getColor(R.color.red));
                mTextview_DDmessage.setTextColor(getResources().getColor(R.color.white));
                mTextview_DDmessage.setBackgroundResource(R.drawable.btn_rightfind2x);
                type=0;
                request(1);
                break;
            case R.id.text_DDmessage:
                mTextview_XTmessage.setBackgroundResource(R.drawable.btn_leftfind2x);
                mTextview_DDmessage.setBackgroundResource(R.drawable.btn_rightfind);
                mTextview_XTmessage.setTextColor(getResources().getColor(R.color.white));
                mTextview_DDmessage.setTextColor(getResources().getColor(R.color.red));
                type=1;
                request(1);
                break;
        }
    }
    public void request(final int page){
        if(type==0){
            messageURL= BaseUrl.BaseURL+BaseUrl.XTmessage+Staticdata.userBean_static.getResult().getToken()+"&p="+page;
        }else {
            messageURL= BaseUrl.BaseURL+BaseUrl.DDmessage+Staticdata.userBean_static.getResult().getToken()+"&p="+page;
        }
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                if(page==1){
                    mData.clear();
                }
                LogUtils.LOG("ceshi","message"+messageURL);
//                String json="{\"status\":1,\"msg\":\"\",\"result\":[{\"id\":1,\"title\":\"测试一下\",\"content\":\"<p s以一限公司<\\/span><\\/p><p><br\\/><\\/p>\",\"status\":1,\"create_time\":1504595777}]}";
              if(new Gson().fromJson(respose,MessageBean.class).getResult().size()==0){
                  ToastUtils.showToast(MessageActivity.this,"没有更多内容了");
              }
                mData.addAll(new Gson().fromJson(respose,MessageBean.class).getResult());
                mAdapter.notifyDataSetChanged();
                if (mListview.isRefreshing()) {
                    mListview.onRefreshComplete();
                }
            }

            @Override
            public void onError(int error) {
                if (mListview.isRefreshing()) {
                    mListview.onRefreshComplete();
                }
            }
        }).Http(messageURL,MessageActivity.this,0);

    }
    class  Adapter extends BaseAdapter{
        List<MessageBean.ResultBean> mData;
        Context mContext;
        LayoutInflater mINflater;

        public Adapter(List mDatas, Context mContext) {
            super(mDatas, mContext);
            this.mData=mDatas;
            this.mContext=mContext;
            mINflater=LayoutInflater.from(mContext);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder=null;
            MessageBean.ResultBean bean=mData.get(position);
            if(convertView==null){
                holder=new ViewHolder();
                convertView=mINflater.inflate(R.layout.item_message,null,false);
                holder.text_title= (TextView) convertView.findViewById(R.id.textview_title);
                holder.text_time= (TextView) convertView.findViewById(R.id.textview_time);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();

            }
            if(type==0){
                holder.text_title.setText(bean.getTitle());
            }else {
                holder.text_title.setText(bean.getContent());
            }

            holder.text_time.setText(DateUtils.timet(bean.getCreate_time()+""));

            return convertView;
        }
        class  ViewHolder{
            TextView text_title;
            TextView text_time;
        }
    }
}
