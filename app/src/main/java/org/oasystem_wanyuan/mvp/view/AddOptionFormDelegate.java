package org.oasystem_wanyuan.mvp.view;


import org.oasystem_wanyuan.R;
import org.oasystem_wanyuan.mvp.view.baseDelegate.ViewDelegate;

/**
 * Created by www on 2019/5/23.
 */

public class AddOptionFormDelegate extends ViewDelegate {
    @Override
    public void onDestroy() {

    }

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_add_option;
    }

    @Override
    public void initWidget() {
        getTitleView().setText("处理意见单");
        setToolBarRightTv2("提交");
    }
}
