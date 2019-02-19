package org.oasystem_wanyuan.mvp.model.bean;

import java.util.List;

/**
 * Created by www on 2019/1/5.
 */

public class OfficeListBean {

    /**
     * current_page : 1
     * data : [{"id":16,"name":"pdf","document_type_id":4,"path":"http://oa.zycnb.net/admin/readFlie/43","user_id":8,"source_id":43,"type":1,"company_id":1,"created_at":"2018-12-27 21:12:42","updated_at":"2018-12-27 21:12:42","share_company_id":"asdsad","document_type":{"id":4,"name":"分类A","company_id":1,"type":1,"created_at":"2018-12-24 21:06:00","updated_at":"2018-12-24 21:06:00"},"source":{"id":43,"name":"compressed.tracemonkey-pldi-09.pdf","user_id":8,"company_id":1,"path":"1/8/compressed.tracemonkey-pldi-09.pdf","created_at":"2018-12-27 21:12:41","updated_at":"2018-12-27 21:12:41"}},{"id":15,"name":"word","document_type_id":4,"path":"http://oa.zycnb.net/admin/readFlie/42","user_id":8,"source_id":42,"type":1,"company_id":1,"created_at":"2018-12-27 21:12:27","updated_at":"2018-12-27 21:12:27","share_company_id":"asdsad","document_type":{"id":4,"name":"分类A","company_id":1,"type":1,"created_at":"2018-12-24 21:06:00","updated_at":"2018-12-24 21:06:00"},"source":{"id":42,"name":"test.doc","user_id":8,"company_id":1,"path":"1/8/test.doc","created_at":"2018-12-27 21:11:46","updated_at":"2018-12-27 21:11:46"}},{"id":14,"name":"ces","document_type_id":4,"path":"http://oa.zycnb.net/admin/readFlie/41","user_id":8,"source_id":41,"type":1,"company_id":1,"created_at":"2018-12-27 21:11:23","updated_at":"2018-12-27 21:11:23","share_company_id":"asdad","document_type":{"id":4,"name":"分类A","company_id":1,"type":1,"created_at":"2018-12-24 21:06:00","updated_at":"2018-12-24 21:06:00"},"source":{"id":41,"name":"36711545903501_.pic_hd.jpg","user_id":8,"company_id":1,"path":"1/8/36711545903501_.pic_hd.jpg","created_at":"2018-12-27 21:11:22","updated_at":"2018-12-27 21:11:22"}}]
     * first_page_url : http://oa.zycnb.net/api/document/personage?page=1
     * from : 1
     * last_page : 1
     * last_page_url : http://oa.zycnb.net/api/document/personage?page=1
     * next_page_url : asdad
     * path : http://oa.zycnb.net/api/document/personage
     * per_page : 20
     * prev_page_url : asdsadsa
     * to : 3
     * total : 3
     */

    private int current_page;
    private String first_page_url;
    private int from;
    private int last_page;
    private String last_page_url;
    private String next_page_url;
    private String path;
    private int per_page;
    private String prev_page_url;
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

    public String getNext_page_url() {
        return next_page_url;
    }

    public void setNext_page_url(String next_page_url) {
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

    public String getPrev_page_url() {
        return prev_page_url;
    }

    public void setPrev_page_url(String prev_page_url) {
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
         * id : 16
         * name : pdf
         * document_type_id : 4
         * path : http://oa.zycnb.net/admin/readFlie/43
         * user_id : 8
         * source_id : 43
         * type : 1
         * company_id : 1
         * created_at : 2018-12-27 21:12:42
         * updated_at : 2018-12-27 21:12:42
         * share_company_id : asdsad
         * document_type : {"id":4,"name":"分类A","company_id":1,"type":1,"created_at":"2018-12-24 21:06:00","updated_at":"2018-12-24 21:06:00"}
         * source : {"id":43,"name":"compressed.tracemonkey-pldi-09.pdf","user_id":8,"company_id":1,"path":"1/8/compressed.tracemonkey-pldi-09.pdf","created_at":"2018-12-27 21:12:41","updated_at":"2018-12-27 21:12:41"}
         */

        private int id;
        private String name;
        private int document_type_id;
        private String path;
        private int user_id;
        private int source_id;
        private int type;
        private int company_id;
        private String created_at;
        private String updated_at;
        private String share_company_id;
        private DocumentTypeBean document_type;
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

        public int getDocument_type_id() {
            return document_type_id;
        }

        public void setDocument_type_id(int document_type_id) {
            this.document_type_id = document_type_id;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getSource_id() {
            return source_id;
        }

        public void setSource_id(int source_id) {
            this.source_id = source_id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
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

        public String getShare_company_id() {
            return share_company_id;
        }

        public void setShare_company_id(String share_company_id) {
            this.share_company_id = share_company_id;
        }

        public DocumentTypeBean getDocument_type() {
            return document_type;
        }

        public void setDocument_type(DocumentTypeBean document_type) {
            this.document_type = document_type;
        }

        public SourceBean getSource() {
            return source;
        }

        public void setSource(SourceBean source) {
            this.source = source;
        }

        public static class DocumentTypeBean {
            /**
             * id : 4
             * name : 分类A
             * company_id : 1
             * type : 1
             * created_at : 2018-12-24 21:06:00
             * updated_at : 2018-12-24 21:06:00
             */

            private int id;
            private String name;
            private int company_id;
            private int type;
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
        }

        public static class SourceBean {
            /**
             * id : 43
             * name : compressed.tracemonkey-pldi-09.pdf
             * user_id : 8
             * company_id : 1
             * path : 1/8/compressed.tracemonkey-pldi-09.pdf
             * created_at : 2018-12-27 21:12:41
             * updated_at : 2018-12-27 21:12:41
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
