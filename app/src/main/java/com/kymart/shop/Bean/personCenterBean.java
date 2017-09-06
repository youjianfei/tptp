package com.kymart.shop.Bean;

/**
 * Created by Administrator on 2017/6/15.
 */

public class personCenterBean {


    /**
     * status : 1
     * msg : 获取成功
     * result : {"user_id":456,"email":"","password":"519475228fe35ad067744465c42a19b2","sex":0,"birthday":0,"user_money":"0.50","frozen_money":"0.00","distribut_money":"0.00","pay_points":0,"paypwd":null,"reg_time":1497457527,"last_login":1504659987,"last_ip":"","qq":"","mobile":"18737105569","mobile_validated":1,"oauth":"","openid":null,"unionid":null,"head_pic":null,"bank_name":null,"bank_card":null,"realname":null,"idcard":null,"email_validated":0,"nickname":"18737105569","level":2,"discount":"1.00","total_amount":"1.30","is_lock":0,"is_distribut":1,"first_leader":0,"second_leader":0,"third_leader":0,"token":"fe163021f6818d638f63be1a80d9c0fa","underling_number":0,"message_mask":63,"push_id":"","ref_id":1,"bonus":"0.00","bonus1":"0.00","total_bonus1":"0.00","total_bonus":"0.00","total_sell":"0.00","lft":10294,"rgt":10295,"deep":2,"operator_status":0,"sell_status":0,"coupon_count":0,"collect_count":0,"waitPay":34,"waitSend":12,"waitReceive":0,"comment_count":0,"order_count":46,"waitComment":0,"return_count":0,"ref_nickname":"","level_name":"一级开心果"}
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
         * user_id : 456
         * email :
         * password : 519475228fe35ad067744465c42a19b2
         * sex : 0
         * birthday : 0
         * user_money : 0.50
         * frozen_money : 0.00
         * distribut_money : 0.00
         * pay_points : 0
         * paypwd : null
         * reg_time : 1497457527
         * last_login : 1504659987
         * last_ip :
         * qq :
         * mobile : 18737105569
         * mobile_validated : 1
         * oauth :
         * openid : null
         * unionid : null
         * head_pic : null
         * bank_name : null
         * bank_card : null
         * realname : null
         * idcard : null
         * email_validated : 0
         * nickname : 18737105569
         * level : 2
         * discount : 1.00
         * total_amount : 1.30
         * is_lock : 0
         * is_distribut : 1
         * first_leader : 0
         * second_leader : 0
         * third_leader : 0
         * token : fe163021f6818d638f63be1a80d9c0fa
         * underling_number : 0
         * message_mask : 63
         * push_id :
         * ref_id : 1
         * bonus : 0.00
         * bonus1 : 0.00
         * total_bonus1 : 0.00
         * total_bonus : 0.00
         * total_sell : 0.00
         * lft : 10294
         * rgt : 10295
         * deep : 2
         * operator_status : 0
         * sell_status : 0
         * coupon_count : 0
         * collect_count : 0
         * waitPay : 34
         * waitSend : 12
         * waitReceive : 0
         * comment_count : 0
         * order_count : 46
         * waitComment : 0
         * return_count : 0
         * ref_nickname :
         * level_name : 一级开心果
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
        private Object paypwd;
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
        private Object bank_name;
        private Object bank_card;
        private Object realname;
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
        private String bonus1;
        private String total_bonus1;
        private String total_bonus;
        private String total_sell;
        private int lft;
        private int rgt;
        private int deep;
        private int operator_status;
        private int sell_status;
        private int coupon_count;
        private int collect_count;
        private int waitPay;
        private int waitSend;
        private int waitReceive;
        private int comment_count;
        private int order_count;
        private int waitComment;
        private int return_count;
        private String ref_nickname;
        private String level_name;

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

        public Object getPaypwd() {
            return paypwd;
        }

        public void setPaypwd(Object paypwd) {
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

        public Object getBank_name() {
            return bank_name;
        }

        public void setBank_name(Object bank_name) {
            this.bank_name = bank_name;
        }

        public Object getBank_card() {
            return bank_card;
        }

        public void setBank_card(Object bank_card) {
            this.bank_card = bank_card;
        }

        public Object getRealname() {
            return realname;
        }

        public void setRealname(Object realname) {
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

        public String getBonus1() {
            return bonus1;
        }

        public void setBonus1(String bonus1) {
            this.bonus1 = bonus1;
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

        public int getCoupon_count() {
            return coupon_count;
        }

        public void setCoupon_count(int coupon_count) {
            this.coupon_count = coupon_count;
        }

        public int getCollect_count() {
            return collect_count;
        }

        public void setCollect_count(int collect_count) {
            this.collect_count = collect_count;
        }

        public int getWaitPay() {
            return waitPay;
        }

        public void setWaitPay(int waitPay) {
            this.waitPay = waitPay;
        }

        public int getWaitSend() {
            return waitSend;
        }

        public void setWaitSend(int waitSend) {
            this.waitSend = waitSend;
        }

        public int getWaitReceive() {
            return waitReceive;
        }

        public void setWaitReceive(int waitReceive) {
            this.waitReceive = waitReceive;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public int getOrder_count() {
            return order_count;
        }

        public void setOrder_count(int order_count) {
            this.order_count = order_count;
        }

        public int getWaitComment() {
            return waitComment;
        }

        public void setWaitComment(int waitComment) {
            this.waitComment = waitComment;
        }

        public int getReturn_count() {
            return return_count;
        }

        public void setReturn_count(int return_count) {
            this.return_count = return_count;
        }

        public String getRef_nickname() {
            return ref_nickname;
        }

        public void setRef_nickname(String ref_nickname) {
            this.ref_nickname = ref_nickname;
        }

        public String getLevel_name() {
            return level_name;
        }

        public void setLevel_name(String level_name) {
            this.level_name = level_name;
        }
    }
}
