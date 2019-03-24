package org.oasystem_wanyuan.mvp.model;


import org.oasystem_wanyuan.http.HttpClient;
import org.oasystem_wanyuan.mvp.model.bean.AllUserBean;
import org.oasystem_wanyuan.mvp.model.bean.CarApplyBean;
import org.oasystem_wanyuan.mvp.model.bean.CarApplyDetailBean;
import org.oasystem_wanyuan.mvp.model.bean.CarApplyListBean;
import org.oasystem_wanyuan.mvp.model.bean.CarTypeListBean;
import org.oasystem_wanyuan.mvp.model.bean.DocumentBean;
import org.oasystem_wanyuan.mvp.model.bean.HomeTypeBean;
import org.oasystem_wanyuan.mvp.model.bean.LoginBean;
import org.oasystem_wanyuan.mvp.model.bean.MeetingDetailBean;
import org.oasystem_wanyuan.mvp.model.bean.MeetingListBean;
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
     * 修改密码
     */
    public void updatePwd(Subscriber<BaseEntity> subscriber, String ypass, String npass) {
        HttpClient.getInstance().updatePwd(subscriber, ypass, npass);
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
        HttpClient.getInstance().add_countersign(subscriber, id, user_id);
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
        HttpClient.getInstance().getMonitorList(subscriber, bean);
    }

    /**
     * 获取会议列表
     */
    public void getMeetingList(Subscriber<BaseEntity<MeetingListBean>> subscriber, String status) {
        HttpClient.getInstance().getMeetingList(subscriber, status);
    }

    /**
     * 获取会议详情
     */
    public void getMeetingDetail(Subscriber<BaseEntity<MeetingDetailBean>> subscriber, String id) {
        HttpClient.getInstance().getMeetingDetail(subscriber, id);
    }

    /**
     * 会议签到
     */
    public void countersign(Subscriber<BaseEntity> subscriber, String id,String status,String remark) {
        HttpClient.getInstance().countersign(subscriber, id,status,remark);
    }


    /**
     * 获取用车申请列表
     */
    public void getApplyBean(Subscriber<BaseEntity<CarApplyListBean>> subscriber) {
        HttpClient.getInstance().getApplyBean(subscriber);
    }

    /**
     * 获取待我审批的用车列表
     */
    public void getApproveBean(Subscriber<BaseEntity<CarApplyListBean>> subscriber) {
        HttpClient.getInstance().getApproveBean(subscriber);
    }


    /**
     * 获取申请详情
     */
    public void getApplyDetailBean(Subscriber<BaseEntity<CarApplyDetailBean>> subscriber, String id) {
        HttpClient.getInstance().getApplyDetailBean(subscriber,id);
    }

    /**
     * 获取申请类型
     */
    public void getCarTypeBean(Subscriber<CarTypeListBean> subscriber) {
        HttpClient.getInstance().getCarTypeBean(subscriber);
    }

    /**
     * 新增用车申请
     */
    public void car_apply(Subscriber<BaseEntity> subscriber, CarApplyBean bean) {
        HttpClient.getInstance().car_apply(subscriber,bean);
    }

    /**
     * 审批用车通过
     */
    public void approveAgree(Subscriber<BaseEntity> subscriber,String examine_id,String id) {
        HttpClient.getInstance().approveAgree(subscriber,examine_id,id);
    }

    /**
     * 审批用车不通过
     */
    public void approveReject(Subscriber<BaseEntity> subscriber,String examine_id,String text) {
        HttpClient.getInstance().approveReject(subscriber,examine_id,text);
    }
}