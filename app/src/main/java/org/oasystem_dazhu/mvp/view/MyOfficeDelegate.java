package org.oasystem_dazhu.mvp.view;

import org.oasystem_dazhu.R;
import org.oasystem_dazhu.mvp.view.baseDelegate.ViewDelegate;

/**
 * Created by www on 2019/1/5.
 */

public class MyOfficeDelegate extends ViewDelegate {
    @Override
    public void onDestroy() {

    }

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_my_office;
    }

    @Override
    public void initWidget() {
        getTitleView().setText("个人文档");
    }
}
