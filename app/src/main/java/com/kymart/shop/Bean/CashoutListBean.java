package com.kymart.shop.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */

public class CashoutListBean {

    /**
     * status : 1
     * msg : 获取成功
     * result : [{"id":14,"user_id":47,"money":"100.00","real_money":"95.00","create_time":1499175054,"check_time":0,"pay_time":0,"refuse_time":0,"bank_name":"建行","bank_card":"44444","realname":"bb","remark":"","taxfee":"0.00","status":0,"pay_code":null,"changetype":1,"error_code":null,"status_text":"申请中"},{"id":13,"user_id":47,"money":"100.00","real_money":"95.00","create_time":1499174920,"check_time":1499174952,"pay_time":0,"refuse_time":0,"bank_name":"建行","bank_card":"44444","realname":"bb","remark":"审核通过","taxfee":"0.00","status":1,"pay_code":null,"changetype":1,"error_code":null,"status_text":"申请成功"},{"id":11,"user_id":47,"money":"100.00","real_money":"95.00","create_time":1498015728,"check_time":1499173995,"pay_time":0,"refuse_time":0,"bank_name":"建行","bank_card":"44444","realname":"bb","remark":"审核通过","taxfee":"0.00","status":1,"pay_code":null,"changetype":1,"error_code":null,"status_text":"申请成功"},{"id":10,"user_id":47,"money":"100.00","real_money":"95.00","create_time":1497710820,"check_time":1498015597,"pay_time":0,"refuse_time":0,"bank_name":"建行","bank_card":"666","realname":"qqq","remark":"审核通过","taxfee":"0.00","status":1,"pay_code":null,"changetype":2,"error_code":null,"status_text":"申请成功"},{"id":9,"user_id":47,"money":"100.00","real_money":"95.00","create_time":1497710437,"check_time":1497710798,"pay_time":0,"refuse_time":0,"bank_name":"建行","bank_card":"999","realname":"jj","remark":"审核通过","taxfee":"0.00","status":1,"pay_code":null,"changetype":1,"error_code":null,"status_text":"申请成功"},{"id":8,"user_id":47,"money":"100.00","real_money":"95.00","create_time":1497261958,"check_time":1497265274,"pay_time":0,"refuse_time":0,"bank_name":"建行","bank_card":"999","realname":"jj","remark":"审核通过","taxfee":"0.00","status":1,"pay_code":null,"changetype":2,"error_code":null,"status_text":"申请成功"},{"id":7,"user_id":47,"money":"100.00","real_money":"95.00","create_time":1497261800,"check_time":1497261916,"pay_time":1497261944,"refuse_time":1497261916,"bank_name":"建行","bank_card":"999","realname":"jj","remark":"1","taxfee":"0.00","status":2,"pay_code":null,"changetype":2,"error_code":null,"status_text":"申请失败"},{"id":6,"user_id":47,"money":"100.00","real_money":"95.00","create_time":1497261699,"check_time":1497261786,"pay_time":1497261936,"refuse_time":1497261786,"bank_name":"建行","bank_card":"999","realname":"jj","remark":"1","taxfee":"0.00","status":2,"pay_code":null,"changetype":1,"error_code":null,"status_text":"申请失败"},{"id":5,"user_id":47,"money":"100.00","real_money":"0.00","create_time":1497153581,"check_time":1497153614,"pay_time":1497242460,"refuse_time":1497153614,"bank_name":"建行","bank_card":"999","realname":"jj","remark":"vv","taxfee":"0.00","status":2,"pay_code":null,"changetype":1,"error_code":null,"status_text":"申请失败"},{"id":4,"user_id":47,"money":"100.00","real_money":"0.00","create_time":1497153431,"check_time":1497153551,"pay_time":1497153634,"refuse_time":1497153551,"bank_name":"建行","bank_card":"999","realname":"jj","remark":"jj","taxfee":"0.00","status":2,"pay_code":null,"changetype":1,"error_code":null,"status_text":"申请失败"}]
     * info : {"bank_name":"建行","bank_card":"44444","realname":"bb"}
     */

    private int status;
    private String msg;
    private InfoBean info;
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

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class InfoBean {
        /**
         * bank_name : 建行
         * bank_card : 44444
         * realname : bb
         */

        private String bank_name;
        private String bank_card;
        private String realname;

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
    }

    public static class ResultBean {
        /**
         * id : 14
         * user_id : 47
         * money : 100.00
         * real_money : 95.00
         * create_time : 1499175054
         * check_time : 0
         * pay_time : 0
         * refuse_time : 0
         * bank_name : 建行
         * bank_card : 44444
         * realname : bb
         * remark :
         * taxfee : 0.00
         * status : 0
         * pay_code : null
         * changetype : 1
         * error_code : null
         * status_text : 申请中
         */

        private int id;
        private int user_id;
        private String money;
        private String real_money;
        private int create_time;
        private int check_time;
        private int pay_time;
        private int refuse_time;
        private String bank_name;
        private String bank_card;
        private String realname;
        private String remark;
        private String taxfee;
        private int status;
        private Object pay_code;
        private int changetype;
        private Object error_code;
        private String status_text;

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

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getReal_money() {
            return real_money;
        }

        public void setReal_money(String real_money) {
            this.real_money = real_money;
        }

        public int getCreate_time() {
            return create_time;
        }

        public void setCreate_time(int create_time) {
            this.create_time = create_time;
        }

        public int getCheck_time() {
            return check_time;
        }

        public void setCheck_time(int check_time) {
            this.check_time = check_time;
        }

        public int getPay_time() {
            return pay_time;
        }

        public void setPay_time(int pay_time) {
            this.pay_time = pay_time;
        }

        public int getRefuse_time() {
            return refuse_time;
        }

        public void setRefuse_time(int refuse_time) {
            this.refuse_time = refuse_time;
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

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getTaxfee() {
            return taxfee;
        }

        public void setTaxfee(String taxfee) {
            this.taxfee = taxfee;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Object getPay_code() {
            return pay_code;
        }

        public void setPay_code(Object pay_code) {
            this.pay_code = pay_code;
        }

        public int getChangetype() {
            return changetype;
        }

        public void setChangetype(int changetype) {
            this.changetype = changetype;
        }

        public Object getError_code() {
            return error_code;
        }

        public void setError_code(Object error_code) {
            this.error_code = error_code;
        }

        public String getStatus_text() {
            return status_text;
        }

        public void setStatus_text(String status_text) {
            this.status_text = status_text;
        }
    }
}
