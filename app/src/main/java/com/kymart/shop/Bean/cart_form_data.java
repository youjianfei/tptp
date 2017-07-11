package com.kymart.shop.Bean;


import java.util.HashMap;

/**
 * Created by Administrator on 2017/7/11.
 */

public class cart_form_data {

    /**
     * shipping_code : {"1":"shufeng","2":"zhongtong"}
     * user_note : {"1":"请给我快点发货","2":"给我发好货"}
     * couponTypeSelect : {"1":1,"2":2}
     * coupon_id : {"1":36}
     * couponCode : {"2":"afe32334"}
     */

    private HashMap shipping_code;
    private HashMap user_note;
    private HashMap couponTypeSelect;
    private HashMap coupon_id;
    private HashMap couponCode;

    public HashMap getShipping_code() {
        return shipping_code;
    }

    public void setShipping_code(HashMap shipping_code) {
        this.shipping_code = shipping_code;
    }

    public HashMap getUser_note() {
        return user_note;
    }

    public void setUser_note(HashMap user_note) {
        this.user_note = user_note;
    }

    public HashMap getCouponTypeSelect() {
        return couponTypeSelect;
    }

    public void setCouponTypeSelect(HashMap couponTypeSelect) {
        this.couponTypeSelect = couponTypeSelect;
    }

    public HashMap getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(HashMap coupon_id) {
        this.coupon_id = coupon_id;
    }

    public HashMap getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(HashMap couponCode) {
        this.couponCode = couponCode;
    }
}
