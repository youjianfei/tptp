/**
  * Copyright 2017 aTool.org 
  */
package com.kymart.shop.Bean;

import java.util.List;

/**
 * Auto-generated: 2017-06-13 11:2:17
 *
 * @author aTool.org (i@aTool.org)
 * @website http://www.atool.org/json2javabean.php
 */
public class GoodDetailsBean {

    private int status;
    private String msg;
    private Result result;
    public void setStatus(int status) {
         this.status = status;
     }
     public int getStatus() {
         return status;
     }

    public void setMsg(String msg) {
         this.msg = msg;
     }
     public String getMsg() {
         return msg;
     }

    public void setResult(Result result) {
         this.result = result;
     }
     public Result getResult() {
         return result;
     }

    public  static class Result {

        private List<String> activity;
        private Store store;
        private Goods goods;
        private List<SpecGoodsPrice> spec_goods_price;
        private List<Gallery> gallery;
        private List<Comment> comment;
        private List<RecommendGoods> recommend_goods;
        private Statistics statistics;
        public void setActivity(List<String> activity) {
            this.activity = activity;
        }
        public List<String> getActivity() {
            return activity;
        }

        public void setStore(Store store) {
            this.store = store;
        }
        public Store getStore() {
            return store;
        }

        public List<SpecGoodsPrice> getSpec_goods_price() {
            return spec_goods_price;
        }

        public void setSpec_goods_price(List<SpecGoodsPrice> spec_goods_price) {
            this.spec_goods_price = spec_goods_price;
        }

        public void setGoods(Goods goods) {
            this.goods = goods;
        }
        public Goods getGoods() {
            return goods;
        }



        public void setGallery(List<Gallery> gallery) {
            this.gallery = gallery;
        }
        public List<Gallery> getGallery() {
            return gallery;
        }

        public void setComment(List<Comment> comment) {
            this.comment = comment;
        }
        public List<Comment> getComment() {
            return comment;
        }

        public List<RecommendGoods> getRecommend_goods() {
            return recommend_goods;
        }

        public void setRecommend_goods(List<RecommendGoods> recommend_goods) {
            this.recommend_goods = recommend_goods;
        }

        public void setStatistics(Statistics statistics) {
            this.statistics = statistics;
        }
        public Statistics getStatistics() {
            return statistics;
        }

        public static class Store {

            private int store_id;
            private String store_name;
            private int grade_id;
            private int user_id;
            private String user_name;
            private String seller_name;
            private int sc_id;
            private String company_name;
            private int province_id;
            private int city_id;
            private int district;
            private String store_address;
            private String longitude;
            private String latitude;
            private String store_Zip;
            private int store_State;
            private String store_CloseInfo;
            private int store_Sort;
            private String store_Rebate_Paytime;
            private String store_Time;
            private String store_End_Time;
            private String store_Logo;
            private String store_Banner;
            private String store_Avatar;
            private String seo_Keywords;
            private String seo_Description;
            private String store_Aliwangwang;
            private String store_Qq;
            private String store_Phone;
            private String store_Zy;
            private String store_Domain;
            private int store_Recommend;
            private String store_Theme;
            private int store_Credit;
            private String store_Desccredit;
            private String store_Servicecredit;
            private String store_Deliverycredit;
            private int store_Collect;
            private String store_Slide;
            private String store_SlideUrl;
            private String store_Printdesc;
            private int store_Sales;
            private String store_Presales;
            private String store_Aftersales;
            private String store_Workingtime;
            private String store_FreePrice;
            private int store_Warning_Storage;
            private int store_Decoration_Switch;
            private int store_DecorationOnly;
            private int is_Own_Shop;
            private int bind_All_Gc;
            private int qitian;
            private int certified;
            private int returned;
            private String store_Free_Time;
            private String mb_Slide;
            private String mb_Slide_Url;
            private String deliver_Region;
            private int cod;
            private int two_Hour;
            private int ensure;
            private String deposit;
            private int deposit_Icon;
            private String store_Money;
            private String pending_Money;
            private int deleted;
            private int goods_Examine;
            private String service_Phone;

            public int getStore_id() {
                return store_id;
            }

            public void setStore_id(int store_id) {
                this.store_id = store_id;
            }

            public String getStore_name() {
                return store_name;
            }

            public void setStore_name(String store_name) {
                this.store_name = store_name;
            }

            public int getGrade_id() {
                return grade_id;
            }

            public void setGrade_id(int grade_id) {
                this.grade_id = grade_id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public String getSeller_name() {
                return seller_name;
            }

            public void setSeller_name(String seller_name) {
                this.seller_name = seller_name;
            }

            public int getSc_id() {
                return sc_id;
            }

            public void setSc_id(int sc_id) {
                this.sc_id = sc_id;
            }

            public String getCompany_name() {
                return company_name;
            }

            public void setCompany_name(String company_name) {
                this.company_name = company_name;
            }

            public int getProvince_id() {
                return province_id;
            }

            public void setProvince_id(int province_id) {
                this.province_id = province_id;
            }

            public int getCity_id() {
                return city_id;
            }

            public void setCity_id(int city_id) {
                this.city_id = city_id;
            }

            public int getDistrict() {
                return district;
            }

            public void setDistrict(int district) {
                this.district = district;
            }

            public String getStore_address() {
                return store_address;
            }

            public void setStore_address(String store_address) {
                this.store_address = store_address;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getStore_Zip() {
                return store_Zip;
            }

            public void setStore_Zip(String store_Zip) {
                this.store_Zip = store_Zip;
            }

            public int getStore_State() {
                return store_State;
            }

            public void setStore_State(int store_State) {
                this.store_State = store_State;
            }

            public String getStore_CloseInfo() {
                return store_CloseInfo;
            }

            public void setStore_CloseInfo(String store_CloseInfo) {
                this.store_CloseInfo = store_CloseInfo;
            }

            public int getStore_Sort() {
                return store_Sort;
            }

            public void setStore_Sort(int store_Sort) {
                this.store_Sort = store_Sort;
            }

            public String getStore_Rebate_Paytime() {
                return store_Rebate_Paytime;
            }

            public void setStore_Rebate_Paytime(String store_Rebate_Paytime) {
                this.store_Rebate_Paytime = store_Rebate_Paytime;
            }

            public String getStore_Time() {
                return store_Time;
            }

            public void setStore_Time(String store_Time) {
                this.store_Time = store_Time;
            }

            public String getStore_End_Time() {
                return store_End_Time;
            }

            public void setStore_End_Time(String store_End_Time) {
                this.store_End_Time = store_End_Time;
            }

            public String getStore_Logo() {
                return store_Logo;
            }

            public void setStore_Logo(String store_Logo) {
                this.store_Logo = store_Logo;
            }

            public String getStore_Banner() {
                return store_Banner;
            }

            public void setStore_Banner(String store_Banner) {
                this.store_Banner = store_Banner;
            }

            public String getStore_Avatar() {
                return store_Avatar;
            }

            public void setStore_Avatar(String store_Avatar) {
                this.store_Avatar = store_Avatar;
            }

            public String getSeo_Keywords() {
                return seo_Keywords;
            }

            public void setSeo_Keywords(String seo_Keywords) {
                this.seo_Keywords = seo_Keywords;
            }

            public String getSeo_Description() {
                return seo_Description;
            }

            public void setSeo_Description(String seo_Description) {
                this.seo_Description = seo_Description;
            }

            public String getStore_Aliwangwang() {
                return store_Aliwangwang;
            }

            public void setStore_Aliwangwang(String store_Aliwangwang) {
                this.store_Aliwangwang = store_Aliwangwang;
            }

            public String getStore_Qq() {
                return store_Qq;
            }

            public void setStore_Qq(String store_Qq) {
                this.store_Qq = store_Qq;
            }

            public String getStore_Phone() {
                return store_Phone;
            }

            public void setStore_Phone(String store_Phone) {
                this.store_Phone = store_Phone;
            }

            public String getStore_Zy() {
                return store_Zy;
            }

            public void setStore_Zy(String store_Zy) {
                this.store_Zy = store_Zy;
            }

            public String getStore_Domain() {
                return store_Domain;
            }

            public void setStore_Domain(String store_Domain) {
                this.store_Domain = store_Domain;
            }

            public int getStore_Recommend() {
                return store_Recommend;
            }

            public void setStore_Recommend(int store_Recommend) {
                this.store_Recommend = store_Recommend;
            }

            public String getStore_Theme() {
                return store_Theme;
            }

            public void setStore_Theme(String store_Theme) {
                this.store_Theme = store_Theme;
            }

            public int getStore_Credit() {
                return store_Credit;
            }

            public void setStore_Credit(int store_Credit) {
                this.store_Credit = store_Credit;
            }

            public String getStore_Desccredit() {
                return store_Desccredit;
            }

            public void setStore_Desccredit(String store_Desccredit) {
                this.store_Desccredit = store_Desccredit;
            }

            public String getStore_Servicecredit() {
                return store_Servicecredit;
            }

            public void setStore_Servicecredit(String store_Servicecredit) {
                this.store_Servicecredit = store_Servicecredit;
            }

            public String getStore_Deliverycredit() {
                return store_Deliverycredit;
            }

            public void setStore_Deliverycredit(String store_Deliverycredit) {
                this.store_Deliverycredit = store_Deliverycredit;
            }

            public int getStore_Collect() {
                return store_Collect;
            }

            public void setStore_Collect(int store_Collect) {
                this.store_Collect = store_Collect;
            }

            public String getStore_Slide() {
                return store_Slide;
            }

            public void setStore_Slide(String store_Slide) {
                this.store_Slide = store_Slide;
            }

            public String getStore_SlideUrl() {
                return store_SlideUrl;
            }

            public void setStore_SlideUrl(String store_SlideUrl) {
                this.store_SlideUrl = store_SlideUrl;
            }

            public String getStore_Printdesc() {
                return store_Printdesc;
            }

            public void setStore_Printdesc(String store_Printdesc) {
                this.store_Printdesc = store_Printdesc;
            }

            public int getStore_Sales() {
                return store_Sales;
            }

            public void setStore_Sales(int store_Sales) {
                this.store_Sales = store_Sales;
            }

            public String getStore_Presales() {
                return store_Presales;
            }

            public void setStore_Presales(String store_Presales) {
                this.store_Presales = store_Presales;
            }

            public String getStore_Aftersales() {
                return store_Aftersales;
            }

            public void setStore_Aftersales(String store_Aftersales) {
                this.store_Aftersales = store_Aftersales;
            }

            public String getStore_Workingtime() {
                return store_Workingtime;
            }

            public void setStore_Workingtime(String store_Workingtime) {
                this.store_Workingtime = store_Workingtime;
            }

            public String getStore_FreePrice() {
                return store_FreePrice;
            }

            public void setStore_FreePrice(String store_FreePrice) {
                this.store_FreePrice = store_FreePrice;
            }

            public int getStore_Warning_Storage() {
                return store_Warning_Storage;
            }

            public void setStore_Warning_Storage(int store_Warning_Storage) {
                this.store_Warning_Storage = store_Warning_Storage;
            }

            public int getStore_Decoration_Switch() {
                return store_Decoration_Switch;
            }

            public void setStore_Decoration_Switch(int store_Decoration_Switch) {
                this.store_Decoration_Switch = store_Decoration_Switch;
            }

            public int getStore_DecorationOnly() {
                return store_DecorationOnly;
            }

            public void setStore_DecorationOnly(int store_DecorationOnly) {
                this.store_DecorationOnly = store_DecorationOnly;
            }

            public int getIs_Own_Shop() {
                return is_Own_Shop;
            }

            public void setIs_Own_Shop(int is_Own_Shop) {
                this.is_Own_Shop = is_Own_Shop;
            }

            public int getBind_All_Gc() {
                return bind_All_Gc;
            }

            public void setBind_All_Gc(int bind_All_Gc) {
                this.bind_All_Gc = bind_All_Gc;
            }

            public int getQitian() {
                return qitian;
            }

            public void setQitian(int qitian) {
                this.qitian = qitian;
            }

            public int getCertified() {
                return certified;
            }

            public void setCertified(int certified) {
                this.certified = certified;
            }

            public int getReturned() {
                return returned;
            }

            public void setReturned(int returned) {
                this.returned = returned;
            }

            public String getStore_Free_Time() {
                return store_Free_Time;
            }

            public void setStore_Free_Time(String store_Free_Time) {
                this.store_Free_Time = store_Free_Time;
            }

            public String getMb_Slide() {
                return mb_Slide;
            }

            public void setMb_Slide(String mb_Slide) {
                this.mb_Slide = mb_Slide;
            }

            public String getMb_Slide_Url() {
                return mb_Slide_Url;
            }

            public void setMb_Slide_Url(String mb_Slide_Url) {
                this.mb_Slide_Url = mb_Slide_Url;
            }

            public String getDeliver_Region() {
                return deliver_Region;
            }

            public void setDeliver_Region(String deliver_Region) {
                this.deliver_Region = deliver_Region;
            }

            public int getCod() {
                return cod;
            }

            public void setCod(int cod) {
                this.cod = cod;
            }

            public int getTwo_Hour() {
                return two_Hour;
            }

            public void setTwo_Hour(int two_Hour) {
                this.two_Hour = two_Hour;
            }

            public int getEnsure() {
                return ensure;
            }

            public void setEnsure(int ensure) {
                this.ensure = ensure;
            }

            public String getDeposit() {
                return deposit;
            }

            public void setDeposit(String deposit) {
                this.deposit = deposit;
            }

            public int getDeposit_Icon() {
                return deposit_Icon;
            }

            public void setDeposit_Icon(int deposit_Icon) {
                this.deposit_Icon = deposit_Icon;
            }

            public String getStore_Money() {
                return store_Money;
            }

            public void setStore_Money(String store_Money) {
                this.store_Money = store_Money;
            }

            public String getPending_Money() {
                return pending_Money;
            }

            public void setPending_Money(String pending_Money) {
                this.pending_Money = pending_Money;
            }

            public int getDeleted() {
                return deleted;
            }

            public void setDeleted(int deleted) {
                this.deleted = deleted;
            }

            public int getGoods_Examine() {
                return goods_Examine;
            }

            public void setGoods_Examine(int goods_Examine) {
                this.goods_Examine = goods_Examine;
            }

            public String getService_Phone() {
                return service_Phone;
            }

            public void setService_Phone(String service_Phone) {
                this.service_Phone = service_Phone;
            }
        }
        public  static class   Goods {

            private int goods_id;
            private int cat_id1;
            private int cat_id2;
            private int cat_id3;
            private int store_cat_id1;
            private int store_Cat_id2;
            private String goods_sn;
            private String goods_name;
            private int click_count;
            private int brand_id;
            private int store_count;
            private int collect_sum;
            private int comment_count;
            private int weight;
            private String market_price;
            private String shop_price;
            private String cost_price;
            private int exchange_integral;
            private String keywords;
            private String goods_remark;
            private String original_img;
            private int is_virtual;
            private int virtual_indate;
            private int virtual_limit;
            private int virtual_refund;
            private int is_on_sale;
            private int is_free_shipping;
            private int on_time;
            private int sort;
            private int is_recommend;
            private int is_new;
            private int is_hot;
            private int last_update;
            private int goods_type;
            private int give_integral;
            private int sales_sum;
            private int prom_type;
            private int prom_id;
            private String distribut;
            private int store_id;
            private String spu;
            private String sku;
            private int goods_state;
            private String close_reason;
            private String suppliers_id;
            private String shipping_areaIds;
            private int is_own_shop;
            private int prom_is_able;
            private String goods_attrList;
            private List<GoodsSpecList> goods_spec_list;
            private String goods_content;

            public List<GoodsSpecList> getGoods_spec_list() {
                return goods_spec_list;
            }

            public void setGoods_spec_list(List<GoodsSpecList> goods_spec_list) {
                this.goods_spec_list = goods_spec_list;
            }

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public int getCat_id1() {
                return cat_id1;
            }

            public void setCat_id1(int cat_id1) {
                this.cat_id1 = cat_id1;
            }

            public int getCat_id2() {
                return cat_id2;
            }

            public void setCat_id2(int cat_id2) {
                this.cat_id2 = cat_id2;
            }

            public int getCat_id3() {
                return cat_id3;
            }

            public void setCat_id3(int cat_id3) {
                this.cat_id3 = cat_id3;
            }

            public int getStore_cat_id1() {
                return store_cat_id1;
            }

            public void setStore_cat_id1(int store_cat_id1) {
                this.store_cat_id1 = store_cat_id1;
            }

            public int getStore_Cat_id2() {
                return store_Cat_id2;
            }

            public void setStore_Cat_id2(int store_Cat_id2) {
                this.store_Cat_id2 = store_Cat_id2;
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

            public int getClick_count() {
                return click_count;
            }

            public void setClick_count(int click_count) {
                this.click_count = click_count;
            }

            public int getBrand_id() {
                return brand_id;
            }

            public void setBrand_id(int brand_id) {
                this.brand_id = brand_id;
            }

            public int getStore_count() {
                return store_count;
            }

            public void setStore_count(int store_count) {
                this.store_count = store_count;
            }

            public int getCollect_sum() {
                return collect_sum;
            }

            public void setCollect_sum(int collect_sum) {
                this.collect_sum = collect_sum;
            }

            public int getComment_count() {
                return comment_count;
            }

            public void setComment_count(int comment_count) {
                this.comment_count = comment_count;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            public String getMarket_price() {
                return market_price;
            }

            public void setMarket_price(String market_price) {
                this.market_price = market_price;
            }

            public String getShop_price() {
                return shop_price;
            }

            public void setShop_price(String shop_price) {
                this.shop_price = shop_price;
            }

            public String getCost_price() {
                return cost_price;
            }

            public void setCost_price(String cost_price) {
                this.cost_price = cost_price;
            }

            public int getExchange_integral() {
                return exchange_integral;
            }

            public void setExchange_integral(int exchange_integral) {
                this.exchange_integral = exchange_integral;
            }

            public String getKeywords() {
                return keywords;
            }

            public void setKeywords(String keywords) {
                this.keywords = keywords;
            }

            public String getGoods_remark() {
                return goods_remark;
            }

            public void setGoods_remark(String goods_remark) {
                this.goods_remark = goods_remark;
            }

            public String getOriginal_img() {
                return original_img;
            }

            public void setOriginal_img(String original_img) {
                this.original_img = original_img;
            }

            public int getIs_virtual() {
                return is_virtual;
            }

            public void setIs_virtual(int is_virtual) {
                this.is_virtual = is_virtual;
            }

            public int getVirtual_indate() {
                return virtual_indate;
            }

            public void setVirtual_indate(int virtual_indate) {
                this.virtual_indate = virtual_indate;
            }

            public int getVirtual_limit() {
                return virtual_limit;
            }

            public void setVirtual_limit(int virtual_limit) {
                this.virtual_limit = virtual_limit;
            }

            public int getVirtual_refund() {
                return virtual_refund;
            }

            public void setVirtual_refund(int virtual_refund) {
                this.virtual_refund = virtual_refund;
            }

            public int getIs_on_sale() {
                return is_on_sale;
            }

            public void setIs_on_sale(int is_on_sale) {
                this.is_on_sale = is_on_sale;
            }

            public int getIs_free_shipping() {
                return is_free_shipping;
            }

            public void setIs_free_shipping(int is_free_shipping) {
                this.is_free_shipping = is_free_shipping;
            }

            public int getOn_time() {
                return on_time;
            }

            public void setOn_time(int on_time) {
                this.on_time = on_time;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public int getIs_recommend() {
                return is_recommend;
            }

            public void setIs_recommend(int is_recommend) {
                this.is_recommend = is_recommend;
            }

            public int getIs_new() {
                return is_new;
            }

            public void setIs_new(int is_new) {
                this.is_new = is_new;
            }

            public int getIs_hot() {
                return is_hot;
            }

            public void setIs_hot(int is_hot) {
                this.is_hot = is_hot;
            }

            public int getLast_update() {
                return last_update;
            }

            public void setLast_update(int last_update) {
                this.last_update = last_update;
            }

            public int getGoods_type() {
                return goods_type;
            }

            public void setGoods_type(int goods_type) {
                this.goods_type = goods_type;
            }

            public int getGive_integral() {
                return give_integral;
            }

            public void setGive_integral(int give_integral) {
                this.give_integral = give_integral;
            }

            public int getSales_sum() {
                return sales_sum;
            }

            public void setSales_sum(int sales_sum) {
                this.sales_sum = sales_sum;
            }

            public int getProm_type() {
                return prom_type;
            }

            public void setProm_type(int prom_type) {
                this.prom_type = prom_type;
            }

            public int getProm_id() {
                return prom_id;
            }

            public void setProm_id(int prom_id) {
                this.prom_id = prom_id;
            }

            public String getDistribut() {
                return distribut;
            }

            public void setDistribut(String distribut) {
                this.distribut = distribut;
            }

            public int getStore_id() {
                return store_id;
            }

            public void setStore_id(int store_id) {
                this.store_id = store_id;
            }

            public String getSpu() {
                return spu;
            }

            public void setSpu(String spu) {
                this.spu = spu;
            }

            public String getSku() {
                return sku;
            }

            public void setSku(String sku) {
                this.sku = sku;
            }

            public int getGoods_state() {
                return goods_state;
            }

            public void setGoods_state(int goods_state) {
                this.goods_state = goods_state;
            }

            public String getClose_reason() {
                return close_reason;
            }

            public void setClose_reason(String close_reason) {
                this.close_reason = close_reason;
            }

            public String getSuppliers_id() {
                return suppliers_id;
            }

            public void setSuppliers_id(String suppliers_id) {
                this.suppliers_id = suppliers_id;
            }

            public String getShipping_areaIds() {
                return shipping_areaIds;
            }

            public void setShipping_areaIds(String shipping_areaIds) {
                this.shipping_areaIds = shipping_areaIds;
            }

            public int getIs_own_shop() {
                return is_own_shop;
            }

            public void setIs_own_shop(int is_own_shop) {
                this.is_own_shop = is_own_shop;
            }

            public int getProm_is_able() {
                return prom_is_able;
            }

            public void setProm_is_able(int prom_is_able) {
                this.prom_is_able = prom_is_able;
            }

            public String getGoods_attrList() {
                return goods_attrList;
            }

            public void setGoods_attrList(String goods_attrList) {
                this.goods_attrList = goods_attrList;
            }


            public String getGoods_content() {
                return goods_content;
            }

            public void setGoods_content(String goods_content) {
                this.goods_content = goods_content;
            }

            public static class GoodsSpecList {

                private String spec_name;
                private List<SpecList> spec_list;

                public String getSpec_name() {
                    return spec_name;
                }

                public void setSpec_name(String spec_name) {
                    this.spec_name = spec_name;
                }

                public List<SpecList> getSpec_list() {
                    return spec_list;
                }

                public void setSpec_list(List<SpecList> spec_list) {
                    this.spec_list = spec_list;
                }

                @Override
                public String toString() {
                    return "GoodsSpecList{" +
                            "spec_name='" + spec_name + '\'' +
                            ", spec_list=" + spec_list +
                            '}';
                }

                public  static class SpecList {

                    private int item_id;
                    private String item;
                    private String src;

                    public int getItem_id() {
                        return item_id;
                    }

                    public void setItem_id(int item_id) {
                        this.item_id = item_id;
                    }

                    public void setItem(String item) {
                        this.item = item;
                    }
                    public String getItem() {
                        return item;
                    }

                    public void setSrc(String src) {
                        this.src = src;
                    }
                    public String getSrc() {
                        return src;
                    }

                    @Override
                    public String toString() {
                        return "SpecList{" +
                                "item_id=" + item_id +
                                ", item='" + item + '\'' +
                                ", src='" + src + '\'' +
                                '}';
                    }
                }
            }
        }

        public static class SpecGoodsPrice {

            private String key;
            private String price;
            private int store_count;
            private String key_name;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public int getStore_count() {
                return store_count;
            }

            public void setStore_count(int store_count) {
                this.store_count = store_count;
            }

            public String getKey_name() {
                return key_name;
            }

            public void setKey_name(String key_name) {
                this.key_name = key_name;
            }
        }



        public  static class Gallery {

            private String image_url;

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }
        }
        public static class Comment {

            private int commentId;
            private int goodsId;
            private int orderId;
            private int storeId;
            private int userId;
            private String content;
            private int addTime;
            private String ipAddress;
            private int isShow;
            private String img;
            private String specKeyName;
            private String goodsRank;
            private int zanNum;
            private String zanUserid;
            private int replyNum;
            private int isAnonymous;
            private String impression;
            private int deleted;
            private int parentId;
            public void setCommentId(int commentId) {
                this.commentId = commentId;
            }
            public int getCommentId() {
                return commentId;
            }

            public void setGoodsId(int goodsId) {
                this.goodsId = goodsId;
            }
            public int getGoodsId() {
                return goodsId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }
            public int getOrderId() {
                return orderId;
            }

            public void setStoreId(int storeId) {
                this.storeId = storeId;
            }
            public int getStoreId() {
                return storeId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }
            public int getUserId() {
                return userId;
            }

            public void setContent(String content) {
                this.content = content;
            }
            public String getContent() {
                return content;
            }

            public void setAddTime(int addTime) {
                this.addTime = addTime;
            }
            public int getAddTime() {
                return addTime;
            }

            public void setIpAddress(String ipAddress) {
                this.ipAddress = ipAddress;
            }
            public String getIpAddress() {
                return ipAddress;
            }

            public void setIsShow(int isShow) {
                this.isShow = isShow;
            }
            public int getIsShow() {
                return isShow;
            }

            public void setImg(String img) {
                this.img = img;
            }
            public String getImg() {
                return img;
            }

            public void setSpecKeyName(String specKeyName) {
                this.specKeyName = specKeyName;
            }
            public String getSpecKeyName() {
                return specKeyName;
            }

            public void setGoodsRank(String goodsRank) {
                this.goodsRank = goodsRank;
            }
            public String getGoodsRank() {
                return goodsRank;
            }

            public void setZanNum(int zanNum) {
                this.zanNum = zanNum;
            }
            public int getZanNum() {
                return zanNum;
            }

            public void setZanUserid(String zanUserid) {
                this.zanUserid = zanUserid;
            }
            public String getZanUserid() {
                return zanUserid;
            }

            public void setReplyNum(int replyNum) {
                this.replyNum = replyNum;
            }
            public int getReplyNum() {
                return replyNum;
            }

            public void setIsAnonymous(int isAnonymous) {
                this.isAnonymous = isAnonymous;
            }
            public int getIsAnonymous() {
                return isAnonymous;
            }

            public void setImpression(String impression) {
                this.impression = impression;
            }
            public String getImpression() {
                return impression;
            }

            public void setDeleted(int deleted) {
                this.deleted = deleted;
            }
            public int getDeleted() {
                return deleted;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }
            public int getParentId() {
                return parentId;
            }

        }
        public static class RecommendGoods {

            private int goods_id;
            private String goods_name;
            private String shop_price;

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
        }
        public static class Statistics {

            private int c0;
            private int c1;
            private int c2;
            private int c3;
            private int c4;
            private int rate1;
            private int rate2;
            private int rate3;
            public void setC0(int c0) {
                this.c0 = c0;
            }
            public int getC0() {
                return c0;
            }

            public void setC1(int c1) {
                this.c1 = c1;
            }
            public int getC1() {
                return c1;
            }

            public void setC2(int c2) {
                this.c2 = c2;
            }
            public int getC2() {
                return c2;
            }

            public void setC3(int c3) {
                this.c3 = c3;
            }
            public int getC3() {
                return c3;
            }

            public void setC4(int c4) {
                this.c4 = c4;
            }
            public int getC4() {
                return c4;
            }

            public void setRate1(int rate1) {
                this.rate1 = rate1;
            }
            public int getRate1() {
                return rate1;
            }

            public void setRate2(int rate2) {
                this.rate2 = rate2;
            }
            public int getRate2() {
                return rate2;
            }

            public void setRate3(int rate3) {
                this.rate3 = rate3;
            }
            public int getRate3() {
                return rate3;
            }

        }
    }







}