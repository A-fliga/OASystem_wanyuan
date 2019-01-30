package org.oasystem.manager;

import org.oasystem.application.MyApplication;
import org.oasystem.mvp.model.bean.LoginBean;
import org.oasystem.mvp.model.bean.UserInfo;
import org.oasystem.simplecache.ACache;

import static org.oasystem.constants.Constants.LOGIN_INFO;

/**
 * Created by www on 2018/12/29.
 */

public class UserManager {
    private static volatile UserManager instance;
    private UserInfo userInfo;
    private UserManager() {
    }

    public static UserManager getInstance() {
        if (instance == null) {
            synchronized (UserManager.class) {
                if (instance == null) {
                    instance = new UserManager();
                }
            }
        }
        return instance;
    }

    public Boolean isLogin() {
        ACache aCache = ACache.get(MyApplication.getContext());
        LoginBean bean = (LoginBean) aCache.getAsObject(LOGIN_INFO);
        return bean != null;
    }

    public void setUserInfo(UserInfo userInfo){
        this.userInfo = userInfo;
    }

    public UserInfo getUserInfo(){
        return userInfo;
    }
}
