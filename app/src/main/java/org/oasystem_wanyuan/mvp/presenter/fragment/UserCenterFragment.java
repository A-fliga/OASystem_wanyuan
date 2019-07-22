package org.oasystem_wanyuan.mvp.presenter.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import org.oasystem_wanyuan.R;
import org.oasystem_wanyuan.application.MyApplication;
import org.oasystem_wanyuan.mvp.presenter.activity.ActivityPresenter;
import org.oasystem_wanyuan.mvp.presenter.activity.ChangePassWordActivity;
import org.oasystem_wanyuan.mvp.presenter.activity.LoginActivity;
import org.oasystem_wanyuan.mvp.presenter.activity.MySealActivity;
import org.oasystem_wanyuan.mvp.view.UserCenterDelegate;
import org.oasystem_wanyuan.simplecache.ACache;
import org.oasystem_wanyuan.utils.DialogUtil;
import org.oasystem_wanyuan.utils.FileUtil;
import org.oasystem_wanyuan.utils.ToastUtil;


/**
 * Created by www on 2018/12/29.
 */

public class UserCenterFragment extends FragmentPresenter {
    @Override
    public Class getDelegateClass() {
        return UserCenterDelegate.class;
    }

    @Override
    protected void onFragmentVisible() {

    }

    @Override
    protected void onFragmentHidden() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewDelegate.setOnClickListener(mOnClickListener, R.id.logout, R.id.mySeal, R.id.changePwd, R.id.clear_cache);

    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.logout:
                    showDialog();
                    break;
                case R.id.mySeal:
                    startMyActivity(MySealActivity.class, null);
                    break;

                case R.id.changePwd:
                    startMyActivity(ChangePassWordActivity.class, null);
                    break;

                case R.id.clear_cache:
                    FileUtil.clearCache();
                    ToastUtil.s("清理完成");
                    break;
            }
        }
    };


    private void showDialog() {
        DialogUtil.showDialog(getActivity(), "您确定要退出帐号吗？", "确定", "取消", onClickListener);
    }

    DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == -1) {
                //// TODO: 2018/12/30
                ACache.get(MyApplication.getContext()).clear();
                startMyActivityWithFinish(LoginActivity.class, null);
                ActivityPresenter.finishAllActivity();
            }
            dialogInterface.dismiss();
        }
    };
}
