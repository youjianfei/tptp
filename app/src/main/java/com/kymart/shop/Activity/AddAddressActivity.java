package com.kymart.shop.Activity;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;


import com.kymart.shop.Adapter.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.kymart.tptp.R;

public class AddAddressActivity extends BaseActivityother {
    TextView mTextview_area;


    PopupWindow mPopupWindow;
    LinearLayout mLinearLayout_bottom;
    ListView popListview;
    List<String> mListAddress;
    AddressAdapter mAdapter;



    @Override
    public int setLayoutResID() {
        return R.layout.activity_add_address;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {
        mListAddress=new ArrayList<>();

        mListAddress.add("河南");
        mListAddress.add("河北");
        mListAddress.add("郑州");
        mListAddress.add("天津");

    }

    @Override
    protected void initListener() {
        mTextview_area.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        mLinearLayout_bottom= (LinearLayout) findViewById(R.id.activity_add_address);
        mTextview_area= (TextView) findViewById(R.id.text_area);

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.text_area:
                showPopwindow();

                break;
        }
    }
    TextView mTextview_one,mTextview_two,mTextview_three,mTextview_four;
    private void showPopwindow() {

        //初始化popwindow；
        View conView= LayoutInflater.from(this).inflate(R.layout.popwindow_select_address,null,false);
        mPopupWindow=new PopupWindow(conView,
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setOutsideTouchable(true);// 触摸popupwindow外部，popupwindow消失
        mPopupWindow.showAtLocation(mLinearLayout_bottom, Gravity.BOTTOM, 0, 0);
        popListview= (ListView) conView.findViewById(R.id.Listview_addresspopwindow);
        mTextview_one= (TextView) conView.findViewById(R.id.text_one);
        mTextview_two= (TextView) conView.findViewById(R.id.text_two);
        mTextview_three= (TextView) conView.findViewById(R.id.text_three);
        mTextview_four= (TextView) conView.findViewById(R.id.text_four);


        mAdapter=new AddressAdapter(mListAddress,this);
        popListview.setAdapter(mAdapter);

        setListener();



        setAlpha((float) 0.3);
    }
     void setListener(){
         popListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                   mTextview_one.setText(mListAddress.get(i));
                 mTextview_two.setVisibility(View.VISIBLE);
                 mListAddress.clear();
                 mListAddress.add("sdfdasf");
                 mListAddress.add("sdfdasf");
                 mListAddress.add("sdfdasf");
                 mListAddress.add("sdfdasf");
                 mAdapter.notifyDataSetChanged();

             }
         });
     }
    public void setAlpha(float bgAlpha) {//设置背景遮罩颜色
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        this.getWindow().setAttributes(lp);
    }

    class  AddressAdapter extends BaseAdapter{
        List<String> mData;
        Context mContext;
        LayoutInflater mInflater;

        public AddressAdapter(List mDatas, Context mContext) {
            super(mDatas, mContext);
            this.mContext=mContext;
            this.mData=mDatas;
            mInflater=LayoutInflater.from(mContext);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder  holder=null;
            if(convertView==null){
                holder=new ViewHolder();
                convertView=mInflater.inflate(R.layout.item_listview_pop_address,null,false);
                holder.mTextview= (TextView) convertView.findViewById(R.id.text_address);
                convertView.setTag(holder);
            }else {
                holder= (ViewHolder) convertView.getTag();

            }
            holder.mTextview.setText(mData.get(position));

            return convertView;
        }
        class ViewHolder {
            TextView mTextview;
        }
    }
}
