package com.kymart.shop.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kymart.shop.Activity.AllOrderActivity;
import com.kymart.shop.Activity.FenLeiActivity;
import com.kymart.shop.Activity.LoginActivity;
import com.kymart.shop.AppStaticData.Staticdata;

import cn.kymart.tptp.R;

import static com.kymart.shop.Activity.MainActivity.mMainactivity;
import static com.kymart.shop.AppStaticData.Staticdata.isLogin;
import static com.kymart.shop.Fragment.Fragment_classification.fragment_classification;

/**
 * Created by Administrator on 2017/7/16.
 */

public class Fragment_main_icon_two  extends Fragment implements View.OnClickListener{
    View rootView;
    LinearLayout mLinearlayout_wodedinfdan,meizhuanggehu,yundonghuwai,qicheyongpin,shenghuochuxing,dianpujie,pinpaijie,xianshiyouhui;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.item_fragment_main_icon_two,container,false);

        mLinearlayout_wodedinfdan= (LinearLayout) rootView.findViewById(R.id.Linear_wodedingdan);
        meizhuanggehu= (LinearLayout) rootView.findViewById(R.id.Linear_meizhuanggehu);
        yundonghuwai= (LinearLayout) rootView.findViewById(R.id.Linear_yundonghuwai);
        qicheyongpin= (LinearLayout) rootView.findViewById(R.id.Linear_qicheyongpin);
        shenghuochuxing= (LinearLayout) rootView.findViewById(R.id.linearlayout_shenghuochuxing);
        dianpujie= (LinearLayout) rootView.findViewById(R.id.Linear_dianpujie);
        pinpaijie= (LinearLayout) rootView.findViewById(R.id.Linear_pinpaijie);
        xianshiyouhui= (LinearLayout) rootView.findViewById(R.id.linearlayout_xianshiyouhui);
        mLinearlayout_wodedinfdan.setOnClickListener(this);
        meizhuanggehu.setOnClickListener(this);
        yundonghuwai.setOnClickListener(this);
        qicheyongpin.setOnClickListener(this);
        shenghuochuxing.setOnClickListener(this);
        dianpujie.setOnClickListener(this);
        pinpaijie.setOnClickListener(this);
        xianshiyouhui.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Linear_wodedingdan:
                if(isLogin==1){
                    Intent intent_dingdan=new Intent(getActivity(), AllOrderActivity.class);
                    getActivity().startActivity(intent_dingdan);
                }else{
                    Intent intent=new Intent(getActivity(),LoginActivity.class);
                    startActivityForResult(intent,0);
                }

                break;
            case R.id.Linear_meizhuanggehu:
//                Staticdata.left_position=1;
//                mMainactivity.onClick(getActivity().findViewById(R.id.rl_2));
//                if(fragment_classification!=null){
//                    fragment_classification.repuestDataLeft(1);
//                }
                Intent intent10=new Intent(getActivity(), FenLeiActivity.class);
                intent10.putExtra("ID",10);
                startActivity(intent10);
                break;

            case R.id.Linear_yundonghuwai:
//                Staticdata.left_position=2;
//                mMainactivity.onClick(getActivity().findViewById(R.id.rl_2));
//                if(fragment_classification!=null){
//                    fragment_classification.repuestDataLeft(2);
//                }
                Intent intent11=new Intent(getActivity(), FenLeiActivity.class);
                intent11.putExtra("ID",11);
                startActivity(intent11);


                break;

            case R.id.Linear_qicheyongpin:
//                Staticdata.left_position=3;
//                mMainactivity.onClick(getActivity().findViewById(R.id.rl_2));
//                if(fragment_classification!=null){
//                    fragment_classification.repuestDataLeft(3);
//                }
                Intent intent12=new Intent(getActivity(), FenLeiActivity.class);
                intent12.putExtra("ID",12);
                startActivity(intent12);

                break;

            case R.id.linearlayout_shenghuochuxing:
                Staticdata.left_position=5;
//                mMainactivity.onClick(getActivity().findViewById(R.id.rl_2));
//                if(fragment_classification!=null){
//                    fragment_classification.repuestDataLeft(5);
//                }
                Intent intent399=new Intent(getActivity(), FenLeiActivity.class);
                intent399.putExtra("ID",399);
                startActivity(intent399);
                break;

            case R.id.Linear_dianpujie:
                break;

            case R.id.Linear_pinpaijie:
                break;

            case R.id.linearlayout_xianshiyouhui:
                break;

        }


    }
}
