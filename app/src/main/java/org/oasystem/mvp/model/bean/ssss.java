package org.oasystem.mvp.model.bean;

import java.util.List;

/**
 * Created by www on 2019/1/20.
 */

public class ssss {

    /**
     * current_page : 1
     * data : [{"id":115,"user_id":8,"dispatch_id":57,"level":4,"company_id":1,"created_at":"2019-01-09 12:59:33","updated_at":"2019-01-19 21:14:57","status":0,"form_source_id":330,"accessory_source_id":"323#328#43","is_examine":1,"dispatch_name":"测试123","form_type":1,"dispatch_serial":"测试123","dispatch_organ":"测试123","dispatch_number":"0","dispatch_urgent":null,"dispatch_principal_id":8,"name":"自定义","auth":"1,2,3,4,5","accessory_list":[{"name":"","source_id":"323"},{"name":"","source_id":"328"},{"name":"","source_id":"43"}],"status_name":"等待审核","form_source":{"id":330,"name":"2a1fa86a8dd8b022b8311ec30f387505.docx","user_id":8,"company_id":1,"path":"1/8/dispatch/2a1fa86a8dd8b022b8311ec30f387505.docx","created_at":"2019-01-19 15:14:02","updated_at":"2019-01-19 15:14:02"},"user":{"id":8,"name":"测试1","phone":1212,"headimg":"http://oa.zycnb.net/uploads/images/2019-01-08/3a347815c69b699c8f1196e2a954d2a1.jpg","department_id":1,"position_id":4,"position":{"id":4,"name":"主任","level":4,"company_id":1,"created_at":"2019-01-08 14:47:08","updated_at":"2019-01-08 14:47:08"},"department":{"id":1,"name":"县政府","parent_id":0,"sort":1,"level":1,"company_id":1,"created_at":"2018-12-20 19:21:07","updated_at":"2019-01-08 14:38:32"}},"dispatch":{"id":57,"user_id":1,"company_id":1,"form":null,"form_source_id":330,"organ":"测试123","name":"测试123","serial":"测试123","number":"0","urgent":0,"principal_id":null,"main_body":null,"main_body_source_id":null,"accessory":"测试.pdf#compressed.tracemonkey-pldi-09.pdf#compressed.tracemonkey-pldi-09.pdf","accessory_source_id":"323#328#43","flow_type":2,"status":0,"form_type":1,"created_at":"2019-01-09 12:59:33","updated_at":"2019-01-20 01:01:15","accessory_list":[{"name":"测试.pdf","source_id":"323"},{"name":"compressed.tracemonkey-pldi-09.pdf","source_id":"328"},{"name":"compressed.tracemonkey-pldi-09.pdf","source_id":"43"}],"approver":"测试1","user":{"id":1,"name":"admin","phone":null,"headimg":"http://oa.zycnb.net/uploads/images/2019-01-08/f0f17012fb5ac0b8771d823f7e4ff482.jpg","department_id":0,"position_id":0},"company":{"id":1,"name":"admin","account":"admin","phone":null,"mail":null,"status":1,"headimg":"http://oa.zycnb.net/uploads/images/2019-01-08/f0f17012fb5ac0b8771d823f7e4ff482.jpg","password":"$2y$10$X6qEGidOZGEDYzbcrUHOhe1ISLfs1BveeadLcHCF5uJBqq/tgLD9i","remark":null,"is_admin":1,"company_id":1,"department_id":0,"position_id":0,"company_name":"县政府","remember_token":"GaDm56fArTseXMwBfTjiPviJ4q8RI22hyAvJDzxM2CgJ3UycAsrEefzqsOue","created_at":null,"updated_at":"2019-01-10 22:58:45"},"form_source":{"id":330,"name":"2a1fa86a8dd8b022b8311ec30f387505.docx","user_id":8,"company_id":1,"path":"1/8/dispatch/2a1fa86a8dd8b022b8311ec30f387505.docx","created_at":"2019-01-19 15:14:02","updated_at":"2019-01-19 15:14:02"},"flows":[{"id":115,"user_id":8,"dispatch_id":57,"level":4,"company_id":1,"created_at":"2019-01-09 12:59:33","updated_at":"2019-01-19 21:14:57","status":0,"form_source_id":330,"accessory_source_id":"323#328#43","is_examine":1,"dispatch_name":"测试123","form_type":1,"dispatch_serial":"测试123","dispatch_organ":"测试123","dispatch_number":"0","dispatch_urgent":null,"dispatch_principal_id":8,"name":"自定义","auth":"1,2,3,4,5","user":{"id":8,"name":"测试1","phone":1212,"headimg":"http://oa.zycnb.net/uploads/images/2019-01-08/3a347815c69b699c8f1196e2a954d2a1.jpg","department_id":1,"position_id":4}}]},"principal":{"id":8,"name":"测试1","phone":1212,"headimg":"http://oa.zycnb.net/uploads/images/2019-01-08/3a347815c69b699c8f1196e2a954d2a1.jpg","department_id":1,"position_id":4}}]
     * first_page_url : http://oa.zycnb.net/api/dispatch/wait?page=1
     * from : 1
     * last_page : 1
     * last_page_url : http://oa.zycnb.net/api/dispatch/wait?page=1
     * next_page_url : null
     * path : http://oa.zycnb.net/api/dispatch/wait
     * per_page : 20
     * prev_page_url : null
     * to : 1
     * total : 1
     */

    private int current_page;
    private String first_page_url;
    private int from;
    private int last_page;
    private String last_page_url;
    private Object next_page_url;
    private String path;
    private int per_page;
    private Object prev_page_url;
    private int to;
    private int total;
    private List<DataBean> data;

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public String getFirst_page_url() {
        return first_page_url;
    }

    public void setFirst_page_url(String first_page_url) {
        this.first_page_url = first_page_url;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getLast_page() {
        return last_page;
    }

    public void setLast_page(int last_page) {
        this.last_page = last_page;
    }

    public String getLast_page_url() {
        return last_page_url;
    }

    public void setLast_page_url(String last_page_url) {
        this.last_page_url = last_page_url;
    }

    public Object getNext_page_url() {
        return next_page_url;
    }

    public void setNext_page_url(Object next_page_url) {
        this.next_page_url = next_page_url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public Object getPrev_page_url() {
        return prev_page_url;
    }

    public void setPrev_page_url(Object prev_page_url) {
        this.prev_page_url = prev_page_url;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 115
         * user_id : 8
         * dispatch_id : 57
         * level : 4
         * company_id : 1
         * created_at : 2019-01-09 12:59:33
         * updated_at : 2019-01-19 21:14:57
         * status : 0
         * form_source_id : 330
         * accessory_source_id : 323#328#43
         * is_examine : 1
         * dispatch_name : 测试123
         * form_type : 1
         * dispatch_serial : 测试123
         * dispatch_organ : 测试123
         * dispatch_number : 0
         * dispatch_urgent : null
         * dispatch_principal_id : 8
         * name : 自定义
         * auth : 1,2,3,4,5
         * accessory_list : [{"name":"","source_id":"323"},{"name":"","source_id":"328"},{"name":"","source_id":"43"}]
         * status_name : 等待审核
         * form_source : {"id":330,"name":"2a1fa86a8dd8b022b8311ec30f387505.docx","user_id":8,"company_id":1,"path":"1/8/dispatch/2a1fa86a8dd8b022b8311ec30f387505.docx","created_at":"2019-01-19 15:14:02","updated_at":"2019-01-19 15:14:02"}
         * user : {"id":8,"name":"测试1","phone":1212,"headimg":"http://oa.zycnb.net/uploads/images/2019-01-08/3a347815c69b699c8f1196e2a954d2a1.jpg","department_id":1,"position_id":4,"position":{"id":4,"name":"主任","level":4,"company_id":1,"created_at":"2019-01-08 14:47:08","updated_at":"2019-01-08 14:47:08"},"department":{"id":1,"name":"县政府","parent_id":0,"sort":1,"level":1,"company_id":1,"created_at":"2018-12-20 19:21:07","updated_at":"2019-01-08 14:38:32"}}
         * dispatch : {"id":57,"user_id":1,"company_id":1,"form":null,"form_source_id":330,"organ":"测试123","name":"测试123","serial":"测试123","number":"0","urgent":0,"principal_id":null,"main_body":null,"main_body_source_id":null,"accessory":"测试.pdf#compressed.tracemonkey-pldi-09.pdf#compressed.tracemonkey-pldi-09.pdf","accessory_source_id":"323#328#43","flow_type":2,"status":0,"form_type":1,"created_at":"2019-01-09 12:59:33","updated_at":"2019-01-20 01:01:15","accessory_list":[{"name":"测试.pdf","source_id":"323"},{"name":"compressed.tracemonkey-pldi-09.pdf","source_id":"328"},{"name":"compressed.tracemonkey-pldi-09.pdf","source_id":"43"}],"approver":"测试1","user":{"id":1,"name":"admin","phone":null,"headimg":"http://oa.zycnb.net/uploads/images/2019-01-08/f0f17012fb5ac0b8771d823f7e4ff482.jpg","department_id":0,"position_id":0},"company":{"id":1,"name":"admin","account":"admin","phone":null,"mail":null,"status":1,"headimg":"http://oa.zycnb.net/uploads/images/2019-01-08/f0f17012fb5ac0b8771d823f7e4ff482.jpg","password":"$2y$10$X6qEGidOZGEDYzbcrUHOhe1ISLfs1BveeadLcHCF5uJBqq/tgLD9i","remark":null,"is_admin":1,"company_id":1,"department_id":0,"position_id":0,"company_name":"县政府","remember_token":"GaDm56fArTseXMwBfTjiPviJ4q8RI22hyAvJDzxM2CgJ3UycAsrEefzqsOue","created_at":null,"updated_at":"2019-01-10 22:58:45"},"form_source":{"id":330,"name":"2a1fa86a8dd8b022b8311ec30f387505.docx","user_id":8,"company_id":1,"path":"1/8/dispatch/2a1fa86a8dd8b022b8311ec30f387505.docx","created_at":"2019-01-19 15:14:02","updated_at":"2019-01-19 15:14:02"},"flows":[{"id":115,"user_id":8,"dispatch_id":57,"level":4,"company_id":1,"created_at":"2019-01-09 12:59:33","updated_at":"2019-01-19 21:14:57","status":0,"form_source_id":330,"accessory_source_id":"323#328#43","is_examine":1,"dispatch_name":"测试123","form_type":1,"dispatch_serial":"测试123","dispatch_organ":"测试123","dispatch_number":"0","dispatch_urgent":null,"dispatch_principal_id":8,"name":"自定义","auth":"1,2,3,4,5","user":{"id":8,"name":"测试1","phone":1212,"headimg":"http://oa.zycnb.net/uploads/images/2019-01-08/3a347815c69b699c8f1196e2a954d2a1.jpg","department_id":1,"position_id":4}}]}
         * principal : {"id":8,"name":"测试1","phone":1212,"headimg":"http://oa.zycnb.net/uploads/images/2019-01-08/3a347815c69b699c8f1196e2a954d2a1.jpg","department_id":1,"position_id":4}
         */

        private int id;
        private int user_id;
        private int dispatch_id;
        private int level;
        private int company_id;
        private String created_at;
        private String updated_at;
        private int status;
        private int form_source_id;
        private String accessory_source_id;
        private int is_examine;
        private String dispatch_name;
        private int form_type;
        private String dispatch_serial;
        private String dispatch_organ;
        private String dispatch_number;
        private Object dispatch_urgent;
        private int dispatch_principal_id;
        private String name;
        private String auth;
        private String status_name;
        private FormSourceBean form_source;
        private UserBean user;
        private DispatchBean dispatch;
        private PrincipalBean principal;
        private List<AccessoryListBeanX> accessory_list;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getDispatch_id() {
            return dispatch_id;
        }

        public void setDispatch_id(int dispatch_id) {
            this.dispatch_id = dispatch_id;
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

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getForm_source_id() {
            return form_source_id;
        }

        public void setForm_source_id(int form_source_id) {
            this.form_source_id = form_source_id;
        }

        public String getAccessory_source_id() {
            return accessory_source_id;
        }

        public void setAccessory_source_id(String accessory_source_id) {
            this.accessory_source_id = accessory_source_id;
        }

        public int getIs_examine() {
            return is_examine;
        }

        public void setIs_examine(int is_examine) {
            this.is_examine = is_examine;
        }

        public String getDispatch_name() {
            return dispatch_name;
        }

        public void setDispatch_name(String dispatch_name) {
            this.dispatch_name = dispatch_name;
        }

        public int getForm_type() {
            return form_type;
        }

        public void setForm_type(int form_type) {
            this.form_type = form_type;
        }

        public String getDispatch_serial() {
            return dispatch_serial;
        }

        public void setDispatch_serial(String dispatch_serial) {
            this.dispatch_serial = dispatch_serial;
        }

        public String getDispatch_organ() {
            return dispatch_organ;
        }

        public void setDispatch_organ(String dispatch_organ) {
            this.dispatch_organ = dispatch_organ;
        }

        public String getDispatch_number() {
            return dispatch_number;
        }

        public void setDispatch_number(String dispatch_number) {
            this.dispatch_number = dispatch_number;
        }

        public Object getDispatch_urgent() {
            return dispatch_urgent;
        }

        public void setDispatch_urgent(Object dispatch_urgent) {
            this.dispatch_urgent = dispatch_urgent;
        }

        public int getDispatch_principal_id() {
            return dispatch_principal_id;
        }

        public void setDispatch_principal_id(int dispatch_principal_id) {
            this.dispatch_principal_id = dispatch_principal_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAuth() {
            return auth;
        }

        public void setAuth(String auth) {
            this.auth = auth;
        }

        public String getStatus_name() {
            return status_name;
        }

        public void setStatus_name(String status_name) {
            this.status_name = status_name;
        }

        public FormSourceBean getForm_source() {
            return form_source;
        }

        public void setForm_source(FormSourceBean form_source) {
            this.form_source = form_source;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public DispatchBean getDispatch() {
            return dispatch;
        }

        public void setDispatch(DispatchBean dispatch) {
            this.dispatch = dispatch;
        }

        public PrincipalBean getPrincipal() {
            return principal;
        }

        public void setPrincipal(PrincipalBean principal) {
            this.principal = principal;
        }

        public List<AccessoryListBeanX> getAccessory_list() {
            return accessory_list;
        }

        public void setAccessory_list(List<AccessoryListBeanX> accessory_list) {
            this.accessory_list = accessory_list;
        }

        public static class FormSourceBean {
            /**
             * id : 330
             * name : 2a1fa86a8dd8b022b8311ec30f387505.docx
             * user_id : 8
             * company_id : 1
             * path : 1/8/dispatch/2a1fa86a8dd8b022b8311ec30f387505.docx
             * created_at : 2019-01-19 15:14:02
             * updated_at : 2019-01-19 15:14:02
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

        public static class UserBean {
            /**
             * id : 8
             * name : 测试1
             * phone : 1212
             * headimg : http://oa.zycnb.net/uploads/images/2019-01-08/3a347815c69b699c8f1196e2a954d2a1.jpg
             * department_id : 1
             * position_id : 4
             * position : {"id":4,"name":"主任","level":4,"company_id":1,"created_at":"2019-01-08 14:47:08","updated_at":"2019-01-08 14:47:08"}
             * department : {"id":1,"name":"县政府","parent_id":0,"sort":1,"level":1,"company_id":1,"created_at":"2018-12-20 19:21:07","updated_at":"2019-01-08 14:38:32"}
             */

            private int id;
            private String name;
            private int phone;
            private String headimg;
            private int department_id;
            private int position_id;
            private PositionBean position;
            private DepartmentBean department;

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

            public int getPhone() {
                return phone;
            }

            public void setPhone(int phone) {
                this.phone = phone;
            }

            public String getHeadimg() {
                return headimg;
            }

            public void setHeadimg(String headimg) {
                this.headimg = headimg;
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

            public PositionBean getPosition() {
                return position;
            }

            public void setPosition(PositionBean position) {
                this.position = position;
            }

            public DepartmentBean getDepartment() {
                return department;
            }

            public void setDepartment(DepartmentBean department) {
                this.department = department;
            }

            public static class PositionBean {
                /**
                 * id : 4
                 * name : 主任
                 * level : 4
                 * company_id : 1
                 * created_at : 2019-01-08 14:47:08
                 * updated_at : 2019-01-08 14:47:08
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

            public static class DepartmentBean {
                /**
                 * id : 1
                 * name : 县政府
                 * parent_id : 0
                 * sort : 1
                 * level : 1
                 * company_id : 1
                 * created_at : 2018-12-20 19:21:07
                 * updated_at : 2019-01-08 14:38:32
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

        public static class DispatchBean {
            /**
             * id : 57
             * user_id : 1
             * company_id : 1
             * form : null
             * form_source_id : 330
             * organ : 测试123
             * name : 测试123
             * serial : 测试123
             * number : 0
             * urgent : 0
             * principal_id : null
             * main_body : null
             * main_body_source_id : null
             * accessory : 测试.pdf#compressed.tracemonkey-pldi-09.pdf#compressed.tracemonkey-pldi-09.pdf
             * accessory_source_id : 323#328#43
             * flow_type : 2
             * status : 0
             * form_type : 1
             * created_at : 2019-01-09 12:59:33
             * updated_at : 2019-01-20 01:01:15
             * accessory_list : [{"name":"测试.pdf","source_id":"323"},{"name":"compressed.tracemonkey-pldi-09.pdf","source_id":"328"},{"name":"compressed.tracemonkey-pldi-09.pdf","source_id":"43"}]
             * approver : 测试1
             * user : {"id":1,"name":"admin","phone":null,"headimg":"http://oa.zycnb.net/uploads/images/2019-01-08/f0f17012fb5ac0b8771d823f7e4ff482.jpg","department_id":0,"position_id":0}
             * company : {"id":1,"name":"admin","account":"admin","phone":null,"mail":null,"status":1,"headimg":"http://oa.zycnb.net/uploads/images/2019-01-08/f0f17012fb5ac0b8771d823f7e4ff482.jpg","password":"$2y$10$X6qEGidOZGEDYzbcrUHOhe1ISLfs1BveeadLcHCF5uJBqq/tgLD9i","remark":null,"is_admin":1,"company_id":1,"department_id":0,"position_id":0,"company_name":"县政府","remember_token":"GaDm56fArTseXMwBfTjiPviJ4q8RI22hyAvJDzxM2CgJ3UycAsrEefzqsOue","created_at":null,"updated_at":"2019-01-10 22:58:45"}
             * form_source : {"id":330,"name":"2a1fa86a8dd8b022b8311ec30f387505.docx","user_id":8,"company_id":1,"path":"1/8/dispatch/2a1fa86a8dd8b022b8311ec30f387505.docx","created_at":"2019-01-19 15:14:02","updated_at":"2019-01-19 15:14:02"}
             * flows : [{"id":115,"user_id":8,"dispatch_id":57,"level":4,"company_id":1,"created_at":"2019-01-09 12:59:33","updated_at":"2019-01-19 21:14:57","status":0,"form_source_id":330,"accessory_source_id":"323#328#43","is_examine":1,"dispatch_name":"测试123","form_type":1,"dispatch_serial":"测试123","dispatch_organ":"测试123","dispatch_number":"0","dispatch_urgent":null,"dispatch_principal_id":8,"name":"自定义","auth":"1,2,3,4,5","user":{"id":8,"name":"测试1","phone":1212,"headimg":"http://oa.zycnb.net/uploads/images/2019-01-08/3a347815c69b699c8f1196e2a954d2a1.jpg","department_id":1,"position_id":4}}]
             */

            private int id;
            private int user_id;
            private int company_id;
            private Object form;
            private int form_source_id;
            private String organ;
            private String name;
            private String serial;
            private String number;
            private int urgent;
            private Object principal_id;
            private Object main_body;
            private Object main_body_source_id;
            private String accessory;
            private String accessory_source_id;
            private int flow_type;
            private int status;
            private int form_type;
            private String created_at;
            private String updated_at;
            private String approver;
            private UserBeanX user;
            private CompanyBean company;
            private FormSourceBeanX form_source;
            private List<AccessoryListBean> accessory_list;
            private List<FlowsBean> flows;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
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

            public Object getForm() {
                return form;
            }

            public void setForm(Object form) {
                this.form = form;
            }

            public int getForm_source_id() {
                return form_source_id;
            }

            public void setForm_source_id(int form_source_id) {
                this.form_source_id = form_source_id;
            }

            public String getOrgan() {
                return organ;
            }

            public void setOrgan(String organ) {
                this.organ = organ;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSerial() {
                return serial;
            }

            public void setSerial(String serial) {
                this.serial = serial;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public int getUrgent() {
                return urgent;
            }

            public void setUrgent(int urgent) {
                this.urgent = urgent;
            }

            public Object getPrincipal_id() {
                return principal_id;
            }

            public void setPrincipal_id(Object principal_id) {
                this.principal_id = principal_id;
            }

            public Object getMain_body() {
                return main_body;
            }

            public void setMain_body(Object main_body) {
                this.main_body = main_body;
            }

            public Object getMain_body_source_id() {
                return main_body_source_id;
            }

            public void setMain_body_source_id(Object main_body_source_id) {
                this.main_body_source_id = main_body_source_id;
            }

            public String getAccessory() {
                return accessory;
            }

            public void setAccessory(String accessory) {
                this.accessory = accessory;
            }

            public String getAccessory_source_id() {
                return accessory_source_id;
            }

            public void setAccessory_source_id(String accessory_source_id) {
                this.accessory_source_id = accessory_source_id;
            }

            public int getFlow_type() {
                return flow_type;
            }

            public void setFlow_type(int flow_type) {
                this.flow_type = flow_type;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getForm_type() {
                return form_type;
            }

            public void setForm_type(int form_type) {
                this.form_type = form_type;
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

            public String getApprover() {
                return approver;
            }

            public void setApprover(String approver) {
                this.approver = approver;
            }

            public UserBeanX getUser() {
                return user;
            }

            public void setUser(UserBeanX user) {
                this.user = user;
            }

            public CompanyBean getCompany() {
                return company;
            }

            public void setCompany(CompanyBean company) {
                this.company = company;
            }

            public FormSourceBeanX getForm_source() {
                return form_source;
            }

            public void setForm_source(FormSourceBeanX form_source) {
                this.form_source = form_source;
            }

            public List<AccessoryListBean> getAccessory_list() {
                return accessory_list;
            }

            public void setAccessory_list(List<AccessoryListBean> accessory_list) {
                this.accessory_list = accessory_list;
            }

            public List<FlowsBean> getFlows() {
                return flows;
            }

            public void setFlows(List<FlowsBean> flows) {
                this.flows = flows;
            }

            public static class UserBeanX {
                /**
                 * id : 1
                 * name : admin
                 * phone : null
                 * headimg : http://oa.zycnb.net/uploads/images/2019-01-08/f0f17012fb5ac0b8771d823f7e4ff482.jpg
                 * department_id : 0
                 * position_id : 0
                 */

                private int id;
                private String name;
                private Object phone;
                private String headimg;
                private int department_id;
                private int position_id;

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

                public Object getPhone() {
                    return phone;
                }

                public void setPhone(Object phone) {
                    this.phone = phone;
                }

                public String getHeadimg() {
                    return headimg;
                }

                public void setHeadimg(String headimg) {
                    this.headimg = headimg;
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
            }

            public static class CompanyBean {
                /**
                 * id : 1
                 * name : admin
                 * account : admin
                 * phone : null
                 * mail : null
                 * status : 1
                 * headimg : http://oa.zycnb.net/uploads/images/2019-01-08/f0f17012fb5ac0b8771d823f7e4ff482.jpg
                 * password : $2y$10$X6qEGidOZGEDYzbcrUHOhe1ISLfs1BveeadLcHCF5uJBqq/tgLD9i
                 * remark : null
                 * is_admin : 1
                 * company_id : 1
                 * department_id : 0
                 * position_id : 0
                 * company_name : 县政府
                 * remember_token : GaDm56fArTseXMwBfTjiPviJ4q8RI22hyAvJDzxM2CgJ3UycAsrEefzqsOue
                 * created_at : null
                 * updated_at : 2019-01-10 22:58:45
                 */

                private int id;
                private String name;
                private String account;
                private Object phone;
                private Object mail;
                private int status;
                private String headimg;
                private String password;
                private Object remark;
                private int is_admin;
                private int company_id;
                private int department_id;
                private int position_id;
                private String company_name;
                private String remember_token;
                private Object created_at;
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

                public String getAccount() {
                    return account;
                }

                public void setAccount(String account) {
                    this.account = account;
                }

                public Object getPhone() {
                    return phone;
                }

                public void setPhone(Object phone) {
                    this.phone = phone;
                }

                public Object getMail() {
                    return mail;
                }

                public void setMail(Object mail) {
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

                public Object getRemark() {
                    return remark;
                }

                public void setRemark(Object remark) {
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

                public Object getCreated_at() {
                    return created_at;
                }

                public void setCreated_at(Object created_at) {
                    this.created_at = created_at;
                }

                public String getUpdated_at() {
                    return updated_at;
                }

                public void setUpdated_at(String updated_at) {
                    this.updated_at = updated_at;
                }
            }

            public static class FormSourceBeanX {
                /**
                 * id : 330
                 * name : 2a1fa86a8dd8b022b8311ec30f387505.docx
                 * user_id : 8
                 * company_id : 1
                 * path : 1/8/dispatch/2a1fa86a8dd8b022b8311ec30f387505.docx
                 * created_at : 2019-01-19 15:14:02
                 * updated_at : 2019-01-19 15:14:02
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

            public static class AccessoryListBean {
                /**
                 * name : 测试.pdf
                 * source_id : 323
                 */

                private String name;
                private String source_id;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getSource_id() {
                    return source_id;
                }

                public void setSource_id(String source_id) {
                    this.source_id = source_id;
                }
            }

            public static class FlowsBean {
                /**
                 * id : 115
                 * user_id : 8
                 * dispatch_id : 57
                 * level : 4
                 * company_id : 1
                 * created_at : 2019-01-09 12:59:33
                 * updated_at : 2019-01-19 21:14:57
                 * status : 0
                 * form_source_id : 330
                 * accessory_source_id : 323#328#43
                 * is_examine : 1
                 * dispatch_name : 测试123
                 * form_type : 1
                 * dispatch_serial : 测试123
                 * dispatch_organ : 测试123
                 * dispatch_number : 0
                 * dispatch_urgent : null
                 * dispatch_principal_id : 8
                 * name : 自定义
                 * auth : 1,2,3,4,5
                 * user : {"id":8,"name":"测试1","phone":1212,"headimg":"http://oa.zycnb.net/uploads/images/2019-01-08/3a347815c69b699c8f1196e2a954d2a1.jpg","department_id":1,"position_id":4}
                 */

                private int id;
                private int user_id;
                private int dispatch_id;
                private int level;
                private int company_id;
                private String created_at;
                private String updated_at;
                private int status;
                private int form_source_id;
                private String accessory_source_id;
                private int is_examine;
                private String dispatch_name;
                private int form_type;
                private String dispatch_serial;
                private String dispatch_organ;
                private String dispatch_number;
                private Object dispatch_urgent;
                private int dispatch_principal_id;
                private String name;
                private String auth;
                private UserBeanXX user;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getUser_id() {
                    return user_id;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }

                public int getDispatch_id() {
                    return dispatch_id;
                }

                public void setDispatch_id(int dispatch_id) {
                    this.dispatch_id = dispatch_id;
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

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public int getForm_source_id() {
                    return form_source_id;
                }

                public void setForm_source_id(int form_source_id) {
                    this.form_source_id = form_source_id;
                }

                public String getAccessory_source_id() {
                    return accessory_source_id;
                }

                public void setAccessory_source_id(String accessory_source_id) {
                    this.accessory_source_id = accessory_source_id;
                }

                public int getIs_examine() {
                    return is_examine;
                }

                public void setIs_examine(int is_examine) {
                    this.is_examine = is_examine;
                }

                public String getDispatch_name() {
                    return dispatch_name;
                }

                public void setDispatch_name(String dispatch_name) {
                    this.dispatch_name = dispatch_name;
                }

                public int getForm_type() {
                    return form_type;
                }

                public void setForm_type(int form_type) {
                    this.form_type = form_type;
                }

                public String getDispatch_serial() {
                    return dispatch_serial;
                }

                public void setDispatch_serial(String dispatch_serial) {
                    this.dispatch_serial = dispatch_serial;
                }

                public String getDispatch_organ() {
                    return dispatch_organ;
                }

                public void setDispatch_organ(String dispatch_organ) {
                    this.dispatch_organ = dispatch_organ;
                }

                public String getDispatch_number() {
                    return dispatch_number;
                }

                public void setDispatch_number(String dispatch_number) {
                    this.dispatch_number = dispatch_number;
                }

                public Object getDispatch_urgent() {
                    return dispatch_urgent;
                }

                public void setDispatch_urgent(Object dispatch_urgent) {
                    this.dispatch_urgent = dispatch_urgent;
                }

                public int getDispatch_principal_id() {
                    return dispatch_principal_id;
                }

                public void setDispatch_principal_id(int dispatch_principal_id) {
                    this.dispatch_principal_id = dispatch_principal_id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getAuth() {
                    return auth;
                }

                public void setAuth(String auth) {
                    this.auth = auth;
                }

                public UserBeanXX getUser() {
                    return user;
                }

                public void setUser(UserBeanXX user) {
                    this.user = user;
                }

                public static class UserBeanXX {
                    /**
                     * id : 8
                     * name : 测试1
                     * phone : 1212
                     * headimg : http://oa.zycnb.net/uploads/images/2019-01-08/3a347815c69b699c8f1196e2a954d2a1.jpg
                     * department_id : 1
                     * position_id : 4
                     */

                    private int id;
                    private String name;
                    private int phone;
                    private String headimg;
                    private int department_id;
                    private int position_id;

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

                    public int getPhone() {
                        return phone;
                    }

                    public void setPhone(int phone) {
                        this.phone = phone;
                    }

                    public String getHeadimg() {
                        return headimg;
                    }

                    public void setHeadimg(String headimg) {
                        this.headimg = headimg;
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
                }
            }
        }

        public static class PrincipalBean {
            /**
             * id : 8
             * name : 测试1
             * phone : 1212
             * headimg : http://oa.zycnb.net/uploads/images/2019-01-08/3a347815c69b699c8f1196e2a954d2a1.jpg
             * department_id : 1
             * position_id : 4
             */

            private int id;
            private String name;
            private int phone;
            private String headimg;
            private int department_id;
            private int position_id;

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

            public int getPhone() {
                return phone;
            }

            public void setPhone(int phone) {
                this.phone = phone;
            }

            public String getHeadimg() {
                return headimg;
            }

            public void setHeadimg(String headimg) {
                this.headimg = headimg;
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
        }

        public static class AccessoryListBeanX {
            /**
             * name :
             * source_id : 323
             */

            private String name;
            private String source_id;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSource_id() {
                return source_id;
            }

            public void setSource_id(String source_id) {
                this.source_id = source_id;
            }
        }
    }
}
