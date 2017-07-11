package com.kymart.shop.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/11.
 */

public class OrderBean {

    /**
     * status : 1
     * msg : 获取成功
     * result : {"addressList":{"address_id":38,"user_id":47,"consignee":"123","email":"","country":0,"province":1,"city":2,"district":3,"twon":4,"address":"13123133","zipcode":"212122","mobile":"18338220350","is_default":1},"totalPrice":{"total_fee":3909,"cut_fee":340,"num":8},"userInfo":{"user_id":47,"email":"","password":"519475228fe35ad067744465c42a19b2","sex":0,"birthday":0,"user_money":"2879.07","frozen_money":"0.00","distribut_money":"0.00","pay_points":0,"paypwd":"519475228fe35ad067744465c42a19b2","reg_time":1496569650,"last_login":1499740802,"last_ip":"","qq":"","mobile":"13653839640","mobile_validated":1,"oauth":"","openid":null,"unionid":null,"head_pic":null,"bank_name":"建行","bank_card":"44444","realname":"bb","idcard":null,"email_validated":0,"nickname":"13653839640","level":1,"discount":"1.00","total_amount":"7573.00","is_lock":0,"is_distribut":1,"first_leader":0,"second_leader":0,"third_leader":0,"token":"89d102485fc988749b65713ad9d182e7","underling_number":0,"message_mask":53,"push_id":"","ref_id":1,"bonus":"2988.00","total_bonus1":"121.72","total_bonus":"121.72","total_sell":"449.00","lft":2,"rgt":2,"deep":0,"operator_status":0,"sell_status":1},"storeList":[{"store_id":4,"store_name":"q","coupon_num":0,"shippingList":[{"shipping_area_id":52,"shipping_code":"ems","store_id":4,"name":"EMS","freight":0},{"shipping_area_id":58,"shipping_code":"huitong","store_id":4,"name":"百世汇通快递","freight":0},{"shipping_area_id":51,"shipping_code":"shentong","store_id":4,"name":"申通物流","freight":0},{"shipping_area_id":53,"shipping_code":"shunfeng","store_id":4,"name":"顺丰物流","freight":0},{"shipping_area_id":54,"shipping_code":"yuantong","store_id":4,"name":"圆通快递","freight":0}],"cartList":[{"id":30,"user_id":47,"session_id":"3843A7144E6540E2A4BCD6E2CA3A6AFA","goods_id":162,"goods_sn":"TP0000162","goods_name":"直接上架","market_price":"130.00","goods_price":"100.00","member_goods_price":"100.00","goods_num":5,"spec_key":"","spec_key_name":"","bar_code":"","selected":1,"add_time":1499675687,"prom_type":0,"prom_id":0,"sku":"","store_id":4,"goods_fee":500,"store_count":91},{"id":31,"user_id":47,"session_id":"3843A7144E6540E2A4BCD6E2CA3A6AFA","goods_id":169,"goods_sn":"TP0000169","goods_name":"vvvvvv","market_price":"1.00","goods_price":"11.00","member_goods_price":"11.00","goods_num":1,"spec_key":"165_167","spec_key_name":"容量:6公斤 样式:侧开门","bar_code":"","selected":1,"add_time":1499675907,"prom_type":0,"prom_id":0,"sku":"11.00","store_id":4,"goods_fee":11,"store_count":10}]},{"store_id":2,"store_name":"海澜之家","coupon_num":0,"shippingList":[{"shipping_area_id":45,"shipping_code":"shentong","store_id":2,"name":"申通物流","freight":0},{"shipping_area_id":48,"shipping_code":"shunfeng","store_id":2,"name":"顺丰物流","freight":0}],"cartList":[{"id":32,"user_id":47,"session_id":"3843A7144E6540E2A4BCD6E2CA3A6AFA","goods_id":143,"goods_sn":"TP0000143","goods_name":"haier海尔 BC-93TMPF 93升单门冰箱","market_price":"799.00","goods_price":"699.00","member_goods_price":"699.00","goods_num":1,"spec_key":"","spec_key_name":"","bar_code":"","selected":1,"add_time":1499675913,"prom_type":0,"prom_id":0,"sku":"","store_id":2,"goods_fee":699,"store_count":99},{"id":33,"user_id":47,"session_id":"3843A7144E6540E2A4BCD6E2CA3A6AFA","goods_id":142,"goods_sn":"TP0000142","goods_name":"海尔（Haier）BCD-251WDGW 251升 无霜两门冰箱（白色）","market_price":"2799.00","goods_price":"2699.00","member_goods_price":"2699.00","goods_num":1,"spec_key":"","spec_key_name":"","bar_code":"","selected":1,"add_time":1499675916,"prom_type":0,"prom_id":0,"sku":"","store_id":2,"goods_fee":2699,"store_count":97}]}]}
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
         * addressList : {"address_id":38,"user_id":47,"consignee":"123","email":"","country":0,"province":1,"city":2,"district":3,"twon":4,"address":"13123133","zipcode":"212122","mobile":"18338220350","is_default":1}
         * totalPrice : {"total_fee":3909,"cut_fee":340,"num":8}
         * userInfo : {"user_id":47,"email":"","password":"519475228fe35ad067744465c42a19b2","sex":0,"birthday":0,"user_money":"2879.07","frozen_money":"0.00","distribut_money":"0.00","pay_points":0,"paypwd":"519475228fe35ad067744465c42a19b2","reg_time":1496569650,"last_login":1499740802,"last_ip":"","qq":"","mobile":"13653839640","mobile_validated":1,"oauth":"","openid":null,"unionid":null,"head_pic":null,"bank_name":"建行","bank_card":"44444","realname":"bb","idcard":null,"email_validated":0,"nickname":"13653839640","level":1,"discount":"1.00","total_amount":"7573.00","is_lock":0,"is_distribut":1,"first_leader":0,"second_leader":0,"third_leader":0,"token":"89d102485fc988749b65713ad9d182e7","underling_number":0,"message_mask":53,"push_id":"","ref_id":1,"bonus":"2988.00","total_bonus1":"121.72","total_bonus":"121.72","total_sell":"449.00","lft":2,"rgt":2,"deep":0,"operator_status":0,"sell_status":1}
         * storeList : [{"store_id":4,"store_name":"q","coupon_num":0,"shippingList":[{"shipping_area_id":52,"shipping_code":"ems","store_id":4,"name":"EMS","freight":0},{"shipping_area_id":58,"shipping_code":"huitong","store_id":4,"name":"百世汇通快递","freight":0},{"shipping_area_id":51,"shipping_code":"shentong","store_id":4,"name":"申通物流","freight":0},{"shipping_area_id":53,"shipping_code":"shunfeng","store_id":4,"name":"顺丰物流","freight":0},{"shipping_area_id":54,"shipping_code":"yuantong","store_id":4,"name":"圆通快递","freight":0}],"cartList":[{"id":30,"user_id":47,"session_id":"3843A7144E6540E2A4BCD6E2CA3A6AFA","goods_id":162,"goods_sn":"TP0000162","goods_name":"直接上架","market_price":"130.00","goods_price":"100.00","member_goods_price":"100.00","goods_num":5,"spec_key":"","spec_key_name":"","bar_code":"","selected":1,"add_time":1499675687,"prom_type":0,"prom_id":0,"sku":"","store_id":4,"goods_fee":500,"store_count":91},{"id":31,"user_id":47,"session_id":"3843A7144E6540E2A4BCD6E2CA3A6AFA","goods_id":169,"goods_sn":"TP0000169","goods_name":"vvvvvv","market_price":"1.00","goods_price":"11.00","member_goods_price":"11.00","goods_num":1,"spec_key":"165_167","spec_key_name":"容量:6公斤 样式:侧开门","bar_code":"","selected":1,"add_time":1499675907,"prom_type":0,"prom_id":0,"sku":"11.00","store_id":4,"goods_fee":11,"store_count":10}]},{"store_id":2,"store_name":"海澜之家","coupon_num":0,"shippingList":[{"shipping_area_id":45,"shipping_code":"shentong","store_id":2,"name":"申通物流","freight":0},{"shipping_area_id":48,"shipping_code":"shunfeng","store_id":2,"name":"顺丰物流","freight":0}],"cartList":[{"id":32,"user_id":47,"session_id":"3843A7144E6540E2A4BCD6E2CA3A6AFA","goods_id":143,"goods_sn":"TP0000143","goods_name":"haier海尔 BC-93TMPF 93升单门冰箱","market_price":"799.00","goods_price":"699.00","member_goods_price":"699.00","goods_num":1,"spec_key":"","spec_key_name":"","bar_code":"","selected":1,"add_time":1499675913,"prom_type":0,"prom_id":0,"sku":"","store_id":2,"goods_fee":699,"store_count":99},{"id":33,"user_id":47,"session_id":"3843A7144E6540E2A4BCD6E2CA3A6AFA","goods_id":142,"goods_sn":"TP0000142","goods_name":"海尔（Haier）BCD-251WDGW 251升 无霜两门冰箱（白色）","market_price":"2799.00","goods_price":"2699.00","member_goods_price":"2699.00","goods_num":1,"spec_key":"","spec_key_name":"","bar_code":"","selected":1,"add_time":1499675916,"prom_type":0,"prom_id":0,"sku":"","store_id":2,"goods_fee":2699,"store_count":97}]}]
         */

        private AddressListBean addressList;
        private TotalPriceBean totalPrice;
        private UserInfoBean userInfo;
        private List<StoreListBean> storeList;

        public AddressListBean getAddressList() {
            return addressList;
        }

        public void setAddressList(AddressListBean addressList) {
            this.addressList = addressList;
        }

        public TotalPriceBean getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(TotalPriceBean totalPrice) {
            this.totalPrice = totalPrice;
        }

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public List<StoreListBean> getStoreList() {
            return storeList;
        }

        public void setStoreList(List<StoreListBean> storeList) {
            this.storeList = storeList;
        }

        public static class AddressListBean {
            /**
             * address_id : 38
             * user_id : 47
             * consignee : 123
             * email :
             * country : 0
             * province : 1
             * city : 2
             * district : 3
             * twon : 4
             * address : 13123133
             * zipcode : 212122
             * mobile : 18338220350
             * is_default : 1
             */

            private int address_id;
            private int user_id;
            private String consignee;
            private String email;
            private int country;
            private int province;
            private int city;
            private int district;
            private int twon;
            private String address;
            private String zipcode;
            private String mobile;
            private int is_default;

            public int getAddress_id() {
                return address_id;
            }

            public void setAddress_id(int address_id) {
                this.address_id = address_id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getConsignee() {
                return consignee;
            }

            public void setConsignee(String consignee) {
                this.consignee = consignee;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
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

            public int getIs_default() {
                return is_default;
            }

            public void setIs_default(int is_default) {
                this.is_default = is_default;
            }
        }

        public static class TotalPriceBean {
            /**
             * total_fee : 3909
             * cut_fee : 340
             * num : 8
             */

            private int total_fee;
            private int cut_fee;
            private int num;

            public int getTotal_fee() {
                return total_fee;
            }

            public void setTotal_fee(int total_fee) {
                this.total_fee = total_fee;
            }

            public int getCut_fee() {
                return cut_fee;
            }

            public void setCut_fee(int cut_fee) {
                this.cut_fee = cut_fee;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }
        }

        public static class UserInfoBean {
            /**
             * user_id : 47
             * email :
             * password : 519475228fe35ad067744465c42a19b2
             * sex : 0
             * birthday : 0
             * user_money : 2879.07
             * frozen_money : 0.00
             * distribut_money : 0.00
             * pay_points : 0
             * paypwd : 519475228fe35ad067744465c42a19b2
             * reg_time : 1496569650
             * last_login : 1499740802
             * last_ip :
             * qq :
             * mobile : 13653839640
             * mobile_validated : 1
             * oauth :
             * openid : null
             * unionid : null
             * head_pic : null
             * bank_name : 建行
             * bank_card : 44444
             * realname : bb
             * idcard : null
             * email_validated : 0
             * nickname : 13653839640
             * level : 1
             * discount : 1.00
             * total_amount : 7573.00
             * is_lock : 0
             * is_distribut : 1
             * first_leader : 0
             * second_leader : 0
             * third_leader : 0
             * token : 89d102485fc988749b65713ad9d182e7
             * underling_number : 0
             * message_mask : 53
             * push_id :
             * ref_id : 1
             * bonus : 2988.00
             * total_bonus1 : 121.72
             * total_bonus : 121.72
             * total_sell : 449.00
             * lft : 2
             * rgt : 2
             * deep : 0
             * operator_status : 0
             * sell_status : 1
             */

            private int user_id;
            private String email;
            private String password;
            private int sex;
            private int birthday;
            private String user_money;
            private String frozen_money;
            private String distribut_money;
            private int pay_points;
            private String paypwd;
            private int reg_time;
            private int last_login;
            private String last_ip;
            private String qq;
            private String mobile;
            private int mobile_validated;
            private String oauth;
            private Object openid;
            private Object unionid;
            private Object head_pic;
            private String bank_name;
            private String bank_card;
            private String realname;
            private Object idcard;
            private int email_validated;
            private String nickname;
            private int level;
            private String discount;
            private String total_amount;
            private int is_lock;
            private int is_distribut;
            private int first_leader;
            private int second_leader;
            private int third_leader;
            private String token;
            private int underling_number;
            private int message_mask;
            private String push_id;
            private int ref_id;
            private String bonus;
            private String total_bonus1;
            private String total_bonus;
            private String total_sell;
            private int lft;
            private int rgt;
            private int deep;
            private int operator_status;
            private int sell_status;

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public int getBirthday() {
                return birthday;
            }

            public void setBirthday(int birthday) {
                this.birthday = birthday;
            }

            public String getUser_money() {
                return user_money;
            }

            public void setUser_money(String user_money) {
                this.user_money = user_money;
            }

            public String getFrozen_money() {
                return frozen_money;
            }

            public void setFrozen_money(String frozen_money) {
                this.frozen_money = frozen_money;
            }

            public String getDistribut_money() {
                return distribut_money;
            }

            public void setDistribut_money(String distribut_money) {
                this.distribut_money = distribut_money;
            }

            public int getPay_points() {
                return pay_points;
            }

            public void setPay_points(int pay_points) {
                this.pay_points = pay_points;
            }

            public String getPaypwd() {
                return paypwd;
            }

            public void setPaypwd(String paypwd) {
                this.paypwd = paypwd;
            }

            public int getReg_time() {
                return reg_time;
            }

            public void setReg_time(int reg_time) {
                this.reg_time = reg_time;
            }

            public int getLast_login() {
                return last_login;
            }

            public void setLast_login(int last_login) {
                this.last_login = last_login;
            }

            public String getLast_ip() {
                return last_ip;
            }

            public void setLast_ip(String last_ip) {
                this.last_ip = last_ip;
            }

            public String getQq() {
                return qq;
            }

            public void setQq(String qq) {
                this.qq = qq;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public int getMobile_validated() {
                return mobile_validated;
            }

            public void setMobile_validated(int mobile_validated) {
                this.mobile_validated = mobile_validated;
            }

            public String getOauth() {
                return oauth;
            }

            public void setOauth(String oauth) {
                this.oauth = oauth;
            }

            public Object getOpenid() {
                return openid;
            }

            public void setOpenid(Object openid) {
                this.openid = openid;
            }

            public Object getUnionid() {
                return unionid;
            }

            public void setUnionid(Object unionid) {
                this.unionid = unionid;
            }

            public Object getHead_pic() {
                return head_pic;
            }

            public void setHead_pic(Object head_pic) {
                this.head_pic = head_pic;
            }

            public String getBank_name() {
                return bank_name;
            }

            public void setBank_name(String bank_name) {
                this.bank_name = bank_name;
            }

            public String getBank_card() {
                return bank_card;
            }

            public void setBank_card(String bank_card) {
                this.bank_card = bank_card;
            }

            public String getRealname() {
                return realname;
            }

            public void setRealname(String realname) {
                this.realname = realname;
            }

            public Object getIdcard() {
                return idcard;
            }

            public void setIdcard(Object idcard) {
                this.idcard = idcard;
            }

            public int getEmail_validated() {
                return email_validated;
            }

            public void setEmail_validated(int email_validated) {
                this.email_validated = email_validated;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public String getDiscount() {
                return discount;
            }

            public void setDiscount(String discount) {
                this.discount = discount;
            }

            public String getTotal_amount() {
                return total_amount;
            }

            public void setTotal_amount(String total_amount) {
                this.total_amount = total_amount;
            }

            public int getIs_lock() {
                return is_lock;
            }

            public void setIs_lock(int is_lock) {
                this.is_lock = is_lock;
            }

            public int getIs_distribut() {
                return is_distribut;
            }

            public void setIs_distribut(int is_distribut) {
                this.is_distribut = is_distribut;
            }

            public int getFirst_leader() {
                return first_leader;
            }

            public void setFirst_leader(int first_leader) {
                this.first_leader = first_leader;
            }

            public int getSecond_leader() {
                return second_leader;
            }

            public void setSecond_leader(int second_leader) {
                this.second_leader = second_leader;
            }

            public int getThird_leader() {
                return third_leader;
            }

            public void setThird_leader(int third_leader) {
                this.third_leader = third_leader;
            }

            public String getToken() {
                return token;
            }

            public void setToken(String token) {
                this.token = token;
            }

            public int getUnderling_number() {
                return underling_number;
            }

            public void setUnderling_number(int underling_number) {
                this.underling_number = underling_number;
            }

            public int getMessage_mask() {
                return message_mask;
            }

            public void setMessage_mask(int message_mask) {
                this.message_mask = message_mask;
            }

            public String getPush_id() {
                return push_id;
            }

            public void setPush_id(String push_id) {
                this.push_id = push_id;
            }

            public int getRef_id() {
                return ref_id;
            }

            public void setRef_id(int ref_id) {
                this.ref_id = ref_id;
            }

            public String getBonus() {
                return bonus;
            }

            public void setBonus(String bonus) {
                this.bonus = bonus;
            }

            public String getTotal_bonus1() {
                return total_bonus1;
            }

            public void setTotal_bonus1(String total_bonus1) {
                this.total_bonus1 = total_bonus1;
            }

            public String getTotal_bonus() {
                return total_bonus;
            }

            public void setTotal_bonus(String total_bonus) {
                this.total_bonus = total_bonus;
            }

            public String getTotal_sell() {
                return total_sell;
            }

            public void setTotal_sell(String total_sell) {
                this.total_sell = total_sell;
            }

            public int getLft() {
                return lft;
            }

            public void setLft(int lft) {
                this.lft = lft;
            }

            public int getRgt() {
                return rgt;
            }

            public void setRgt(int rgt) {
                this.rgt = rgt;
            }

            public int getDeep() {
                return deep;
            }

            public void setDeep(int deep) {
                this.deep = deep;
            }

            public int getOperator_status() {
                return operator_status;
            }

            public void setOperator_status(int operator_status) {
                this.operator_status = operator_status;
            }

            public int getSell_status() {
                return sell_status;
            }

            public void setSell_status(int sell_status) {
                this.sell_status = sell_status;
            }
        }

        public static class StoreListBean {
            /**
             * store_id : 4
             * store_name : q
             * coupon_num : 0
             * shippingList : [{"shipping_area_id":52,"shipping_code":"ems","store_id":4,"name":"EMS","freight":0},{"shipping_area_id":58,"shipping_code":"huitong","store_id":4,"name":"百世汇通快递","freight":0},{"shipping_area_id":51,"shipping_code":"shentong","store_id":4,"name":"申通物流","freight":0},{"shipping_area_id":53,"shipping_code":"shunfeng","store_id":4,"name":"顺丰物流","freight":0},{"shipping_area_id":54,"shipping_code":"yuantong","store_id":4,"name":"圆通快递","freight":0}]
             * cartList : [{"id":30,"user_id":47,"session_id":"3843A7144E6540E2A4BCD6E2CA3A6AFA","goods_id":162,"goods_sn":"TP0000162","goods_name":"直接上架","market_price":"130.00","goods_price":"100.00","member_goods_price":"100.00","goods_num":5,"spec_key":"","spec_key_name":"","bar_code":"","selected":1,"add_time":1499675687,"prom_type":0,"prom_id":0,"sku":"","store_id":4,"goods_fee":500,"store_count":91},{"id":31,"user_id":47,"session_id":"3843A7144E6540E2A4BCD6E2CA3A6AFA","goods_id":169,"goods_sn":"TP0000169","goods_name":"vvvvvv","market_price":"1.00","goods_price":"11.00","member_goods_price":"11.00","goods_num":1,"spec_key":"165_167","spec_key_name":"容量:6公斤 样式:侧开门","bar_code":"","selected":1,"add_time":1499675907,"prom_type":0,"prom_id":0,"sku":"11.00","store_id":4,"goods_fee":11,"store_count":10}]
             */

            private int store_id;
            private String store_name;
            private int coupon_num;
            private List<ShippingListBean> shippingList;
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

            public int getCoupon_num() {
                return coupon_num;
            }

            public void setCoupon_num(int coupon_num) {
                this.coupon_num = coupon_num;
            }

            public List<ShippingListBean> getShippingList() {
                return shippingList;
            }

            public void setShippingList(List<ShippingListBean> shippingList) {
                this.shippingList = shippingList;
            }

            public List<CartListBean> getCartList() {
                return cartList;
            }

            public void setCartList(List<CartListBean> cartList) {
                this.cartList = cartList;
            }

            public static class ShippingListBean {
                /**
                 * shipping_area_id : 52
                 * shipping_code : ems
                 * store_id : 4
                 * name : EMS
                 * freight : 0
                 */

                private int shipping_area_id;
                private String shipping_code;
                private int store_id;
                private String name;
                private int freight;

                public int getShipping_area_id() {
                    return shipping_area_id;
                }

                public void setShipping_area_id(int shipping_area_id) {
                    this.shipping_area_id = shipping_area_id;
                }

                public String getShipping_code() {
                    return shipping_code;
                }

                public void setShipping_code(String shipping_code) {
                    this.shipping_code = shipping_code;
                }

                public int getStore_id() {
                    return store_id;
                }

                public void setStore_id(int store_id) {
                    this.store_id = store_id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getFreight() {
                    return freight;
                }

                public void setFreight(int freight) {
                    this.freight = freight;
                }
            }

            public static class CartListBean {
                /**
                 * id : 30
                 * user_id : 47
                 * session_id : 3843A7144E6540E2A4BCD6E2CA3A6AFA
                 * goods_id : 162
                 * goods_sn : TP0000162
                 * goods_name : 直接上架
                 * market_price : 130.00
                 * goods_price : 100.00
                 * member_goods_price : 100.00
                 * goods_num : 5
                 * spec_key :
                 * spec_key_name :
                 * bar_code :
                 * selected : 1
                 * add_time : 1499675687
                 * prom_type : 0
                 * prom_id : 0
                 * sku :
                 * store_id : 4
                 * goods_fee : 500
                 * store_count : 91
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
                private int goods_fee;
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

                public int getGoods_fee() {
                    return goods_fee;
                }

                public void setGoods_fee(int goods_fee) {
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
