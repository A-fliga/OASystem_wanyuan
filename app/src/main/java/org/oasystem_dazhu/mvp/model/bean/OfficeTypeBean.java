package org.oasystem_dazhu.mvp.model.bean;

import java.util.List;

/**
 * Created by www on 2019/1/5.
 */

public class OfficeTypeBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 4
         * name : 分类A
         * company_id : 1
         * type : 1
         * created_at : 2018-12-24 21:06:00
         * updated_at : 2018-12-24 21:06:00
         * document_count : 3
         */

        private int id;
        private String name;
        private int company_id;
        private int type;
        private String created_at;
        private String updated_at;
        private String document_count;

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

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
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

        public String getDocument_count() {
            return document_count;
        }

        public void setDocument_count(String document_count) {
            this.document_count = document_count;
        }
    }
}
