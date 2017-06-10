package com.kymart.shop.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/9.
 */

public class Classifacation_leftBean  {

    /**
     * msg : 获取成功
     * result : [{"image":"/Public/upload/category/2016/04-02/56ffa1252fb1b.jpg","level":1,"mobile_name":"数码产品","type_id":18,"is_show":1,"cat_group":0,"parent_id_path":"0_1","parent_id":0,"is_hot":1,"name":"手机 、 数码 、 通信","commission":11,"commission_rate":0,"id":1,"sort_order":50},{"image":"/Public/upload/category/2016/04-22/5719c3c5bc052.jpg","level":1,"mobile_name":"家用电器","type_id":29,"is_show":1,"cat_group":0,"parent_id_path":"0_2","parent_id":0,"is_hot":1,"name":"家用电器","commission":13,"commission_rate":0,"id":2,"sort_order":50},{"image":"/Public/upload/category/2016/04-22/5719c40f21341.jpg","level":1,"mobile_name":"电脑","type_id":0,"is_show":1,"cat_group":0,"parent_id_path":"0_3","parent_id":0,"is_hot":1,"name":"电脑、办公","commission":31,"commission_rate":0,"id":3,"sort_order":50},{"image":"/Public/upload/category/2016/04-22/5719c41e70959.jpg","level":1,"mobile_name":"家具","type_id":0,"is_show":1,"cat_group":0,"parent_id_path":"0_4","parent_id":0,"is_hot":0,"name":"家居、家具、家装、厨具","commission":41,"commission_rate":0,"id":4,"sort_order":50},{"image":"/Public/upload/category/2016/04-22/5719c432da41e.jpg","level":1,"mobile_name":"服装","type_id":0,"is_show":1,"cat_group":0,"parent_id_path":"0_5","parent_id":0,"is_hot":0,"name":"男装、女装、童装、内衣","commission":0,"commission_rate":0,"id":5,"sort_order":50},{"image":"/Public/upload/category/2016/04-22/5719c4a1e3447.jpg","level":1,"mobile_name":"个人化妆","type_id":0,"is_show":1,"cat_group":0,"parent_id_path":"0_6","parent_id":0,"is_hot":0,"name":"个人化妆","commission":0,"commission_rate":0,"id":6,"sort_order":52},{"image":"/Public/upload/category/2016/04-22/5719c445a02ba.jpg","level":1,"mobile_name":"箱包","type_id":0,"is_show":1,"cat_group":0,"parent_id_path":"0_7","parent_id":0,"is_hot":0,"name":"鞋、箱包、珠宝、手表","commission":0,"commission_rate":0,"id":7,"sort_order":50}]
     * status : 1
     */
    private String msg;
    private List<ResultEntity> result;
    private int status;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public int getStatus() {
        return status;
    }

    public class ResultEntity {
        /**
         * image : /Public/upload/category/2016/04-02/56ffa1252fb1b.jpg
         * level : 1
         * mobile_name : 数码产品
         * type_id : 18
         * is_show : 1
         * cat_group : 0
         * parent_id_path : 0_1
         * parent_id : 0
         * is_hot : 1
         * name : 手机 、 数码 、 通信
         * commission : 11
         * commission_rate : 0
         * id : 1
         * sort_order : 50
         */
        private String image;
        private int level;
        private String mobile_name;
        private int type_id;
        private int is_show;
        private int cat_group;
        private String parent_id_path;
        private int parent_id;
        private int is_hot;
        private String name;
        private int commission;
        private int commission_rate;
        private int id;
        private int sort_order;

        public void setImage(String image) {
            this.image = image;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public void setMobile_name(String mobile_name) {
            this.mobile_name = mobile_name;
        }

        public void setType_id(int type_id) {
            this.type_id = type_id;
        }

        public void setIs_show(int is_show) {
            this.is_show = is_show;
        }

        public void setCat_group(int cat_group) {
            this.cat_group = cat_group;
        }

        public void setParent_id_path(String parent_id_path) {
            this.parent_id_path = parent_id_path;
        }

        public void setParent_id(int parent_id) {
            this.parent_id = parent_id;
        }

        public void setIs_hot(int is_hot) {
            this.is_hot = is_hot;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCommission(int commission) {
            this.commission = commission;
        }

        public void setCommission_rate(int commission_rate) {
            this.commission_rate = commission_rate;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setSort_order(int sort_order) {
            this.sort_order = sort_order;
        }

        public String getImage() {
            return image;
        }

        public int getLevel() {
            return level;
        }

        public String getMobile_name() {
            return mobile_name;
        }

        public int getType_id() {
            return type_id;
        }

        public int getIs_show() {
            return is_show;
        }

        public int getCat_group() {
            return cat_group;
        }

        public String getParent_id_path() {
            return parent_id_path;
        }

        public int getParent_id() {
            return parent_id;
        }

        public int getIs_hot() {
            return is_hot;
        }

        public String getName() {
            return name;
        }

        public int getCommission() {
            return commission;
        }

        public int getCommission_rate() {
            return commission_rate;
        }

        public int getId() {
            return id;
        }

        public int getSort_order() {
            return sort_order;
        }
    }
}
