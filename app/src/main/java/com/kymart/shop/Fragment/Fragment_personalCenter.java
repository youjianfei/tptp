package com.kymart.shop.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Bean.personCenterBean;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.Volley_Utils;

import cn.kymart.tptp.R;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2017/6/11.
 */

public class Fragment_personalCenter extends Fragment {
    View rootView;
    CircleImageView mImage_head;
    TextView mTextview_name,mTextview_tuiPerson;
    RelativeLayout mRE_yue,mRE_jiangjin,mRE_dingdan;

    personCenterBean person;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_person_center,container,false);
        initview();
        request();


        return rootView;
    }
    String name="";
    private void setdata() {
        Glide.with(getActivity()).load(person.getResult().getHead_pic()).placeholder(R.mipmap.user68).error(R.mipmap.user68).into(mImage_head) ;
        name=   person.getResult().getNickname();
        if(name==null||name.equals("")){
            name=person.getResult().getMobile();
        }
        mTextview_name.setText(person.getResult().getNickname());
        mTextview_tuiPerson.setVisibility(View.INVISIBLE);
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
    }
}
