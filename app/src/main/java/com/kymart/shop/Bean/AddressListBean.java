package com.kymart.shop.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */

public class AddressListBean {

    /**
     * status : 1
     * msg : 获取成功
     * result : [{"address_id":47,"user_id":50,"consignee":"考虑","email":"","country":0,"province":4670,"city":5162,"district":5219,"twon":5225,"address":"啦啦啦","zipcode":"542575","mobile":"13536255426","is_default":0},{"address_id":48,"user_id":50,"consignee":"啦啦啦","email":"","country":0,"province":4670,"city":5029,"district":5079,"twon":5083,"address":"刚回来","zipcode":"588","mobile":"1555888","is_default":0},{"address_id":49,"user_id":50,"consignee":"啦啦啦","email":"","country":0,"province":4670,"city":5029,"district":5079,"twon":5083,"address":"刚回来","zipcode":"588","mobile":"1555888","is_default":0},{"address_id":50,"user_id":50,"consignee":"啦啦啦监控","email":"","country":0,"province":3102,"city":3690,"district":3723,"twon":3728,"address":"啦啦啦","zipcode":"55","mobile":"18337105569","is_default":0},{"address_id":51,"user_id":50,"consignee":"啦啦啦监控","email":"","country":0,"province":3102,"city":3690,"district":3723,"twon":3728,"address":"啦啦啦","zipcode":"55","mobile":"1833569","is_default":0},{"address_id":52,"user_id":50,"consignee":"啦啦啦监控","email":"","country":0,"province":3102,"city":3690,"district":3723,"twon":3728,"address":"啦啦啦","zipcode":"55","mobile":"1833569","is_default":0},{"address_id":53,"user_id":50,"consignee":"啦啦啦监控","email":"","country":0,"province":3102,"city":3690,"district":3723,"twon":3728,"address":"啦啦啦","zipcode":"55","mobile":"1863569","is_default":0},{"address_id":54,"user_id":50,"consignee":"兔兔","email":"","country":0,"province":4670,"city":5162,"district":5201,"twon":5206,"address":"具体","zipcode":"555","mobile":"18733636585","is_default":1}]
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
         * address_id : 47
         * user_id : 50
         * consignee : 考虑
         * email :
         * country : 0
         * province : 4670
         * city : 5162
         * district : 5219
         * twon : 5225
         * address : 啦啦啦
         * zipcode : 542575
         * mobile : 13536255426
         * is_default : 0
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
}
