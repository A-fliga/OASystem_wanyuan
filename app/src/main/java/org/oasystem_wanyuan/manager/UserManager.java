package org.oasystem_wanyuan.manager;

import org.oasystem_wanyuan.application.MyApplication;
import org.oasystem_wanyuan.mvp.model.bean.AllUserBean;
import org.oasystem_wanyuan.mvp.model.bean.LoginBean;
import org.oasystem_wanyuan.mvp.model.bean.UserInfo;
import org.oasystem_wanyuan.simplecache.ACache;

import java.util.ArrayList;
import java.util.List;

import static org.oasystem_wanyuan.constants.Constants.LOGIN_INFO;

/**
 * Created by www on 2018/12/29.
 */

public class UserManager {
    private static volatile UserManager sInstance;
    private UserInfo mUserInfo;
    private AllUserBean mAllUserBean;
    private UserManager() {
    }

    public static UserManager getInstance() {
        if (sInstance == null) {
            synchronized (UserManager.class) {
                if (sInstance == null) {
                    sInstance = new UserManager();
                }
            }
        }
        return sInstance;
    }

    public Boolean isLogin() {
        ACache aCache = ACache.get(MyApplication.getContext());
        LoginBean bean = (LoginBean) aCache.getAsObject(LOGIN_INFO);
        return bean != null;
    }

    public void setAllUserInfo(AllUserBean allUserInfo){
        this.mAllUserBean = allUserInfo;
    }

    public List<AllUserBean.DataBean> getAllUserInfo(){
        List<AllUserBean.DataBean> beanList = new ArrayList<>();
        for (int i = 0; i < mAllUserBean.getData().size(); i++) {
//            if (allUserBean.getData().get(i).getId() != UserManager.getInstance().getUserInfo().getId()) {
                beanList.add(mAllUserBean.getData().get(i));
//            }
        }
        return beanList;
    }


    public void setUserInfo(UserInfo userInfo){
        this.mUserInfo = userInfo;
    }

    public UserInfo getUserInfo(){
        return mUserInfo;
    }
}
