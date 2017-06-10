package com.kymart.shop.Bean;

import java.util.List;

/**
 * Created by PC on 2017/6/8.
 */

public class mainLike {

    /**
     * status : 1
     * msg : 获取成功
     * result : {"favourite_goods":[{"goods_id":143,"goods_name":"haier海尔 BC-93TMPF 93升单门冰箱","shop_price":"699.00","cat_id3":100},{"goods_id":142,"goods_name":"海尔（Haier）BCD-251WDGW 251升 无霜两门冰箱（白色）","shop_price":"2699.00","cat_id3":194},{"goods_id":131,"goods_name":"【蚂蚁摄影】单反外观Sony/索尼 DSC-H400高清长焦射月数码照相机","shop_price":"1698.00","cat_id3":103},{"goods_id":130,"goods_name":"Nikon/尼康 D7200套机(18-140mm) 尼康D7200 单反相机 正品","shop_price":"6340.00","cat_id3":103},{"goods_id":129,"goods_name":"【蚂蚁摄影】Canon/佳能 PowerShot SX410 IS 媲单反长焦数码相机","shop_price":"1098.00","cat_id3":103},{"goods_id":127,"goods_name":"Canon/佳能 EOS 70D套机(18-135mm)数码相机单反套机 苏宁易购","shop_price":"6798.00","cat_id3":103},{"goods_id":126,"goods_name":"Canon/佳能 EOS 700D套机（18-55mm)数码单反相机 苏宁易购","shop_price":"3499.00","cat_id3":103},{"goods_id":125,"goods_name":"【0首付分期】蚂蚁摄影联保单反数码相机Canon/佳能 EOS 760D套机","shop_price":"5499.00","cat_id3":103},{"goods_id":124,"goods_name":"Nikon/尼康D3300入门单反相机 升级版AF-P 18-55镜头套机 分期购","shop_price":"100.00","cat_id3":104},{"goods_id":123,"goods_name":"Canon/佳能 EOS 750D单反套机（18-55mm）高清数码相机苏宁易购","shop_price":"3997.00","cat_id3":103}]}
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
        private List<FavouriteGoodsBean> favourite_goods;

        public List<FavouriteGoodsBean> getFavourite_goods() {
            return favourite_goods;
        }

        public void setFavourite_goods(List<FavouriteGoodsBean> favourite_goods) {
            this.favourite_goods = favourite_goods;
        }

        public static class FavouriteGoodsBean {
            /**
             * goods_id : 143
             * goods_name : haier海尔 BC-93TMPF 93升单门冰箱
             * shop_price : 699.00
             * cat_id3 : 100
             */

            private int goods_id;
            private String goods_name;
            private String shop_price;
            private int cat_id3;

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
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

            public int getCat_id3() {
                return cat_id3;
            }

            public void setCat_id3(int cat_id3) {
                this.cat_id3 = cat_id3;
            }
        }
    }
}
