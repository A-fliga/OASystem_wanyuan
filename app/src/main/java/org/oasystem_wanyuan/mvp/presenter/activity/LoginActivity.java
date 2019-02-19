package org.oasystem_wanyuan.mvp.presenter.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.oasystem_wanyuan.R;
import org.oasystem_wanyuan.application.MyApplication;
import org.oasystem_wanyuan.http.MSubscribe;
import org.oasystem_wanyuan.mvp.model.BaseEntity;
import org.oasystem_wanyuan.mvp.model.PublicModel;
import org.oasystem_wanyuan.mvp.model.bean.LoginBean;
import org.oasystem_wanyuan.mvp.view.LoginDelegate;
import org.oasystem_wanyuan.simplecache.ACache;
import org.oasystem_wanyuan.utils.AppUtil;
import org.oasystem_wanyuan.utils.SharedPreferencesUtil;
import org.oasystem_wanyuan.utils.ToastUtil;

import static org.oasystem_wanyuan.constants.Constants.LOGIN_INFO;


/**
 * Created by www on 2018/12/29.
 */

public class LoginActivity extends ActivityPresenter {
    private EditText unEt, pwdEt;

    @Override
    public Class getDelegateClass() {
        return LoginDelegate.class;
    }

    @Override
    public boolean isSetDisplayHomeAsUpEnabled() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        unEt = viewDelegate.get(R.id.login_username);
        pwdEt = viewDelegate.get(R.id.login_password);
        viewDelegate.setOnClickListener(onClickListener, R.id.login_btn);
    }


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (unEt.getText().toString().replaceAll(" ", "").isEmpty() || pwdEt.getText().toString().replaceAll(" ", "").isEmpty()) {
                ToastUtil.s("输入不能为空");
            } else {
                if (!AppUtil.isFastDoubleClick(1000)) {
                    toLogin();
                }
            }
        }
    };

    private void toLogin() {
        PublicModel.getInstance().login(new MSubscribe<BaseEntity<LoginBean>>() {
            @Override
            public void onNext(BaseEntity<LoginBean> bean) {
                super.onNext(bean);
                if (bean.getCode() == 0) {
                    SharedPreferencesUtil.saveUserName(unEt.getText().toString().replaceAll(" ", ""));
                    ACache aCache = ACache.get(MyApplication.getContext());
                    aCache.put(LOGIN_INFO, bean.getData());
                    startMyActivityWithFinish(MainActivity.class);
                }
            }
        }, unEt.getText().toString().replaceAll(" ", ""), pwdEt.getText().toString().replaceAll(" ", ""));
    }
}
