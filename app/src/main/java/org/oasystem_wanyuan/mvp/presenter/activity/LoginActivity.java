package org.oasystem_wanyuan.mvp.presenter.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import static org.oasystem_wanyuan.constants.Constants.LOGIN_INFO;


/**
 * Created by www on 2018/12/29.
 */

public class LoginActivity extends ActivityPresenter {
    private EditText mUnEt, mPwdEt;

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
        mUnEt = mViewDelegate.get(R.id.login_username);
        addTextChangeListener(mUnEt);
        mPwdEt = mViewDelegate.get(R.id.login_password);
        mViewDelegate.setOnClickListener(onClickListener, R.id.login_btn, R.id.can_not_login, R.id.forget_pwd);
    }

    public static String stringFilter(String str) throws PatternSyntaxException {
        String regEx = "[/\\:*?<>|\"\n\t]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("");
    }

    private void addTextChangeListener(final EditText et) {
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                String editable = et.getText().toString();
                String str = stringFilter(editable); //过滤特殊字符
                if (!editable.equals(str)) {
                    et.setText(str);
                }
                et.setSelection(et.length());
            }


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.login_btn:
                    if (mUnEt.getText().toString().replaceAll(" ", "").isEmpty() || mPwdEt.getText().toString().replaceAll(" ", "").isEmpty()) {
                        ToastUtil.s("输入不能为空");
                    } else {
                        if (!AppUtil.isFastDoubleClick(1000)) {
                            toLogin();
                        }
                    }
                    break;

                case R.id.can_not_login:
                    ToastUtil.s("暂不支持外部修改，请联系管理员");
                    break;

                case R.id.forget_pwd:
                    ToastUtil.s("暂不支持外部修改，请联系管理员");
                    break;
            }
        }
    };

    private void toLogin() {
        PublicModel.getInstance().login(new MSubscribe<BaseEntity<LoginBean>>() {
            @Override
            public void onNext(BaseEntity<LoginBean> bean) {
                super.onNext(bean);
                if (bean.getCode() == 0) {
                    SharedPreferencesUtil.saveUserName(mUnEt.getText().toString().replaceAll(" ", ""));
                    ACache aCache = ACache.get(MyApplication.getContext());
                    aCache.put(LOGIN_INFO, bean.getData());
                    startMyActivityWithFinish(MainActivity.class);
                }
            }
        }, mUnEt.getText().toString().replaceAll(" ", ""), mPwdEt.getText().toString().replaceAll(" ", ""));
    }
}
