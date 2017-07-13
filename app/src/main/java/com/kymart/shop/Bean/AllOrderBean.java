package com.kymart.shop.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/13.
 */

public class AllOrderBean {

    /**
     * status : 1
     * msg : 获取成功
     * result : [{"order_id":403,"order_sn":"201707131105512949","master_order_sn":"201707131105518110","user_id":49,"order_status":0,"shipping_status":0,"pay_status":0,"consignee":"兔兔","country":0,"province":3102,"city":3597,"district":3642,"twon":3648,"address":"具体","zipcode":"455955","mobile":"18539963645","email":"","shipping_code":"ems","shipping_name":"EMS","pay_code":"","pay_name":"","invoice_title":"","goods_price":"11.00","shipping_price":"0.00","user_money":"0.00","coupon_price":null,"integral":0,"integral_money":"0.00","order_amount":"11.00","total_amount":"11.00","add_time":1499915151,"confirm_time":0,"pay_time":0,"transaction_id":null,"shipping_time":0,"order_prom_id":0,"order_prom_type":0,"order_prom_amount":"0.00","discount":"0.00","user_note":"","admin_note":"","parent_sn":null,"store_id":4,"is_comment":0,"deleted":0,"order_statis_id":0,"order_status_code":"WAITPAY","order_status_desc":"待支付","pay_btn":1,"cancel_btn":1,"receive_btn":0,"comment_btn":0,"shipping_btn":0,"return_btn":0,"goods_list":[{"rec_id":508,"order_id":403,"goods_id":169,"goods_name":"vvvvvv","goods_sn":"TP0000169","goods_num":1,"market_price":"1.00","goods_price":"11.00","cost_price":"1.00","member_goods_price":"11.00","give_integral":0,"spec_key":"165_167","spec_key_name":"容量:6公斤 样式:侧开门","bar_code":"","is_comment":0,"prom_type":0,"prom_id":0,"is_send":0,"delivery_id":0,"sku":"11.00","store_id":4,"commission":13,"is_checkout":0,"deleted":0,"distribut":"0.00","original_img":"/public/upload/goods/2017/06-07/8261bdcfcb50ca22a1ebaac3205f99d9.jpg"}],"store_name":"q","store_logo":null},{"order_id":402,"order_sn":"201707131103388501","master_order_sn":"201707131103387161","user_id":49,"order_status":0,"shipping_status":0,"pay_status":0,"consignee":"兔兔","country":0,"province":3102,"city":3597,"district":3642,"twon":3648,"address":"具体","zipcode":"455955","mobile":"18539963645","email":"","shipping_code":"ems","shipping_name":"EMS","pay_code":"","pay_name":"","invoice_title":"","goods_price":"11.00","shipping_price":"0.00","user_money":"0.00","coupon_price":null,"integral":0,"integral_money":"0.00","order_amount":"11.00","total_amount":"11.00","add_time":1499915018,"confirm_time":0,"pay_time":0,"transaction_id":null,"shipping_time":0,"order_prom_id":0,"order_prom_type":0,"order_prom_amount":"0.00","discount":"0.00","user_note":"","admin_note":"","parent_sn":null,"store_id":4,"is_comment":0,"deleted":0,"order_statis_id":0,"order_status_code":"WAITPAY","order_status_desc":"待支付","pay_btn":1,"cancel_btn":1,"receive_btn":0,"comment_btn":0,"shipping_btn":0,"return_btn":0,"goods_list":[{"rec_id":507,"order_id":402,"goods_id":169,"goods_name":"vvvvvv","goods_sn":"TP0000169","goods_num":1,"market_price":"1.00","goods_price":"11.00","cost_price":"1.00","member_goods_price":"11.00","give_integral":0,"spec_key":"165_167","spec_key_name":"容量:6公斤 样式:侧开门","bar_code":"","is_comment":0,"prom_type":0,"prom_id":0,"is_send":0,"delivery_id":0,"sku":"11.00","store_id":4,"commission":13,"is_checkout":0,"deleted":0,"distribut":"0.00","original_img":"/public/upload/goods/2017/06-07/8261bdcfcb50ca22a1ebaac3205f99d9.jpg"}],"store_name":"q","store_logo":null},{"order_id":401,"order_sn":"201707131058529659","master_order_sn":"201707131058528356","user_id":49,"order_status":0,"shipping_status":0,"pay_status":0,"consignee":"兔兔","country":0,"province":3102,"city":3597,"district":3642,"twon":3648,"address":"具体","zipcode":"455955","mobile":"18539963645","email":"","shipping_code":"shentong","shipping_name":"申通物流","pay_code":"","pay_name":"","invoice_title":"","goods_price":"300.00","shipping_price":"20.00","user_money":"0.00","coupon_price":null,"integral":0,"integral_money":"0.00","order_amount":"320.00","total_amount":"320.00","add_time":1499914732,"confirm_time":0,"pay_time":0,"transaction_id":null,"shipping_time":0,"order_prom_id":0,"order_prom_type":0,"order_prom_amount":"0.00","discount":"0.00","user_note":"","admin_note":"","parent_sn":null,"store_id":3,"is_comment":0,"deleted":0,"order_statis_id":0,"order_status_code":"WAITPAY","order_status_desc":"待支付","pay_btn":1,"cancel_btn":1,"receive_btn":0,"comment_btn":0,"shipping_btn":0,"return_btn":0,"goods_list":[{"rec_id":506,"order_id":401,"goods_id":1,"goods_name":"Apple iPhone 6s Plus 16G 玫瑰金 移动联通电信4G手机","goods_sn":"TP000000","goods_num":1,"market_price":"300.00","goods_price":"300.00","cost_price":"0.00","member_goods_price":"300.00","give_integral":0,"spec_key":"13_100","spec_key_name":"内存:16G 颜色:玫瑰金","bar_code":"","is_comment":0,"prom_type":0,"prom_id":0,"is_send":0,"delivery_id":0,"sku":"0.00","store_id":3,"commission":0,"is_checkout":0,"deleted":0,"distribut":"0.00","original_img":"/public/upload/goods/2016/03-09/56e01a4088d3b.jpg"}]}]
     */

    private int status;
    private String msg;
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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * order_id : 403
         * order_sn : 201707131105512949
         * master_order_sn : 201707131105518110
         * user_id : 49
         * order_status : 0
         * shipping_status : 0
         * pay_status : 0
         * consignee : 兔兔
         * country : 0
         * province : 3102
         * city : 3597
         * district : 3642
         * twon : 3648
         * address : 具体
         * zipcode : 455955
         * mobile : 18539963645
         * email :
         * shipping_code : ems
         * shipping_name : EMS
         * pay_code :
         * pay_name :
         * invoice_title :
         * goods_price : 11.00
         * shipping_price : 0.00
         * user_money : 0.00
         * coupon_price : null
         * integral : 0
         * integral_money : 0.00
         * order_amount : 11.00
         * total_amount : 11.00
         * add_time : 1499915151
         * confirm_time : 0
         * pay_time : 0
         * transaction_id : null
         * shipping_time : 0
         * order_prom_id : 0
         * order_prom_type : 0
         * order_prom_amount : 0.00
         * discount : 0.00
         * user_note :
         * admin_note :
         * parent_sn : null
         * store_id : 4
         * is_comment : 0
         * deleted : 0
         * order_statis_id : 0
         * order_status_code : WAITPAY
         * order_status_desc : 待支付
         * pay_btn : 1
         * cancel_btn : 1
         * receive_btn : 0
         * comment_btn : 0
         * shipping_btn : 0
         * return_btn : 0
         * goods_list : [{"rec_id":508,"order_id":403,"goods_id":169,"goods_name":"vvvvvv","goods_sn":"TP0000169","goods_num":1,"market_price":"1.00","goods_price":"11.00","cost_price":"1.00","member_goods_price":"11.00","give_integral":0,"spec_key":"165_167","spec_key_name":"容量:6公斤 样式:侧开门","bar_code":"","is_comment":0,"prom_type":0,"prom_id":0,"is_send":0,"delivery_id":0,"sku":"11.00","store_id":4,"commission":13,"is_checkout":0,"deleted":0,"distribut":"0.00","original_img":"/public/upload/goods/2017/06-07/8261bdcfcb50ca22a1ebaac3205f99d9.jpg"}]
         * store_name : q
         * store_logo : null
         */

        private int order_id;
        private String order_sn;
        private String master_order_sn;
        private int user_id;
        private int order_status;
        private int shipping_status;
        private int pay_status;
        private String consignee;
        private int country;
        private int province;
        private int city;
        private int district;
        private int twon;
        private String address;
        private String zipcode;
        private String mobile;
        private String email;
        private String shipping_code;
        private String shipping_name;
        private String pay_code;
        private String pay_name;
        private String invoice_title;
        private String goods_price;
        private String shipping_price;
        private String user_money;
        private Object coupon_price;
        private int integral;
        private String integral_money;
        private String order_amount;
        private String total_amount;
        private int add_time;
        private int confirm_time;
        private int pay_time;
        private Object transaction_id;
        private int shipping_time;
        private int order_prom_id;
        private int order_prom_type;
        private String order_prom_amount;
        private String discount;
        private String user_note;
        private String admin_note;
        private Object parent_sn;
        private int store_id;
        private int is_comment;
        private int deleted;
        private int order_statis_id;
        private String order_status_code;
        private String order_status_desc;
        private int pay_btn;
        private int cancel_btn;
        private int receive_btn;
        private int comment_btn;
        private int shipping_btn;
        private int return_btn;
        private String store_name;
        private Object store_logo;
        private List<GoodsListBean> goods_list;

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public String getOrder_sn() {
            return order_sn;
        }

        public void setOrder_sn(String order_sn) {
            this.order_sn = order_sn;
        }

        public String getMaster_order_sn() {
            return master_order_sn;
        }

        public void setMaster_order_sn(String master_order_sn) {
            this.master_order_sn = master_order_sn;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getOrder_status() {
            return order_status;
        }

        public void setOrder_status(int order_status) {
            this.order_status = order_status;
        }

        public int getShipping_status() {
            return shipping_status;
        }

        public void setShipping_status(int shipping_status) {
            this.shipping_status = shipping_status;
        }

        public int getPay_status() {
            return pay_status;
        }

        public void setPay_status(int pay_status) {
            this.pay_status = pay_status;
        }

        public String getConsignee() {
            return consignee;
        }

        public void setConsignee(String consignee) {
            this.consignee = consignee;
        }

        public int getCountry() {
            return country;
        }

        public void setCountry(int country) {
            this.country = country;
        }

        public int getProvince() {
            return province;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public int getDistrict() {
            return district;
        }

        public void setDistrict(int district) {
            this.district = district;
        }

        public int getTwon() {
            return twon;
        }

        public void setTwon(int twon) {
            this.twon = twon;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getShipping_code() {
            return shipping_code;
        }

        public void setShipping_code(String shipping_code) {
            this.shipping_code = shipping_code;
        }

        public String getShipping_name() {
            return shipping_name;
        }

        public void setShipping_name(String shipping_name) {
            this.shipping_name = shipping_name;
        }

        public String getPay_code() {
            return pay_code;
        }

        public void setPay_code(String pay_code) {
            this.pay_code = pay_code;
        }

        public String getPay_name() {
            return pay_name;
        }

        public void setPay_name(String pay_name) {
            this.pay_name = pay_name;
        }

        public String getInvoice_title() {
            return invoice_title;
        }

        public void setInvoice_title(String invoice_title) {
            this.invoice_title = invoice_title;
        }

        public String getGoods_price() {
            return goods_price;
        }

        public void setGoods_price(String goods_price) {
            this.goods_price = goods_price;
        }

        public String getShipping_price() {
            return shipping_price;
        }

        public void setShipping_price(String shipping_price) {
            this.shipping_price = shipping_price;
        }

        public String getUser_money() {
            return user_money;
        }

        public void setUser_money(String user_money) {
            this.user_money = user_money;
        }

        public Object getCoupon_price() {
            return coupon_price;
        }

        public void setCoupon_price(Object coupon_price) {
            this.coupon_price = coupon_price;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public String getIntegral_money() {
            return integral_money;
        }

        public void setIntegral_money(String integral_money) {
            this.integral_money = integral_money;
        }

        public String getOrder_amount() {
            return order_amount;
        }

        public void setOrder_amount(String order_amount) {
            this.order_amount = order_amount;
        }

        public String getTotal_amount() {
            return total_amount;
        }

        public void setTotal_amount(String total_amount) {
            this.total_amount = total_amount;
        }

        public int getAdd_time() {
            return add_time;
        }

        public void setAdd_time(int add_time) {
            this.add_time = add_time;
        }

        public int getConfirm_time() {
            return confirm_time;
        }

        public void setConfirm_time(int confirm_time) {
            this.confirm_time = confirm_time;
        }

        public int getPay_time() {
            return pay_time;
        }

        public void setPay_time(int pay_time) {
            this.pay_time = pay_time;
        }

        public Object getTransaction_id() {
            return transaction_id;
        }

        public void setTransaction_id(Object transaction_id) {
            this.transaction_id = transaction_id;
        }

        public int getShipping_time() {
            return shipping_time;
        }

        public void setShipping_time(int shipping_time) {
            this.shipping_time = shipping_time;
        }

        public int getOrder_prom_id() {
            return order_prom_id;
        }

        public void setOrder_prom_id(int order_prom_id) {
            this.order_prom_id = order_prom_id;
        }

        public int getOrder_prom_type() {
            return order_prom_type;
        }

        public void setOrder_prom_type(int order_prom_type) {
            this.order_prom_type = order_prom_type;
        }

        public String getOrder_prom_amount() {
            return order_prom_amount;
        }

        public void setOrder_prom_amount(String order_prom_amount) {
            this.order_prom_amount = order_prom_amount;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getUser_note() {
            return user_note;
        }

        public void setUser_note(String user_note) {
            this.user_note = user_note;
        }

        public String getAdmin_note() {
            return admin_note;
        }

        public void setAdmin_note(String admin_note) {
            this.admin_note = admin_note;
        }

        public Object getParent_sn() {
            return parent_sn;
        }

        public void setParent_sn(Object parent_sn) {
            this.parent_sn = parent_sn;
        }

        public int getStore_id() {
            return store_id;
        }

        public void setStore_id(int store_id) {
            this.store_id = store_id;
        }

        public int getIs_comment() {
            return is_comment;
        }

        public void setIs_comment(int is_comment) {
            this.is_comment = is_comment;
        }

        public int getDeleted() {
            return deleted;
        }

        public void setDeleted(int deleted) {
            this.deleted = deleted;
        }

        public int getOrder_statis_id() {
            return order_statis_id;
        }

        public void setOrder_statis_id(int order_statis_id) {
            this.order_statis_id = order_statis_id;
        }

        public String getOrder_status_code() {
            return order_status_code;
        }

        public void setOrder_status_code(String order_status_code) {
            this.order_status_code = order_status_code;
        }

        public String getOrder_status_desc() {
            return order_status_desc;
        }

        public void setOrder_status_desc(String order_status_desc) {
            this.order_status_desc = order_status_desc;
        }

        public int getPay_btn() {
            return pay_btn;
        }

        public void setPay_btn(int pay_btn) {
            this.pay_btn = pay_btn;
        }

        public int getCancel_btn() {
            return cancel_btn;
        }

        public void setCancel_btn(int cancel_btn) {
            this.cancel_btn = cancel_btn;
        }

        public int getReceive_btn() {
            return receive_btn;
        }

        public void setReceive_btn(int receive_btn) {
            this.receive_btn = receive_btn;
        }

        public int getComment_btn() {
            return comment_btn;
        }

        public void setComment_btn(int comment_btn) {
            this.comment_btn = comment_btn;
        }

        public int getShipping_btn() {
            return shipping_btn;
        }

        public void setShipping_btn(int shipping_btn) {
            this.shipping_btn = shipping_btn;
        }

        public int getReturn_btn() {
            return return_btn;
        }

        public void setReturn_btn(int return_btn) {
            this.return_btn = return_btn;
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

        public List<GoodsListBean> getGoods_list() {
            return goods_list;
        }

        public void setGoods_list(List<GoodsListBean> goods_list) {
            this.goods_list = goods_list;
        }

        public static class GoodsListBean {
            /**
             * rec_id : 508
             * order_id : 403
             * goods_id : 169
             * goods_name : vvvvvv
             * goods_sn : TP0000169
             * goods_num : 1
             * market_price : 1.00
             * goods_price : 11.00
             * cost_price : 1.00
             * member_goods_price : 11.00
             * give_integral : 0
             * spec_key : 165_167
             * spec_key_name : 容量:6公斤 样式:侧开门
             * bar_code :
             * is_comment : 0
             * prom_type : 0
             * prom_id : 0
             * is_send : 0
             * delivery_id : 0
             * sku : 11.00
             * store_id : 4
             * commission : 13
             * is_checkout : 0
             * deleted : 0
             * distribut : 0.00
             * original_img : /public/upload/goods/2017/06-07/8261bdcfcb50ca22a1ebaac3205f99d9.jpg
             */

            private int rec_id;
            private int order_id;
            private int goods_id;
            private String goods_name;
            private String goods_sn;
            private int goods_num;
            private String market_price;
            private String goods_price;
            private String cost_price;
            private String member_goods_price;
            private int give_integral;
            private String spec_key;
            private String spec_key_name;
            private String bar_code;
            private int is_comment;
            private int prom_type;
            private int prom_id;
            private int is_send;
            private int delivery_id;
            private String sku;
            private int store_id;
            private int commission;
            private int is_checkout;
            private int deleted;
            private String distribut;
            private String original_img;

            public int getRec_id() {
                return rec_id;
            }

            public void setRec_id(int rec_id) {
                this.rec_id = rec_id;
            }

            public int getOrder_id() {
                return order_id;
            }

            public void setOrder_id(int order_id) {
                this.order_id = order_id;
            }

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_sn() {
                return goods_sn;
            }

            public void setGoods_sn(String goods_sn) {
                this.goods_sn = goods_sn;
            }

            public int getGoods_num() {
                return goods_num;
            }

            public void setGoods_num(int goods_num) {
                this.goods_num = goods_num;
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

            public String getCost_price() {
                return cost_price;
            }

            public void setCost_price(String cost_price) {
                this.cost_price = cost_price;
            }

            public String getMember_goods_price() {
                return member_goods_price;
            }

            public void setMember_goods_price(String member_goods_price) {
                this.member_goods_price = member_goods_price;
            }

            public int getGive_integral() {
                return give_integral;
            }

            public void setGive_integral(int give_integral) {
                this.give_integral = give_integral;
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

            public int getIs_comment() {
                return is_comment;
            }

            public void setIs_comment(int is_comment) {
                this.is_comment = is_comment;
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

            public int getIs_send() {
                return is_send;
            }

            public void setIs_send(int is_send) {
                this.is_send = is_send;
            }

            public int getDelivery_id() {
                return delivery_id;
            }

            public void setDelivery_id(int delivery_id) {
                this.delivery_id = delivery_id;
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

            public int getCommission() {
                return commission;
            }

            public void setCommission(int commission) {
                this.commission = commission;
            }

            public int getIs_checkout() {
                return is_checkout;
            }

            public void setIs_checkout(int is_checkout) {
                this.is_checkout = is_checkout;
            }

            public int getDeleted() {
                return deleted;
            }

            public void setDeleted(int deleted) {
                this.deleted = deleted;
            }

            public String getDistribut() {
                return distribut;
            }

            public void setDistribut(String distribut) {
                this.distribut = distribut;
            }

            public String getOriginal_img() {
                return original_img;
            }

            public void setOriginal_img(String original_img) {
                this.original_img = original_img;
            }
        }
    }
}
