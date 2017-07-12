package com.kymart.shop.Bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/12.
 */

public class WechatPayBean {

    /**
     * msg : 获取成功
     * status : 1
     * result : {"appid":"wxcf54c829295655ba","noncestr":"DFHrOLOklNfOIJo0","package":"Sign=WXPay","partnerid":"1484415532","prepayid":"wx201707121617196f6c3f46270822941183","timestamp":1499847439,"sign":"1FF9D0A68910C934DD1FA7A5450F1EE7"}
     */

    private String msg;
    private int status;
    private ResultBean result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * appid : wxcf54c829295655ba
         * noncestr : DFHrOLOklNfOIJo0
         * package : Sign=WXPay
         * partnerid : 1484415532
         * prepayid : wx201707121617196f6c3f46270822941183
         * timestamp : 1499847439
         * sign : 1FF9D0A68910C934DD1FA7A5450F1EE7
         */

        private String appid;
        private String noncestr;
        @SerializedName("package")
        private String packageX;
        private String partnerid;
        private String prepayid;
        private int timestamp;
        private String sign;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getNoncestr() {
            return noncestr;
        }

        public void setNoncestr(String noncestr) {
            this.noncestr = noncestr;
        }

        public String getPackageX() {
            return packageX;
        }

        public void setPackageX(String packageX) {
            this.packageX = packageX;
        }

        public String getPartnerid() {
            return partnerid;
        }

        public void setPartnerid(String partnerid) {
            this.partnerid = partnerid;
        }

        public String getPrepayid() {
            return prepayid;
        }

        public void setPrepayid(String prepayid) {
            this.prepayid = prepayid;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }
    }
}
