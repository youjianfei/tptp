package com.kymart.shop.Bean;

/**
 * Created by Administrator on 2017/6/12.
 */

public class UserBean {

    /**
     * msg : 登陆成功
     * result : {"birthday":0,"pay_points":0,"last_ip":"","bank_card":null,"unionid":null,"push_id":"","frozen_money":"0.00","discount":"1.00","third_leader":0,"password":"db964bd974809505de68d884b6367f9c","reg_time":1497152330,"bank_name":null,"nickname":"18595756282","mobile_validated":1,"underling_number":0,"oauth":"","email":"","qq":"","second_leader":0,"level":1,"last_login":1497190503,"openid":null,"sex":0,"mobile":"18595756282","head_pic":null,"is_distribut":1,"realname":null,"token":"708b196e9def1d2a857ad1bfe5faf42c","user_money":"0.00","first_leader":0,"message_mask":63,"email_validated":0,"level_name":"注册会员","user_id":51,"total_amount":"0.00","idcard":null,"is_lock":0,"distribut_money":"0.00","paypwd":null}
     * status : 1
     */
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

    public class ResultEntity {
        /**
         * birthday : 0
         * pay_points : 0
         * last_ip :
         * bank_card : null
         * unionid : null
         * push_id :
         * frozen_money : 0.00
         * discount : 1.00
         * third_leader : 0
         * password : db964bd974809505de68d884b6367f9c
         * reg_time : 1497152330
         * bank_name : null
         * nickname : 18595756282
         * mobile_validated : 1
         * underling_number : 0
         * oauth :
         * email :
         * qq :
         * second_leader : 0
         * level : 1
         * last_login : 1497190503
         * openid : null
         * sex : 0
         * mobile : 18595756282
         * head_pic : null
         * is_distribut : 1
         * realname : null
         * token : 708b196e9def1d2a857ad1bfe5faf42c
         * user_money : 0.00
         * first_leader : 0
         * message_mask : 63
         * email_validated : 0
         * level_name : 注册会员
         * user_id : 51
         * total_amount : 0.00
         * idcard : null
         * is_lock : 0
         * distribut_money : 0.00
         * paypwd : null
         */
        private int birthday;
        private int pay_points;
        private String last_ip;
        private String bank_card;
        private String unionid;
        private String push_id;
        private String frozen_money;
        private String discount;
        private int third_leader;
        private String password;
        private int reg_time;
        private String bank_name;
        private String nickname;
        private int mobile_validated;
        private int underling_number;
        private String oauth;
        private String email;
        private String qq;
        private int second_leader;
        private int level;
        private int last_login;
        private String openid;
        private int sex;
        private String mobile;
        private String head_pic;
        private int is_distribut;
        private String realname;
        private String token;
        private String user_money;
        private int first_leader;
        private int message_mask;
        private int email_validated;
        private String level_name;
        private int user_id;
        private String total_amount;
        private String idcard;
        private int is_lock;
        private String distribut_money;
        private String paypwd;

        public void setBirthday(int birthday) {
            this.birthday = birthday;
        }

        public void setPay_points(int pay_points) {
            this.pay_points = pay_points;
        }

        public void setLast_ip(String last_ip) {
            this.last_ip = last_ip;
        }

        public void setBank_card(String bank_card) {
            this.bank_card = bank_card;
        }

        public void setUnionid(String unionid) {
            this.unionid = unionid;
        }

        public void setPush_id(String push_id) {
            this.push_id = push_id;
        }

        public void setFrozen_money(String frozen_money) {
            this.frozen_money = frozen_money;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public void setThird_leader(int third_leader) {
            this.third_leader = third_leader;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setReg_time(int reg_time) {
            this.reg_time = reg_time;
        }

        public void setBank_name(String bank_name) {
            this.bank_name = bank_name;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public void setMobile_validated(int mobile_validated) {
            this.mobile_validated = mobile_validated;
        }

        public void setUnderling_number(int underling_number) {
            this.underling_number = underling_number;
        }

        public void setOauth(String oauth) {
            this.oauth = oauth;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public void setSecond_leader(int second_leader) {
            this.second_leader = second_leader;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public void setLast_login(int last_login) {
            this.last_login = last_login;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public void setHead_pic(String head_pic) {
            this.head_pic = head_pic;
        }

        public void setIs_distribut(int is_distribut) {
            this.is_distribut = is_distribut;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public void setUser_money(String user_money) {
            this.user_money = user_money;
        }

        public void setFirst_leader(int first_leader) {
            this.first_leader = first_leader;
        }

        public void setMessage_mask(int message_mask) {
            this.message_mask = message_mask;
        }

        public void setEmail_validated(int email_validated) {
            this.email_validated = email_validated;
        }

        public void setLevel_name(String level_name) {
            this.level_name = level_name;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public void setTotal_amount(String total_amount) {
            this.total_amount = total_amount;
        }

        public void setIdcard(String idcard) {
            this.idcard = idcard;
        }

        public void setIs_lock(int is_lock) {
            this.is_lock = is_lock;
        }

        public void setDistribut_money(String distribut_money) {
            this.distribut_money = distribut_money;
        }

        public void setPaypwd(String paypwd) {
            this.paypwd = paypwd;
        }

        public int getBirthday() {
            return birthday;
        }

        public int getPay_points() {
            return pay_points;
        }

        public String getLast_ip() {
            return last_ip;
        }

        public String getBank_card() {
            return bank_card;
        }

        public String getUnionid() {
            return unionid;
        }

        public String getPush_id() {
            return push_id;
        }

        public String getFrozen_money() {
            return frozen_money;
        }

        public String getDiscount() {
            return discount;
        }

        public int getThird_leader() {
            return third_leader;
        }

        public String getPassword() {
            return password;
        }

        public int getReg_time() {
            return reg_time;
        }

        public String getBank_name() {
            return bank_name;
        }

        public String getNickname() {
            return nickname;
        }

        public int getMobile_validated() {
            return mobile_validated;
        }

        public int getUnderling_number() {
            return underling_number;
        }

        public String getOauth() {
            return oauth;
        }

        public String getEmail() {
            return email;
        }

        public String getQq() {
            return qq;
        }

        public int getSecond_leader() {
            return second_leader;
        }

        public int getLevel() {
            return level;
        }

        public int getLast_login() {
            return last_login;
        }

        public String getOpenid() {
            return openid;
        }

        public int getSex() {
            return sex;
        }

        public String getMobile() {
            return mobile;
        }

        public String getHead_pic() {
            return head_pic;
        }

        public int getIs_distribut() {
            return is_distribut;
        }

        public String getRealname() {
            return realname;
        }

        public String getToken() {
            return token;
        }

        public String getUser_money() {
            return user_money;
        }

        public int getFirst_leader() {
            return first_leader;
        }

        public int getMessage_mask() {
            return message_mask;
        }

        public int getEmail_validated() {
            return email_validated;
        }

        public String getLevel_name() {
            return level_name;
        }

        public int getUser_id() {
            return user_id;
        }

        public String getTotal_amount() {
            return total_amount;
        }

        public String getIdcard() {
            return idcard;
        }

        public int getIs_lock() {
            return is_lock;
        }

        public String getDistribut_money() {
            return distribut_money;
        }

        public String getPaypwd() {
            return paypwd;
        }
    }
}
