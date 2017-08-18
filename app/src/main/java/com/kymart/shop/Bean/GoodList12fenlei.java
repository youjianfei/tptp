package com.kymart.shop.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/17.
 */

public class GoodList12fenlei {

    /**
     * status : 1
     * msg : 获取成功
     * search_kt : 0
     * result : [{"goods_id":5953,"cat_id3":88,"goods_sn":"PU-B009","goods_name":"韩本 pu-B009大口径家用电动慢速榨汁机低速榨汁机果汁机","shop_price":"2180.00","comment_count":0,"ky_type":0},{"goods_id":5946,"cat_id3":89,"goods_sn":"HB600","goods_name":"韩本 HB-600全能王破壁机 全营养多功能料理机 家用多功能搅拌机","shop_price":"2580.00","comment_count":0,"ky_type":0},{"goods_id":5938,"cat_id3":83,"goods_sn":"K02","goods_name":"韩本K02空气炸锅 无油无烟大容量智能电炸锅薯条机家用电烤箱","shop_price":"1880.00","comment_count":0,"ky_type":0},{"goods_id":3258,"cat_id3":17,"goods_sn":"TP0003258","goods_name":"TCL BCD-518WEF1 518升 风冷无霜 对开门冰箱 电脑温控（流光金）","shop_price":"4700.00","comment_count":0,"ky_type":0},{"goods_id":3133,"cat_id3":100,"goods_sn":"BJH-JS2001","goods_name":"贝立安 加湿器 BJH-JS2001","shop_price":"279.00","comment_count":0,"ky_type":0},{"goods_id":3124,"cat_id3":89,"goods_sn":"BJH-LL0203","goods_name":"贝立安 乐享果蔬料理机 BJH-LL0203","shop_price":"279.00","comment_count":0,"ky_type":0},{"goods_id":3123,"cat_id3":89,"goods_sn":"BJH-LL0201","goods_name":"贝立安 乐享果蔬料理机 BJH-LL0201","shop_price":"268.00","comment_count":0,"ky_type":0},{"goods_id":3122,"cat_id3":0,"goods_sn":" BJH-SN0301","goods_name":"贝立安 乐享养生宝（酵素酸奶机） BJH-SN0301","shop_price":"258.00","comment_count":0,"ky_type":0},{"goods_id":3119,"cat_id3":93,"goods_sn":"BJH-DZ2201","goods_name":"贝立安 乐享营养煲(电炖盅）BJH-DZ2201","shop_price":"279.00","comment_count":0,"ky_type":0},{"goods_id":3118,"cat_id3":93,"goods_sn":"BJH-DZ7001","goods_name":"贝立安 乐享辅食煲(电炖盅）BJH-DZ7001","shop_price":"159.00","comment_count":0,"ky_type":0}]
     */

    private int status;
    private String msg;
    private int search_kt;
    private List<ResultBean> result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getSearch_kt() {
        return search_kt;
    }

    public void setSearch_kt(int search_kt) {
        this.search_kt = search_kt;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * goods_id : 5953
         * cat_id3 : 88
         * goods_sn : PU-B009
         * goods_name : 韩本 pu-B009大口径家用电动慢速榨汁机低速榨汁机果汁机
         * shop_price : 2180.00
         * comment_count : 0
         * ky_type : 0
         */

        private int goods_id;
        private int cat_id3;
        private String goods_sn;
        private String goods_name;
        private String shop_price;
        private int comment_count;
        private int ky_type;

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public int getCat_id3() {
            return cat_id3;
        }

        public void setCat_id3(int cat_id3) {
            this.cat_id3 = cat_id3;
        }

        public String getGoods_sn() {
            return goods_sn;
        }

        public void setGoods_sn(String goods_sn) {
            this.goods_sn = goods_sn;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getShop_price() {
            return shop_price;
        }

        public void setShop_price(String shop_price) {
            this.shop_price = shop_price;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public int getKy_type() {
            return ky_type;
        }

        public void setKy_type(int ky_type) {
            this.ky_type = ky_type;
        }
    }
}
