package org.oasystem_wanyuan.mvp.model.bean;

import java.util.List;

/**
 * Created by www on 2019/1/27.
 */

public class AllUserBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 7
         * name : 测试2
         * account : cs2
         * phone : asdsad
         * mail : asdas
         * status : 1
         * headimg : http://oa.zycnb.net/uploads/images/2019-01-08/4d897a9b5b9a62d586483488ba7629c0.jpg
         * password : $2y$10$Tun1VnI/ITlBbU6YyroAC.dT4Eo3cmsQ4oWCCKaR7q2IgCG/WOucm
         * remark : asda
         * is_admin : 0
         * company_id : 1
         * department_id : 4
         * position_id : 5
         * company_name : asdsa
         * remember_token : PGL5mMxMHNKhap0c9Ju4vHX2hppyEiFyxbJ5Ey1BHwOb5OjR0WhbFhyeqbsq
         * created_at : 2018-12-18 15:23:29
         * updated_at : 2019-01-08 14:52:28
         * department : {"id":4,"name":"财务科","parent_id":1,"sort":1,"level":2,"company_id":1,"created_at":"2018-12-20 19:29:54","updated_at":"2019-01-08 14:38:47"}
         */

        private int id;
        private String name;
        private String account;
        private String phone;
        private String mail;
        private int status;
        private String headimg;
        private String password;
        private String remark;
        private int is_admin;
        private int company_id;
        private int department_id;
        private int position_id;
        private String company_name;
        private String remember_token;
        private String created_at;
        private String updated_at;
        private DepartmentBean department;
        private Boolean isSelected;

        public Boolean getSelected() {
            return isSelected;
        }

        public void setSelected(Boolean selected) {
            isSelected = selected;
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

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getHeadimg() {
            return headimg;
        }

        public void setHeadimg(String headimg) {
            this.headimg = headimg;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getIs_admin() {
            return is_admin;
        }

        public void setIs_admin(int is_admin) {
            this.is_admin = is_admin;
        }

        public int getCompany_id() {
            return company_id;
        }

        public void setCompany_id(int company_id) {
            this.company_id = company_id;
        }

        public int getDepartment_id() {
            return department_id;
        }

        public void setDepartment_id(int department_id) {
            this.department_id = department_id;
        }

        public int getPosition_id() {
            return position_id;
        }

        public void setPosition_id(int position_id) {
            this.position_id = position_id;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getRemember_token() {
            return remember_token;
        }

        public void setRemember_token(String remember_token) {
            this.remember_token = remember_token;
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

        public DepartmentBean getDepartment() {
            return department;
        }

        public void setDepartment(DepartmentBean department) {
            this.department = department;
        }

        public static class DepartmentBean {
            /**
             * id : 4
             * name : 财务科
             * parent_id : 1
             * sort : 1
             * level : 2
             * company_id : 1
             * created_at : 2018-12-20 19:29:54
             * updated_at : 2019-01-08 14:38:47
             */

            private int id;
            private String name;
            private int parent_id;
            private int sort;
            private int level;
            private int company_id;
            private String created_at;
            private String updated_at;

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

            public int getParent_id() {
                return parent_id;
            }

            public void setParent_id(int parent_id) {
                this.parent_id = parent_id;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
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
        }
    }
}
