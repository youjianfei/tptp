package com.kymart.shop.Bean;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

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

        private float postFee;
        private float couponFee;
        private float balance;
        private float pointsFee;
        private float payables;
        private float goodsFee;
        private float order_prom_amount;
        private HashMap store_order_prom_id;
        private HashMap store_order_prom_amount;
        private HashMap store_order_amount;
        private HashMap store_shipping_price;
        private HashMap store_coupon_price;
        private HashMap store_point_count;
        private HashMap store_balance;
        private HashMap store_goods_price;


        public float getPostFee() {
            return postFee;
        }

        public void setPostFee(float postFee) {
            this.postFee = postFee;
        }

        public float getCouponFee() {
            return couponFee;
        }

        public void setCouponFee(float couponFee) {
            this.couponFee = couponFee;
        }

        public float getBalance() {
            return balance;
        }

        public void setBalance(float balance) {
            this.balance = balance;
        }

        public float getPointsFee() {
            return pointsFee;
        }

        public void setPointsFee(float pointsFee) {
            this.pointsFee = pointsFee;
        }

        public float getPayables() {
            return payables;
        }

        public void setPayables(float payables) {
            this.payables = payables;
        }

        public float getGoodsFee() {
            return goodsFee;
        }

        public void setGoodsFee(float goodsFee) {
            this.goodsFee = goodsFee;
        }

        public float getOrder_prom_amount() {
            return order_prom_amount;
        }

        public void setOrder_prom_amount(float order_prom_amount) {
            this.order_prom_amount = order_prom_amount;
        }

        public HashMap getStore_order_prom_id() {
            return store_order_prom_id;
        }

        public void setStore_order_prom_id(HashMap store_order_prom_id) {
            this.store_order_prom_id = store_order_prom_id;
        }

        public HashMap getStore_order_prom_amount() {
            return store_order_prom_amount;
        }

        public void setStore_order_prom_amount(HashMap store_order_prom_amount) {
            this.store_order_prom_amount = store_order_prom_amount;
        }

        public HashMap getStore_order_amount() {
            return store_order_amount;
        }

        public void setStore_order_amount(HashMap store_order_amount) {
            this.store_order_amount = store_order_amount;
        }

        public HashMap getStore_shipping_price() {
            return store_shipping_price;
        }

        public void setStore_shipping_price(HashMap store_shipping_price) {
            this.store_shipping_price = store_shipping_price;
        }

        public HashMap getStore_coupon_price() {
            return store_coupon_price;
        }

        public void setStore_coupon_price(HashMap store_coupon_price) {
            this.store_coupon_price = store_coupon_price;
        }

        public HashMap getStore_point_count() {
            return store_point_count;
        }

        public void setStore_point_count(HashMap store_point_count) {
            this.store_point_count = store_point_count;
        }

        public HashMap getStore_balance() {
            return store_balance;
        }

        public void setStore_balance(HashMap store_balance) {
            this.store_balance = store_balance;
        }

        public HashMap getStore_goods_price() {
            return store_goods_price;
        }

        public void setStore_goods_price(HashMap store_goods_price) {
            this.store_goods_price = store_goods_price;
        }
    }
}
