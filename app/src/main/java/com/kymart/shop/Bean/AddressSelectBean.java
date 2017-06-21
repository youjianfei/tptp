package com.kymart.shop.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */

public class AddressSelectBean {

    /**
     * address_select : [{"level":1,"parent_id":0,"name":"北京市","id":1},{"level":1,"parent_id":0,"name":"天津市","id":338},{"level":1,"parent_id":0,"name":"河北省","id":636},{"level":1,"parent_id":0,"name":"山西","id":3102},{"level":1,"parent_id":0,"name":"内蒙古自治区","id":4670},{"level":1,"parent_id":0,"name":"辽宁省","id":5827},{"level":1,"parent_id":0,"name":"吉林省","id":7531},{"level":1,"parent_id":0,"name":"黑龙江省","id":8558},{"level":1,"parent_id":0,"name":"上海市","id":10543},{"level":1,"parent_id":0,"name":"江苏省","id":10808},{"level":1,"parent_id":0,"name":"浙江省","id":12596},{"level":1,"parent_id":0,"name":"安徽省","id":14234},{"level":1,"parent_id":0,"name":"福建省","id":16068},{"level":1,"parent_id":0,"name":"江西省","id":17359},{"level":1,"parent_id":0,"name":"山东省","id":19280},{"level":1,"parent_id":0,"name":"河南省","id":21387},{"level":1,"parent_id":0,"name":"湖北省","id":24022},{"level":1,"parent_id":0,"name":"湖南省","id":25579},{"level":1,"parent_id":0,"name":"广东省","id":28240},{"level":1,"parent_id":0,"name":"广西壮族自治区","id":30164},{"level":1,"parent_id":0,"name":"海南省","id":31563},{"level":1,"parent_id":0,"name":"重庆市","id":31929},{"level":1,"parent_id":0,"name":"四川省","id":33007},{"level":1,"parent_id":0,"name":"贵州省","id":37906},{"level":1,"parent_id":0,"name":"云南省","id":39556},{"level":1,"parent_id":0,"name":"西藏自治区","id":41103},{"level":1,"parent_id":0,"name":"陕西省","id":41877},{"level":1,"parent_id":0,"name":"甘肃省","id":43776},{"level":1,"parent_id":0,"name":"青海省","id":45286},{"level":1,"parent_id":0,"name":"宁夏回族自治区","id":45753},{"level":1,"parent_id":0,"name":"新疆维吾尔自治区","id":46047},{"level":1,"parent_id":0,"name":"台湾省","id":47493},{"level":1,"parent_id":0,"name":"香港特别行政区","id":47494},{"level":1,"parent_id":0,"name":"澳门特别行政区","id":47495}]
     */
    private List<Address_selectEntity> address_select;

    public void setAddress_select(List<Address_selectEntity> address_select) {
        this.address_select = address_select;
    }

    public List<Address_selectEntity> getAddress_select() {
        return address_select;
    }

    public class Address_selectEntity {
        /**
         * level : 1
         * parent_id : 0
         * name : 北京市
         * id : 1
         */
        private int level;
        private int parent_id;
        private String name;
        private int id;

        public void setLevel(int level) {
            this.level = level;
        }

        public void setParent_id(int parent_id) {
            this.parent_id = parent_id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLevel() {
            return level;
        }

        public int getParent_id() {
            return parent_id;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Address_selectEntity{" +
                    "level=" + level +
                    ", parent_id=" + parent_id +
                    ", name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
    }
}



