package com.kymart.shop.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */

public class GoodList_ModouleBean {

    /**
     * status : 1
     * msg : 获取成功
     * search_kt : 3
     * result : [{"goods_id":2211,"cat_id3":365,"goods_sn":"TP0002211","goods_name":"【促销区】伙伴之星TPE瑜伽垫002","shop_price":"93.00","comment_count":0,"ky_type":3},{"goods_id":2212,"cat_id3":468,"goods_sn":"TP0002212","goods_name":"【促销区】伙伴之星 新款溜冰鞋套装001（包含鞋，头盔，护肘，护膝）","shop_price":"215.00","comment_count":0,"ky_type":3},{"goods_id":2213,"cat_id3":360,"goods_sn":"TP0002213","goods_name":"【促销区】伙伴之星滑板558(PU闪光轮，海鸥支架 PU避震 双翘凹版)","shop_price":"135.00","comment_count":0,"ky_type":3},{"goods_id":2214,"cat_id3":459,"goods_sn":"TP0002214","goods_name":"【促销区】广东珠海 祺海 大黄鱼生鲜冰鲜 海鲜大礼包 5斤礼盒装 (全部是大黄鱼)","shop_price":"271.00","comment_count":0,"ky_type":3},{"goods_id":2215,"cat_id3":459,"goods_sn":"TP0002215","goods_name":"【促销区】广东珠海 祺海 白蕉海鲈鱼生鲜冰鲜 海鲜大礼包 5斤礼盒装 (全部是白蕉海鲈鱼)","shop_price":"271.00","comment_count":0,"ky_type":3},{"goods_id":2216,"cat_id3":345,"goods_sn":"TP0002216","goods_name":"【促销区】【契尔氏】377美白祛斑霜套装黄褐斑雀斑孕妇斑晒斑遗传斑","shop_price":"193.00","comment_count":0,"ky_type":3},{"goods_id":2217,"cat_id3":345,"goods_sn":"TP0002217","goods_name":"【促销区】【契尔氏】八方润泽亮肤BB霜80g","shop_price":"46.00","comment_count":0,"ky_type":3},{"goods_id":2218,"cat_id3":345,"goods_sn":"TP0002218","goods_name":"【促销区】【契尔氏】G肽美白精华液素颜面膜10片装","shop_price":"126.00","comment_count":0,"ky_type":3},{"goods_id":2219,"cat_id3":345,"goods_sn":"TP0002219","goods_name":"【促销区】【契尔氏】芭比闺蜜温和卸妆棉正品","shop_price":"36.00","comment_count":0,"ky_type":3},{"goods_id":2220,"cat_id3":345,"goods_sn":"TP0002220","goods_name":"【促销区】【契尔氏】防晒霜喷雾全身男女通用美白100ml","shop_price":"82.00","comment_count":0,"ky_type":3}]
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
         * goods_id : 2211
         * cat_id3 : 365
         * goods_sn : TP0002211
         * goods_name : 【促销区】伙伴之星TPE瑜伽垫002
         * shop_price : 93.00
         * comment_count : 0
         * ky_type : 3
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
