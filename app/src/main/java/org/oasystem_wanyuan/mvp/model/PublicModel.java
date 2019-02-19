package org.oasystem_wanyuan.mvp.model;


import org.oasystem_wanyuan.http.HttpClient;
import org.oasystem_wanyuan.mvp.model.bean.AllUserBean;
import org.oasystem_wanyuan.mvp.model.bean.DocumentBean;
import org.oasystem_wanyuan.mvp.model.bean.HomeTypeBean;
import org.oasystem_wanyuan.mvp.model.bean.LoginBean;
import org.oasystem_wanyuan.mvp.model.bean.OfficeListBean;
import org.oasystem_wanyuan.mvp.model.bean.OfficeTypeBean;
import org.oasystem_wanyuan.mvp.model.bean.ScreenBean;
import org.oasystem_wanyuan.mvp.model.bean.UpFileBean;
import org.oasystem_wanyuan.mvp.model.bean.UserInfo;

import java.io.File;

import okhttp3.ResponseBody;
import rx.Subscriber;

/**
 * Created by www on 6/7/2017.
 * 公共Model类
 */
public class PublicModel implements IModel {


    private PublicModel() {
    }

    private static PublicModel model;

    public static PublicModel getInstance() {
        if (null == model)
            model = new PublicModel();
        return model;
    }

    /**
     * 登录
     */
    public void login(Subscriber<BaseEntity<LoginBean>> subscriber, String username, String password) {
        HttpClient.getInstance().login(subscriber, username, password);
    }

    /**
     * 获取用户信息
     */
    public void getUserInfo(Subscriber<BaseEntity<UserInfo>> subscriber) {
        HttpClient.getInstance().getUserInfo(subscriber);
    }

    /**
     * 获取资源
     */
    public void getSource(Subscriber<ResponseBody> subscriber, String sourceId) {
        HttpClient.getInstance().getSource(subscriber, sourceId);
    }

    /**
     * 获取文档分类
     */
    public void getOfficeType(Subscriber<BaseEntity<OfficeTypeBean>> subscriber, String type) {
        HttpClient.getInstance().getOfficeType(subscriber, type);
    }

    /**
     * 获取个人文档
     */
    public void getOfficeList(Subscriber<BaseEntity<OfficeListBean>> subscriber, String document_type_id, String page) {
        HttpClient.getInstance().getOfficeList(subscriber, document_type_id, page);
    }

    /**
     * 待我审批
     */
    public void getNotDoneDocument(Subscriber<BaseEntity<DocumentBean>> subscriber, ScreenBean bean) {
        HttpClient.getInstance().getNotDoneDocument(subscriber, bean);
    }


    /**
     * 我已审批
     */
    public void getDoneDocument(Subscriber<BaseEntity<DocumentBean>> subscriber, ScreenBean bean) {
        HttpClient.getInstance().getDoneDocument(subscriber, bean);
    }


    /**
     * 上传资源
     */
    public void upload_file(Subscriber<BaseEntity<UpFileBean>> subscriber, File file) {
        HttpClient.getInstance().upload_file(subscriber, file);
    }

    /**
     * 审批接口
     */
    public void examine(Subscriber<BaseEntity> subscriber, String id, String status, String accessory_source_id, String form_source_id) {
        HttpClient.getInstance().examine(subscriber, id, status, accessory_source_id, form_source_id);
    }


    /**
     * 结束流程
     */
    public void closeAll(Subscriber<BaseEntity> subscriber, int id, String accessory_source_id, String form_source_id) {
        HttpClient.getInstance().closeAll(subscriber, id, accessory_source_id, form_source_id);
    }


    /**
     * 添加附件
     */
    public void addAccessory(Subscriber<BaseEntity> subscriber, int id, String name, int source_id) {
        HttpClient.getInstance().addAccessory(subscriber, id, name, source_id);
    }

    /**
     * 添加意见
     */
    public void add_opinion(Subscriber<BaseEntity> subscriber, int id, String accessory_source_id, String form_source_id) {
        HttpClient.getInstance().add_opinion(subscriber, id, accessory_source_id, form_source_id);
    }


    /**
     * 获取全部用户的信息
     */
    public void getAllUser(Subscriber<BaseEntity<AllUserBean>> subscriber) {
        HttpClient.getInstance().getAllUser(subscriber);
    }
    /**
     * 加签
     */
    public void add_countersign(Subscriber<BaseEntity> subscriber, int id, String user_id) {
        HttpClient.getInstance().add_countersign(subscriber,id,user_id);
    }

    /**
     * 获取固定分类
     */
    public void getType(Subscriber<BaseEntity<HomeTypeBean>> subscriber) {
        HttpClient.getInstance().getType(subscriber);
    }

    /**
     * 文件监控
     */
    public void getMonitorList(Subscriber<BaseEntity<DocumentBean>> subscriber, ScreenBean bean) {
        HttpClient.getInstance().getMonitorList(subscriber,bean);
    }
}