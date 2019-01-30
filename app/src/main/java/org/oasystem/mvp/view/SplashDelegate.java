package org.oasystem.mvp.view;

import android.widget.ImageView;

import org.oasystem.R;
import org.oasystem.mvp.view.baseDelegate.ViewDelegate;
import org.oasystem.mvp.view.customView.photoView.BuildConfig;

/**
 * Created by www on 2018/12/29.
 */

public class SplashDelegate extends ViewDelegate {
    @Override
    public void onDestroy() {

    }

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initWidget() {

    }
}
