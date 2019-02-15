package org.oasystem_dazhu.mvp.presenter.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import org.oasystem_dazhu.R;
import org.oasystem_dazhu.application.MyApplication;
import org.oasystem_dazhu.mvp.presenter.activity.ActivityPresenter;
import org.oasystem_dazhu.mvp.presenter.activity.LoginActivity;
import org.oasystem_dazhu.mvp.presenter.activity.MySealActivity;
import org.oasystem_dazhu.mvp.view.UserCenterDelegate;
import org.oasystem_dazhu.simplecache.ACache;
import org.oasystem_dazhu.utils.DialogUtil;

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
        LinearLayout ll = viewDelegate.get(R.id.logout);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        LinearLayout mySeal = viewDelegate.get(R.id.mySeal);
        mySeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMyActivity(MySealActivity.class,null);
            }
        });
    }

    private void showDialog() {
        DialogUtil.showDialog(getActivity(), "您确定要退出帐号吗？", "确定","取消", onClickListener);
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
