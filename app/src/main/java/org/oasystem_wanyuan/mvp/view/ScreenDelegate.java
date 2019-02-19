package org.oasystem_wanyuan.mvp.view;

import org.oasystem_wanyuan.R;
import org.oasystem_wanyuan.mvp.view.baseDelegate.ViewDelegate;

/**
 * Created by www on 2019/1/8.
 */

public class ScreenDelegate extends ViewDelegate {
    @Override
    public void onDestroy() {

    }

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_screen;
    }

    @Override
    public void initWidget() {
        getTitleView().setText("筛选");
    }
}
