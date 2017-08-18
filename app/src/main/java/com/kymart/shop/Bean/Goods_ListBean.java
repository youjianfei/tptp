package com.kymart.shop.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/9.
 */

public class Goods_ListBean {

    /**
     * status : 1
     * msg : 获取成功
     * result : {"goods_list":[{"goods_id":159,"cat_id3":100,"goods_sn":"P0000122323","goods_name":"魅族 MX5 16GB 灰色 移动联通双4G手机 双卡双待","shop_price":"1999.00","comment_count":0,"good_comment_rate":100},{"goods_id":104,"cat_id3":100,"goods_sn":"TP0000104","goods_name":"小米手机5,十余项黑科技，很轻狠快","shop_price":"1999.00","comment_count":5,"good_comment_rate":80},{"goods_id":65,"cat_id3":100,"goods_sn":"TP0000065","goods_name":"长虹(CHANGHONG) 49A1U 49英寸双64位4K超清智能网络LED液晶电视","shop_price":"2799.00","comment_count":3,"good_comment_rate":100},{"goods_id":133,"cat_id3":108,"goods_sn":"TP0000133","goods_name":"电信手机卡 电信4G流量卡全国通用手机号码卡选号电话卡上网卡","shop_price":"100.00","comment_count":0,"good_comment_rate":0},{"goods_id":132,"cat_id3":108,"goods_sn":"TP0000132","goods_name":"中国电信4G号卡手机卡电话卡上网卡177号段套餐可选 预存1200全返","shop_price":"1200.00","comment_count":0,"good_comment_rate":0},{"goods_id":131,"cat_id3":103,"goods_sn":"TP0000131","goods_name":"【蚂蚁摄影】单反外观Sony/索尼 DSC-H400高清长焦射月数码照相机","shop_price":"1698.00","comment_count":0,"good_comment_rate":50},{"goods_id":130,"cat_id3":103,"goods_sn":"TP0000130","goods_name":"Nikon/尼康 D7200套机(18-140mm) 尼康D7200 单反相机 正品","shop_price":"6340.00","comment_count":0,"good_comment_rate":0},{"goods_id":129,"cat_id3":103,"goods_sn":"TP0000129","goods_name":"【蚂蚁摄影】Canon/佳能 PowerShot SX410 IS 媲单反长焦数码相机","shop_price":"1098.00","comment_count":0,"good_comment_rate":0},{"goods_id":127,"cat_id3":103,"goods_sn":"TP0000127","goods_name":"Canon/佳能 EOS 70D套机(18-135mm)数码相机单反套机 苏宁易购","shop_price":"6798.00","comment_count":0,"good_comment_rate":50},{"goods_id":126,"cat_id3":103,"goods_sn":"TP0000126","goods_name":"Canon/佳能 EOS 700D套机（18-55mm)数码单反相机 苏宁易购","shop_price":"3499.00","comment_count":0,"good_comment_rate":50}],"filter_attr":[{"name":"内存容量","item":[{"name":"16G","href":"/index.php/api/Goods/goodsList/id/1/attr/68_16G","id":1},{"name":"64G","href":"/index.php/api/Goods/goodsList/id/1/attr/68_64G","id":2},{"name":"8G","href":"/index.php/api/Goods/goodsList/id/1/attr/68_8G","id":3}]},{"name":"操作系统","item":[{"name":"EMUI 3.1（兼容Android 5.1）","href":"/index.php/api/Goods/goodsList/id/1/attr/69_EMUI 3.1（兼容Android 5.1）","id":4},{"name":"华为 EMUI 3.1（兼容 Android 5.0）","href":"/index.php/api/Goods/goodsList/id/1/attr/69_华为 EMUI 3.1（兼容 Android 5.0）","id":5},{"name":"华为 EMUI 4.0（兼容Android 6.0）","href":"/index.php/api/Goods/goodsList/id/1/attr/69_华为 EMUI 4.0（兼容Android 6.0）","id":6},{"name":"IOS","href":"/index.php/api/Goods/goodsList/id/1/attr/69_IOS","id":7},{"name":"android4.0","href":"/index.php/api/Goods/goodsList/id/1/attr/69_android4.0","id":8}]},{"name":"上市日期","item":[{"name":"2008年06月","href":"/index.php/api/Goods/goodsList/id/1/attr/172_2008年06月","id":9}]},{"name":"颜色","item":[{"name":"黑色","href":"/index.php/api/Goods/goodsList/id/1/attr/185_黑色","id":10}]},{"name":"屏幕颜色","item":[{"name":"1600万","href":"/index.php/api/Goods/goodsList/id/1/attr/186_1600万","id":11}]},{"name":"屏幕分辨率","item":[{"name":"176x220 像素","href":"/index.php/api/Goods/goodsList/id/1/attr/188_176x220 像素","id":12}]},{"name":"产品名称","item":[{"name":"科智 50000","href":"/index.php/api/Goods/goodsList/id/1/attr/321_科智 50000","id":13}]},{"name":"品牌","item":[{"name":"科智","href":"/index.php/api/Goods/goodsList/id/1/attr/322_科智","id":14}]},{"name":"电池容量","item":[{"name":"20000mAh","href":"/index.php/api/Goods/goodsList/id/1/attr/323_20000mAh","id":15}]},{"name":"品牌","item":[{"name":"佳能","href":"/index.php/api/Goods/goodsList/id/1/attr/324_佳能","id":16}]},{"name":"单反级别","item":[{"name":"入门级","href":"/index.php/api/Goods/goodsList/id/1/attr/325_入门级","id":17},{"name":"中级","href":"/index.php/api/Goods/goodsList/id/1/attr/325_中级","id":18}]},{"name":"屏幕尺寸","item":[{"name":"3英寸","href":"/index.php/api/Goods/goodsList/id/1/attr/326_3英寸","id":19}]},{"name":"储存介质","item":[{"name":"SD卡","href":"/index.php/api/Goods/goodsList/id/1/attr/327_SD卡","id":20},{"name":"sd卡","href":"/index.php/api/Goods/goodsList/id/1/attr/327_sd卡","id":21}]},{"name":"像素","item":[{"name":"2416万","href":"/index.php/api/Goods/goodsList/id/1/attr/328_2416万","id":22},{"name":"2020万","href":"/index.php/api/Goods/goodsList/id/1/attr/328_2020万","id":23},{"name":"2000万","href":"/index.php/api/Goods/goodsList/id/1/attr/328_2000万","id":24}]},{"name":"手机制式","item":[{"name":"GSM,850,900,1800,1900","href":"/index.php/api/Goods/goodsList/id/1/attr/173_GSM,850,900,1800,1900","id":25}]},{"name":"外观样式","item":[{"name":"翻盖","href":"/index.php/api/Goods/goodsList/id/1/attr/178_翻盖","id":26}]}],"filter_brand":[{"name":"现代/HYUNDAI","hreg":"/index.php/api/Goods/goodsList/id/1/brand_id/17","id":27},{"name":"小米","hreg":"/index.php/api/Goods/goodsList/id/1/brand_id/349","id":28}],"filter_price":[{"name":"1360元以下","href":"/index.php/api/Goods/goodsList/id/1/price/0-1360","id":29},{"name":"1360-2720元","href":"/index.php/api/Goods/goodsList/id/1/price/1360-2720","id":30},{"name":"2720-4080元","href":"/index.php/api/Goods/goodsList/id/1/price/2720-4080","id":31},{"name":"4080-5440元","href":"/index.php/api/Goods/goodsList/id/1/price/4080-5440","id":32},{"name":"5440-6800元","href":"/index.php/api/Goods/goodsList/id/1/price/5440-6800","id":33}],"sort":"is_new","sort_asc":"desc","orderby_default":"/index.php/api/Goods/goodsList/id/1","orderby_sales_sum":"/index.php/api/Goods/goodsList/id/1/sort/sales_sum/sort_asc/desc","orderby_price":"/index.php/api/Goods/goodsList/id/1/sort/shop_price/sort_asc/asc","orderby_comment_count":"/index.php/api/Goods/goodsList/id/1/sort/comment_count/sort_asc/desc","orderby_is_new":"/index.php/api/Goods/goodsList/id/1/sort/is_new/sort_asc/desc"}
     */

    private int status;
    private String msg;
    private ResultBean result;
    private int search_kt;

    public int getSearch_kt() {
        return search_kt;
    }

    public void setSearch_kt(int search_kt) {
        this.search_kt = search_kt;
    }

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
         * goods_list : [{"goods_id":159,"cat_id3":100,"goods_sn":"P0000122323","goods_name":"魅族 MX5 16GB 灰色 移动联通双4G手机 双卡双待","shop_price":"1999.00","comment_count":0,"good_comment_rate":100},{"goods_id":104,"cat_id3":100,"goods_sn":"TP0000104","goods_name":"小米手机5,十余项黑科技，很轻狠快","shop_price":"1999.00","comment_count":5,"good_comment_rate":80},{"goods_id":65,"cat_id3":100,"goods_sn":"TP0000065","goods_name":"长虹(CHANGHONG) 49A1U 49英寸双64位4K超清智能网络LED液晶电视","shop_price":"2799.00","comment_count":3,"good_comment_rate":100},{"goods_id":133,"cat_id3":108,"goods_sn":"TP0000133","goods_name":"电信手机卡 电信4G流量卡全国通用手机号码卡选号电话卡上网卡","shop_price":"100.00","comment_count":0,"good_comment_rate":0},{"goods_id":132,"cat_id3":108,"goods_sn":"TP0000132","goods_name":"中国电信4G号卡手机卡电话卡上网卡177号段套餐可选 预存1200全返","shop_price":"1200.00","comment_count":0,"good_comment_rate":0},{"goods_id":131,"cat_id3":103,"goods_sn":"TP0000131","goods_name":"【蚂蚁摄影】单反外观Sony/索尼 DSC-H400高清长焦射月数码照相机","shop_price":"1698.00","comment_count":0,"good_comment_rate":50},{"goods_id":130,"cat_id3":103,"goods_sn":"TP0000130","goods_name":"Nikon/尼康 D7200套机(18-140mm) 尼康D7200 单反相机 正品","shop_price":"6340.00","comment_count":0,"good_comment_rate":0},{"goods_id":129,"cat_id3":103,"goods_sn":"TP0000129","goods_name":"【蚂蚁摄影】Canon/佳能 PowerShot SX410 IS 媲单反长焦数码相机","shop_price":"1098.00","comment_count":0,"good_comment_rate":0},{"goods_id":127,"cat_id3":103,"goods_sn":"TP0000127","goods_name":"Canon/佳能 EOS 70D套机(18-135mm)数码相机单反套机 苏宁易购","shop_price":"6798.00","comment_count":0,"good_comment_rate":50},{"goods_id":126,"cat_id3":103,"goods_sn":"TP0000126","goods_name":"Canon/佳能 EOS 700D套机（18-55mm)数码单反相机 苏宁易购","shop_price":"3499.00","comment_count":0,"good_comment_rate":50}]
         * filter_attr : [{"name":"内存容量","item":[{"name":"16G","href":"/index.php/api/Goods/goodsList/id/1/attr/68_16G","id":1},{"name":"64G","href":"/index.php/api/Goods/goodsList/id/1/attr/68_64G","id":2},{"name":"8G","href":"/index.php/api/Goods/goodsList/id/1/attr/68_8G","id":3}]},{"name":"操作系统","item":[{"name":"EMUI 3.1（兼容Android 5.1）","href":"/index.php/api/Goods/goodsList/id/1/attr/69_EMUI 3.1（兼容Android 5.1）","id":4},{"name":"华为 EMUI 3.1（兼容 Android 5.0）","href":"/index.php/api/Goods/goodsList/id/1/attr/69_华为 EMUI 3.1（兼容 Android 5.0）","id":5},{"name":"华为 EMUI 4.0（兼容Android 6.0）","href":"/index.php/api/Goods/goodsList/id/1/attr/69_华为 EMUI 4.0（兼容Android 6.0）","id":6},{"name":"IOS","href":"/index.php/api/Goods/goodsList/id/1/attr/69_IOS","id":7},{"name":"android4.0","href":"/index.php/api/Goods/goodsList/id/1/attr/69_android4.0","id":8}]},{"name":"上市日期","item":[{"name":"2008年06月","href":"/index.php/api/Goods/goodsList/id/1/attr/172_2008年06月","id":9}]},{"name":"颜色","item":[{"name":"黑色","href":"/index.php/api/Goods/goodsList/id/1/attr/185_黑色","id":10}]},{"name":"屏幕颜色","item":[{"name":"1600万","href":"/index.php/api/Goods/goodsList/id/1/attr/186_1600万","id":11}]},{"name":"屏幕分辨率","item":[{"name":"176x220 像素","href":"/index.php/api/Goods/goodsList/id/1/attr/188_176x220 像素","id":12}]},{"name":"产品名称","item":[{"name":"科智 50000","href":"/index.php/api/Goods/goodsList/id/1/attr/321_科智 50000","id":13}]},{"name":"品牌","item":[{"name":"科智","href":"/index.php/api/Goods/goodsList/id/1/attr/322_科智","id":14}]},{"name":"电池容量","item":[{"name":"20000mAh","href":"/index.php/api/Goods/goodsList/id/1/attr/323_20000mAh","id":15}]},{"name":"品牌","item":[{"name":"佳能","href":"/index.php/api/Goods/goodsList/id/1/attr/324_佳能","id":16}]},{"name":"单反级别","item":[{"name":"入门级","href":"/index.php/api/Goods/goodsList/id/1/attr/325_入门级","id":17},{"name":"中级","href":"/index.php/api/Goods/goodsList/id/1/attr/325_中级","id":18}]},{"name":"屏幕尺寸","item":[{"name":"3英寸","href":"/index.php/api/Goods/goodsList/id/1/attr/326_3英寸","id":19}]},{"name":"储存介质","item":[{"name":"SD卡","href":"/index.php/api/Goods/goodsList/id/1/attr/327_SD卡","id":20},{"name":"sd卡","href":"/index.php/api/Goods/goodsList/id/1/attr/327_sd卡","id":21}]},{"name":"像素","item":[{"name":"2416万","href":"/index.php/api/Goods/goodsList/id/1/attr/328_2416万","id":22},{"name":"2020万","href":"/index.php/api/Goods/goodsList/id/1/attr/328_2020万","id":23},{"name":"2000万","href":"/index.php/api/Goods/goodsList/id/1/attr/328_2000万","id":24}]},{"name":"手机制式","item":[{"name":"GSM,850,900,1800,1900","href":"/index.php/api/Goods/goodsList/id/1/attr/173_GSM,850,900,1800,1900","id":25}]},{"name":"外观样式","item":[{"name":"翻盖","href":"/index.php/api/Goods/goodsList/id/1/attr/178_翻盖","id":26}]}]
         * filter_brand : [{"name":"现代/HYUNDAI","hreg":"/index.php/api/Goods/goodsList/id/1/brand_id/17","id":27},{"name":"小米","hreg":"/index.php/api/Goods/goodsList/id/1/brand_id/349","id":28}]
         * filter_price : [{"name":"1360元以下","href":"/index.php/api/Goods/goodsList/id/1/price/0-1360","id":29},{"name":"1360-2720元","href":"/index.php/api/Goods/goodsList/id/1/price/1360-2720","id":30},{"name":"2720-4080元","href":"/index.php/api/Goods/goodsList/id/1/price/2720-4080","id":31},{"name":"4080-5440元","href":"/index.php/api/Goods/goodsList/id/1/price/4080-5440","id":32},{"name":"5440-6800元","href":"/index.php/api/Goods/goodsList/id/1/price/5440-6800","id":33}]
         * sort : is_new
         * sort_asc : desc
         * orderby_default : /index.php/api/Goods/goodsList/id/1
         * orderby_sales_sum : /index.php/api/Goods/goodsList/id/1/sort/sales_sum/sort_asc/desc
         * orderby_price : /index.php/api/Goods/goodsList/id/1/sort/shop_price/sort_asc/asc
         * orderby_comment_count : /index.php/api/Goods/goodsList/id/1/sort/comment_count/sort_asc/desc
         * orderby_is_new : /index.php/api/Goods/goodsList/id/1/sort/is_new/sort_asc/desc
         */

        private String sort;
        private String sort_asc;
        private String orderby_default;
        private String orderby_sales_sum;
        private String orderby_price;
        private String orderby_comment_count;
        private String orderby_is_new;
        private List<GoodsListBean> goods_list;
        private List<FilterAttrBean> filter_attr;
        private List<FilterBrandBean> filter_brand;
        private List<FilterPriceBean> filter_price;

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getSort_asc() {
            return sort_asc;
        }

        public void setSort_asc(String sort_asc) {
            this.sort_asc = sort_asc;
        }

        public String getOrderby_default() {
            return orderby_default;
        }

        public void setOrderby_default(String orderby_default) {
            this.orderby_default = orderby_default;
        }

        public String getOrderby_sales_sum() {
            return orderby_sales_sum;
        }

        public void setOrderby_sales_sum(String orderby_sales_sum) {
            this.orderby_sales_sum = orderby_sales_sum;
        }

        public String getOrderby_price() {
            return orderby_price;
        }

        public void setOrderby_price(String orderby_price) {
            this.orderby_price = orderby_price;
        }

        public String getOrderby_comment_count() {
            return orderby_comment_count;
        }

        public void setOrderby_comment_count(String orderby_comment_count) {
            this.orderby_comment_count = orderby_comment_count;
        }

        public String getOrderby_is_new() {
            return orderby_is_new;
        }

        public void setOrderby_is_new(String orderby_is_new) {
            this.orderby_is_new = orderby_is_new;
        }

        public List<GoodsListBean> getGoods_list() {
            return goods_list;
        }

        public void setGoods_list(List<GoodsListBean> goods_list) {
            this.goods_list = goods_list;
        }

        public List<FilterAttrBean> getFilter_attr() {
            return filter_attr;
        }

        public void setFilter_attr(List<FilterAttrBean> filter_attr) {
            this.filter_attr = filter_attr;
        }

        public List<FilterBrandBean> getFilter_brand() {
            return filter_brand;
        }

        public void setFilter_brand(List<FilterBrandBean> filter_brand) {
            this.filter_brand = filter_brand;
        }

        public List<FilterPriceBean> getFilter_price() {
            return filter_price;
        }

        public void setFilter_price(List<FilterPriceBean> filter_price) {
            this.filter_price = filter_price;
        }

        public static class GoodsListBean {
            /**
             * goods_id : 159
             * cat_id3 : 100
             * goods_sn : P0000122323
             * goods_name : 魅族 MX5 16GB 灰色 移动联通双4G手机 双卡双待
             * shop_price : 1999.00
             * comment_count : 0
             * good_comment_rate : 100
             */

            private int goods_id;
            private int ky_type;
            private int cat_id3;
            private String goods_sn;
            private String goods_name;
            private String shop_price;
            private int comment_count;
            private int good_comment_rate;

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public int getCat_id3() {
                return cat_id3;
            }

            public void setCat_id3(int cat_id3) {
                this.cat_id3 = cat_id3;
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

            public String getShop_price() {
                return shop_price;
            }

            public void setShop_price(String shop_price) {
                this.shop_price = shop_price;
            }

            public int getComment_count() {
                return comment_count;
            }

            public void setComment_count(int comment_count) {
                this.comment_count = comment_count;
            }

            public int getGood_comment_rate() {
                return good_comment_rate;
            }

            public void setGood_comment_rate(int good_comment_rate) {
                this.good_comment_rate = good_comment_rate;
            }

            public int getKy_type() {
                return ky_type;
            }

            public void setKy_type(int ky_type) {
                this.ky_type = ky_type;
            }
        }

        public static class FilterAttrBean {
            /**
             * name : 内存容量
             * item : [{"name":"16G","href":"/index.php/api/Goods/goodsList/id/1/attr/68_16G","id":1},{"name":"64G","href":"/index.php/api/Goods/goodsList/id/1/attr/68_64G","id":2},{"name":"8G","href":"/index.php/api/Goods/goodsList/id/1/attr/68_8G","id":3}]
             */

            private String name;
            private List<ItemBean> item;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<ItemBean> getItem() {
                return item;
            }

            public void setItem(List<ItemBean> item) {
                this.item = item;
            }

            public static class ItemBean {
                /**
                 * name : 16G
                 * href : /index.php/api/Goods/goodsList/id/1/attr/68_16G
                 * id : 1
                 */

                private String name;
                private String href;
                private int id;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getHref() {
                    return href;
                }

                public void setHref(String href) {
                    this.href = href;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }
            }
        }

        public static class FilterBrandBean {
            /**
             * name : 现代/HYUNDAI
             * hreg : /index.php/api/Goods/goodsList/id/1/brand_id/17
             * id : 27
             */

            private String name;
            private String hreg;
            private int id;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getHreg() {
                return hreg;
            }

            public void setHreg(String hreg) {
                this.hreg = hreg;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class FilterPriceBean {
            /**
             * name : 1360元以下
             * href : /index.php/api/Goods/goodsList/id/1/price/0-1360
             * id : 29
             */

            private String name;
            private String href;
            private int id;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
