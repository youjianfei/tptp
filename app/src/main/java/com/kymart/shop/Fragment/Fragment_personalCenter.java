package com.kymart.shop.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.kymart.shop.Activity.AddAddressActivity;
import com.kymart.shop.Activity.LoginActivity;
import com.kymart.shop.Activity.SettingActivity;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Bean.personCenterBean;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.SharedPreferencesUtils;
import com.kymart.shop.Utils.ToastUtils;
import com.kymart.shop.Utils.Volley_Utils;

import java.util.HashMap;
import java.util.Map;

import cn.kymart.tptp.R;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.kymart.shop.AppStaticData.Staticdata.userBean_static;

/**
 * Created by Administrator on 2017/6/11.
 */

public class Fragment_personalCenter extends Fragment implements View.OnClickListener{
    View rootView;
    CircleImageView mImage_head;
    TextView mTextview_name,mTextview_tuiPerson,mTextview_blance,mTextview_sharePrice,mTextview_Exit;
    RelativeLayout mRE_yue,mRE_jiangjin,mRE_shezhi,mRE_shouhudizhi,mRE_quanbudingdan;

    personCenterBean person;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_person_center,container,false);
        initview();
        initListener();
        request();
        LogUtils.LOG("ceshi","oncreat");

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.LOG("ceshi","onResume");
        request();
    }

    private void initListener() {
        mTextview_Exit.setOnClickListener(this);
        mRE_shezhi.setOnClickListener(this);
        mRE_shouhudizhi.setOnClickListener(this);
    }

    String name="";
    private void setdata() {
        Glide.with(getActivity()).load(person.getResult().getHead_pic()).placeholder(R.mipmap.user68).error(R.mipmap.user68).into(mImage_head) ;
        name=   person.getResult().getNickname();
        if(name==null||name.equals("")){
            name=person.getResult().getMobile();
        }
        mTextview_name.setText(person.getResult().getNickname());
        mTextview_tuiPerson.setVisibility(View.GONE);
        mTextview_blance.setText("￥"+person.getResult().getUser_money()+"");
        mTextview_sharePrice.setText("￥"+person.getResult().getBonus());
    }
   void  request(){
       new Volley_Utils(new Interface_volley_respose() {
           @Override
           public void onSuccesses(String respose) {
               LogUtils.LOG("ceshi","userInfO"+respose);
               person=new Gson().fromJson(respose,personCenterBean.class);
               setdata();
           }

           @Override
           public void onError(int error) {

           }
       }).Http(BaseUrl.BaseURL+BaseUrl.userInfo+"&unique_id="+ Staticdata.UUID_static+"&token="+Staticdata.userBean_static.getResult().getToken(),getActivity(),0);
        LogUtils.LOG("ceshi","userInfO"+BaseUrl.BaseURL+BaseUrl.userInfo+"&unique_id="+ Staticdata.UUID_static+"&token="+Staticdata.userBean_static.getResult().getToken());
    }

    private void initview() {
        mImage_head= (CircleImageView) rootView.findViewById(R.id.image_head);
        mTextview_name= (TextView) rootView.findViewById(R.id.textview_accountname);
        mTextview_tuiPerson= (TextView) rootView.findViewById(R.id.textview_tuiPerson);
        mTextview_blance= (TextView) rootView.findViewById(R.id.text_balance);
        mTextview_sharePrice= (TextView) rootView.findViewById(R.id.text_sharePrice);
        mTextview_Exit= (TextView) rootView.findViewById(R.id.text_exit);
        mRE_shezhi= (RelativeLayout) rootView.findViewById(R.id.re_shezhi);
        mRE_shouhudizhi= (RelativeLayout) rootView.findViewById(R.id.re_dizhi);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text_exit://注销登录
                Map map=new HashMap();
                map.put("token",Staticdata.userBean_static.getResult().getToken());
                loginOut(map);
                break;
            case R.id.re_shezhi:
                Intent intent=new Intent(getActivity(), SettingActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.re_dizhi:
                Intent intent_addAddress=new Intent(getActivity(), AddAddressActivity.class);
                getActivity().startActivity(intent_addAddress);
                break;
        }
    }

    private void loginOut(Map map) {
        new  Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {

                LogUtils.LOG("ceshi","注销登录成功");
                Staticdata.isLogin=0;
                SharedPreferencesUtils.putString(getActivity(),"kymt","password", "");
                userBean_static=null;
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                getActivity().startActivity(intent);
            }

            @Override
            public void onError(int error) {
                ToastUtils.showToast(getActivity(),"网络连接失败");

            }
        }).postHttp(BaseUrl.BaseURL+BaseUrl.loginout,getActivity(),1,map);
    }
}
