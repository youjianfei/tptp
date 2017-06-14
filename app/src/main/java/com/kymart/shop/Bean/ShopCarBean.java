package com.kymart.shop.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */

public class ShopCarBean {


    private String msg;
    private ResultEntity result;
    private int status;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public ResultEntity getResult() {
        return result;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ShopCarBean{" +
                "msg='" + msg + '\'' +
                ", result=" + result +
                ", status=" + status +
                '}';
    }

    public class ResultEntity {
        /**
         * total_price : {"cut_fee":-400,"total_fee":1300,"num":3}
         * storeList : [{"store_id":3,"store_logo":"/public/upload/seller/2016/07-28/5799d51cc525b.jpg","store_name":"旺小姐旗舰店","is_own_shop":0,"cartList":[{"store_id":3,"goods_name":"Apple iPhone 6s Plus 16G 玫瑰金 移动联通电信4G手机","spec_key":"13_55","prom_type":0,"goods_price":"500.00","session_id":"5c52c86c-74d6-4bee-a26b-4dd869cfc31a","goods_id":1,"goods_sn":"TP000000","prom_id":0,"member_goods_price":"500.00","user_id":52,"bar_code":"","market_price":"300.00","goods_num":2,"spec_key_name":"内存:16G 颜色:黑色","goods_fee":1000,"id":209,"sku":"","add_time":1497424756,"selected":1,"store_count":100},{"store_id":3,"goods_name":"Apple iPhone 6s Plus 16G 玫瑰金 移动联通电信4G手机","spec_key":"13_100","prom_type":0,"goods_price":"300.00","session_id":"5c52c86c-74d6-4bee-a26b-4dd869cfc31a","goods_id":1,"goods_sn":"TP000000","prom_id":0,"member_goods_price":"300.00","user_id":52,"bar_code":"","market_price":"300.00","goods_num":1,"spec_key_name":"内存:16G 颜色:玫瑰金","goods_fee":300,"id":210,"sku":"","add_time":1497424761,"selected":1,"store_count":100}]}]
         */
        private Total_priceEntity total_price;
        private List<StoreListEntity> storeList;

        public void setTotal_price(Total_priceEntity total_price) {
            this.total_price = total_price;
        }

        public void setStoreList(List<StoreListEntity> storeList) {
            this.storeList = storeList;
        }

        public Total_priceEntity getTotal_price() {
            return total_price;
        }

        public List<StoreListEntity> getStoreList() {
            return storeList;
        }

        @Override
        public String toString() {
            return "ResultEntity{" +
                    "total_price=" + total_price +
                    ", storeList=" + storeList +
                    '}';
        }

        public class Total_priceEntity {
            /**
             * cut_fee : -400
             * total_fee : 1300
             * num : 3
             */
            private int cut_fee;
            private int total_fee;
            private int num;

            public void setCut_fee(int cut_fee) {
                this.cut_fee = cut_fee;
            }

            public void setTotal_fee(int total_fee) {
                this.total_fee = total_fee;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public int getCut_fee() {
                return cut_fee;
            }

            public int getTotal_fee() {
                return total_fee;
            }

            public int getNum() {
                return num;
            }

            @Override
            public String toString() {
                return "Total_priceEntity{" +
                        "cut_fee=" + cut_fee +
                        ", total_fee=" + total_fee +
                        ", num=" + num +
                        '}';
            }
        }

        public class StoreListEntity {
            /**
             * store_id : 3
             * store_logo : /public/upload/seller/2016/07-28/5799d51cc525b.jpg
             * store_name : 旺小姐旗舰店
             * is_own_shop : 0
             * cartList : [{"store_id":3,"goods_name":"Apple iPhone 6s Plus 16G 玫瑰金 移动联通电信4G手机","spec_key":"13_55","prom_type":0,"goods_price":"500.00","session_id":"5c52c86c-74d6-4bee-a26b-4dd869cfc31a","goods_id":1,"goods_sn":"TP000000","prom_id":0,"member_goods_price":"500.00","user_id":52,"bar_code":"","market_price":"300.00","goods_num":2,"spec_key_name":"内存:16G 颜色:黑色","goods_fee":1000,"id":209,"sku":"","add_time":1497424756,"selected":1,"store_count":100},{"store_id":3,"goods_name":"Apple iPhone 6s Plus 16G 玫瑰金 移动联通电信4G手机","spec_key":"13_100","prom_type":0,"goods_price":"300.00","session_id":"5c52c86c-74d6-4bee-a26b-4dd869cfc31a","goods_id":1,"goods_sn":"TP000000","prom_id":0,"member_goods_price":"300.00","user_id":52,"bar_code":"","market_price":"300.00","goods_num":1,"spec_key_name":"内存:16G 颜色:玫瑰金","goods_fee":300,"id":210,"sku":"","add_time":1497424761,"selected":1,"store_count":100}]
             */
            private int store_id;
            private String store_logo;
            private String store_name;
            private int is_own_shop;
            private List<CartListEntity> cartList;

            public void setStore_id(int store_id) {
                this.store_id = store_id;
            }

            public void setStore_logo(String store_logo) {
                this.store_logo = store_logo;
            }

            public void setStore_name(String store_name) {
                this.store_name = store_name;
            }

            public void setIs_own_shop(int is_own_shop) {
                this.is_own_shop = is_own_shop;
            }

            public void setCartList(List<CartListEntity> cartList) {
                this.cartList = cartList;
            }

            public int getStore_id() {
                return store_id;
            }

            public String getStore_logo() {
                return store_logo;
            }

            public String getStore_name() {
                return store_name;
            }

            public int getIs_own_shop() {
                return is_own_shop;
            }

            public List<CartListEntity> getCartList() {
                return cartList;
            }

            @Override
            public String toString() {
                return "StoreListEntity{" +
                        "store_id=" + store_id +
                        ", store_logo='" + store_logo + '\'' +
                        ", store_name='" + store_name + '\'' +
                        ", is_own_shop=" + is_own_shop +
                        ", cartList=" + cartList +
                        '}';
            }

            public class CartListEntity {
                /**
                 * store_id : 3
                 * goods_name : Apple iPhone 6s Plus 16G 玫瑰金 移动联通电信4G手机
                 * spec_key : 13_55
                 * prom_type : 0
                 * goods_price : 500.00
                 * session_id : 5c52c86c-74d6-4bee-a26b-4dd869cfc31a
                 * goods_id : 1
                 * goods_sn : TP000000
                 * prom_id : 0
                 * member_goods_price : 500.00
                 * user_id : 52
                 * bar_code :
                 * market_price : 300.00
                 * goods_num : 2
                 * spec_key_name : 内存:16G 颜色:黑色
                 * goods_fee : 1000
                 * id : 209
                 * sku :
                 * add_time : 1497424756
                 * selected : 1
                 * store_count : 100
                 */
                private int store_id;
                private String goods_name;
                private String spec_key;
                private int prom_type;
                private String goods_price;
                private String session_id;
                private int goods_id;
                private String goods_sn;
                private int prom_id;
                private String member_goods_price;
                private int user_id;
                private String bar_code;
                private String market_price;
                private int goods_num;
                private String spec_key_name;
                private int goods_fee;
                private int id;
                private String sku;
                private int add_time;
                private int selected;
                private int store_count;

                public void setStore_id(int store_id) {
                    this.store_id = store_id;
                }

                public void setGoods_name(String goods_name) {
                    this.goods_name = goods_name;
                }

                public void setSpec_key(String spec_key) {
                    this.spec_key = spec_key;
                }

                public void setProm_type(int prom_type) {
                    this.prom_type = prom_type;
                }

                public void setGoods_price(String goods_price) {
                    this.goods_price = goods_price;
                }

                public void setSession_id(String session_id) {
                    this.session_id = session_id;
                }

                public void setGoods_id(int goods_id) {
                    this.goods_id = goods_id;
                }

                public void setGoods_sn(String goods_sn) {
                    this.goods_sn = goods_sn;
                }

                public void setProm_id(int prom_id) {
                    this.prom_id = prom_id;
                }

                public void setMember_goods_price(String member_goods_price) {
                    this.member_goods_price = member_goods_price;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }

                public void setBar_code(String bar_code) {
                    this.bar_code = bar_code;
                }

                public void setMarket_price(String market_price) {
                    this.market_price = market_price;
                }

                public void setGoods_num(int goods_num) {
                    this.goods_num = goods_num;
                }

                public void setSpec_key_name(String spec_key_name) {
                    this.spec_key_name = spec_key_name;
                }

                public void setGoods_fee(int goods_fee) {
                    this.goods_fee = goods_fee;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public void setSku(String sku) {
                    this.sku = sku;
                }

                public void setAdd_time(int add_time) {
                    this.add_time = add_time;
                }

                public void setSelected(int selected) {
                    this.selected = selected;
                }

                public void setStore_count(int store_count) {
                    this.store_count = store_count;
                }

                public int getStore_id() {
                    return store_id;
                }

                public String getGoods_name() {
                    return goods_name;
                }

                public String getSpec_key() {
                    return spec_key;
                }

                public int getProm_type() {
                    return prom_type;
                }

                public String getGoods_price() {
                    return goods_price;
                }

                public String getSession_id() {
                    return session_id;
                }

                public int getGoods_id() {
                    return goods_id;
                }

                public String getGoods_sn() {
                    return goods_sn;
                }

                public int getProm_id() {
                    return prom_id;
                }

                public String getMember_goods_price() {
                    return member_goods_price;
                }

                public int getUser_id() {
                    return user_id;
                }

                public String getBar_code() {
                    return bar_code;
                }

                public String getMarket_price() {
                    return market_price;
                }

                public int getGoods_num() {
                    return goods_num;
                }

                public String getSpec_key_name() {
                    return spec_key_name;
                }

                public int getGoods_fee() {
                    return goods_fee;
                }

                public int getId() {
                    return id;
                }

                public String getSku() {
                    return sku;
                }

                public int getAdd_time() {
                    return add_time;
                }

                public int getSelected() {
                    return selected;
                }

                public int getStore_count() {
                    return store_count;
                }

                @Override
                public String toString() {
                    return "CartListEntity{" +
                            "store_id=" + store_id +
                            ", goods_name='" + goods_name + '\'' +
                            ", spec_key='" + spec_key + '\'' +
                            ", prom_type=" + prom_type +
                            ", goods_price='" + goods_price + '\'' +
                            ", session_id='" + session_id + '\'' +
                            ", goods_id=" + goods_id +
                            ", goods_sn='" + goods_sn + '\'' +
                            ", prom_id=" + prom_id +
                            ", member_goods_price='" + member_goods_price + '\'' +
                            ", user_id=" + user_id +
                            ", bar_code='" + bar_code + '\'' +
                            ", market_price='" + market_price + '\'' +
                            ", goods_num=" + goods_num +
                            ", spec_key_name='" + spec_key_name + '\'' +
                            ", goods_fee=" + goods_fee +
                            ", id=" + id +
                            ", sku='" + sku + '\'' +
                            ", add_time=" + add_time +
                            ", selected=" + selected +
                            ", store_count=" + store_count +
                            '}';
                }
            }
        }
    }
}
