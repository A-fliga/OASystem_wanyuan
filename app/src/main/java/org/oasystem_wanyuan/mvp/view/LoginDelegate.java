package org.oasystem_wanyuan.mvp.view;

import android.widget.EditText;

import org.oasystem_wanyuan.R;
import org.oasystem_wanyuan.mvp.view.baseDelegate.ViewDelegate;
import org.oasystem_wanyuan.utils.SharedPreferencesUtil;


/**
 * Created by www on 2018/12/28.
 */

public class LoginDelegate extends ViewDelegate {

    @Override
    public void onDestroy() {

    }

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initWidget() {
        String userName = SharedPreferencesUtil.getUserName();
        if (userName != null && !userName.isEmpty()) {
            EditText editText = get(R.id.login_username);
            editText.setText(userName);
        }
        getTitleView().setText("登录");
    }
}
