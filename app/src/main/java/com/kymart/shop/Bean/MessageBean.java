package com.kymart.shop.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/6.
 */

public class MessageBean {


    /**
     * status : 1
     * msg :
     * result : [{"id":1,"title":"测试一下","content":"<p s以一限公司<\/span><\/p><p><br/><\/p>","status":1,"create_time":1504595777}]
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
         * id : 1
         * title : 测试一下
         * content : <p s以一限公司</span></p><p><br/></p>
         * status : 1
         * create_time : 1504595777
         */

        private int id;
        private String title;
        private String content;
        private int status;
        private int create_time;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getCreate_time() {
            return create_time;
        }

        public void setCreate_time(int create_time) {
            this.create_time = create_time;
        }
    }
}
