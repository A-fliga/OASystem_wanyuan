package org.oasystem.mvp.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by www on 2018/12/29.
 */

public class UserInfo {

    /**
     * id : 8
     * name : 测
     * account : ce1
     * phone : 1212
     * mail : 1212
     * status : 1
     * headimg : http://www.fly.com/admin/img/head_img.jpeg
     * remark : 备注
     * company_id : 1
     * department_id : 4
     * position_id : 2
     * company_name : 备注
     * created_at : 2018-12-21 16:17:11
     * department : {"id":4,"name":"部门置顶","parent_id":1,"sort":1,"level":2,"company_id":1,"created_at":"2018-12-20 19:29:54","updated_at":"2018-12-20 19:36:13"}
     * position : {"id":2,"name":"职务2","level":2,"company_id":1,"created_at":"2018-12-21 13:53:55","updated_at":"2018-12-21 13:53:55"}
     * office_seal : [{"id":7,"name":"我的印章1","office_seal_type_id":1,"path":"http://oa.zycnb.net/admin/readFlie/40","company_id":1,"source_id":40,"user_id":8,"created_at":"2018-12-27 20:30:51","updated_at":"2018-12-27 20:30:51","office_seal_type":{"id":1,"name":"印章类型1","company_id":1,"created_at":"2018-12-23 16:14:43","updated_at":"2018-12-23 16:14:43"},"source":{"id":40,"name":"36711545903501_.pic_hd.jpg","user_id":8,"company_id":1,"path":"1/8/36711545903501_.pic_hd.jpg","created_at":"2018-12-27 20:30:47","updated_at":"2018-12-27 20:30:47"}}]
     */

    private int id;
    private String name;
    private String account;
    private String phone;
    private String mail;
    private int status;
    private String headimg;
    private String remark;
    private int company_id;
    private int department_id;
    private int position_id;
    private String company_name;
    private String created_at;
    private DepartmentBean department;
    private PositionBean position;
    private List<OfficeSealBean> office_seal;
    private List<OfficeSealTypeListBean> office_seal_tpye;

    public List<OfficeSealTypeListBean> getOffice_seal_tpye() {
        return office_seal_tpye;
    }

    public void setOffice_seal_tpye(List<OfficeSealTypeListBean> office_seal_tpye) {
        this.office_seal_tpye = office_seal_tpye;
    }

    public static class OfficeSealTypeListBean {
        /**
         * id : 1
         * name : 印章类型1
         * company_id : 1
         * created_at : 2018-12-23 16:14:43
         * updated_at : 2018-12-23 16:14:43
         */

        private int id;
        private String name;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public DepartmentBean getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentBean department) {
        this.department = department;
    }

    public PositionBean getPosition() {
        return position;
    }

    public void setPosition(PositionBean position) {
        this.position = position;
    }

    public List<OfficeSealBean> getOffice_seal() {
        return office_seal;
    }

    public void setOffice_seal(List<OfficeSealBean> office_seal) {
        this.office_seal = office_seal;
    }

    public static class DepartmentBean {
        /**
         * id : 4
         * name : 部门置顶
         * parent_id : 1
         * sort : 1
         * level : 2
         * company_id : 1
         * created_at : 2018-12-20 19:29:54
         * updated_at : 2018-12-20 19:36:13
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

    public static class PositionBean {
        /**
         * id : 2
         * name : 职务2
         * level : 2
         * company_id : 1
         * created_at : 2018-12-21 13:53:55
         * updated_at : 2018-12-21 13:53:55
         */

        private int id;
        private String name;
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

    public static class OfficeSealBean {
        /**
         * id : 7
         * name : 我的印章1
         * office_seal_type_id : 1
         * path : http://oa.zycnb.net/admin/readFlie/40
         * company_id : 1
         * source_id : 40
         * user_id : 8
         * created_at : 2018-12-27 20:30:51
         * updated_at : 2018-12-27 20:30:51
         * office_seal_type : {"id":1,"name":"印章类型1","company_id":1,"created_at":"2018-12-23 16:14:43","updated_at":"2018-12-23 16:14:43"}
         * source : {"id":40,"name":"36711545903501_.pic_hd.jpg","user_id":8,"company_id":1,"path":"1/8/36711545903501_.pic_hd.jpg","created_at":"2018-12-27 20:30:47","updated_at":"2018-12-27 20:30:47"}
         */

        private int id;
        private String name;
        private int office_seal_type_id;
        private String path;
        private int company_id;
        private String source_id;
        private int user_id;
        private String created_at;
        private String updated_at;
        private OfficeSealTypeBean office_seal_type;
        private SourceBean source;

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

        public int getOffice_seal_type_id() {
            return office_seal_type_id;
        }

        public void setOffice_seal_type_id(int office_seal_type_id) {
            this.office_seal_type_id = office_seal_type_id;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public int getCompany_id() {
            return company_id;
        }

        public void setCompany_id(int company_id) {
            this.company_id = company_id;
        }

        public String getSource_id() {
            return source_id;
        }

        public void setSource_id(String source_id) {
            this.source_id = source_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
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

        public OfficeSealTypeBean getOffice_seal_type() {
            return office_seal_type;
        }

        public void setOffice_seal_type(OfficeSealTypeBean office_seal_type) {
            this.office_seal_type = office_seal_type;
        }

        public SourceBean getSource() {
            return source;
        }

        public void setSource(SourceBean source) {
            this.source = source;
        }

        public static class OfficeSealTypeBean {
            /**
             * id : 1
             * name : 印章类型1
             * company_id : 1
             * created_at : 2018-12-23 16:14:43
             * updated_at : 2018-12-23 16:14:43
             */

            private int id;
            private String name;
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

        public static class SourceBean {
            /**
             * id : 40
             * name : 36711545903501_.pic_hd.jpg
             * user_id : 8
             * company_id : 1
             * path : 1/8/36711545903501_.pic_hd.jpg
             * created_at : 2018-12-27 20:30:47
             * updated_at : 2018-12-27 20:30:47
             */

            private int id;
            private String name;
            private int user_id;
            private int company_id;
            private String path;
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

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public int getCompany_id() {
                return company_id;
            }

            public void setCompany_id(int company_id) {
                this.company_id = company_id;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
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
