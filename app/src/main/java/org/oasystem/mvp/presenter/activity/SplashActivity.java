package org.oasystem.mvp.presenter.activity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import org.oasystem.BuildConfig;
import org.oasystem.R;
import org.oasystem.constants.Constants;
import org.oasystem.manager.UserManager;
import org.oasystem.mvp.view.SplashDelegate;

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
        initView();
    }

    private void initView() {
        ImageView splash_img = viewDelegate.get(R.id.splash_img);
        //大竹
        if (BuildConfig.HOST.equals(Constants.DAZHU_URL)) {
            splash_img.setImageResource(R.mipmap.splash_dazhu);
        }
        //万源
        else if (BuildConfig.HOST.equals(Constants.WANYUAN_URL)) {
            splash_img.setImageResource(R.mipmap.splash_wanyuan);
        } else {
            splash_img.setImageResource(R.mipmap.splash_wanyuan);
        }
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
