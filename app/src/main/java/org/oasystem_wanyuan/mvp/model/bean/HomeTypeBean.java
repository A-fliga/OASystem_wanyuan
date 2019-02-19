package org.oasystem_wanyuan.mvp.model.bean;

import java.util.List;

/**
 * Created by www on 2019/2/16.
 */

public class HomeTypeBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * name : 上级来文
         * company_id : 1
         * created_at : 2018-12-23 17:09:20
         * updated_at : 2018-12-23 17:09:20
         * parent_id : 0
         * sort : null
         */

        private int id;
        private String name;
        private int company_id;
        private String created_at;
        private String updated_at;
        private int parent_id;
        private String sort;
        private String img;
        private long dispatch_flow_list_count;

        public long getDispatch_flow_list_count() {
            return dispatch_flow_list_count;
        }

        public void setDispatch_flow_list_count(long dispatch_flow_list_count) {
            this.dispatch_flow_list_count = dispatch_flow_list_count;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCompany_id() {
            return company_id;
        }

        public void setCompany_id(int company_id) {
            this.company_id = company_id;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public int getParent_id() {
            return parent_id;
        }

        public void setParent_id(int parent_id) {
            this.parent_id = parent_id;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }
    }
}
