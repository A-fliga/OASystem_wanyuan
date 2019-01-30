package org.oasystem.mvp.presenter.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import org.oasystem.BuildConfig;
import org.oasystem.R;
import org.oasystem.application.MyApplication;
import org.oasystem.constants.Constants;
import org.oasystem.http.MSubscribe;
import org.oasystem.mvp.model.BaseEntity;
import org.oasystem.mvp.model.PublicModel;
import org.oasystem.mvp.model.bean.LoginBean;
import org.oasystem.mvp.view.LoginDelegate;
import org.oasystem.simplecache.ACache;
import org.oasystem.utils.AppUtil;
import org.oasystem.utils.SharedPreferencesUtil;
import org.oasystem.utils.ToastUtil;

import static org.oasystem.constants.Constants.LOGIN_INFO;

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
        initTop();
        unEt = viewDelegate.get(R.id.login_username);
        pwdEt = viewDelegate.get(R.id.login_password);
        viewDelegate.setOnClickListener(onClickListener, R.id.login_btn);
    }

    private void initTop() {
        ImageView login_top_img = viewDelegate.get(R.id.login_top_img);
        //大竹
        if (BuildConfig.HOST.equals(Constants.DAZHU_URL)) {
            login_top_img.setImageResource(R.mipmap.login_top_dazhu);
        }
        //万源
        else if (BuildConfig.HOST.equals(Constants.WANYUAN_URL)) {
            login_top_img.setImageResource(R.mipmap.login_top_wanyuan);
        } else {
            login_top_img.setImageResource(R.mipmap.login_top_wanyuan);
        }
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
