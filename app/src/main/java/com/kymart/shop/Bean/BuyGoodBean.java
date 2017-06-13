package com.kymart.shop.Bean;

import android.util.Log;

import com.kymart.shop.Utils.LogUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2017/6/13.
 */

public class BuyGoodBean {
    private int good_buy_id;//购买ID
    private int good_buy_count;//购买数量
    private int good_buy_store_count;//当前价格库存
    private String good_buy_price;//购买价格（单价）

    private List<GoodsSpecList>good_buy_propertys;//属性数组
    private List<GoodsSpecList>good_buy_propertys_copy;//属性数组
    private List<GoodDetailsBean.Result.SpecGoodsPrice>spec_goods_prices;//价格数组



    private String good_select_info;//已选
    private boolean isCanBuy;//是否可买

    public int getGood_buy_id() {
        return good_buy_id;
    }

    public void setGood_buy_id(int good_buy_id) {
        this.good_buy_id = good_buy_id;
    }

    public int getGood_buy_count() {
        return good_buy_count;
    }

    public void setGood_buy_count(int good_buy_count) {
        this.good_buy_count = good_buy_count;
    }

    public int getGood_buy_store_count() {
        return good_buy_store_count;
    }

    public void setGood_buy_store_count(int good_buy_store_count) {
        this.good_buy_store_count = good_buy_store_count;
    }

    public String getGood_buy_price() {
        return good_buy_price;
    }

    public void setGood_buy_price(String good_buy_price) {
        this.good_buy_price = good_buy_price;
    }

    public List<GoodsSpecList> getGood_buy_propertys() {
        return good_buy_propertys;
    }

    public void setGood_buy_propertys(List<GoodsSpecList> good_buy_propertys) {
        this.good_buy_propertys = good_buy_propertys;
    }

    public List<GoodDetailsBean.Result.SpecGoodsPrice> getSpec_goods_prices() {
        return spec_goods_prices;
    }
    public List<GoodsSpecList> getGood_buy_propertys_copy() {
        return good_buy_propertys_copy;
    }

    public void setGood_buy_propertys_copy(List<GoodsSpecList> good_buy_propertys_copy) {
        this.good_buy_propertys_copy = good_buy_propertys_copy;
    }
    public void setSpec_goods_prices(List<GoodDetailsBean.Result.SpecGoodsPrice> spec_goods_prices) {
        this.spec_goods_prices = spec_goods_prices;
    }

    public String getGood_select_info() {
        return good_select_info;
    }

    public void setGood_select_info(String good_select_info) {
        this.good_select_info = good_select_info;
    }

    public boolean isCanBuy() {
        return isCanBuy;
    }

    public void setCanBuy(boolean canBuy) {
        isCanBuy = canBuy;
    }
    public static class GoodsSpecList {

        private String spec_name;
        private GoodDetailsBean.Result.Goods.GoodsSpecList.SpecList spec_list;

        public String getSpec_name() {
            return spec_name;
        }

        public void setSpec_name(String spec_name) {
            this.spec_name = spec_name;
        }

        public GoodDetailsBean.Result.Goods.GoodsSpecList.SpecList getSpec_list() {
            return spec_list;
        }

        public void setSpec_list(GoodDetailsBean.Result.Goods.GoodsSpecList.SpecList spec_list) {
            this.spec_list = spec_list;
        }
    }

    public   List<GoodsSpecList> sort(){

        good_buy_propertys_copy = new  ArrayList<GoodsSpecList>();
        good_buy_propertys_copy .addAll(good_buy_propertys);

        LogUtils.LOG("ceshi",good_buy_propertys_copy.toString()+".."+good_buy_propertys.toString());
        for(int i=0;i<good_buy_propertys.size();i++){
            LogUtils.LOG("ceshi","aaa"+good_buy_propertys.get(i).getSpec_name());
        }

        Collections.sort(good_buy_propertys_copy, new Comparator<GoodsSpecList>() {
            @Override
            public int compare(GoodsSpecList o1, GoodsSpecList o2) {
                //按照学生的年龄进行升序排列
                if(o1.getSpec_list().getItem_id() > o2.getSpec_list().getItem_id()){
                    return 1;
                }
                if(o1.getSpec_list().getItem_id() == o2.getSpec_list().getItem_id()){
                    return 0;
                }

                return -1;
            }
        });
        for(int i=0;i<good_buy_propertys.size();i++){
            LogUtils.LOG("ceshi","bbb"+good_buy_propertys.get(i).getSpec_name());
        }
        return  good_buy_propertys_copy;
    }

    public   void PinJieString (List<GoodsSpecList> propertys){
        LogUtils.LOG("ceshi",propertys.toString());
        String string ="";

        for(GoodsSpecList  bean:propertys){
            int id= bean.getSpec_list().getItem_id();
            string="_"+id;
        }
        if(!string.equals("")){
            string=string.substring(1);
        }
        if(spec_goods_prices==null){
            return;
        }
        for(int i=0;i<spec_goods_prices.size();i++){
            String mes=spec_goods_prices.get(i).getKey();
            if(string.equals(mes)){
                good_buy_price=spec_goods_prices.get(i).getPrice();
                good_buy_store_count=spec_goods_prices.get(i).getStore_count();
            }
        }

    }
    public void yiXuan(){
        String string ="";
        for(GoodsSpecList  bean:good_buy_propertys){
            String id= bean.getSpec_list().getItem();
            string+=id+",";
            LogUtils.LOG("ceshi",string+"ididididid");
        }
        string=string+good_buy_count;
        good_select_info=string;
    }
    public void reload(){
        List<GoodsSpecList>propertys=sort();
        if(propertys==null){
            return;
        }
        PinJieString (propertys);
        yiXuan();

        isCanBuy = (good_buy_store_count >= good_buy_count);
        isCanBuy = !(good_buy_store_count == 0);

    }

}
