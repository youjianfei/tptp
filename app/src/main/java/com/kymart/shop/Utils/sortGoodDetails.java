package com.kymart.shop.Utils;

import com.kymart.shop.Bean.BuyGoodBean;
import com.kymart.shop.Bean.GoodDetailsBean;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2017/6/13.
 */

public class sortGoodDetails {
    public static List<GoodDetailsBean.ResultBean.GoodsSpecListBean> sort(List<GoodDetailsBean.ResultBean.GoodsSpecListBean> mList){
        Collections.sort(mList, new Comparator<GoodDetailsBean.ResultBean.GoodsSpecListBean>() {
            @Override
            public int compare(GoodDetailsBean.ResultBean.GoodsSpecListBean o1, GoodDetailsBean.ResultBean.GoodsSpecListBean o2) {
                //按照学生的年龄进行升序排列
                if(o1.getSpec_list().get(0).getItem_id() > o2.getSpec_list().get(0).getItem_id()){
                    return 1;
                }
                if(o1.getSpec_list().get(0).getItem_id() == o2.getSpec_list().get(0).getItem_id()){
                    return 0;
                }

                return -1;
            }
        });

        return mList;
    }








}
