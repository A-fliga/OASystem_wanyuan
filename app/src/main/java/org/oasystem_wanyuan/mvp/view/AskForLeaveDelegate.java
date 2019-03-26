package org.oasystem_wanyuan.mvp.view;


import org.oasystem_wanyuan.R;
import org.oasystem_wanyuan.mvp.view.baseDelegate.ViewDelegate;

/**
 * Created by www on 2019/3/25.
 */

public class AskForLeaveDelegate extends ViewDelegate {
    @Override
    public void onDestroy() {

    }

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_ask_for_leave;
    }

    @Override
    public void initWidget() {
        getTitleView().setText("我的请假");
    }
}
