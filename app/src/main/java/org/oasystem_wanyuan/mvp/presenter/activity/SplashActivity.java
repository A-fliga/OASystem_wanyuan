package org.oasystem_wanyuan.mvp.presenter.activity;

import android.os.Bundle;
import android.os.Handler;

import org.oasystem_wanyuan.manager.UserManager;
import org.oasystem_wanyuan.mvp.view.SplashDelegate;

/**
 * Created by www on 2018/12/29.
 */

public class SplashActivity extends ActivityPresenter {
    private Handler handler;

    @Override
    public Class getDelegateClass() {
        return SplashDelegate.class;
    }

    @Override
    public boolean isSetDisplayHomeAsUpEnabled() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler = new Handler();
        handler.postDelayed(mRun, 1500);
    }



    Runnable mRun = new Runnable() {
        @Override
        public void run() {
            if (UserManager.getInstance().isLogin()) {
                startMyActivityWithFinish(MainActivity.class);
            } else startMyActivityWithFinish(LoginActivity.class);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(mRun);
    }
}
