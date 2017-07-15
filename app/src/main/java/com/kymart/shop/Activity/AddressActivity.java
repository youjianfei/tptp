package com.kymart.shop.Activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.kymart.shop.Adapter.BaseAdapter;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Bean.AddressListBean;
import com.kymart.shop.Bean.CityIDBean;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.ToastUtils;
import com.kymart.shop.Utils.Volley_Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.kymart.tptp.R;

public class AddressActivity extends BaseActivityother {
    TextView mTextview_addAddress;
    ListView mListview_address;
    List<AddressListBean.ResultBean>mList_address;
    AddressAdapter mAdapter;
    KProgressHUD mKProgressHUD;
    @Override
    public int setLayoutResID() {
        return R.layout.activity_address;
    }

    @Override
    protected void setData() {
        mKProgressHUD = new KProgressHUD(this);

    }

    @Override
    protected void initData() {
        mList_address=new ArrayList<>();
        mAdapter=new AddressAdapter(mList_address,this);
        mListview_address.setAdapter(mAdapter);
        requestAddressList();

    }

    @Override
    protected void initListener() {
        mTextview_addAddress.setOnClickListener(this);
       mListview_address.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Staticdata.mList_address =mList_address.get(position);
               Intent  intent =new Intent(AddressActivity.this,AddAddressActivity.class);
               intent .putExtra("id", Staticdata.mList_address.getAddress_id());
               AddressActivity.this.startActivity(intent);
           }
       });

    }

    @Override
    protected void initView() {
        mTextview_addAddress= (TextView) findViewById(R.id.text_addAddress);
        mListview_address= (ListView) findViewById(R.id.listview_addressList);

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.text_addAddress:
                Intent intent=new Intent(this,AddAddressActivity.class);
                this.startActivity(intent);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        requestAddressList();
    }

    private void requestAddressList() {
        String URL_addressList= BaseUrl.BaseURL+BaseUrl.addressList+ Staticdata.UUID_static+"&token="+Staticdata.userBean_static.getResult().getToken();
        LogUtils.LOG("ceshi","addressList"+URL_addressList);
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi","addressList"+respose);
                mList_address.clear();
                mList_address.addAll(new Gson().fromJson(respose, AddressListBean.class).getResult());
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(int error) {

            }
        }).Http(URL_addressList,this,0);


    }
    class AddressAdapter  extends BaseAdapter{
        List<AddressListBean.ResultBean >  mData;
        Context mContext;
        LayoutInflater mLayoutInflater;

        public AddressAdapter(List mDatas, Context mContext) {
            super(mDatas, mContext);
            this.mData=mDatas;
            this.mContext=mContext;
            mLayoutInflater=LayoutInflater.from(mContext);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
          viewHolder holder=null;
            final AddressListBean.ResultBean bean=mData.get(position);
            if(convertView==null){
                holder=new viewHolder();
                convertView=mLayoutInflater.inflate(R.layout.item_list_address,null,false);
                holder.mImageView_select= (ImageView) convertView.findViewById(R.id.image_select);
                holder.mImageView_delete= (ImageView) convertView.findViewById(R.id.image_delate);
                holder.mTextview_name= (TextView) convertView.findViewById(R.id.textview_name);
                holder.mTextview_phonenumber= (TextView) convertView.findViewById(R.id.textview_phonenumber);
                holder.mTextview_address= (TextView) convertView.findViewById(R.id.textview_address);
                convertView.setTag(holder);
            }else{
                holder= (viewHolder) convertView.getTag();
            }
            holder.mTextview_name.setText(bean.getConsignee());
            holder.mTextview_phonenumber.setText(bean.getMobile());
            if(bean.getIs_default()==1){
                holder.mImageView_select.setSelected(true);
                Intent mIntent = new Intent();
                mIntent.putExtra("Province", bean.getProvince());
                if(bean.getCity()!=0){
                    mIntent.putExtra("City", bean.getCity());
                }
                if(bean.getDistrict()!=0){
                    mIntent.putExtra("District", bean.getDistrict());
                }
                if(bean.getTwon()!=0){
                    mIntent.putExtra("Twon", bean.getTwon());
                }
                mIntent.putExtra("Address", bean.getAddress());
                mIntent.putExtra("Address_id", bean.getAddress_id());
                mIntent.putExtra("Consignee", bean.getConsignee());
                mIntent.putExtra("Mobile", bean.getMobile());

                // 设置结果，并进行传送
               setResult(RESULT_OK, mIntent);
            }else{

                holder.mImageView_select.setSelected(false);
            }


            if (bean.getProvince()!=0){//请求网络 根据ID获得市县信息
                final viewHolder finalHolder = holder;
                final String[] address = {"","","",""};
                mKProgressHUD.setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                        .setCancellable(true)
                        .setAnimationSpeed(2)
                        .setDimAmount(0.5f)
                        .show();
                new  Volley_Utils(new Interface_volley_respose() {
                    @Override
                    public void onSuccesses(String respose) {
                        final List<CityIDBean> cityList=new ArrayList<>();
                        mList_address.get(position).setCityid(cityList);
                        LogUtils.LOG("ceshi",respose);
                        CityIDBean  cityIDBean=new  Gson().fromJson(respose,CityIDBean.class);
                        LogUtils.LOG("ceshi",cityIDBean.getName());
                        LogUtils.LOG("ceshi", mList_address.get(position).getCityid()+"");
                        mList_address.get(position).getCityid().add(cityIDBean);
                        address[0] =cityIDBean.getName();
                        finalHolder.mTextview_address.setText(address[0]);

                        if(bean.getCity()!=0){
                            new  Volley_Utils(new Interface_volley_respose() {
                                @Override
                                public void onSuccesses(String respose) {
                                    CityIDBean  cityIDBean=new  Gson().fromJson(respose,CityIDBean.class);
                                    mList_address.get(position).getCityid().add(cityIDBean);
                                    address[1] =cityIDBean.getName();
                                    finalHolder.mTextview_address.setText(address[0]+" "+ address[1]);
                                        LogUtils.LOG("ceshi",bean.getCountry()+"country");
                                    if(bean.getDistrict()!=0){
                                        new  Volley_Utils(new Interface_volley_respose() {
                                            @Override
                                            public void onSuccesses(String respose) {
                                                LogUtils.LOG("ceshi","第三层请求");
                                                CityIDBean  cityIDBean=new  Gson().fromJson(respose,CityIDBean.class);
                                                mList_address.get(position).getCityid().add(cityIDBean);
                                                address[2] =cityIDBean.getName();
                                                finalHolder.mTextview_address.setText(address[0]+" "+ address[1]+" "+address[2]);

                                                if(bean.getTwon()!=0){
                                                  new  Volley_Utils(new Interface_volley_respose() {
                                                      @Override
                                                      public void onSuccesses(String respose) {
                                                          CityIDBean  cityIDBean=new  Gson().fromJson(respose,CityIDBean.class);
                                                          mList_address.get(position).getCityid().add(cityIDBean);
                                                          address[3] =cityIDBean.getName();
                                                          finalHolder.mTextview_address.setText(address[0]+" "+ address[1]+" "+address[2]+" "+address[3]+bean.getAddress());
                                                          mKProgressHUD.dismiss();
                                                      }

                                                      @Override
                                                      public void onError(int error) {

                                                      }
                                                  }).Http(BaseUrl.BaseURL+BaseUrl.cityId+bean.getTwon(),mContext,0);
                                                }else {
                                                    finalHolder.mTextview_address.setText(address[0]+" "+ address[1]+" "+address[2]+bean.getAddress());
                                                    mKProgressHUD.dismiss();
                                                }

                                            }

                                            @Override
                                            public void onError(int error) {

                                            }
                                        }).Http(BaseUrl.BaseURL+BaseUrl.cityId+bean.getDistrict(),mContext,0);
                                    }else {
                                        finalHolder.mTextview_address.setText(address[0]+" "+ address[1]+bean.getAddress());
                                        mKProgressHUD.dismiss();
                                    }
                                }

                                @Override
                                public void onError(int error) {

                                }
                            }).Http(BaseUrl.BaseURL+BaseUrl.cityId+bean.getCity(),mContext,0);
                        }else {
                            finalHolder.mTextview_address.setText(address[0]+bean.getAddress());
                            mKProgressHUD.dismiss();
                        }
                    }

                    @Override
                    public void onError(int error) {

                    }
                }).Http(BaseUrl.BaseURL+BaseUrl.cityId+bean.getProvince(),mContext,0);
            }

            holder.mImageView_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LogUtils.LOG("ceshi","删除被点击了");
                    Map mapdel=new HashMap();
                    mapdel.put("id",bean.getAddress_id()+"");
                    new  Volley_Utils(new Interface_volley_respose() {
                        @Override
                        public void onSuccesses(String respose) {
                            LogUtils.LOG("ceshi","删除被点击了1"+respose);
                            ToastUtils.showToast(mContext,"删除成功");
                            requestAddressList();
                        }

                        @Override
                        public void onError(int error) {

                        }
                    }).postHttp(BaseUrl.BaseURL+BaseUrl.delAddress+Staticdata.UUID_static+"&token="+Staticdata.userBean_static.getResult().getToken(),mContext,1,mapdel);
                }
            });



            return convertView;
        }
        class  viewHolder {
            TextView mTextview_name,mTextview_phonenumber,mTextview_address;
            ImageView mImageView_select,mImageView_delete;
        }

    }
}
