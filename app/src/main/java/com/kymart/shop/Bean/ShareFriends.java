package com.kymart.shop.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */

public class ShareFriends {

    /**
     * status : 1
     * count : 2
     * list : [{"nickname":"又见飞","user_id":49,"reg_time":1498611867,"head_pic":null},{"nickname":"匿名","user_id":48,"reg_time":1496737916,"head_pic":null}]
     */

    private int status;
    private int count;
    private List<ListBean> list;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * nickname : 又见飞
         * user_id : 49
         * reg_time : 1498611867
         * head_pic : null
         */

        private String nickname;
        private int user_id;
        private int reg_time;
        private int sell_status;
        private Object head_pic;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getSell_status() {
            return sell_status;
        }

        public void setSell_status(int sell_status) {
            this.sell_status = sell_status;
        }

        public int getReg_time() {
            return reg_time;
        }

        public void setReg_time(int reg_time) {
            this.reg_time = reg_time;
        }

        public Object getHead_pic() {
            return head_pic;
        }

        public void setHead_pic(Object head_pic) {
            this.head_pic = head_pic;
        }
    }
}
