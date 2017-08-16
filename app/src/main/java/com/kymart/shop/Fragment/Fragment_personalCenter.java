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
import com.kymart.shop.Activity.AddressActivity;
import com.kymart.shop.Activity.AllOrderActivity;
import com.kymart.shop.Activity.CashoutActivity;
import com.kymart.shop.Activity.JiangZYActivity;
import com.kymart.shop.Activity.LoginActivity;
import com.kymart.shop.Activity.MoneyActivity;
import com.kymart.shop.Activity.QRcodeActivity;
import com.kymart.shop.Activity.RechargeActivity;
import com.kymart.shop.Activity.SettingActivity;
import com.kymart.shop.Activity.ShareFriendsActivity;
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
    TextView mTextview_name,mTextview_ID,mTextview_sellState,mTextview_blance,mTextview_sharePrice,mTextview_Exit;
    RelativeLayout mRE_yue,mRE_wodeqianbao,mRE_jiangjin,mRE_shezhi,mRE_shouhudizhi,mRE_QRcode,mRE_shenqingtixian,mRE_jiangjinzhuanyue,mRE_shareFrends,mRE_quanbudingdan;

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
        mRE_yue.setOnClickListener(this);
        mTextview_Exit.setOnClickListener(this);
        mRE_shezhi.setOnClickListener(this);
        mRE_shouhudizhi.setOnClickListener(this);
        mRE_wodeqianbao.setOnClickListener(this);
        mRE_jiangjin.setOnClickListener(this);
        mRE_QRcode.setOnClickListener(this);
        mRE_shenqingtixian.setOnClickListener(this);
        mRE_jiangjinzhuanyue.setOnClickListener(this);
        mRE_shareFrends.setOnClickListener(this);
        mRE_quanbudingdan.setOnClickListener(this);
    }

    String name="";
    private void setdata() {
        Glide.with(getActivity()).load(person.getResult().getHead_pic()).placeholder(R.mipmap.user68).error(R.mipmap.user68).into(mImage_head) ;
        name=   person.getResult().getNickname();
        if(name==null||name.equals("")){
            name=person.getResult().getMobile();
        }
        mTextview_name.setText(person.getResult().getNickname());
        mTextview_ID.setText(person.getResult().getOperator_status()==0? "会员ID:"+(person.getResult().getUser_id() ):"会员ID:"+(person.getResult().getUser_id())+"(运营商)");
        mTextview_sellState.setText(person.getResult().getSell_status()==0? "预备会员":"开心果");
        mTextview_blance.setText("￥"+person.getResult().getUser_money()+"");
        mTextview_sharePrice.setText("￥"+person.getResult().getBonus());
    }
   void  request(){
       new Volley_Utils(new Interface_volley_respose() {
           @Override
           public void onSuccesses(String respose) {
               LogUtils.LOG("ceshi","userInfO"+respose);
               person=new Gson().fromJson(respose,personCenterBean.class);
               Staticdata.personCenterBean=person;
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
        mTextview_ID= (TextView) rootView.findViewById(R.id.textview_id);
        mTextview_sellState= (TextView) rootView.findViewById(R.id.Textview_sell_status);
        mTextview_blance= (TextView) rootView.findViewById(R.id.text_balance);
        mTextview_sharePrice= (TextView) rootView.findViewById(R.id.text_sharePrice);
        mTextview_Exit= (TextView) rootView.findViewById(R.id.text_exit);
        mRE_yue= (RelativeLayout) rootView.findViewById(R.id.re_yue);
        mRE_shezhi= (RelativeLayout) rootView.findViewById(R.id.re_shezhi);
        mRE_shouhudizhi= (RelativeLayout) rootView.findViewById(R.id.re_dizhi);
        mRE_wodeqianbao= (RelativeLayout) rootView.findViewById(R.id.re_wodeqianbao);
        mRE_jiangjin= (RelativeLayout) rootView.findViewById(R.id.re_jiangjinmingxi);
        mRE_QRcode=(RelativeLayout)rootView.findViewById(R.id.re_erweima);
        mRE_shenqingtixian= (RelativeLayout) rootView.findViewById(R.id.re_shenqingtixian);
        mRE_jiangjinzhuanyue= (RelativeLayout) rootView.findViewById(R.id.re_jiangjinzhuanyue);
        mRE_shareFrends= (RelativeLayout) rootView.findViewById(R.id.re_fenxianghaoyou);
        mRE_quanbudingdan= (RelativeLayout) rootView.findViewById(R.id.re_dingdan);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text_exit://注销登录
                Map map=new HashMap();
                map.put("token",Staticdata.userBean_static.getResult().getToken());
                loginOut(map);
                break;
            case R.id.re_yue:
                Intent intent_yue=new Intent(getActivity(), RechargeActivity.class);
                getActivity().startActivity(intent_yue);
                break;
            case R.id.re_shezhi:
                Intent intent=new Intent(getActivity(), SettingActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.re_dizhi:
                Intent intent_addAddress=new Intent(getActivity(), AddressActivity.class);
                getActivity().startActivity(intent_addAddress);
                break;
            case R.id.re_wodeqianbao:
                Intent intent_money= new Intent(getActivity(), MoneyActivity.class);
                intent_money.putExtra("yue","￥"+person.getResult().getUser_money());
                intent_money.putExtra("id",1);
                getActivity().startActivity(intent_money);
                break;
            case R.id.re_jiangjinmingxi:
                Intent intent_bonus= new Intent(getActivity(), MoneyActivity.class);
                intent_bonus.putExtra("yue","￥"+person.getResult().getBonus());
                intent_bonus.putExtra("id",2);
                getActivity().startActivity(intent_bonus);
                break;
            case R.id.re_erweima:
                Intent intent_QRcode=new Intent(getActivity(), QRcodeActivity.class);
                getActivity().startActivity(intent_QRcode);
                break;
            case R.id.re_shenqingtixian:
                Intent intent_Cashout=new Intent(getActivity(), CashoutActivity.class);
                getActivity().startActivity(intent_Cashout);
                break;
            case R.id.re_jiangjinzhuanyue:
                Intent intent_JiangJZyue=new Intent(getActivity(), JiangZYActivity.class);
                getActivity().startActivity(intent_JiangJZyue);
                break;
            case R.id.re_fenxianghaoyou:
                Intent intent_sahreFrends=new Intent(getActivity(), ShareFriendsActivity.class);
                getActivity().startActivity(intent_sahreFrends);
                break;
            case R.id.re_dingdan:
                Intent intent_dingdan=new Intent(getActivity(), AllOrderActivity.class);
                getActivity().startActivity(intent_dingdan);
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
