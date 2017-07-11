package com.kymart.shop.Bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/11.
 */

public class OrderPriceBean {


    /**
     * status : 1
     * msg : 计算成功
     * result : {"postFee":0,"couponFee":0,"balance":0,"pointsFee":0,"payables":3909,"goodsFee":3909,"order_prom_amount":0,"store_order_prom_id":{"4":0,"2":0},"store_order_prom_amount":{"4":0,"2":0},"store_order_amount":{"4":511,"2":3398},"store_shipping_price":{"4":0,"2":0},"store_coupon_price":null,"store_point_count":null,"store_balance":null,"store_goods_price":{"4":511,"2":3398}}
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
         * postFee : 0
         * couponFee : 0
         * balance : 0
         * pointsFee : 0
         * payables : 3909
         * goodsFee : 3909
         * order_prom_amount : 0
         * store_order_prom_id : {"4":0,"2":0}
         * store_order_prom_amount : {"4":0,"2":0}
         * store_order_amount : {"4":511,"2":3398}
         * store_shipping_price : {"4":0,"2":0}
         * store_coupon_price : null
         * store_point_count : null
         * store_balance : null
         * store_goods_price : {"4":511,"2":3398}
         */

        private int postFee;
        private int couponFee;
        private int balance;
        private int pointsFee;
        private int payables;
        private int goodsFee;
        private int order_prom_amount;
        private StoreOrderPromIdBean store_order_prom_id;
        private StoreOrderPromAmountBean store_order_prom_amount;
        private StoreOrderAmountBean store_order_amount;
        private StoreShippingPriceBean store_shipping_price;
        private Object store_coupon_price;
        private Object store_point_count;
        private Object store_balance;
        private StoreGoodsPriceBean store_goods_price;

        public int getPostFee() {
            return postFee;
        }

        public void setPostFee(int postFee) {
            this.postFee = postFee;
        }

        public int getCouponFee() {
            return couponFee;
        }

        public void setCouponFee(int couponFee) {
            this.couponFee = couponFee;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public int getPointsFee() {
            return pointsFee;
        }

        public void setPointsFee(int pointsFee) {
            this.pointsFee = pointsFee;
        }

        public int getPayables() {
            return payables;
        }

        public void setPayables(int payables) {
            this.payables = payables;
        }

        public int getGoodsFee() {
            return goodsFee;
        }

        public void setGoodsFee(int goodsFee) {
            this.goodsFee = goodsFee;
        }

        public int getOrder_prom_amount() {
            return order_prom_amount;
        }

        public void setOrder_prom_amount(int order_prom_amount) {
            this.order_prom_amount = order_prom_amount;
        }

        public StoreOrderPromIdBean getStore_order_prom_id() {
            return store_order_prom_id;
        }

        public void setStore_order_prom_id(StoreOrderPromIdBean store_order_prom_id) {
            this.store_order_prom_id = store_order_prom_id;
        }

        public StoreOrderPromAmountBean getStore_order_prom_amount() {
            return store_order_prom_amount;
        }

        public void setStore_order_prom_amount(StoreOrderPromAmountBean store_order_prom_amount) {
            this.store_order_prom_amount = store_order_prom_amount;
        }

        public StoreOrderAmountBean getStore_order_amount() {
            return store_order_amount;
        }

        public void setStore_order_amount(StoreOrderAmountBean store_order_amount) {
            this.store_order_amount = store_order_amount;
        }

        public StoreShippingPriceBean getStore_shipping_price() {
            return store_shipping_price;
        }

        public void setStore_shipping_price(StoreShippingPriceBean store_shipping_price) {
            this.store_shipping_price = store_shipping_price;
        }

        public Object getStore_coupon_price() {
            return store_coupon_price;
        }

        public void setStore_coupon_price(Object store_coupon_price) {
            this.store_coupon_price = store_coupon_price;
        }

        public Object getStore_point_count() {
            return store_point_count;
        }

        public void setStore_point_count(Object store_point_count) {
            this.store_point_count = store_point_count;
        }

        public Object getStore_balance() {
            return store_balance;
        }

        public void setStore_balance(Object store_balance) {
            this.store_balance = store_balance;
        }

        public StoreGoodsPriceBean getStore_goods_price() {
            return store_goods_price;
        }

        public void setStore_goods_price(StoreGoodsPriceBean store_goods_price) {
            this.store_goods_price = store_goods_price;
        }

        public static class StoreOrderPromIdBean {
            /**
             * 4 : 0
             * 2 : 0
             */

            @SerializedName("4")
            private int _$4;
            @SerializedName("2")
            private int _$2;

            public int get_$4() {
                return _$4;
            }

            public void set_$4(int _$4) {
                this._$4 = _$4;
            }

            public int get_$2() {
                return _$2;
            }

            public void set_$2(int _$2) {
                this._$2 = _$2;
            }
        }

        public static class StoreOrderPromAmountBean {
            /**
             * 4 : 0
             * 2 : 0
             */

            @SerializedName("4")
            private int _$4;
            @SerializedName("2")
            private int _$2;

            public int get_$4() {
                return _$4;
            }

            public void set_$4(int _$4) {
                this._$4 = _$4;
            }

            public int get_$2() {
                return _$2;
            }

            public void set_$2(int _$2) {
                this._$2 = _$2;
            }
        }

        public static class StoreOrderAmountBean {
            /**
             * 4 : 511
             * 2 : 3398
             */

            @SerializedName("4")
            private int _$4;
            @SerializedName("2")
            private int _$2;

            public int get_$4() {
                return _$4;
            }

            public void set_$4(int _$4) {
                this._$4 = _$4;
            }

            public int get_$2() {
                return _$2;
            }

            public void set_$2(int _$2) {
                this._$2 = _$2;
            }
        }

        public static class StoreShippingPriceBean {
            /**
             * 4 : 0
             * 2 : 0
             */

            @SerializedName("4")
            private int _$4;
            @SerializedName("2")
            private int _$2;

            public int get_$4() {
                return _$4;
            }

            public void set_$4(int _$4) {
                this._$4 = _$4;
            }

            public int get_$2() {
                return _$2;
            }

            public void set_$2(int _$2) {
                this._$2 = _$2;
            }
        }

        public static class StoreGoodsPriceBean {
            /**
             * 4 : 511
             * 2 : 3398
             */

            @SerializedName("4")
            private int _$4;
            @SerializedName("2")
            private int _$2;

            public int get_$4() {
                return _$4;
            }

            public void set_$4(int _$4) {
                this._$4 = _$4;
            }

            public int get_$2() {
                return _$2;
            }

            public void set_$2(int _$2) {
                this._$2 = _$2;
            }
        }
    }
}
