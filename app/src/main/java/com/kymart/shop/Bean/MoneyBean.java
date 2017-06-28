package com.kymart.shop.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */

public class MoneyBean {

    /**
     * status : 1
     * msg : 获取成功
     * result : [{"log_id":316,"user_id":47,"user_money":"-100.00","frozen_money":"0.00","pay_points":0,"change_time":1498015728,"desc":"用户余额提现申请","order_sn":"","order_id":0},{"log_id":315,"user_id":47,"user_money":"100.00","frozen_money":"0.00","pay_points":0,"change_time":1497789798,"desc":"用户申请订单退款","order_sn":"201706182033155706","order_id":368},{"log_id":314,"user_id":47,"user_money":"18.00","frozen_money":"0.00","pay_points":0,"change_time":1497789656,"desc":"用户申请订单退款","order_sn":"201706161502363297","order_id":360},{"log_id":313,"user_id":47,"user_money":"-122.00","frozen_money":"0.00","pay_points":0,"change_time":1497789195,"desc":"下单消费","order_sn":"201706182033155706","order_id":368},{"log_id":312,"user_id":47,"user_money":"-320.00","frozen_money":"0.00","pay_points":0,"change_time":1497778869,"desc":"下单消费","order_sn":"201706181741097571","order_id":367},{"log_id":311,"user_id":47,"user_money":"-100.00","frozen_money":"0.00","pay_points":0,"change_time":1497778869,"desc":"下单消费","order_sn":"201706181741091630","order_id":366},{"log_id":310,"user_id":47,"user_money":"-100.00","frozen_money":"0.00","pay_points":0,"change_time":1497710437,"desc":"用户余额提现申请","order_sn":"","order_id":0},{"log_id":309,"user_id":47,"user_money":"80.00","frozen_money":"0.00","pay_points":0,"change_time":1497696126,"desc":"用户申请订单退款","order_sn":"201706171623257410","order_id":361},{"log_id":308,"user_id":47,"user_money":"-11.00","frozen_money":"0.00","pay_points":0,"change_time":1497688221,"desc":"下单消费","order_sn":"201706171630219128","order_id":365},{"log_id":307,"user_id":47,"user_money":"-198.00","frozen_money":"0.00","pay_points":0,"change_time":1497688121,"desc":"下单消费","order_sn":"201706171628419466","order_id":363}]
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
         * log_id : 316
         * user_id : 47
         * user_money : -100.00
         * frozen_money : 0.00
         * pay_points : 0
         * change_time : 1498015728
         * desc : 用户余额提现申请
         * order_sn :
         * order_id : 0
         */

        private int log_id;
        private int id;
        private int user_id;
        private String user_money;
        private String frozen_money;
        private int pay_points;
        private int change_time;
        private int create_time;
        private String desc;
        private String order_sn;
        private String amount;
        private String type_text;
        private int order_id;
        private int from_user_id;
        private int type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCreate_time() {
            return create_time;
        }

        public void setCreate_time(int create_time) {
            this.create_time = create_time;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getType_text() {
            return type_text;
        }

        public void setType_text(String type_text) {
            this.type_text = type_text;
        }

        public int getFrom_user_id() {
            return from_user_id;
        }

        public void setFrom_user_id(int from_user_id) {
            this.from_user_id = from_user_id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getLog_id() {
            return log_id;
        }

        public void setLog_id(int log_id) {
            this.log_id = log_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
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

        public int getPay_points() {
            return pay_points;
        }

        public void setPay_points(int pay_points) {
            this.pay_points = pay_points;
        }

        public int getChange_time() {
            return change_time;
        }

        public void setChange_time(int change_time) {
            this.change_time = change_time;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getOrder_sn() {
            return order_sn;
        }

        public void setOrder_sn(String order_sn) {
            this.order_sn = order_sn;
        }

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }
    }
}
