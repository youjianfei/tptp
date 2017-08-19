package com.kymart.shop.Activity;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kymart.shop.Adapter.BaseAdapter;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Bean.AddressSelectBean;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.ToastUtils;
import com.kymart.shop.Utils.Volley_Utils;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.kymart.tptp.R;

public class AddAddressActivity extends BaseActivityother {
    int ID=0;//地址id


    TextView mTextview_title,mTextview_area;
    EditText mEdit_name,mEdit_phonenumber,mEdit_address,mEdit_zipcode;

    String name="",phonenumber="",address="",zipcode="";
    ImageView mImage_select,mImage_delete;


    PopupWindow mPopupWindow;
    LinearLayout mLinearLayout_bottom;
    ListView popListview;
    List<AddressSelectBean.Address_selectEntity> mListAddress;
    AddressAdapter mAdapter;
    int TAG=0;

    Button mButton_addAddress;
    Map map_addAddress;



    @Override
    public int setLayoutResID() {
        return R.layout.activity_add_address;
    }

    @Override
    protected void setData() {

    }
    String one,two,three,four;
    @Override
    protected void initData() {
        map_addAddress=new HashMap();
        if(ID!=0){
           int i= Staticdata.mList_address.getIs_default();
            if(i==1){
                mImage_select.setSelected(true);
            }else{
                mImage_select.setSelected(false);
            }
            mEdit_name.setText(Staticdata.mList_address.getConsignee());
            map_addAddress.put("consignee",Staticdata.mList_address.getConsignee());
            mEdit_phonenumber.setText(Staticdata.mList_address.getMobile());
            map_addAddress.put("mobile",Staticdata.mList_address.getMobile());
            mEdit_address.setText(Staticdata.mList_address.getAddress());
            map_addAddress.put("address",Staticdata.mList_address.getAddress());
            mEdit_zipcode.setText(Staticdata.mList_address.getZipcode());
            map_addAddress.put("zipcode",Staticdata.mList_address.getZipcode());
            map_addAddress.put("user_id",Staticdata.userBean_static.getResult().getUser_id()+"");
            map_addAddress.put("is_default",Staticdata.mList_address.getIs_default()+"");
            String y=Staticdata.mList_address.getCityid().get(0).getName();
            String e=Staticdata.mList_address.getCityid().get(1).getName();
            String sa=Staticdata.mList_address.getCityid().get(2).getName();
            String si=Staticdata.mList_address.getCityid().get(3).getName();
            mTextview_area.setText(y+" "+e+" "+sa+" "+si);
            map_addAddress.put("province",Staticdata.mList_address.getCityid().get(0).getId()+"");
            map_addAddress.put("city",Staticdata.mList_address.getCityid().get(1).getId()+"");
            map_addAddress.put("district",Staticdata.mList_address.getCityid().get(2).getId()+"");
            map_addAddress.put("twon",Staticdata.mList_address.getCityid().get(3).getId()+"");
            map_addAddress.put("address_id",Staticdata.mList_address.getAddress_id()+"");
        }
        volley_utils=new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                String RES="{\"address_select\":"+respose+"}";
                mListAddress.clear();
                mListAddress.addAll(new  Gson().fromJson(RES,AddressSelectBean.class).getAddress_select());
                if(mListAddress.size()==0){
                    mPopupWindow.dismiss();
                }
                mAdapter.notifyDataSetChanged();
                popListview.setSelection(0);

                /**
                 * 赋值给界面
                 */
                 one=  mTextview_one.getText()+"";
                two= mTextview_two.getText()+"";
                three= mTextview_three.getText()+"";
                four= mTextview_four.getText()+"";
                if(one.equals("请选择")){
                    one="";
                }
                if(two.equals("请选择")){
                    two="";
                }
                if(three.equals("请选择")){
                    three="";
                }
                if(four.equals("请选择")){
                    four="";
                }
                mTextview_area.setText(one+" "+two+" "+three+" "+four);//赋值给界面


            }

            @Override
            public void onError(int error) {

            }
        });



        mListAddress=new ArrayList<>();

    }

    @Override
    protected void initListener() {
        mTextview_area.setOnClickListener(this);
        mButton_addAddress.setOnClickListener(this);
        mImage_select.setOnClickListener(this);
        mImage_delete.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        Intent intent=getIntent();
        ID=intent.getIntExtra("id",0);

        mTextview_title= (TextView) findViewById(R.id.text_title);
        mLinearLayout_bottom= (LinearLayout) findViewById(R.id.activity_add_address);
        mTextview_area= (TextView) findViewById(R.id.text_area);
        mButton_addAddress= (Button) findViewById(R.id.button_addAddress);
        mEdit_name= (EditText) findViewById(R.id.edit_name);
        mEdit_phonenumber= (EditText) findViewById(R.id.edit_phonenumber);
        mEdit_address= (EditText) findViewById(R.id.edit_address);
        mEdit_zipcode= (EditText) findViewById(R.id.edit_zipcode);
        mImage_select= (ImageView) findViewById(R.id.image_isdefault);
        mImage_delete= (ImageView) findViewById(R.id.image_delate);
        if(ID==0){
            mTextview_title.setText("新增地址");
            mImage_delete.setVisibility(View.INVISIBLE);
        }else{
            mTextview_title.setText("编辑地址");
            mButton_addAddress.setText("完成");
        }

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.image_isdefault:
                mImage_select.setSelected( mImage_select.isSelected()? false:true);
                break;
            case R.id.text_area:
                showPopwindow();
                break;
            case R.id.button_addAddress:
                name=mEdit_name.getText()+"";
                if(!name.equals("")){
                    map_addAddress.put("consignee",name);
                }else {
                    ToastUtils.showToast(this,"请填写收货人姓名");
                    return;
                }
                phonenumber=mEdit_phonenumber.getText()+"";
                if(!phonenumber.equals("")){
                    map_addAddress.put("mobile",phonenumber);
                }else{
                    ToastUtils.showToast(this,"请填写收货人联系电话");
                    return;
                }
                address=mEdit_address.getText()+"";
                if(!address.equals("")){
                    map_addAddress.put("address",address);
                }else {
                    ToastUtils.showToast(this,"请填写收货人详细地址");
                    return;
                }
                zipcode=mEdit_zipcode.getText()+"";
                if(!zipcode.equals("")){
                    map_addAddress.put("zipcode",zipcode);
                }else {
                    ToastUtils.showToast(this,"请填写收货人邮政编码");
                    return;
                }
                if(mTextview_area.getText().equals("")){
                    ToastUtils.showToast(this,"请选择收货地址");
                    return;
                }
                map_addAddress.put("user_id",Staticdata.userBean_static.getResult().getUser_id()+"");
                if(mImage_select.isSelected()){
                    map_addAddress.put("is_default",1+"");
                }else {
                    map_addAddress.put("is_default",0+"");
                }

                request_addAddress(map_addAddress);

                break;
            case R.id.image_delate:
                Map map_del=new HashMap();
                map_del.put("id",Staticdata.mList_address.getAddress_id()+"");
                new Volley_Utils(new Interface_volley_respose() {
                    @Override
                    public void onSuccesses(String respose) {
                        LogUtils.LOG("ceshi","删除成功");

                    }

                    @Override
                    public void onError(int error) {

                    }
                }).postHttp(BaseUrl.BaseURL+BaseUrl.delAddress+Staticdata.UUID_static+"&token="+Staticdata.userBean_static.getResult().getToken(),AddAddressActivity.this,1,map_del);

                break;
        }
    }

    private void request_addAddress(Map addAddress_map) {
        String URL_addAddress=BaseUrl.BaseURL+BaseUrl.addAddress+ Staticdata.UUID_static+"&token="+Staticdata.userBean_static.getResult().getToken();
       LogUtils.LOG("ceshi","postAddress"+URL_addAddress+addAddress_map.toString());

        new  Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi",respose);
                try {
                    JSONObject object=new JSONObject(respose);
                    int  state= (int) object.get("status");
                    String  msg= (String) object.get("msg");
                    if(state==1){
                        ToastUtils.showToast(AddAddressActivity.this,msg);
                        finish();
                    }else {
                        ToastUtils.showToast(AddAddressActivity.this,msg);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onError(int error) {

            }
        }).postHttp( URL_addAddress,this,1,addAddress_map);

    }

    TextView mTextview_one,mTextview_two,mTextview_three,mTextview_four;
    ImageView mImage_close;
    private void showPopwindow() {

        //初始化popwindow；
        View conView= LayoutInflater.from(this).inflate(R.layout.popwindow_select_address,null,false);
        mPopupWindow=new PopupWindow(conView,
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setOutsideTouchable(true);// 触摸popupwindow外部，popupwindow消失
        mPopupWindow.showAtLocation(mLinearLayout_bottom, Gravity.BOTTOM, 0, 0);
        popListview= (ListView) conView.findViewById(R.id.Listview_addresspopwindow);
        mImage_close= (ImageView) conView.findViewById(R.id.ImageView_close);
        mTextview_one= (TextView) conView.findViewById(R.id.text_one);
        mTextview_two= (TextView) conView.findViewById(R.id.text_two);
        mTextview_three= (TextView) conView.findViewById(R.id.text_three);
        mTextview_four= (TextView) conView.findViewById(R.id.text_four);


        mAdapter=new AddressAdapter(mListAddress,this);
        popListview.setAdapter(mAdapter);

        requestAddress(1,0);

        setListener();



        setAlpha((float) 0.3);
    }
       Volley_Utils volley_utils;
    void requestAddress(int level,int parent_id){
        String URL_address= BaseUrl.BaseURL+BaseUrl.Address+level+"&parent_id="+parent_id;
        LogUtils.LOG("ceshi","地址URL"+URL_address);
        volley_utils .Http(URL_address,this,0);
        TAG=level;
    }
     void setListener(){
         mImage_close.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 mPopupWindow.dismiss();
             }
         });
         popListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 switch (TAG){
                     case 1:
                         mTextview_one.setText(mListAddress.get(i).getName());//设置 已经选择的内容
                         mTextview_one.setTag(mListAddress.get(i).getId());// 设置 ID 为TAG，以便上传服务器
                         mTextview_two.setVisibility(View.VISIBLE);//显示下一个按钮
                         requestAddress(2,mListAddress.get(i).getId());
                         break;
                     case 2:
                         mTextview_two.setText(mListAddress.get(i).getName());
                         mTextview_two.setTag(mListAddress.get(i).getId());// 设置 ID 为TAG，以便上传服务器
                         mTextview_three.setVisibility(View.VISIBLE);
                         requestAddress(3,mListAddress.get(i).getId());
                         break;
                     case 3:
                         mTextview_three.setText(mListAddress.get(i).getName());
                         mTextview_three.setTag(mListAddress.get(i).getId());// 设置 ID 为TAG，以便上传服务器
                         mTextview_four.setVisibility(View.VISIBLE);
                         requestAddress(4,mListAddress.get(i).getId());
                         break;
                     case 4:
                         mTextview_four.setText(mListAddress.get(i).getName());
                         mTextview_four.setTag(mListAddress.get(i).getId());// 设置 ID 为TAG，以便上传服务器
                         four= mTextview_four.getText()+"";
                         mTextview_area.setText(one+" "+two+" "+three+" "+four);//赋值给界面
                         break;
                 }



             }
         });
         mTextview_one.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 mTextview_two.setVisibility(View.GONE);//设置按钮消失
                 mTextview_three.setVisibility(View.GONE);
                 mTextview_four.setVisibility(View.GONE);
                 mTextview_two.setText("请选择");
                 mTextview_three.setText("请选择");
                 mTextview_four.setText("请选择");
                 requestAddress(1,0);
             }
         });
         mTextview_two.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 mTextview_three.setVisibility(View.GONE);
                 mTextview_four.setVisibility(View.GONE);
                 mTextview_three.setText("请选择");
                 mTextview_four.setText("请选择");
                 requestAddress(2, (Integer) mTextview_one.getTag());
             }
         });
         mTextview_three.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 mTextview_four.setVisibility(View.GONE);
                 mTextview_four.setText("请选择");
                 requestAddress(3, (Integer) mTextview_two.getTag());
             }
         });
         mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
             @Override
             public void onDismiss() {
                 LogUtils.LOG("ceshi","TAG:"+mTextview_one.getTag()+".."+mTextview_two.getTag()+".."+mTextview_three.getTag()+".."+mTextview_four.getTag());
                 setAlpha((float) 1);

                 if(mTextview_one.getTag()!=null){
                     map_addAddress.put("province",mTextview_one.getTag()+"");
                 }
                 if(mTextview_two.getTag()!=null){
                     map_addAddress.put("city",mTextview_two.getTag()+"");
                 }
                 if(mTextview_three.getTag()!=null){
                     map_addAddress.put("district",mTextview_three.getTag()+"");
                 }
                 if(mTextview_four.getTag()!=null){
                     map_addAddress.put("twon",mTextview_four.getTag()+"");
                 }
             }
         });
     }
    public void setAlpha(float bgAlpha) {//设置背景遮罩颜色
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        this.getWindow().setAttributes(lp);
    }

    class  AddressAdapter extends BaseAdapter{
        List<AddressSelectBean.Address_selectEntity> mData;
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
            AddressSelectBean.Address_selectEntity bean=mData.get(position);
            if(convertView==null){
                holder=new ViewHolder();
                convertView=mInflater.inflate(R.layout.item_listview_pop_address,null,false);
                holder.mTextview= (TextView) convertView.findViewById(R.id.text_address);
                convertView.setTag(holder);
            }else {
                holder= (ViewHolder) convertView.getTag();

            }
            holder.mTextview.setText(bean.getName());

            return convertView;
        }
        class ViewHolder {
            TextView mTextview;
        }
    }
}
