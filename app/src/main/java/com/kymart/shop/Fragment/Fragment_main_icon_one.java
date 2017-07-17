package com.kymart.shop.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kymart.shop.Activity.FenLeiActivity;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Utils.LogUtils;

import cn.kymart.tptp.R;

import static com.kymart.shop.Activity.MainActivity.mMainactivity;
import static com.kymart.shop.Fragment.Fragment_classification.fragment_classification;

/**
 * Created by Administrator on 2017/7/16.
 */

public class Fragment_main_icon_one extends Fragment implements View.OnClickListener{
    View rootView;
    LinearLayout jiayongdianqi,shoujishuma,jiajushenghuo,chaoliufushi,xiexuexiangbao,lipinshoushi,shiwushengxian,muyingzhuanqu;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.item_fragment_main_icon_one,container,false);
        jiayongdianqi= (LinearLayout) rootView.findViewById(R.id.Linear_jiayongdainqi);
        shoujishuma= (LinearLayout) rootView.findViewById(R.id.Linear_shoujishuma);
        chaoliufushi= (LinearLayout) rootView.findViewById(R.id.linearlayout_chaoliufushi);
        xiexuexiangbao= (LinearLayout) rootView.findViewById(R.id.Linear_xiexuexiangbao);
        lipinshoushi= (LinearLayout) rootView.findViewById(R.id.Linear_lipinshoushi);
        shiwushengxian= (LinearLayout) rootView.findViewById(R.id.Linear_shiwushengxian);
        muyingzhuanqu= (LinearLayout) rootView.findViewById(R.id.linearlayout_muyingzhuanqu);
        jiajushenghuo= (LinearLayout) rootView.findViewById(R.id.Linear_jiajushenghuo);
        jiayongdianqi.setOnClickListener(this);
        shoujishuma.setOnClickListener(this);
        chaoliufushi.setOnClickListener(this);
        xiexuexiangbao.setOnClickListener(this);
        lipinshoushi.setOnClickListener(this);
        muyingzhuanqu.setOnClickListener(this);
        jiajushenghuo.setOnClickListener(this);
        shiwushengxian.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Linear_jiayongdainqi:
//                Staticdata.left_position=0;
//                mMainactivity.onClick(getActivity().findViewById(R.id.rl_2));
//                if(fragment_classification!=null){
//                    LogUtils.LOG("ceshi","fragment_classification!=null........");
//                    fragment_classification.repuestDataLeft(0);
//                }
                Intent intent1=new Intent(getActivity(), FenLeiActivity.class);
                intent1.putExtra("ID",1);
                startActivity(intent1);

                break;
            case R.id.Linear_shoujishuma:
//                Staticdata.left_position=4;
//                mMainactivity.onClick(getActivity().findViewById(R.id.rl_2));
//                if(fragment_classification!=null){
//                    LogUtils.LOG("ceshi","jiadianshuma"+fragment_classification.toString());
//                    fragment_classification.repuestDataLeft(4);
//                }
                Intent intent2=new Intent(getActivity(), FenLeiActivity.class);
                intent2.putExtra("ID",2);
                startActivity(intent2);

                break;
            case R.id.linearlayout_chaoliufushi:
//                Staticdata.left_position=7;
//                mMainactivity.onClick(getActivity().findViewById(R.id.rl_2));
//                if(fragment_classification!=null){
//                    fragment_classification.repuestDataLeft(7);
//                }
                Intent intent5=new Intent(getActivity(), FenLeiActivity.class);
                intent5.putExtra("ID",5);
                startActivity(intent5);
                break;
            case R.id.Linear_xiexuexiangbao:
//                Staticdata.left_position=8;
//                mMainactivity.onClick(getActivity().findViewById(R.id.rl_2));
//                if(fragment_classification!=null){
//                    fragment_classification.repuestDataLeft(8);
//                }
                Intent intent6=new Intent(getActivity(), FenLeiActivity.class);
                intent6.putExtra("ID",6);
                startActivity(intent6);
                break;
            case R.id.Linear_lipinshoushi:
//                Staticdata.left_position=9;
//                mMainactivity.onClick(getActivity().findViewById(R.id.rl_2));
//                if(fragment_classification!=null){
//                    fragment_classification.repuestDataLeft(9);
//                }
                Intent intent7=new Intent(getActivity(), FenLeiActivity.class);
                intent7.putExtra("ID",7);
                startActivity(intent7);
                break;
            case R.id.Linear_shiwushengxian:
//                Staticdata.left_position=10;
//                mMainactivity.onClick(getActivity().findViewById(R.id.rl_2));
//                if(fragment_classification!=null){
//                    fragment_classification.repuestDataLeft(10);
//                }
                Intent intent8=new Intent(getActivity(), FenLeiActivity.class);
                intent8.putExtra("ID",8);
                startActivity(intent8);
                break;
            case R.id.linearlayout_muyingzhuanqu:
//                Staticdata.left_position=11;
//                mMainactivity.onClick(getActivity().findViewById(R.id.rl_2));
//                if(fragment_classification!=null){
//                    fragment_classification.repuestDataLeft(11);
//                }
                Intent intent9=new Intent(getActivity(), FenLeiActivity.class);
                intent9.putExtra("ID",9);
                startActivity(intent9);
                break;
            case R.id.Linear_jiajushenghuo:
//                Staticdata.left_position=6;
//                mMainactivity.onClick(getActivity().findViewById(R.id.rl_2));
//                if(fragment_classification!=null){
//                    fragment_classification.repuestDataLeft(6);
//                }
                Intent intent4=new Intent(getActivity(), FenLeiActivity.class);
                intent4.putExtra("ID",4);
                startActivity(intent4);
                break;
        }


    }
}
