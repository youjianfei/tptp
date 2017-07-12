package com.kymart.shop.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */

public class ShopCarBean {


    /**
     * status : 1
     * msg :
     * result : {"total_price":{"total_fee":0.2,"cut_fee":0.2,"num":2},"storeList":[{"store_id":2,"store_name":"东韩科技(深圳)有限公司","store_logo":null,"is_own_shop":0,"cartList":[{"id":109,"user_id":456,"session_id":"146feab2-0139-4671-afea-751451118580","goods_id":455,"goods_sn":"TP0000455","goods_name":"测试商品，请勿购买不发货不退款","market_price":"0.20","goods_price":"0.10","member_goods_price":"0.10","goods_num":2,"spec_key":"","spec_key_name":"","bar_code":"","selected":1,"add_time":1499845118,"prom_type":0,"prom_id":0,"sku":"","store_id":2,"is_day_bonus":1,"ky_type":0,"goods_fee":0.2,"store_count":87}]}]}
     */

    private int status;
    private String msg;
    private ResultBean result;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * total_price : {"total_fee":0.2,"cut_fee":0.2,"num":2}
         * storeList : [{"store_id":2,"store_name":"东韩科技(深圳)有限公司","store_logo":null,"is_own_shop":0,"cartList":[{"id":109,"user_id":456,"session_id":"146feab2-0139-4671-afea-751451118580","goods_id":455,"goods_sn":"TP0000455","goods_name":"测试商品，请勿购买不发货不退款","market_price":"0.20","goods_price":"0.10","member_goods_price":"0.10","goods_num":2,"spec_key":"","spec_key_name":"","bar_code":"","selected":1,"add_time":1499845118,"prom_type":0,"prom_id":0,"sku":"","store_id":2,"is_day_bonus":1,"ky_type":0,"goods_fee":0.2,"store_count":87}]}]
         */

        private TotalPriceBean total_price;
        private List<StoreListBean> storeList;

        public TotalPriceBean getTotal_price() {
            return total_price;
        }

        public void setTotal_price(TotalPriceBean total_price) {
            this.total_price = total_price;
        }

        public List<StoreListBean> getStoreList() {
            return storeList;
        }

        public void setStoreList(List<StoreListBean> storeList) {
            this.storeList = storeList;
        }

        public static class TotalPriceBean {
            /**
             * total_fee : 0.2
             * cut_fee : 0.2
             * num : 2
             */

            private double total_fee;
            private double cut_fee;
            private int num;

            public double getTotal_fee() {
                return total_fee;
            }

            public void setTotal_fee(double total_fee) {
                this.total_fee = total_fee;
            }

            public double getCut_fee() {
                return cut_fee;
            }

            public void setCut_fee(double cut_fee) {
                this.cut_fee = cut_fee;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }
        }

        public static class StoreListBean {
            /**
             * store_id : 2
             * store_name : 东韩科技(深圳)有限公司
             * store_logo : null
             * is_own_shop : 0
             * cartList : [{"id":109,"user_id":456,"session_id":"146feab2-0139-4671-afea-751451118580","goods_id":455,"goods_sn":"TP0000455","goods_name":"测试商品，请勿购买不发货不退款","market_price":"0.20","goods_price":"0.10","member_goods_price":"0.10","goods_num":2,"spec_key":"","spec_key_name":"","bar_code":"","selected":1,"add_time":1499845118,"prom_type":0,"prom_id":0,"sku":"","store_id":2,"is_day_bonus":1,"ky_type":0,"goods_fee":0.2,"store_count":87}]
             */

            private int store_id;
            private String store_name;
            private Object store_logo;
            private int is_own_shop;
            private List<CartListBean> cartList;

            public int getStore_id() {
                return store_id;
            }

            public void setStore_id(int store_id) {
                this.store_id = store_id;
            }

            public String getStore_name() {
                return store_name;
            }

            public void setStore_name(String store_name) {
                this.store_name = store_name;
            }

            public Object getStore_logo() {
                return store_logo;
            }

            public void setStore_logo(Object store_logo) {
                this.store_logo = store_logo;
            }

            public int getIs_own_shop() {
                return is_own_shop;
            }

            public void setIs_own_shop(int is_own_shop) {
                this.is_own_shop = is_own_shop;
            }

            public List<CartListBean> getCartList() {
                return cartList;
            }

            public void setCartList(List<CartListBean> cartList) {
                this.cartList = cartList;
            }

            public static class CartListBean {
                /**
                 * id : 109
                 * user_id : 456
                 * session_id : 146feab2-0139-4671-afea-751451118580
                 * goods_id : 455
                 * goods_sn : TP0000455
                 * goods_name : 测试商品，请勿购买不发货不退款
                 * market_price : 0.20
                 * goods_price : 0.10
                 * member_goods_price : 0.10
                 * goods_num : 2
                 * spec_key :
                 * spec_key_name :
                 * bar_code :
                 * selected : 1
                 * add_time : 1499845118
                 * prom_type : 0
                 * prom_id : 0
                 * sku :
                 * store_id : 2
                 * is_day_bonus : 1
                 * ky_type : 0
                 * goods_fee : 0.2
                 * store_count : 87
                 */

                private int id;
                private int user_id;
                private String session_id;
                private int goods_id;
                private String goods_sn;
                private String goods_name;
                private String market_price;
                private String goods_price;
                private String member_goods_price;
                private int goods_num;
                private String spec_key;
                private String spec_key_name;
                private String bar_code;
                private int selected;
                private int add_time;
                private int prom_type;
                private int prom_id;
                private String sku;
                private int store_id;
                private int is_day_bonus;
                private int ky_type;
                private double goods_fee;
                private int store_count;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getUser_id() {
                    return user_id;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }

                public String getSession_id() {
                    return session_id;
                }

                public void setSession_id(String session_id) {
                    this.session_id = session_id;
                }

                public int getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(int goods_id) {
                    this.goods_id = goods_id;
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

                public String getMarket_price() {
                    return market_price;
                }

                public void setMarket_price(String market_price) {
                    this.market_price = market_price;
                }

                public String getGoods_price() {
                    return goods_price;
                }

                public void setGoods_price(String goods_price) {
                    this.goods_price = goods_price;
                }

                public String getMember_goods_price() {
                    return member_goods_price;
                }

                public void setMember_goods_price(String member_goods_price) {
                    this.member_goods_price = member_goods_price;
                }

                public int getGoods_num() {
                    return goods_num;
                }

                public void setGoods_num(int goods_num) {
                    this.goods_num = goods_num;
                }

                public String getSpec_key() {
                    return spec_key;
                }

                public void setSpec_key(String spec_key) {
                    this.spec_key = spec_key;
                }

                public String getSpec_key_name() {
                    return spec_key_name;
                }

                public void setSpec_key_name(String spec_key_name) {
                    this.spec_key_name = spec_key_name;
                }

                public String getBar_code() {
                    return bar_code;
                }

                public void setBar_code(String bar_code) {
                    this.bar_code = bar_code;
                }

                public int getSelected() {
                    return selected;
                }

                public void setSelected(int selected) {
                    this.selected = selected;
                }

                public int getAdd_time() {
                    return add_time;
                }

                public void setAdd_time(int add_time) {
                    this.add_time = add_time;
                }

                public int getProm_type() {
                    return prom_type;
                }

                public void setProm_type(int prom_type) {
                    this.prom_type = prom_type;
                }

                public int getProm_id() {
                    return prom_id;
                }

                public void setProm_id(int prom_id) {
                    this.prom_id = prom_id;
                }

                public String getSku() {
                    return sku;
                }

                public void setSku(String sku) {
                    this.sku = sku;
                }

                public int getStore_id() {
                    return store_id;
                }

                public void setStore_id(int store_id) {
                    this.store_id = store_id;
                }

                public int getIs_day_bonus() {
                    return is_day_bonus;
                }

                public void setIs_day_bonus(int is_day_bonus) {
                    this.is_day_bonus = is_day_bonus;
                }

                public int getKy_type() {
                    return ky_type;
                }

                public void setKy_type(int ky_type) {
                    this.ky_type = ky_type;
                }

                public double getGoods_fee() {
                    return goods_fee;
                }

                public void setGoods_fee(double goods_fee) {
                    this.goods_fee = goods_fee;
                }

                public int getStore_count() {
                    return store_count;
                }

                public void setStore_count(int store_count) {
                    this.store_count = store_count;
                }
            }
        }
    }
}
